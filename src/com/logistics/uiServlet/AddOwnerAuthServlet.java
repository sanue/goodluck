package com.logistics.uiServlet;

import com.logistics.bean.OwnerAuthentication;
import com.logistics.bean.Register;
import com.logistics.dao.OwnerAuthenticationDao;
import com.logistics.dao.RegisterDao;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2016/10/29.
 */
@WebServlet(name = "AddOwnerAuthServlet",urlPatterns = "/uiSite/ownerAuth.do")
public class AddOwnerAuthServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        // 检查表单是否包含enctype=multipart/form-data
        //boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        //System.out.println(isMultipart);
        //
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // 设置缓存区
        ServletContext servletContext = this.getServletContext();
        String tempPath = servletContext.getRealPath("/temp");
        //身份证
        String identityPath = servletContext.getRealPath("/upload/identityPath");
        //头像
        String headPath= servletContext.getRealPath("/upload/headPath");
        //驾驶证
        String driverLiPath= servletContext.getRealPath("/upload/driverLiPath");

        System.out.println(tempPath);
        File repository = new File(tempPath);
        factory.setRepository(repository);

        // 创建处理带文件上传的表单处理器
        ServletFileUpload upload = new ServletFileUpload(factory);

        OwnerAuthentication ownerAuthentication = new OwnerAuthentication();
        try {
            // 重新封装request
            List<FileItem> items = upload.parseRequest(request);
            System.out.println(items.size());
            for(FileItem item : items){
                if(item.isFormField()){
                    if("trueName".equals(item.getFieldName())){
                        ownerAuthentication.setTrueName(item.getString("utf-8"));
                    }
                    else if("carNumm".equals(item.getFieldName())){
                        ownerAuthentication.setCarNum(item.getString("utf-8"));
                    }
                }else{
                    // 获取客户端的文件名
                    String clientFilePath = item.getName();
                    String ext = null;
                    if(clientFilePath!= ""){
                        //	文件扩展名
                        ext = clientFilePath.substring(clientFilePath.lastIndexOf("."));
                    }
                    // 生成随机永不重复的文件名
                    /*if(ext.equals(".jpg")||ext.equals(".jpeg")||ext.equals(".png")){*/
                        if(item.getFieldName().equals("driversLicensePic")){
                            //驾驶证
                            String drivers = UUID.randomUUID().toString() + ext;
                            String driversPath = driverLiPath + "\\" + drivers;
                            item.write(new File(driversPath));
                            ownerAuthentication.setDrivesLicensePic(drivers);
                        }else if(item.getFieldName().equals("identity")){
                            //身份证
                            String IdentityPic = UUID.randomUUID().toString() + ext;
                            String IdentityPath = identityPath + "\\" + IdentityPic;
                            item.write(new File(IdentityPath));
                            ownerAuthentication.setIdentityPic(IdentityPic);
                        }else if(item.getFieldName().equals("headPicture")){
                            //头像
                            String headPic = null;
                            if(ext!=null){
                                headPic = UUID.randomUUID().toString() + ext;
                                String headPicPath = headPath + "\\" + headPic;
                                item.write(new File(headPicPath));
                            }

                            ownerAuthentication.setHeadPic(headPic);
                        }
                        //ownerAuthentication.setDrivesLicensePic(driversPath);
                        System.out.println("保存图片成功");
                    }

                    // 保存到服务器端完整路径(绝对路径)

                    //item.write(new File(songImagePath));

                    // System.out.println(fieldName + "--" + fileName + "--" + contentType + "--" + sizeInBytes);
                }

            /*}*/
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if(null != ownerAuthentication.getDrivesLicensePic()&&null != ownerAuthentication.getIdentityPic()){
            Register Re = (Register)request.getSession().getAttribute("register");
            ownerAuthentication.setOwnerName(Re.getName());
            //	向数据库插入数据
            OwnerAuthenticationDao ownerAuthenticationDao = new OwnerAuthenticationDao();
            int val = ownerAuthenticationDao.OwnerAuthentication(ownerAuthentication);
            if(val!=0){
                System.out.print("插入数据库成功");
                RegisterDao rDao = new RegisterDao();
                rDao.setStatus(0,Re.getName());
            }else{
                System.out.print("插入数据库失败");
            }
            response.sendRedirect("basicInfo.html");
        }
    }
}
