<%@ page import="domain.Admin" %>
<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: https://github.com/meethigher
  Date: 2020/6/27
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");
    Admin admin = (Admin) session.getAttribute("admin");
    String message = request.getParameter("message");
%>
<html>
<head>
    <title>总览-meethigher</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/main.css">
</head>
<body>
<%@include file="module/aside.jsp" %>
<div class="main">
    <%@include file="module/navbar.jsp" %>
    <%
        if (message != null) {
            out.write("<error class='h3 mb-3 text-center'>" + URLDecoder.decode(message, "utf-8") + "</error>");
        }
    %>
    <div class="container-fluid">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">综合柜员</th>
                <th scope="col">密码</th>
                <th scope="col">登录地址</th>
                <th scope="col">登录时间</th>
                <th scope="col">操作</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><%=admin.getUsername()%>
                </td>
                <td><input id="newps" class="form-control form-control-sm" type="text" placeholder="输入新密码，为空则不修改"></td>
                <td><%=admin.getAddr()%>
                </td>
                <td><%=admin.getLasttime()%>
                </td>
                <td><a id="updateps" class="btn btn-primary btn-sm" href="#">修改</a></td>
            </tr>
            </tbody>
        </table>
        <div class="jumbotron">
            <h1 class="display-4">欢迎使用！</h1>
            <p class="lead">这是一个开源的住房公积金管理系统，采用了spring框架，以jsp和bootstrap搭建而成，使用了mvc开发模式。作者的github与blog请点击右上角</p>
            <hr class="my-4">
            <p>本质上是对数据库进行的增删改查操作。6月27-29号搭页面，7月6-9号写逻辑，9号竣工。菜逼的练习之作。</p>
            <a class="btn btn-primary btn-lg" href="https://github.com/meethigher" role="button">了解更多</a>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/gh/meethigher/cdn@12/js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/index.js"></script>
</body>
</html>
