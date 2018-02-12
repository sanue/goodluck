package com.logistics.uiServlet;


import com.logistics.bean.GoodsAndPhone;
import com.logistics.bean.RecordSet;
import com.logistics.dao.GoodsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/10/28.
 */
@WebServlet(name = "ShowGoodsServlet",urlPatterns = "/uiSite/goods.html")
public class ShowGoodsServlet extends HttpServlet {
    private final int pageSize = 15;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取所有的货物信息
        request.setCharacterEncoding("utf-8");
        GoodsDao gDao = new GoodsDao();
        RecordSet<GoodsAndPhone> goodsAndPhone = gDao.showGoodsAndPhone(0,pageSize,"","","");
        request.setAttribute("goodsAndPhone" , goodsAndPhone);
          //保存，发送到goods.jsp
        request.getRequestDispatcher("goods.jsp").forward(request,response);
    }
}
