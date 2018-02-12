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
@WebServlet(name = "ModifyCoachTypeServlet",urlPatterns = "/manageSite/modifyCoachType.do")
public class ModifyCoachTypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取新车型和id
        request.setCharacterEncoding("utf-8");
        String coachTypeName=request.getParameter("afterCoachType");
        int id=Integer.parseInt(request.getParameter("id"));
        //System.out.println(id+":"+sectionName);
        CoachType coachType=new CoachType(id, coachTypeName);
        //更新数据库
        CoachType newCoachType=null;
        CoachTypeDao coachTypeDao=new CoachTypeDao();
        int val=coachTypeDao.modifyCoachType(coachType);
        if(val>0){
            //调用dao层，获取新加的车型
            newCoachType=coachTypeDao.getCoachTypeByType(coachTypeName);
            //System.out.println(newSection.getId()+":"+newSection.getName());
        }
        response.setContentType("text/plain;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        //将列表转成json串
        JSONObject jsonObject=new JSONObject(newCoachType);
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
