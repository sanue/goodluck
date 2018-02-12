package com.logistics.uiServlet;

import com.logistics.bean.FormOrder;
import com.logistics.dao.FormOrderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/31.
 */
@WebServlet(name = "loadAllOrdersServlet",urlPatterns = "/uiSite/goodsOrder.html")
public class loadAllOrdersServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        FormOrderDao foDao=new FormOrderDao();
        ArrayList<FormOrder> fo=(ArrayList<FormOrder>) foDao.getAllFormOrder("荷","雪");
        request.setAttribute("formorder",fo);
        request.getRequestDispatcher("releaseMes.jsp").forward(request,response);

    }
}
