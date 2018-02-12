package com.logistics.uiServlet;

import com.logistics.bean.CarInfoAndPhone;
import com.logistics.bean.GoodsAndPhone;
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
@WebServlet(name = "ShowPhoneWithLoginServlet" , urlPatterns = "/uiSite/showPhone")
public class ShowPhoneWithLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String opt = request.getParameter("opt");
        String city = request.getParameter("region");
        String result = null;
        if("goods".equals(opt)){
            GoodsDao gDao = new GoodsDao();
            ArrayList<GoodsAndPhone> gp = gDao.showGoodsAndPhone(city);
            JSONArray jsonArray = new JSONArray(gp);
            result = jsonArray.toString();
        }
        if("car".equals(opt)){
            CarInfoDao cDao = new CarInfoDao();
            ArrayList<CarInfoAndPhone> cp = cDao.getCarInfosBylogin(city);
            JSONArray jsonArray = new JSONArray(cp);
            result = jsonArray.toString();
        }
        response.setContentType("text/plain;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.print(result);
    }
}
