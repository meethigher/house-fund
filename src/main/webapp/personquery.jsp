<%@ page import="java.net.URLDecoder" %>
<%@ page import="top.meethigher.house.fund.domain.Admin" %>
<%@ page import="top.meethigher.house.fund.domain.Page" %><%--
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
    <title>个人查询-meethigher</title>
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
            <li><a href="findPersonByPage?currentPage=1">首页</a></li>
            <c:forEach begin="${requestScope.begin}" end="${requestScope.end}" step="1" var="i">
                <li${requestScope.personByPage.currentPage==i?" class=\"active\"":""}><a
                        href="findPersonByPage?currentPage=${i}">${i}</a></li>
            </c:forEach>
            <li><a href="findPersonByPage?currentPage=${requestScope.personByPage.totalPage}">尾页</a></li>
        </ul>
        <table class="table table-hover table-sm">
            <thead>
            <tr>
                <th scope="col">个人账号</th>
                <th scope="col">姓名</th>
                <th scope="col">所在单位</th>
                <th scope="col">账户状态</th>
                <th scope="col">缴存基数</th>
                <th scope="col">公积金余额</th>
                <th scope="col">单位月缴</th>
                <th scope="col">个人月缴</th>
                <th scope="col">开户柜员</th>

            </tr>
            </thead>
            <c:forEach items="${requestScope.personByPage.list}" var="user">
                <tbody>
                <td>${user.accnum}</td>
                <td>${user.accname}</td>
                <td>${user.unitaccnum}</td>
                <td>${user.peraccstate=="0"?"正常":"销户"}</td>
                <td>${user.basenumber}</td>
                <td>${user.balance}</td>
                <td>${user.unitmonpaysum}</td>
                <td>${user.permonpaysum}</td>
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
