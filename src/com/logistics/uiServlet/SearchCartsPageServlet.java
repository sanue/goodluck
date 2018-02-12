package com.logistics.uiServlet;

import com.logistics.bean.CarInfoAndPhone;
import com.logistics.bean.RecordSet;
import com.logistics.dao.CarInfoDao;
import org.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/11/3.
 */
@WebServlet(name = "SearchCartsPageServlet",urlPatterns = "/uiSite/SearchCartsPage.do")
public class SearchCartsPageServlet extends HttpServlet {
    private int pageSize = 10;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取数据
        String cartLong = request.getParameter("carLong");
        String carType = request.getParameter("carType");
        String coachType = request.getParameter("coachType");
        String startProvince = request.getParameter("startProvince");
        String startCity = request.getParameter("startCity");
        String toProvince = request.getParameter("toProvince");
        String toCity = request.getParameter("toCity");
        int pageCount = 1;
        if(null != request.getParameter("page")){
            pageCount = Integer.parseInt(request.getParameter("page"));
        }
        int start = (pageCount -1 ) * pageSize;
        CarInfoDao bookDao = new CarInfoDao();
        RecordSet<CarInfoAndPhone> carInfos = bookDao.getCarInfosAndPhoneBySelect(start, pageSize, cartLong, carType, coachType, startProvince, startCity, toProvince,toCity);
        JSONArray jsonArray = new JSONArray(carInfos.getRecordSet());
        System.out.print(jsonArray.length());
        // JSONObject jsonObject = new JSONObject(carInfos);
        String result = jsonArray.toString();
        //String result = jsonObject.toString();
        response.setContentType("text/plain;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.print(result);
    }
}
