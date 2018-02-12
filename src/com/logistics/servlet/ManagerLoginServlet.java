package com.logistics.servlet;

import com.logistics.bean.User;
import com.logistics.dao.UserDao;

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
@WebServlet(name = "ManagerLoginServlet",urlPatterns = "/manageSite/login.do")
public class ManagerLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户名和密码
        request.setCharacterEncoding("utf-8");
        String name=request.getParameter("username");
        String pwd=request.getParameter("password");
        //检查用户名是否合法
        int result=0;
        UserDao userDao=new UserDao();
        User user=userDao.login(name,pwd);
        PrintWriter out=response.getWriter();
        //响应客户端
        if(null!=user){
            request.getSession().setAttribute("CurrentUser", user);
            result=1;
        }
        response.setContentType("text/plain;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        out.print(result);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
