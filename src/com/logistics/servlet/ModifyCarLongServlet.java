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
@WebServlet(name = "ModifyCarLongServlet",urlPatterns = "/manageSite/modifyCarLong.do")
public class ModifyCarLongServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取新车型和id
        request.setCharacterEncoding("utf-8");
        String carLongName=request.getParameter("afterCarLong");
        int id=Integer.parseInt(request.getParameter("id"));
        //System.out.println(id+":"+sectionName);
        CarLong carLong=new CarLong(id, carLongName);
        //更新数据库
        CarLong newCarLong=null;
        CarLongDao carLongDao=new CarLongDao();
        int val=carLongDao.modifyCarLong(carLong);
        if(val>0){
            //调用dao层，获取新加的车型
            newCarLong=carLongDao.getCarLongByLong(carLongName);
            //System.out.println(newSection.getId()+":"+newSection.getName());
        }
        response.setContentType("text/plain;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        //将列表转成json串
        JSONObject jsonObject=new JSONObject(newCarLong);
        //JSONArray jsonArray=new JSONArray(sections);
        String result=jsonObject.toString();
        System.out.println(result);
        PrintWriter out=response.getWriter();
        //响应客户端

        out.print(result);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
