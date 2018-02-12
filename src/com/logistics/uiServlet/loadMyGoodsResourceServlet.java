package com.logistics.uiServlet;

import com.logistics.bean.Goods;
import com.logistics.bean.Register;
import com.logistics.dao.GoodsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/11/3.
 */
@WebServlet(name = "loadMyGoodsResourceServlet",urlPatterns = "/uiSite/myGoodResource.html")
public class loadMyGoodsResourceServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        GoodsDao goodsDao=new GoodsDao();
        Register register = (Register)request.getSession().getAttribute("register");
        String name = null;
        if(null!=register){
            name = register.getName();
        }
        ArrayList<Goods> gd = goodsDao.getGoodsByName(name);
        request.setAttribute("goods",gd);
        request.setAttribute("register",name);
        request.getRequestDispatcher("myGoodResource.jsp").forward(request,response);
    }
}
