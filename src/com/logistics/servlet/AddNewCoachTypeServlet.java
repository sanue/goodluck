package com.logistics.servlet;

import com.logistics.bean.CoachType;
import com.logistics.dao.CoachTypeDao;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/10/28.
 */
@WebServlet(name = "AddNewCoachTypeServlet",urlPatterns = "/manageSite/addNewCoachType.do")
public class AddNewCoachTypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取车厢类型
        request.setCharacterEncoding("utf-8");
        String coachTypeName=request.getParameter("newCoachType");
        // System.out.println(sectionName);
        //插入数据库

        CoachTypeDao coachTypeDao=new CoachTypeDao();
        int val=coachTypeDao.insertNewCoachType(coachTypeName);
        CoachType coachType=null;
        //调用dao层，获取新加的车型
        if(val>0){
            coachType=coachTypeDao.getCoachTypeByType(coachTypeName);
        }
        //将列表转成json对象

        JSONObject jsonObject=new JSONObject(coachType);
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
