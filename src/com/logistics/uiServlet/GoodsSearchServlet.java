package com.logistics.uiServlet;

import com.logistics.bean.GoodsAndPhone;
import com.logistics.bean.RecordSet;
import com.logistics.dao.GoodsDao;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/10/19.
 */
@WebServlet(name = "GoodsSearchServlet" , urlPatterns = "/uiSite/searchBySel.do")
public class GoodsSearchServlet extends HttpServlet {
    int pageSize = 10;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int page = Integer.parseInt(request.getParameter("count"));
        String time = request.getParameter("time");
        String startCity = request.getParameter("startCity");
        String toCity = request.getParameter("toCity");
        GoodsDao gDao = new GoodsDao();
        int start = 0;
        if(page!=0){
            start = (page-1)*pageSize;
        }
        RecordSet<GoodsAndPhone> goods = gDao.showGoodsAndPhone(start ,pageSize,time,startCity,toCity );
        JSONObject jsonObject = new JSONObject(goods);
        String result = jsonObject.toString();
        response.setContentType("plain/charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.print(result);
    }
}
