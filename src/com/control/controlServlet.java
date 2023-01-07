package com.control;

import com.bean.checkBean;
import com.bean.selectBean;
import com.bean.shopBean;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/controlServlet")
public class controlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //获取表单的类型，1为登录，2为注册，3为修改，4为删除，5为找回密码
        String type = request.getParameter("id");
        //初始化要读取的数据
        String name = null;
        String email = null;
        String password = null;
        String password2 = null;
        String agree = null;
        String remember =null;
        //初始化bean
        checkBean check = new checkBean();
        selectBean select = new selectBean();
        shopBean shop = new shopBean();
        if(type.equals("1"))
        {
            email = request.getParameter("email");
            password = request.getParameter("password");
            //设置格式bean的数据
            check.setEmail(email);
            check.setPassword(password);
            //设置数据库bean的数据
            select.setEmail(email);
            select.setPassword(password);
            //判断格式正确
            boolean flag = check.emailvalidate();
            boolean flag1 = check.passwordvalidate();
            if(!flag || !flag1)
            {
                request.setAttribute("check",check);
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
            //判断信息正确
            int flag2 = select.loginVerify();
            if(flag2 == 1)
            {
                //登陆成功，转跳到主界面
                //判断男用户是否要记住
                remember = request.getParameter("remember");
                name = select.sqlName();
                if(remember != null) //记住
                {
                    //创建用户的session对象
                    HttpSession session = request.getSession();
                    session.setAttribute("email",email);
                    session.setAttribute("name",name);
                    //存放Session
                    Cookie cookie = new Cookie("JSESSIONID",session.getId());
                    cookie.setMaxAge(60*60*24*30);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                }
                else
                {
                    //创建cookie对象
                    Cookie cookie1 = new Cookie("email",email);
                    Cookie cookie2 = new Cookie("name",name);
                    cookie1.setMaxAge(-1);
                    cookie1.setPath("/");
                    cookie2.setMaxAge(-1);
                    cookie2.setPath("/");
                    response.addCookie(cookie1);
                    response.addCookie(cookie2);

                }
                response.sendRedirect("index.jsp");
            }
            else {
                //验证失败
                request.setAttribute("check",select);
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        }
        if(type.equals("2"))
        {
            agree = request.getParameter("agree");
            name = request.getParameter("name");
            email = request.getParameter("email");
            password = request.getParameter("password");
            password2 = request.getParameter("password_Confirm");
            //设置格式bean的数据
            check.setName(name);
            check.setEmail(email);
            check.setPassword(password);
            check.setPassword2(password2);
            //设置数据库bean的数据
            select.setName(name);
            select.setEmail(email);
            select.setPassword(password);
            //设置shopBean的数据
            shop.setEmail(name);
            System.out.println(name);
            //判断是否勾选用户准则
            if(agree == null)
            {
                String message = "请勾选用户准则！";
                request.setAttribute("mess",message);
                request.getRequestDispatcher("register.jsp").forward(request,response);
            }
            //判断格式正确
            boolean flag = check.emailvalidate();
            boolean flag1 = check.passwordvalidate();
            boolean flag2 = check.namevalidate();
            boolean flag3 = check.password2validate();
            if(!flag || !flag1 || !flag2 || !flag3)
            {
                request.setAttribute("check",check);
                request.getRequestDispatcher("register.jsp").forward(request,response);
            }
            //判断信息正确
            int flag4 = select.loginVerify();
            if(flag4 == 1)
            {
                //用户已存在
                 request.setAttribute("check",select);
                 request.getRequestDispatcher("register.jsp").forward(request,response);

            }
            else {
                //注册成功
                //创建购物车数据库
                shop.creatUser();
                //写入数据库
                select.registerLoad();
                response.sendRedirect("login.jsp");
            }
        }
        if(type.equals("3"))
        {
            email = request.getParameter("email");
            password = request.getParameter("password");
            //设置格式bean的数据
            check.setEmail(email);
            check.setPassword(password);
            //设置数据库bean的数据
            select.setEmail(email);
            select.setPassword(password);
            //判断格式正确
            boolean flag = check.emailvalidate();
            boolean flag1 = check.passwordvalidate();
            if(!flag || !flag1)
            {
                request.setAttribute("check",check);
                request.getRequestDispatcher("reset.jsp").forward(request,response);
            }
            //判断信息正确
            int flag2 = select.resetVerify();
            if(flag2 == 1)
            {
                //修改成功，转跳到主界面
                select.resetLoad();
                response.sendRedirect("index.jsp");
            }
            else {
                //验证失败
                request.setAttribute("check",select);
                request.getRequestDispatcher("reset.jsp").forward(request,response);
            }
        }
        if(type.equals("4"))
        {
            email = request.getParameter("email");
            password = request.getParameter("password");
            //设置格式bean的数据
            check.setEmail(email);
            check.setPassword(password);
            //设置数据库bean的数据
            select.setEmail(email);
            select.setPassword(password);
            //判断格式正确
            boolean flag = check.emailvalidate();
            boolean flag1 = check.passwordvalidate();
            if(!flag || !flag1)
            {
                request.setAttribute("check",check);
                request.getRequestDispatcher("delete.jsp").forward(request,response);
            }
            //判断信息正确
            int flag2 = select.loginVerify();
            if(flag2 == 1)
            {
                //验证正确，删除该用户数据
                select.deleteLoad();
                response.sendRedirect("index.jsp");
            }
            else {
                //验证失败
                request.setAttribute("check",select);
                request.getRequestDispatcher("delete.jsp").forward(request,response);
            }
        }
        if(type.equals("5"))
        {
            email = request.getParameter("email");
            password = request.getParameter("password");
            //设置格式bean的数据
            check.setEmail(email);
            //设置数据库bean的数据
            select.setEmail(email);
            //判断格式正确
            boolean flag = check.emailvalidate();
            if(!flag)
            {
                request.setAttribute("check",check);
                request.getRequestDispatcher("forget.jsp").forward(request,response);
            }
            //判断信息正确
            int flag2 = select.resetVerify();
            if(flag2 == 1)
            {
                //验证成功，返回密码
                String pass = select.forgetLoad();
                request.setAttribute("pass",pass);
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
            else {
                //验证失败
                request.setAttribute("check",select);
                request.getRequestDispatcher("forget.jsp").forward(request,response);
            }
        }
    }

}
