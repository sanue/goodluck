package com.logistics.uiServlet;

import com.logistics.bean.Register;
import com.logistics.dao.CarInfoDao;
import com.logistics.dao.GoodsDao;
import com.logistics.dao.RegisterDao;

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
@WebServlet(name = "deleteServlet",urlPatterns = "/uiSite/delete.do")
public class deleteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int goodId=Integer.parseInt(request.getParameter("orderNum"));
//        FormOrderDao foDao=new FormOrderDao();
//        int result=foDao.delete(goodId);
//        response.setContentType("text/plain;charset=utf-8");
//        response.setCharacterEncoding("utf-8");
//        PrintWriter out=response.getWriter();
//        out.print(result);
        GoodsDao goodsDao=new GoodsDao();
        CarInfoDao carInfoDao=new CarInfoDao();
        int id=Integer.parseInt(request.getParameter("id"));
        int result=0;
        Register register = (Register)request.getSession().getAttribute("register");
        String name=register.getName();
        RegisterDao registerDao=new RegisterDao();
        int identityStatus=registerDao.getIdentityByName(name);
        if(identityStatus==0){
            result=carInfoDao.delete(id);
        }
        if(identityStatus==1){
            result=goodsDao.delete(id);
        }
        response.setContentType("text/plain;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        out.print(result);


    }

}
