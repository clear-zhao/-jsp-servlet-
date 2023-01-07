<%--
  Created by IntelliJ IDEA.
  User: 赵科磊
  Date: 2022/12/13 0013
  Time: 9:11
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
    <title>JAVA购物网页</title>
    <!-- 新 Bootstrap4 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <!--商品页的css-->
    <link rel="stylesheet" href="css/shop.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <!-- bootstrap.bundle.min.js 用于弹窗、提示、下拉菜单，包含了 popper.min.js -->
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>

    <!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-xl navbar-light bg-light">
    <a class="navbar-brand" href="#"><img src="image/java_logo.png" class="img rounded"></a>
    <div class="collapse navbar-collapse" id="navbarnav">
        <ul class="navbar-nav  mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="index.jsp">主页</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="shop.jsp">商品页</a>
            </li>
        </ul>
        <ul class="navbar-nav tail">
            <li class="nav-item cart">
                <a class="nav-link" href="shopServlet?id=2"><img src="image/cart.png"></a>
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
            <img src="./image/java2.jpg">
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
<div class="low">
    <div class="low_mid">
        <h3>初级教程</h3>
        <div class="col-6 item">
            <div class="card">
                <div class="card-body">
                    <img class="card-img-top" src="image/java_low1.jpg" alt="Card image">
                    <h4 class="card-title">JAVA核心技术 卷1</h4>
                    <a href="shopServlet?id=1&item_id=1&book_name=JAVA核心技术卷1&price=24.5" class="btn btn-primary" title="加入购物车">￥24.5</a>
                </div>
            </div>
        </div>

        <div class="col-6 item">
            <div class="card">
                <div class="card-body">
                    <img class="card-img-top" src="image/java_low2.jpg" alt="Card image">
                    <h4 class="card-title">JAVA从入门到精通</h4>
                    <a href="shopServlet?id=1&item_id=2&book_name=JAVA从入门到精通&price=30" class="btn btn-primary" title="加入购物车">￥30</a>
                </div>
            </div>
        </div>

        <div class="col-6 item">
            <div class="card">
                <div class="card-body">
                    <img class="card-img-top" src="image/java_low3.jpg" alt="Card image">
                    <h4 class="card-title" style="height: 58px;">Effective JAVA</h4>
                    <a href="shopServlet?id=1&item_id=3&book_name=Effective JAVA&price=98" class="btn btn-primary" title="加入购物车">￥98</a>
                </div>
            </div>
        </div>

    </div>
</div>

<div class="intermediate">
    <div class="intermediate_mid">
        <h3>中级教程</h3>
        <div class="col-6 item">
            <div class="card">
                <div class="card-body">
                    <img class="card-img-top" src="image/java_mid1.jpg" alt="Card image">
                    <h4 class="card-title">JAVA核心技术 卷2</h4>
                    <a href="shopServlet?id=1&item_id=4&book_name=JAVA核心技术卷2&price=34.5" class="btn btn-primary" title="加入购物车">￥34.5</a>
                </div>
            </div>
        </div>

        <div class="col-6 item">
            <div class="card">
                <div class="card-body">
                    <img class="card-img-top" src="image/java_mid2.jpg" alt="Card image">
                    <h4 class="card-title">JAVA Web从入门到精通</h4>
                    <a href="shopServlet?id=1&item_id=5&book_name=JAVAWeb从入门到精通&price=38" class="btn btn-primary" title="加入购物车">￥38</a>
                </div>
            </div>
        </div>

        <div class="col-6 item">
            <div class="card">
                <div class="card-body">
                    <img class="card-img-top" src="image/java_mid3.jpg" alt="Card image">
                    <h4 class="card-title" style="height: 58px;">JAVA编程思想</h4>
                    <a href="shopServlet?id=1&item_id=6&book_name=JAVA编程思想&price=65" class="btn btn-primary" title="加入购物车">￥65</a>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="high">
    <div class="high_mid">
        <h3>高级教程</h3>
        <div class="col-6 item">
            <div class="card">
                <div class="card-body">
                    <img class="card-img-top" src="image/java_high1.jpg" alt="Card image">
                    <h4 class="card-title">Spring Boot编程思想</h4>
                    <a href="shopServlet?id=1&item_id=7&book_name=Spring Boot编程思想&price=35" class="btn btn-primary" title="加入购物车">￥35</a>
                </div>
            </div>
        </div>

        <div class="col-6 item">
            <div class="card">
                <div class="card-body">
                    <img class="card-img-top" src="image/java_high2.jpg" alt="Card image">
                    <h4 class="card-title">MyBatis 从入门到精通</h4>
                    <a href="shopServlet?id=1&item_id=8&book_name=MyBatis从入门到精通&price=62.4" class="btn btn-primary" title="加入购物车">￥62.4</a>
                </div>
            </div>
        </div>

        <div class="col-6 item">
            <div class="card">
                <div class="card-body">
                    <img class="card-img-top" src="image/java_high3.jpg" alt="Card image">
                    <h4 class="card-title">Spring Cloud微服务架构实战派</h4>
                    <a href="shopServlet?id=1&item_id=9&book_name=SpringCloud微服务架构实战派&price=29.8" class="btn btn-primary" title="加入购物车">￥29.8</a>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
