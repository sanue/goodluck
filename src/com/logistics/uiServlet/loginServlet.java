package com.logistics.uiServlet;

import com.logistics.bean.Register;
import com.logistics.dao.RegisterDao;
import org.json.JSONObject;

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
@WebServlet(name = "loginServlet",urlPatterns = "/uiSite/login.do")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name=request.getParameter("username");
        String password=request.getParameter("password");
        RegisterDao rd=new RegisterDao();
        Register register=rd.login(name,password);
        String result = null;
        if(null!=register){
            request.getSession().setAttribute("register",register);
            JSONObject jsonObject = new JSONObject(register);
            result = jsonObject.toString();
        }
        response.setContentType("text/plain;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.print(result);
    }


}
