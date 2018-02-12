package com.logistics.uiServlet;

import com.logistics.bean.CarInfoAndPhone;
import com.logistics.bean.RecordSet;
import com.logistics.dao.CarInfoDao;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/10/31.
 */
@WebServlet(name = "ShowSearchCartsServlet",urlPatterns = "/uiSite/searchCarts.html")
public class ShowSearchCartsServlet extends HttpServlet {
    private int pageSize = 10;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取相关数据
        String cartLong = request.getParameter("carLong");
        String carType = request.getParameter("carType");
        String coachType = request.getParameter("coachType");
        String startProvince = request.getParameter("startProvince");
        String startCity = request.getParameter("startCity");
        String toProvince = request.getParameter("toProvince");
        String toCity = request.getParameter("toCity");
        int pageCount = 1;
        int start = (pageCount -1 ) * pageCount;
        CarInfoDao carInfoDao = new CarInfoDao();
        RecordSet<CarInfoAndPhone>carInfoes=carInfoDao.getCarInfosAndPhoneBySelect(start , pageSize,cartLong,carType,coachType,startProvince,startCity,toProvince,toCity);
        //响应
        JSONObject jsonObject= new JSONObject(carInfoes);
        String result = jsonObject.toString();
        response.setContentType("text/plain;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.print(result);

    }
}
