package com.logistics.servlet;

import com.logistics.dao.RegisterDao;
import com.logistics.dao.ShipperAuthenticationDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/10/18.
 */
@WebServlet(name = "DeleteShipperInfoServlet",urlPatterns = "/manageSite/deleteShipperInfo.do")
public class DeleteShipperInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取货主名
        String shopperName=request.getParameter("shipperName");
        //删除货主之前先改变认证状态为2
        RegisterDao rDao=new RegisterDao();
        rDao.setStatus(2,shopperName);
        //删除认证失败的货物信息
        ShipperAuthenticationDao sDao=new ShipperAuthenticationDao();
        int result = sDao.deleteShipperInfo(shopperName);
        response.setContentType("text/plain;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        //删除结果反馈客户端
        out.print(result);}
}
