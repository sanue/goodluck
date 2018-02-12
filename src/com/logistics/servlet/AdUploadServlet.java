package com.logistics.servlet;

import com.logistics.bean.Advertisement;
import com.logistics.dao.AdvertisementDao;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2016/10/28.
 */
@WebServlet(name = "AdUploadServlet" , urlPatterns = "/manageSite/adUpload.do")
public class AdUploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //设置上传的路径
        String savePath = this.getServletContext().getRealPath("/upload/adv");
        String temp = this.getServletContext().getRealPath("/temp");

        //存放所有的表单数据 因为enctype="multipart/form-data"
        List<FileItem> items =  null;

        // 设置字符编码为UTF-8, 这样支持汉字显示
        response.setCharacterEncoding("UTF-8");

        /**
         * 首先判断form的enctype是不是multipart/form-data
         * 同时也判断了form的提交方式是不是post
         * 方法：isMultipartContent(request)
         */
        if(ServletFileUpload.isMultipartContent(request)){
            request.setCharacterEncoding("utf-8");
            //设置文件存放的临时文件夹，这个文件夹要真实存在
            File fileDir = new File(temp);
            if(fileDir.isDirectory() && fileDir.exists()==false){
                fileDir.mkdir();
            }
            //图片上传后存放的路径目录
            File images = new File(savePath);
            if(images.exists()==false){
                images.mkdirs();
            }
            // 实例化一个硬盘文件工厂,用来配置上传组件ServletFileUpload
            DiskFileItemFactory factory =  new DiskFileItemFactory();
            //临时存放
            factory.setRepository(fileDir);
            //设置最大占用的内存
            factory.setSizeThreshold(1024*1024*4);
            //创建ServletFileUpload对象
            ServletFileUpload sfu = new ServletFileUpload(factory);
            sfu.setHeaderEncoding("utf-8");
            //设置单个文件最大值byte
            sfu.setFileSizeMax(1024*1024*2);
            //所有上传文件的总和最大值byte
            sfu.setSizeMax(1024*1024*4);
            try {
                /*获取所有表单数据*/
                items = sfu.parseRequest(request);
            }catch (FileUploadBase.SizeLimitExceededException e) {
                System.out.println("文件大小超过了最大值");
            } catch(FileUploadException e) {
                e.printStackTrace();
            }
            Advertisement ad = new Advertisement();
                    /*遍历数据*/
            for(FileItem item : items){
                //也可以根据getFieldName()获取表单name，来区分结果
                //如果传过来的是普通的表单域
                if(item.isFormField()){
                    if("state".equals(item.getFieldName())){
                        ad.setState(Integer.parseInt(item.getString()));
                    }
                }
                //文件域
                else if(!item.isFormField()){
                    if("adv".equals(item.getFieldName())){
                        //获取文件名，格式是c:\路径\文件名
                        String fileName = item.getName().substring(item.getName().lastIndexOf("\\")+1);
                            /*获取扩展名*/
                        //String fileExtName = fileName.substring(fileName.lastIndexOf(".")+1);
                        //System.out.print("扩展名为"+fileExtName);
                        //用uuid获取唯一的文件名
                        String saveName = UUID.randomUUID().toString()+"_"+fileName;
                            /*获取文件名，保存在数据库中*/
                        ad.setImage(saveName);
                            /*建立一个BufferedInputStream对象，并读取文件item*/
                        BufferedInputStream in = new BufferedInputStream(item.getInputStream());
                        //文件存储在savePath目录下,这个目录也得存在
                        BufferedOutputStream outs = new BufferedOutputStream(
                                new FileOutputStream(new File(savePath+"\\"+saveName)));
                            /*拷贝文件*/
                        Streams.copy(in, outs, true);
                        //o.write("文件上传成功");
                    }

                }
            }

            ad.setId(0);
            AdvertisementDao aDao = new AdvertisementDao();
            aDao.addAdvertisement(ad);
            response.sendRedirect("ad.jsp");

        }
    }
}
