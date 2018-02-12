package com.logistics.uiServlet;

import com.logistics.bean.CarInfo;
import com.logistics.bean.Goods;
import com.logistics.dao.CarInfoDao;
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
@WebServlet(name = "ShowGoodsByRegionServlet" ,urlPatterns = "/uiSite/showByRegion")
public class ShowGoodsByRegionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String opt = request.getParameter("opt");
        String city = request.getParameter("startCity");
        String result = null;
        response.setContentType("plain/text;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        if("goods".equals(opt)){
            GoodsDao gDao = new GoodsDao();
            ArrayList<Goods> goods = gDao.getGoodsByCity(city);
            JSONArray jsonArray = new JSONArray(goods);
            result = jsonArray.toString();
        }
        if("car".equals(opt)){
            CarInfoDao cDao = new CarInfoDao();
            ArrayList<CarInfo> cars = cDao.getCarInfosByRegion(city);
            JSONArray jsonArray = new JSONArray(cars);
            result = jsonArray.toString();
        }
        out.print(result);
    }
}
