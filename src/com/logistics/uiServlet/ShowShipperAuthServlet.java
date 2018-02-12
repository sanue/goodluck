package com.logistics.uiServlet;

import com.logistics.bean.Register;
import com.logistics.bean.ShipperAuthentication;
import com.logistics.dao.ShipperAuthenticationDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/10/5.
 */
@WebServlet(name = "ShowShipperAuthServlet",urlPatterns = "/uiSite/shipperAuthInfo.html")
public class ShowShipperAuthServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Register currentRe = new Register();
        if (request.getSession().getAttribute("register")!=null) {
            currentRe = (Register) request.getSession().getAttribute("register");
            //货主验证信息
            ShipperAuthenticationDao shipperAuthenticationDao = new ShipperAuthenticationDao();
            ShipperAuthentication shipperAuthentication = shipperAuthenticationDao.getCurrentShipperAuth(currentRe.getName());
            request.setAttribute("currentRe",currentRe);
            request.setAttribute("shipperAuthentication",shipperAuthentication);

            request.getRequestDispatcher("shipperAuthInfo.jsp").forward(request,response);
        }else{
            response.sendRedirect("index.html");
        }

    }
}
