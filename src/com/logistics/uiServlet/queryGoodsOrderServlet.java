package com.logistics.uiServlet;

import com.logistics.bean.FormOrder;
import com.logistics.dao.FormOrderDao;
import org.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/29.
 */
@WebServlet(name = "queryGoodsOrderServlet",urlPatterns = "/uiSite/queryGoodsOrder.do")
public class queryGoodsOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String fromDate=request.getParameter("fromDate");
        String toDate=request.getParameter("toDate");
        String fromRegion=request.getParameter("fromRegion");
        /*if(!"".equals(fromRegion)){

        }*/
        String fromCity =fromRegion.equals("")?"": fromRegion.split("-")[1];
        String toRegion=request.getParameter("toRegion");
        /*
        if(!"".equals(toRegion)){

        }*/
        String toCity =toRegion.equals("")?"": toRegion.split("-")[1];
        ArrayList<FormOrder> orders=null;
        FormOrderDao foDao=new FormOrderDao();

        orders=foDao.getOrdersByTimeAndAddress("荷","雪",fromDate,toDate,fromCity,toCity);

        JSONArray jsonArray=new JSONArray(orders);
        String result=jsonArray.toString();

        response.setContentType("text/plain;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        out.print(result);

    }


}
