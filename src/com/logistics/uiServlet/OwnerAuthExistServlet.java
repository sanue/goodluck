package com.logistics.uiServlet;

import com.logistics.dao.OwnerAuthenticationDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/10/4.
 */
@WebServlet(name = "OwnerAuthExistServlet",urlPatterns = "/uiSite/checkOwnerAuth.do")
public class OwnerAuthExistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain;charset=utf-8");
        String trueName = request.getParameter("trueName");
        OwnerAuthenticationDao ownerAuthenticationDao = new OwnerAuthenticationDao();
        int result = ownerAuthenticationDao.checkExistOwner(trueName);

        response.setContentType("text/plain;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.print(result);
    }
}
