package com.logistics.servlet;

import com.logistics.bean.BaseInfo;
import com.logistics.bean.Shipper;
import com.logistics.dao.ShipperDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/26.
 */
@WebServlet(name = "ShipperInfoServlet" , urlPatterns = "/manageSite/shipperInfo.html")
public class ShipperInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        ShipperDao sDao = new ShipperDao();
        ArrayList<BaseInfo> baseInfos = sDao.getAllBaseInfo(1);
        request.setAttribute("shippers" , baseInfos);
        request.getRequestDispatcher("shipperInfo.jsp").forward(request , response);

    }
}
