package com.logistics.uiServlet;

import com.logistics.bean.Register;
import com.logistics.dao.RegisterDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/10/28.
 */
@WebServlet(name = "registerServlet",urlPatterns = "/uiSite/register.do")
public class registerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name=request.getParameter("userName");
        String password=request.getParameter("userPwd");
        String phoneNum=request.getParameter("phoneNum");
        String sex=request.getParameter("sex");
        int identity=Integer.parseInt(request.getParameter("identity"));
        RegisterDao rd=new RegisterDao();
        Register r = new Register(name, password, sex, phoneNum, identity, 0);
        int res = rd.register(r);

        //
        request.getSession().setAttribute("register",r);
        response.setContentType("text/plain;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        out.print(res);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
