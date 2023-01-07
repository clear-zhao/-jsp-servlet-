package com.control;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LogoutServlet", value = "/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String id = request.getParameter("id");
        if(id.equals("1"))
        {
            // 删除session
            HttpSession session = request.getSession();
            session.removeAttribute("name");
            session.removeAttribute("email");
            response.sendRedirect("index.jsp");
        }
        else
        {
            // 删除cookie
            Cookie cookie1 = new Cookie("name",null);
            Cookie cookie2 = new Cookie("email",null);
            cookie1.setMaxAge(0);
            cookie1.setPath("/");
            cookie2.setMaxAge(0);
            cookie2.setPath("/");
            response.addCookie(cookie1);
            response.addCookie(cookie2);
            response.sendRedirect("index.jsp");

        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
