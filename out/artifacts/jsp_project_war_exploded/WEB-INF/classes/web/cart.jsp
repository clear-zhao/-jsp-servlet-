<%@ page import="java.util.ArrayList" %>
<%@ page import="com.bean.Item" %><%--
  Created by IntelliJ IDEA.
  User: 赵科磊
  Date: 2022/12/17 0017
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int flag = 0;//判断是否第一次登录
    String name_session =(String) request.getSession().getAttribute("name");
    String email_session = (String) request.getSession().getAttribute("email");
    String name_cookie = null;
    String email_cookie = null;
    if(name_session == null)
    {
        Cookie cookie = null;
        Cookie[] cookies = null;
        // 获取cookies的数据,是一个数组
        cookies = request.getCookies();
        if( cookies != null ){
            for (int i = 0; i < cookies.length; i++)
            {
                cookie = cookies[i];
                String user_name = cookie.getName();
                if(user_name.equals("name"))
                {
                    name_cookie =cookie.getValue();
                    flag = 1;
                }
                if(user_name.equals("email"))
                {
                    email_cookie =cookie.getValue();
                    flag = 1;
                }
            }
        }
    }
    else
    {
        flag = 1;
    }
%>
<html>
<head>
    <title>
        购物车
    </title>
    <!-- 新 Bootstrap4 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <!--商品页的css-->
    <link rel="stylesheet" href="css/cart.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <!-- bootstrap.bundle.min.js 用于弹窗、提示、下拉菜单，包含了 popper.min.js -->
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>

    <!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-xl navbar-light bg-light">
    <a class="navbar-brand" href="#"><img src="image/java_logo.png" class="img rounded" ></a>
    <div class="collapse navbar-collapse" id="navbarnav">
        <ul class="navbar-nav  mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="index.jsp">主页</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="shop.jsp">商品页</a>
            </li>
        </ul>
        <ul class="navbar-nav tail">
            <li class="nav-item cart">
                <a class="nav-link" href="#"><img src="image/cart.png" alt="123"></a>
            </li>
            <%
                int id = 0;  // 判断是session还是cookie变量
                if(flag == 0)
                {
                    out.print(
                            "<li class=\"nav-item cart\">\n" +
                                    "          <a class=\"nav-link\" href=\"login.jsp\"><img src=\"image/login.png\"></a>\n" +
                                    "          </li>"
                    );
                }
                else
                {
                    out.print(
                            "          <li class=\"nav-item dropdown\">\n" +
                                    "          <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdownMenuLink\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n" );

                    if(name_session != null)
                    {
                        id = 1;
                        out.print(name_session + "\n");
                    }
                    else
                    {
                        id = 2;
                        out.print(name_cookie + "\n");
                    }
                    out.print(
                            "          </a>\n" +
                                    "          <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdownMenuLink\">\n" +
                                    "          <a class=\"dropdown-item\" href=\"reset.jsp\">修改用户</a>\n" +
                                    "          <a class=\"dropdown-item\" href=\"delete.jsp\">删除用户</a>\n" +
                                    "          <a class=\"dropdown-item\" href=\"LogoutServlet?id=" + id + "\">退出登录</a>\n" +
                                    "          </div>\n" +
                                    "          </li>"
                    );

                }

            %>

        </ul>
    </div>
</nav>
<!--滑动轮播-->
<div id="demo" class="carousel slide" data-ride="carousel">
    <!-- 轮播指标 -->
    <ul class="carousel-indicators">
        <li data-target="#demo" data-slide-to="0" class="active"></li>
        <li data-target="#demo" data-slide-to="1"></li>
        <li data-target="#demo" data-slide-to="2"></li>
    </ul>
    <!-- 轮播图片 -->
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="./image/java1.jpg">
        </div>
        <div class="carousel-item">
            <img  src="./image/java2.jpg">
        </div>
        <div class="carousel-item">
            <img src="./image/java3.png">
        </div>
    </div>
    <!-- 左右切换按钮 -->
    <a class="carousel-control-prev" href="#demo" data-slide="prev">
        <span class="carousel-control-prev-icon"></span>
    </a>
    <a class="carousel-control-next" href="#demo" data-slide="next">
        <span class="carousel-control-next-icon"></span>
    </a>
</div>

<div class="show">
    <div class="show_mid">
        <%
            ArrayList<Item> list = (ArrayList<Item>) request.getAttribute("list");
            if(list.size() == 0)
            {
                out.print(
                        "<h2>您的购物车为空，快去<a href=\"shop.jsp\">购物</a>吧</h2>"
                );
            }
            else
            {
                int id1,id2,id3,id4,id5,id6,id7,id8,id9;
                float all_price = 0;
                String type = null;
                for(int i=0;i< list.size();i++)
                {
                    Item item = list.get(i);
                    int book_id = item.getId();
                    String book_name = item.getBook_name();
                    float price = item.getPrice();
                    all_price += price;
                    if(book_id >=1 && book_id <=3)
                    {
                        type = "low"+(book_id%3+1);
                    }
                    if(book_id >=4 && book_id <=6)
                    {
                        type = "mid"+(book_id%3+1);
                    }
                    if(book_id >=7 && book_id <=9)
                    {
                        type = "high"+(book_id%3+1);
                    }
                    out.print(
                            "<div class=\"col-6 item\">\n" +
                                    "            <div class=\"card\">\n" +
                                    "                <div class=\"card-body\">\n" +
                                    "                    <img class=\"card-img-top\" src=\"image/java_" + type + ".jpg\" alt=\"Card image\">\n" +
                                    "                    <h4 class=\"card-title\">" + book_name + "</h4>\n" +
                                    "                    <a href=\"#\" class=\"btn btn-primary\" title=\"加入购物车\">" + price + "</a>\n" +
                                    "                </div>\n" +
                                    "            </div>\n" +
                                    "        </div>"
                    );

                }
                out.print(
                        "<div class=\"price\"><h2>总价格为：" + all_price + "</h2></div>"
                );
                out.print(
                        "<div class=\"clear\"><a href=\"shopServlet?id=3\" class=\"btn btn-primary\" title=\"清空\">清空购物车</a></div>"
                );
            }
        %>
    </div>
</div>

</body>
</html>
