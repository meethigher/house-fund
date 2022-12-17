<%--
  Created by IntelliJ IDEA.
  User: https://github.com/meethigher
  Date: 2020/6/27
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg navbar-light">
    <a class="navbar-brand" href="#">住房公积金管理系统</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link active" href="#"><span style="color:hotpink"><%=admin.getUsername()%>，</span>欢迎你</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="exit">注销</a>
            </li>
        </ul>
    </div>
</nav>

