package com.logistics.servlet;

import com.logistics.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/10/29.
 */
@WebServlet(name = "ModifyPasswordServlet",urlPatterns = "/manageSite/modifyPassword.do")
public class ModifyPasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户输入的新密码
        request.setCharacterEncoding("utf-8");
        String name=request.getParameter("userName");
        String oldPwd=request.getParameter("oldPwd");
        String newPwd=request.getParameter("newPwd");
        //String pwd=request.getParameter("password");
        //保存到数据库中
        int result=0;
        UserDao userDao=new UserDao();
        result=userDao.modifyPassword(name, oldPwd,newPwd);
        if(result==1){
            response.sendRedirect("login.html");
        }
        //PrintWriter out=response.getWriter();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
