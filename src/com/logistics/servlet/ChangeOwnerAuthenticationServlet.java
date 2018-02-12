package com.logistics.servlet;

import com.logistics.dao.OwnerAuthenticationDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/10/16.
 */
@WebServlet(name = "ChangeOwnerAuthenticationServlet",urlPatterns = "/manageSite/ChangeOwnerAuthentication.do")
public class ChangeOwnerAuthenticationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int status = Integer.parseInt(request.getParameter("status"));
        String name = request.getParameter("name");
        OwnerAuthenticationDao oDao = new OwnerAuthenticationDao();
        int result = oDao.changeOwnerAnthenticationStatus(status,name );
        response.setContentType("text/plain;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.print(result);
    }
}
