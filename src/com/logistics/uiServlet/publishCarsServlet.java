package com.logistics.uiServlet;

import com.logistics.bean.CarInfo;
import com.logistics.bean.Register;
import com.logistics.dao.CarInfoDao;
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
 * Created by Administrator on 2016/10/31.
 */
@WebServlet(name = "publishCarsServlet",urlPatterns = "/uiSite/publishCar.do")
public class publishCarsServlet extends HttpServlet {
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
        //车辆照片
        String carPicPath = servletContext.getRealPath("/upload/carPicPath");


        System.out.println(tempPath);
        File repository = new File(tempPath);
        factory.setRepository(repository);

        // 创建处理带文件上传的表单处理器
        ServletFileUpload upload = new ServletFileUpload(factory);

        /*OwnerAuthentication ownerAuthentication = new OwnerAuthentication();*/
        CarInfo carInfo = new CarInfo();
        try {
            // 重新封装request
            List<FileItem> items = upload.parseRequest(request);
            System.out.println(items.size());
            for(FileItem item : items){
                if(item.isFormField()){
                    if("startCity".equals(item.getFieldName())){
                        String start = item.getString("utf-8");
                        String startPro = start.split("-")[0];
                        String startCity = start.split("-")[1];
                        carInfo.setStartProvince(startPro);
                        carInfo.setStartCity(startCity);
                    }
                    else if("toCity".equals(item.getFieldName())){
                        String to = item.getString("utf-8");
                        String toPro = to.split("-")[0];
                        String toCity = to.split("-")[1];
                        carInfo.setToProvince(toPro);
                        carInfo.setToCity(toCity);
                    } else if("carNum".equals(item.getFieldName())){
                        carInfo.setCarNum(item.getString("utf-8"));
                    } else if("carLong".equals(item.getFieldName())){
                        carInfo.setCarLong(item.getString("utf-8"));
                    }else if("carType".equals(item.getFieldName())){
                       carInfo.setCarType(item.getString("utf-8"));
                    }else if("coachType".equals(item.getFieldName())){
                       carInfo.setCoachType(item.getString("utf-8"));
                    }
                }else{
                    // 获取客户端的文件名
                    String clientFilePath = item.getName();

                    //	文件扩展名
                    String ext = clientFilePath.substring(clientFilePath.lastIndexOf("."));
                    // 生成随机永不重复的文件名

                    if(ext.equals(".jpg")||ext.equals(".jpeg")||ext.equals(".png")){
                        if(item.getFieldName().equals("carPic")){
                            //车辆照片
                            String cars = UUID.randomUUID().toString() + ext;
                            String carPath = carPicPath + "\\" + cars;
                            item.write(new File(carPath));
                            carInfo.setCarPic(cars);
                        }
                        //ownerAuthentication.setDrivesLicensePic(driversPath);
                        System.out.println("保存图片成功");
                    }

                    // 保存到服务器端完整路径(绝对路径)

                    //item.write(new File(songImagePath));

                    // System.out.println(fieldName + "--" + fileName + "--" + contentType + "--" + sizeInBytes);
                }

            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if(null != carInfo){
            Register Re = (Register)request.getSession().getAttribute("register");
            carInfo.setOwner(Re.getName());
            //	向数据库插入数据
            CarInfoDao carInfoDao = new CarInfoDao();
            int val = carInfoDao.releaseCarInfo(carInfo);
            if(val!=0){
                System.out.print("插入数据库成功");
            }else{
                System.out.print("插入数据库失败");
            }
            response.sendRedirect("basicInfo.html");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
