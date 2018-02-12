package com.logistics.servlet;

import com.logistics.bean.CarType;
import com.logistics.dao.CarTypeDao;
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
@WebServlet(name = "ModifyCarTypeServlet",urlPatterns = "/manageSite/modifyCarType.do")
public class ModifyCarTypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取新车型和id
        request.setCharacterEncoding("utf-8");
        String carTypeName=request.getParameter("afterCarType");
        int id=Integer.parseInt(request.getParameter("id"));
        //System.out.println(id+":"+sectionName);
        CarType carType=new CarType(id, carTypeName);
        //更新数据库
        CarType newCarType=null;
        CarTypeDao carTypeDao=new CarTypeDao();
        int val=carTypeDao.modifyCarType(carType);
        if(val>0){
            //调用dao层，获取新加的车型
            newCarType=carTypeDao.getCarTypeByType(carTypeName);
            //System.out.println(newSection.getId()+":"+newSection.getName());
        }
        response.setContentType("text/plain;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        //将列表转成json串
        JSONObject jsonObject=new JSONObject(newCarType);
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
