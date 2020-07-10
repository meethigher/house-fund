<%@ page import="domain.Admin" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="domain.Unit" %><%--
  Created by IntelliJ IDEA.
  User: https://github.com/meethigher
  Date: 2020/6/28
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");
    String message = request.getParameter("message");
    Admin admin = (Admin) session.getAttribute("admin");
    Unit unit = (Unit) session.getAttribute("unit");
%>
<html>
<head>
    <title>个人开户-meethigher</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/main.css">
</head>
<body>
<%@include file="module/aside.jsp" %>
<div class="main">
    <%@include file="module/navbar.jsp" %>
    <div class="container-fluid">
        <div class="page-title">个人开户<a href="#" class="btn btn-info btn-sm">批量开户</a></div>
        <%
            if (message != null) {
                out.write("<error class='h3 mb-3 text-center'>" + URLDecoder.decode(message, "utf-8") + "</error>");
            }
        %>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">输入账号</th>
                <th scope="col">操作</th>
                <th scope="col">单位账号</th>
                <th scope="col">单位名称</th>
                <th scope="col">单位比例</th>
                <th scope="col">个人比例</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><input id="unitaccnum" maxlength="12" class="form-control form-control-sm" type="text"
                           placeholder="输入你的单位账号"
                           required onkeyup="this.value=this.value.replace(/\D/g,'')"></td>
                <td><a id="queryunit" class="btn btn-primary btn-sm" href="#">查询</a></td>
                <td><%=unit == null ? "请查询" : unit.getUnitaccnum()%>
                </td>
                <td><%=unit == null ? "请查询" : unit.getUnitaccname()%>
                </td>
                <td><%=unit == null ? "请查询" : unit.getUnitprop()%>
                </td>
                <td><%=unit == null ? "请查询" : unit.getPerprop()%>
                </td>
            </tr>
            </tbody>
        </table>
        <form action="person" method="post" class="row">
            <div class="col-md-6">
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">姓名</span>
                    </div>
                    <input required type="text" name="accname" class="form-control" placeholder="名称">
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">身份证</span>
                    </div>
                    <input required type="text" maxlength="20" class="form-control" name="papno"
                           onkeyup="value=value.replace(/[\W]/g,'')" placeholder="身份证号码">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">缴存基数</span>
                    </div>
                    <input type="number" name="basenumber" class="form-control" placeholder="缴存基数"></input>
                </div>
                <button type="submit" class="btn btn-primary">开户</button>
            </div>
            <div class="input-group mb-3 col-md-12">
                <div class="input-group-prepend">
                    <span class="input-group-text">备注</span>
                </div>
                <textarea type="text" name="remark" class="form-control" maxlength="50" placeholder="备注，选填"></textarea>
            </div>


        </form>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/gh/meethigher/cdn@12/js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/person.js"></script>
</body>
</html>