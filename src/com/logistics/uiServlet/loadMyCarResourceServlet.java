package com.logistics.uiServlet;

import com.logistics.bean.CarInfo;
import com.logistics.bean.Register;
import com.logistics.dao.CarInfoDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/11/3.
 */
@WebServlet(name = "loadMyCarResourceServlet",urlPatterns = "/uiSite/myCarResource.html")
public class loadMyCarResourceServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        CarInfoDao carInfoDao=new CarInfoDao();
        Register register=(Register)request.getSession().getAttribute("register");
        String name = null;
        if(register!=null){
            name=register.getName();
        }
        ArrayList<CarInfo> carInfos=carInfoDao.getCarInfoByName(name);
        request.setAttribute("car",carInfos);
        request.setAttribute("register",name);
        request.getRequestDispatcher("myCarResource.jsp").forward(request,response);
    }


}
