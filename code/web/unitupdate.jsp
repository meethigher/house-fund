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
    Admin admin = (Admin) session.getAttribute("admin");
    String message = request.getParameter("message");
    Unit unit = (Unit) session.getAttribute("unit");
%>
<html>
<head>
    <title>单位资料修改-meethigher</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/main.css">
</head>
<body>
<%@include file="module/aside.jsp" %>
<div class="main">
    <%@include file="module/navbar.jsp" %>
    <div class="container-fluid">
        <div class="page-title">单位资料修改</div>
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
                <td><input id="unitaccnum" maxlength="12" class="form-control form-control-sm" type="text"
                           placeholder="输入你的单位账号"<%=unit==null?"":" value="+unit.getUnitaccnum()%>
                           required onkeyup="this.value=this.value.replace(/\D/g,'')"></td>
                <td><a id="queryunit" class="btn btn-primary btn-sm" href="#">查询</a></td>
            </tr>
            </tbody>
        </table>
        <form action="updateUnit" method="post" class="row">
            <div class="col-md-6">
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">单位名称</span>
                    </div>
                    <input required type="text" name="unitaccname" class="form-control"
                           placeholder="单位名称"<%=unit==null?"":" value="+unit.getUnitaccname()%>>
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">单位地址</span>
                    </div>
                    <input required type="text" name="unitaddr" class="form-control"
                           placeholder="单位地址"<%=unit==null?"":" value="+unit.getUnitaddr()%>>
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">联系电话</span>
                    </div>
                    <input required class="form-control" name="unitphone" placeholder="联系电话"
                           onkeyup="this.value=this.value.replace(/\D/g,'')"<%=unit==null?"":" value="+unit.getUnitphone()%>>
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">单位经办人</span>
                    </div>
                    <input required type="text" name="unitlinkman" class="form-control"
                           placeholder="单位经办人"<%=unit==null?"":" value="+unit.getUnitlinkman()%>>
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">经办人身份证号码</span>
                    </div>
                    <input required type="text" maxlength="20" class="form-control" name="unitagentpapno"
                           onkeyup="value=value.replace(/[\W]/g,'')"
                           placeholder="经办人身份证号码"<%=unit==null?"":" value="+unit.getUnitagentpapno()%>>
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">单位类别</span>
                    </div>
                    <select id="unitchar" name="unitchar" class="form-control">
                        <option value="1"<%=unit == null ? "" : (unit.getUnitchar().equals("1") ? " selected" : "")%>>
                            企业
                        </option>
                        <option value="2"<%=unit == null ? "" : (unit.getUnitchar().equals("2") ? " selected" : "")%>>
                            事业
                        </option>
                        <option value="3"<%=unit == null ? "" : (unit.getUnitchar().equals("3") ? " selected" : "")%>>
                            机关
                        </option>
                        <option value="4"<%=unit == null ? "" : (unit.getUnitchar().equals("4") ? " selected" : "")%>>
                            团体
                        </option>
                        <option value="5"<%=unit == null ? "" : (unit.getUnitchar().equals("5") ? " selected" : "")%>>
                            其他
                        </option>
                    </select>
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">企业类型</span>
                    </div>
                    <select id="unitkind" name="unitkind" class="form-control">
                        <option value="110"<%=unit == null ? "" : (unit.getUnitkind().equals("110") ? " selected" : "")%>>
                            国有经济
                        </option>
                        <option value="120"<%=unit == null ? "" : (unit.getUnitkind().equals("120") ? " selected" : "")%>>
                            集体经济
                        </option>
                        <option value="130"<%=unit == null ? "" : (unit.getUnitkind().equals("130") ? " selected" : "")%>>
                            股份合作企业
                        </option>
                        <option value="140"<%=unit == null ? "" : (unit.getUnitkind().equals("140") ? " selected" : "")%>>
                            联营企业
                        </option>
                        <option value="150"<%=unit == null ? "" : (unit.getUnitkind().equals("150") ? " selected" : "")%>>
                            有限责任公司
                        </option>
                        <option value="160"<%=unit == null ? "" : (unit.getUnitkind().equals("160") ? " selected" : "")%>>
                            股份有限责任公司
                        </option>
                        <option value="170"<%=unit == null ? "" : (unit.getUnitkind().equals("170") ? " selected" : "")%>>
                            私营企业
                        </option>
                        <option value="190"<%=unit == null ? "" : (unit.getUnitkind().equals("190") ? " selected" : "")%>>
                            其他企业
                        </option>
                        <option value="200"<%=unit == null ? "" : (unit.getUnitkind().equals("200") ? " selected" : "")%>>
                            港澳台投资企业
                        </option>
                        <option value="300"<%=unit == null ? "" : (unit.getUnitkind().equals("300") ? " selected" : "")%>>
                            外商投资企业
                        </option>
                        <option value="900"<%=unit == null ? "" : (unit.getUnitkind().equals("900") ? " selected" : "")%>>
                            其他
                        </option>
                    </select>
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">发薪日期</span>
                    </div>
                    <input required type="number" name="salarydate" max="31" min="1" class="form-control"
                           placeholder="发薪日期，填写1-31日的其中一天"<%=unit==null?"":" value="+unit.getSalarydate()%>>
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">组织机构代码</span>
                    </div>
                    <input required type="text" name="orgcode" class="form-control"
                           onkeyup="this.value=this.value.replace(/\D/g,'')"
                           placeholder="组织机构代码"<%=unit==null?"":" value="+unit.getOrgcode()%>>
                </div>
                <button type="submit" class="btn btn-primary">修改</button>
            </div>
            <div class="input-group mb-3 col-md-12">
                <div class="input-group-prepend">
                    <span class="input-group-text">备注</span>
                </div>
                <textarea type="text" name="remark" class="form-control" maxlength="50"
                          placeholder="备注，选填"><%=unit == null ? "" : unit.getRemark()%></textarea>
            </div>

        </form>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/gh/meethigher/cdn@12/js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/person.js"></script>
</body>
</html>