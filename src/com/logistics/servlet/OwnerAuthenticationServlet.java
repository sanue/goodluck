package com.logistics.servlet;

import com.logistics.bean.OwnerAuthentication;
import com.logistics.dao.OwnerAuthenticationDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/27.
 */
@WebServlet(name = "OwnerAuthenticationServlet",urlPatterns = "/manageSite/ownerauthentication.html")
public class OwnerAuthenticationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        OwnerAuthenticationDao oDao = new OwnerAuthenticationDao();
        ArrayList<OwnerAuthentication>  ownerAuthentications = oDao.getAllOwnerInfo();
        request.setAttribute("ownerAuthentications" , ownerAuthentications);
        request.getRequestDispatcher("ownerauthentication.jsp").forward(request , response);
    }
}
