package com.logistics.uiServlet;

import com.logistics.dao.RegisterDao;

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
@WebServlet(name = "modifyPwdServlet",urlPatterns = "/uiSite/modifyPwd.do")
public class modifyPwdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String userName=request.getParameter("userName");
        String password=request.getParameter("password");
        String newPassword=request.getParameter("newPassword");
        RegisterDao rd=new RegisterDao();
        int r=rd.modifyPassword(userName, newPassword,password);

        response.setContentType("text/plain;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        out.print(r);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
