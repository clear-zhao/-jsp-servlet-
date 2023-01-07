<%--
  Created by IntelliJ IDEA.
  User: 赵科磊
  Date: 2022/12/16 0016
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>忘记</title>
    <!-- 新 Bootstrap4 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <!--首页的css-->
    <link rel="stylesheet" href="css/login.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>

    <!-- bootstrap.bundle.min.js 用于弹窗、提示、下拉菜单，包含了 popper.min.js -->
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>

    <!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body class="my-login-page">
<section class="h-100">
    <div class="container h-100">
        <div class="row justify-content-md-center align-items-center h-100">
            <div class="card-wrapper">
                <div class="brand">
                    <img src="image/logo.jpg" alt="bootstrap 4 login page">
                </div>
                <div class="card fat">
                    <div class="card-body">
                        <h4 class="card-title">找回密码</h4>
                        <form method="POST" class="my-login-validation" novalidate="" action="/jsp_project_war_exploded/controlServlet?id=5">
                            <div class="form-group">
                                <label for="email">E-Mail 地址</label><p class="text-danger">${check.error.email}</p>
                                <input id="email" type="email" class="form-control" name="email" value="" required autofocus>

                            </div>

                            <div class="form-group m-0">
                                <button type="submit" class="btn btn-primary btn-block">
                                    找回
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

</body>
</html>
