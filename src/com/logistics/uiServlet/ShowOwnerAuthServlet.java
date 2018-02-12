package com.logistics.uiServlet;

import com.logistics.bean.OwnerAuthentication;
import com.logistics.bean.Register;
import com.logistics.dao.OwnerAuthenticationDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/10/4.
 */
@WebServlet(name = "ShowOwnerAuthServlet",urlPatterns = "/uiSite/AuthInfo.html")
public class ShowOwnerAuthServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Register currentRe = new Register();
        if (request.getSession().getAttribute("register")!=null) {
             currentRe = (Register) request.getSession().getAttribute("register");

        //车主验证信息
        OwnerAuthenticationDao ownerAuthenticationDao = new OwnerAuthenticationDao();
        OwnerAuthentication ownerAuthentication = ownerAuthenticationDao.getCurrentOwnerAuth(currentRe.getName());

        request.setAttribute("ownerInfo",ownerAuthentication);
        request.setAttribute("currentRe",currentRe);
        request.getRequestDispatcher("AuthInfo.jsp").forward(request,response); }else{
            response.sendRedirect("index.html");
        }
    }
}
