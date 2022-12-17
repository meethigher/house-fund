<%--
  Created by IntelliJ IDEA.
  User: https://github.com/meethigher
  Date: 2020/6/27
  Time: 23:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String servletPath = request.getServletPath();
    String current = servletPath.substring(1);
%>
<div class="aside">
    <div class="logo">
        <img class="mb-2" style="border-radius:50%;" width="72px" height="72px"
             src="https://meethigher.top/images/kitchen.jpg" alt="">
        <h1 class="h4"><a href="https://github.com/meethigher">Github</a></h1>
        <h1 class="h4"><a href="https://meethigher.top">Blog</a></h1>
    </div>
    <ul class="menu pt-3 pb-3">
        <li<%=current.equals("person.jsp") || current.equals("personupdate.jsp") || current.equals("unit.jsp") || current.equals("unitupdate.jsp") ? " class=\"active\"" : ""%>>
            <a href="#info"
               data-toggle="collapse"<%=current.equals("person.jsp") || current.equals("personupdate.jsp") || current.equals("unit.jsp") || current.equals("unitupdate.jsp") ? " class=\"collapsed\"" : ""%>>客户管理</a>
            <ul id="info"
                class="collapse<%=current.equals("person.jsp") || current.equals("personupdate.jsp") || current.equals("unit.jsp") || current.equals("unitupdate.jsp") ? " show" : ""%>">
                <li<%=current.equals("unit.jsp") ? " class=\"active\"" : ""%>><a href="unit.jsp">单位开户</a></li>
                <li<%=current.equals("person.jsp") ? " class=\"active\"" : ""%>><a href="person.jsp">个人开户</a></li>
                <li<%=current.equals("unitupdate.jsp") ? " class=\"active\"" : ""%>><a href="unitupdate.jsp">单位资料修改</a>
                </li>
                <li<%=current.equals("personupdate.jsp") ? " class=\"active\"" : ""%>><a
                        href="personupdate.jsp">个人资料修改</a>
                </li>
            </ul>
        </li>
        <li>
            <a href="#huibujiao" class="collapsed" data-toggle="collapse">缴存入账</a>
            <ul id="huibujiao" class="collapse">
                <li><a href="#">汇缴</a></li>
                <li><a href="#">补缴</a></li>
            </ul>
        </li>
        <li<%=current.equals("unitdelete.jsp") || current.equals("persondelete.jsp") ? " class=\"active\"" : ""%>>
            <a href="#tiquxiaohu" data-toggle="collapse"<%=current.equals("unitdelete.jsp") || current.equals("persondelete.jsp") ? " class=\"collapsed\"" : ""%>>提取销户</a>
            <ul id="tiquxiaohu" class="collapse<%=current.equals("unitdelete.jsp") || current.equals("persondelete.jsp") ? " show" : ""%>">
                <li><a href="#">部分提取</a></li>
                <li><a href="#">销户提取</a></li>
                <li<%=current.equals("persondelete.jsp") ? " class=\"active\"" : ""%>><a href="persondelete.jsp">个人销户</a></li>
                <li<%=current.equals("unitdelete.jsp") ? " class=\"active\"" : ""%>><a href="unitdelete.jsp">单位销户</a></li>
            </ul>
        </li>
        <li>
            <a href="#business" class="collapsed" data-toggle="collapse">业务管理</a>
            <ul id="business" class="collapse">
                <li><a href="#">个人封存</a></li>
                <li><a href="#">个人启封</a></li>
                <li><a href="#">比例变更</a></li>
                <li><a href="#">基数变更</a></li>
            </ul>
        </li>
        <li<%=current.equals("index.jsp") ? " class=\"active\"" : ""%>><a href="index.jsp">总览</a></li>
        <li<%=current.equals("unitquery.jsp") || current.equals("personquery.jsp") ? " class=\"active\"" : ""%>>
            <a href="#query"
               data-toggle="collapse"<%=current.equals("unitquery.jsp") || current.equals("personquery.jsp") ? " class=\"collapsed\"" : ""%>>业务查询</a>
            <ul id="query"
                class="collapse<%=current.equals("unitquery.jsp") || current.equals("personquery.jsp") ? " show" : ""%>">
                <li<%=current.equals("unitquery.jsp") ? " class=\"active\"" : ""%>><a href="findUnitByPage">单位查询</a></li>
                <li<%=current.equals("personquery.jsp") ? " class=\"active\"" : ""%>><a href="findPersonByPage">个人查询</a></li>
            </ul>
        </li>
    </ul>
</div>