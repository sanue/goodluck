package com.logistics.servlet;

import com.logistics.bean.OwnerInfo;
import com.logistics.dao.BaseInfoDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/27.
 */
@WebServlet(name = "OwnerInfoServlet" , urlPatterns = "/manageSite/owner.html")
public class OwnerInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
       BaseInfoDao bDao = new BaseInfoDao();
        ArrayList<OwnerInfo> OwnerInfos = bDao.getAllOwnerInfo(0);
        request.setAttribute("allOwnerInfos" , OwnerInfos);
        request.getRequestDispatcher("owner.jsp").forward(request , response);
    }
}
