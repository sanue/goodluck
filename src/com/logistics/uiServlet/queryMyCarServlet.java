package com.logistics.uiServlet;

import com.logistics.bean.CarInfo;
import com.logistics.bean.Register;
import com.logistics.dao.CarInfoDao;
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
 * Created by Administrator on 2016/11/4.
 */
@WebServlet(name = "queryMyCarServlet",urlPatterns = "/uiSite/queryMyCar.do")
public class queryMyCarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        根据装货地，卸货地，货主姓名，获取对应的发布信息
        request.setCharacterEncoding("utf-8");
        String fromRegion=request.getParameter("fromRegion");
        String toRegion=request.getParameter("toRegion");
        String fromCity =fromRegion.equals("")?"": fromRegion.split("-")[1];
        String toCity =toRegion.equals("")?"": toRegion.split("-")[1];
        Register register = (Register)request.getSession().getAttribute("register");
        String name=register.getName();
        ArrayList<CarInfo> ci = null;
        CarInfoDao ciDao=new CarInfoDao();
        ci=ciDao.getCarByShipperStartCityToCity(name, fromCity, toCity);

        JSONArray jsonArray=new JSONArray(ci);
        String result=jsonArray.toString();
        request.setAttribute("register",register);
        response.setContentType("text/plain;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        out.print(result);

    }

}
