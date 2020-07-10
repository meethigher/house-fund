<%@ page import="domain.Admin" %>
<%@ page import="java.net.URLDecoder" %><%--
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

%>
<html>
<head>
    <title>单位开户-meethigher</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/main.css">
</head>
<body>
<%@include file="module/aside.jsp" %>
<div class="main">
    <%@include file="module/navbar.jsp" %>
    <div class="container-fluid">
        <div class="page-title">单位开户</div>
        <%
            if (message != null) {
                out.write("<error class='h3 mb-3 text-center'>" + URLDecoder.decode(message, "utf-8") + "</error>");
            }
        %>
        <form action="unit" method="post" class="row">
            <div class="col-md-6">
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">单位名称</span>
                    </div>
                    <input required type="text" name="unitaccname" class="form-control" placeholder="单位名称">
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">单位地址</span>
                    </div>
                    <input required type="text" name="unitaddr" class="form-control" placeholder="单位地址">
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">联系电话</span>
                    </div>
                    <input required class="form-control" name="unitphone" placeholder="联系电话"
                           onkeyup="this.value=this.value.replace(/\D/g,'')">
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">单位经办人</span>
                    </div>
                    <input required type="text" name="unitlinkman" class="form-control" placeholder="单位经办人">
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">组织机构代码</span>
                    </div>
                    <input required type="text" name="orgcode" class="form-control"
                           onkeyup="this.value=this.value.replace(/\D/g,'')" placeholder="组织机构代码">
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">经办人身份证号码</span>
                    </div>
                    <input required type="text" maxlength="20" class="form-control" name="unitagentpapno"
                           onkeyup="value=value.replace(/[\W]/g,'')" placeholder="经办人身份证号码">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">单位类别</span>
                    </div>
                    <select id="unitchar" name="unitchar" class="form-control">
                        <option value="1">企业</option>
                        <option value="2">事业</option>
                        <option value="3">机关</option>
                        <option value="4">团体</option>
                        <option value="5">其他</option>
                    </select>
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">企业类型</span>
                    </div>
                    <select id="unitkind" name="unitkind" class="form-control">
                        <option value="110">国有经济</option>
                        <option value="120">集体经济</option>
                        <option value="130">股份合作企业</option>
                        <option value="140">联营企业</option>
                        <option value="150">有限责任公司</option>
                        <option value="160">股份有限责任公司</option>
                        <option value="170">私营企业</option>
                        <option value="190">其他企业</option>
                        <option value="200">港澳台投资企业</option>
                        <option value="300">外商投资企业</option>
                        <option value="900">其他</option>
                    </select>
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">发薪日期</span>
                    </div>
                    <input required type="number" name="salarydate" max="31" min="1" class="form-control"
                           placeholder="发薪日期，填写1-31日的其中一天">
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">单位比例</span>
                    </div>
                    <select name="unitprop" id="unitprop" class="form-control">
                        <option value="0.05">5</option>
                        <option value="0.06">6</option>
                        <option value="0.07">7</option>
                        <option value="0.08">8</option>
                        <option value="0.09">9</option>
                        <option value="0.10">10</option>
                        <option value="0.11">11</option>
                        <option value="0.12">12</option>
                    </select>
                    <div class="input-group-append">
                        <span class="input-group-text">%</span>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">个人比例</span>
                    </div>
                    <select name="perprop" id="perprop" class="form-control">
                        <option value="0.05">5</option>
                        <option value="0.06">6</option>
                        <option value="0.07">7</option>
                        <option value="0.08">8</option>
                        <option value="0.09">9</option>
                        <option value="0.10">10</option>
                        <option value="0.11">11</option>
                        <option value="0.12">12</option>
                    </select>
                    <%--                    <input required type="text" name="perprop" class="form-control" min="5" max="12" placeholder="个人比例">--%>
                    <div class="input-group-append">
                        <span class="input-group-text">%</span>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">开户</button>
            </div>
            <div class="input-group mb-3 col-md-12">
                <div class="input-group-prepend">
                    <span class="input-group-text">备注</span>
                </div>
                <textarea type="text" name="remark" maxlength="50" class="form-control" placeholder="备注，选填"></textarea>
            </div>

        </form>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/gh/meethigher/cdn@12/js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
