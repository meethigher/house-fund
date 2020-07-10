<%@ page import="domain.Admin" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="domain.Person" %><%--
  Created by IntelliJ IDEA.
  User: https://github.com/meethigher
  Date: 2020/6/28
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");
    Admin admin = (Admin) session.getAttribute("admin");
    String message = request.getParameter("message");
    Person person = (Person) session.getAttribute("person");
%>
<html>
<head>
    <title>个人资料修改-meethigher</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/main.css">
</head>
<body>
<%@include file="module/aside.jsp" %>
<div class="main">
    <%@include file="module/navbar.jsp" %>
    <div class="container-fluid">
        <div class="page-title">个人资料修改</div>
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
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><input id="peraccnum" maxlength="12" class="form-control form-control-sm" type="text"
                           placeholder="输入你的个人账号"
                           required
                           onkeyup="this.value=this.value.replace(/\D/g,'')"<%=person==null?"":" value="+person.getAccnum()%>>
                </td>
                <td><a id="queryperson" class="btn btn-primary btn-sm" href="#">查询</a></td>
            </tr>
            </tbody>
        </table>
        <form action="updatePerson" method="post" class="row">
            <div class="col-md-6">
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">姓名</span>
                    </div>
                    <input required type="text" name="accname" class="form-control"
                           placeholder="名称"<%=person==null?"":" value="+person.getAccname()%>>
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">身份证</span>
                    </div>
                    <input required type="text" maxlength="20" class="form-control" name="papno"
                           onkeyup="value=value.replace(/[\W]/g,'')"
                           placeholder="身份证号码"<%=person==null?"":" value="+person.getPapno()%>>
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">单位账号</span>
                    </div>
                    <input type="number" class="form-control" placeholder="单位账号"
                           disabled<%=person == null ? "" : " value=" + person.getUnitaccnum()%>></input>
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">单位名称</span>
                    </div>
                    <input type="text" class="form-control" placeholder="单位名称"
                           disabled<%=person == null ? "" : " value=" + person.getUnitaccname()%>></input>
                </div>
            </div>
            <div class="input-group mb-3 col-md-12">
                <div class="input-group-prepend">
                    <span class="input-group-text">备注</span>
                </div>
                <textarea type="text" name="remark" class="form-control" placeholder="备注，选填"
                          maxlength="50"><%=person == null ? "" : person.getRemark()%></textarea>
            </div>
            <div class="col-md-6">
                <button type="submit" class="btn btn-primary">修改</button>
            </div>


        </form>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/gh/meethigher/cdn@12/js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/person.js"></script>
</body>
</html>