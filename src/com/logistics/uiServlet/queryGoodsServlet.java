package com.logistics.uiServlet;

import com.logistics.bean.Goods;
import com.logistics.dao.GoodsDao;
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
 * Created by Administrator on 2016/11/1.
 */
@WebServlet(name = "queryGoodsServlet",urlPatterns = "/uiSite/queryGoods.do")
public class queryGoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String loadingTime=request.getParameter("loadingTime");
        String startRegion=request.getParameter("startRegion");
        String toRegion=request.getParameter("toRegion");
        String startCity=startRegion.equals("")?"":startRegion.split("-")[1];
        String toCity=toRegion.equals("")?"":toRegion.split("-")[1];
        ArrayList<Goods> goods=null;
        GoodsDao goodsDao=new GoodsDao();
        if(startCity!=""&&toCity==""&&loadingTime==""){
            //根据装货地点获取货物信息
            goods=goodsDao.getGoodsByCity(startCity);

        }else if(startCity!=""&&toCity==""&&loadingTime!=""){
            //根据装货时间和地点获取货物信息
            goods=goodsDao.getGoodsByTimeAndloading(startCity,loadingTime);

        }else if(startCity!=""&&toCity!=""&&loadingTime!=""){
            //根据时间，装货地点，送货地点获取货物信息
            goods=goodsDao.getGoodsByTimeAndloadingAndUnloading(startCity,toCity,loadingTime);
        }
        JSONArray jsonArray=new JSONArray(goods);
        String result=jsonArray.toString();
        response.setContentType("text/plain;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        out.print(result);
    }
}
