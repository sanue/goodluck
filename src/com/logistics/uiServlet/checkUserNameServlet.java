package com.logistics.uiServlet;

import com.logistics.dao.RegisterDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/11/1.
 */
@WebServlet(name = "checkUserNameServlet",urlPatterns = "/uiSite/checkUserName.do")
public class checkUserNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String inputUserName=request.getParameter("inputUserName");
        RegisterDao registerDao=new RegisterDao();
        int r=registerDao.checkIfExisted(inputUserName);
        response.setContentType("text/plain;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        out.print(r);

    }


}
