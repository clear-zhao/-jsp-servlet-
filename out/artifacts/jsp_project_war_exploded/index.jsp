<%--
  Created by IntelliJ IDEA.
  User: 赵科磊
  Date: 2022/12/12 0012
  Time: 11:55
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
    <title>JAVA学习网页</title>
    <!-- 新 Bootstrap4 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <!--首页的css-->
    <link rel="stylesheet" href="css/index.css">
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
          <a class="nav-link" href="shopServlet?id=2"><img src="image/cart.png" alt="123"></a>
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

  <div class="introduction">
    <div class="intr_mid">
      <div class="intr_info">
        <h1>JAVA</h1>
        <h3>一种编程语言</h3>
        &nbsp;&nbsp;Java是一门面向对象的编程语言，不仅吸收了C++语言的各种优点，还摒弃了C++里难以理解的多继承、指针等概念，因此Java语言具有功能强大和简单易用两个特征。Java语言作为静态面向对象编程语言的代表，极好地实现了面向对象理论，允许程序员以优雅的思维方式进行复杂的编程。<br />
        &nbsp;&nbsp;Java具有简单性、面向对象、分布式、健壮性、安全性、平台独立与可移植性、多线程、动态性等特点 。Java可以编写桌面应用程序、Web应用程序、分布式系统和嵌入式系统应用程序等。
      </div>
      <div class="intr_img">
        <img src="image/intr.png" class="img3 rounded">
      </div>
    </div>
  </div>

  <div class="what">
    <div class="what_mid">
      <div class="what_info">
        <h1>JAVA可以干什么</h1>
        Java可以用来编写网站<br/>
        &nbsp;&nbsp;现在很多大型网站都用jsp写的，JSP 全名为 Java ServerPages。。<br/>
        Java可以做Android<br/>
        &nbsp;&nbsp;Android是一种基于Linux的自由及开放源代码的操作系统，其源代码是Java。<br/>
        Java可以做游戏<br/>
        &nbsp;&nbsp;或者你不知道，在以前诺基亚还很流行的时候，你玩的手机游戏有90%以上都是Java开发的。当然现在已经很少人再去开发了，都转到安卓上去了。电脑上也有java开发的游戏，最经典的是:《我的世界》(mine craft，简称MC)。<br/>
        Java可以做软件<br/>
        &nbsp;&nbsp;一般编程语言都可以做软件的，Java 也不例外，例如Eclipse，IDEA等知名Java开发工具。<br/>
        Java还有很多用途,家里的洗衣机、微波炉等...<br/>
      </div>
      <div class="what_img ">
        <img src="image/what.png" class="img3 rounded">
      </div>
    </div>
  </div>
  <div class="learn">
    <div class="learn_mid">
      <div class="learn_info">
        <h1>如何学习JAVA</h1>
        一、JavaSE基础<br/>
        二、数据库<br/>
        三、Web开发<br/>
        四、高级框架<br/>
        五、工具<br/>
        &nbsp;&nbsp;Java基础要打好那JavaSE必然要学好。<br/>
        J&nbsp;&nbsp;avaSE就是一种标准版，是Java语言的基础部分，Java衍生出来的各种框架（如Spring系列）各种产品都是基于JavaSE标准，JavaSE是Java向上发展的基础。<br/>
        &nbsp;&nbsp;主要包含内容：数据类型、基础语法、运算符、流程控制、数组、面向对象、常用类、异常处理、集合、IO流、多线程、反射、注解、解析、网络编程。<br/>
        点击<a href="shop.jsp">这里</a>，马上开始学习！
      </div>
      <div class="learn_img">
        <img src="image/learn.png" class="img3 rounded">
      </div>
    </div>
  </div>
  <div class="foot">
    <h1 align="center">软件工程2002班&nbsp;&nbsp;&nbsp;20203206235&nbsp;&nbsp;&nbsp;赵科磊</h1>
  </div>
  </body>
</html>
