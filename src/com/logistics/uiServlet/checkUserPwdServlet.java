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
 * Created by Administrator on 2016/11/2.
 */
@WebServlet(name = "checkUserPwdServlet",urlPatterns = "/uiSite/checkUserPwd.do")
public class checkUserPwdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String inputUserPwd=request.getParameter("userPwd");
        String userName=request.getParameter("userName");
        RegisterDao registerDao=new RegisterDao();
        int r=registerDao.checkUserPwd(userName,inputUserPwd);
        response.setContentType("text/plain;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        out.print(r);

    }


}
