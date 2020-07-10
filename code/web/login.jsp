<%--
  Created by IntelliJ IDEA.
  User: https://github.com/meethigher
  Date: 2020/6/27
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录-meethigher</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/particle.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
<script src="js/particle.js"></script>
<%
    String login_error = (String) request.getAttribute("login_error");
    String cc_error = (String) request.getAttribute("cc_error");
%>
<form class="form-signin" method="post" action="login">
    <img class="mb-4 logo" src="https://meethigher.top/images/kitchen.jpg" alt="" width="72" height="72">
    <h1 class="h3 mb-3 font-weight-normal text-center" style="color:#fff">住房公积金管理系统</h1>
    <%
        if (login_error != null) {
            out.write("<error class='h3 mb-3 text-center'>" + login_error + "</error>");
        }
        if (cc_error != null) {
            out.write("<error class='h3 mb-3 text-center'>" + cc_error + "</error>");
        }
    %>
    <label for="username" class="sr-only">管理员账号</label>
    <input type="text" id="username" name="username" class="form-control" placeholder="管理员账号" required="" autofocus="">
    <label for="password" class="sr-only">管理员密码</label>
    <input type="password" id="password" name="password" class="form-control" placeholder="管理员密码" required="">
    <label for="code" class="sr-only">验证码</label>
    <input type="text" id="code" name="checkcode" class="form-control" placeholder="不区分大小写 点击刷新" required="">
    <img src="checkcode" id="checkcode" alt=""
         style="height: 46px;position: absolute;right: 15px;bottom: 151px;z-index:99">
    <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
    <p class="mt-5 mb-3 text-muted">©2020 All Rights Reserved https://meethigher.top/</p>
</form>

<script src="https://cdn.jsdelivr.net/gh/meethigher/cdn@12/js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
    document.querySelector("#checkcode").onclick = function () {
        let url = "checkcode";
        let date = new Date().getTime();
        this.setAttribute("src", url + "?" + date)
    }
</script>
</body>
</html>
