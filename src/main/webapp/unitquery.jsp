<%@ page import="java.net.URLDecoder" %>
<%@ page import="top.meethigher.house.fund.domain.Admin" %><%--
  Created by IntelliJ IDEA.
  User: https://github.com/meethigher
  Date: 2020/7/9
  Time: 8:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>单位查询-meethigher</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/main.css">
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    Admin admin = (Admin) session.getAttribute("admin");
    String message = request.getParameter("message");
%>
<%@include file="module/aside.jsp" %>
<div class="main">
    <%@include file="module/navbar.jsp" %>
    <%
        if (message != null) {
            out.write("<error class='h3 mb-3 text-center'>" + URLDecoder.decode(message, "utf-8") + "</error>");
        }
    %>
    <div class="container-fluid">
        <ul class="pagination pagination-sm pull-right mt-3">
            <li><a href="findUnitByPage?currentPage=1">首页</a></li>
            <c:forEach begin="${requestScope.begin}" end="${requestScope.end}" step="1" var="i">
                <li${requestScope.unitByPage.currentPage==i?" class=\"active\"":""}><a
                        href="findUnitByPage?currentPage=${i}">${i}</a></li>
            </c:forEach>
            <li><a href="findUnitByPage?currentPage=${requestScope.unitByPage.totalPage}">尾页</a></li>
        </ul>
        <table class="table table-hover table-sm">
            <thead>
            <tr>
                <th scope="col">单位账号</th>
                <th scope="col">名称</th>
                <th scope="col">地址</th>
                <th scope="col">账户状态</th>
                <th scope="col">缴存基数</th>
                <th scope="col">公积金余额</th>
                <th scope="col">单位月缴</th>
                <th scope="col">个人月缴</th>
                <th scope="col">单位人数</th>
                <th scope="col">开户柜员</th>
            </tr>
            </thead>
            <c:forEach items="${requestScope.unitByPage.list}" var="user">
                <tbody>
                <td>${user.unitaccnum}</td>
                <td>${user.unitaccname}</td>
                <td>${user.unitaddr}</td>
                <td>${user.accstate=="0"?"正常":"销户"}</td>
                <td>${user.basenumber}</td>
                <td>${user.balance}</td>
                <td>${user.unitpaysum}</td>
                <td>${user.perpaysum}</td>
                <td>${user.persnum}</td>
                <td>${user.op}</td>
                </tbody>
            </c:forEach>
        </table>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/gh/meethigher/cdn@12/js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
