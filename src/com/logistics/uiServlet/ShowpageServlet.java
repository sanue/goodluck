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
@WebServlet(name = "ShowpageServlet",urlPatterns = "/uiSite/car.do")
public class ShowpageServlet extends HttpServlet {
    private int pageSize = 10;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int pageCount = 1;
        if(null != request.getParameter("page")){
            pageCount = Integer.parseInt(request.getParameter("page"));
        }
        int start = (pageCount -1 ) * pageSize;
        CarInfoDao bookDao = new CarInfoDao();
        RecordSet<CarInfoAndPhone> carInfos = bookDao.getCarInfosAndPhone(start, pageSize);
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
