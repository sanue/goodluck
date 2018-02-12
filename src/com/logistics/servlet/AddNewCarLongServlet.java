package com.logistics.servlet;

import com.logistics.bean.CarLong;
import com.logistics.dao.CarLongDao;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/10/27.
 */
@WebServlet(name = "AddNewCarLongServlet",urlPatterns = "/manageSite/addNewCarLong.do")
public class AddNewCarLongServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取车长
        request.setCharacterEncoding("utf-8");
        String carLong=request.getParameter("newCarLong");
        // System.out.println(sectionName);
        //插入数据库

        CarLongDao carLongDao=new CarLongDao();
        int val=carLongDao.insertNewCarLong(carLong);
        CarLong carLong1=null;
        //调用dao层，获取新加的车型
        if(val>0){
            carLong1=carLongDao.getCarLongByLong(carLong);
        }
        //将列表转成json串

        JSONObject jsonObject=new JSONObject(carLong1);
        //JSONArray jsonArray=new JSONArray(sections);
        response.setContentType("text/plain;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        String result=jsonObject.toString();
        PrintWriter out=response.getWriter();
        //响应客户端

        out.print(result);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
