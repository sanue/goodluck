package com.logistics.servlet;

import com.logistics.bean.Goods;
import com.logistics.dao.GoodsDao;

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
@WebServlet(name = "GoodsInfoServlet" , urlPatterns = "/manageSite/goodsInfo.html")
public class GoodsInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        GoodsDao gDao = new GoodsDao();
        ArrayList<Goods> goodses = gDao.getAllGoods();
        request.setAttribute("allGoods" , goodses);
        request.getRequestDispatcher("goodsInfo.jsp").forward(request , response);
    }
}
