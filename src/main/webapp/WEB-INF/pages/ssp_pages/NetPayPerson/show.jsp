<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*" %>
<html>
<head>
    <%@include file="../../base_pages/base.jsp" %>
    <script src="<c:url value="/js/teletext.js"/>" type="text/javascript"></script>
</head>
<body class="claro">
<fieldset style="margin: 10px 0; padding: 10px; border: #DDD 1px solid">
    <legend>柜员详情查看
    </legend>
    <mvc:form action="save.do" theme="simple" method="post" id="form1"
              data-dojo-type="dijit.form.Form">
        <table class="grid">
            <tr>
                <td colspan="4" class="tb_title">
                    柜员详细信息
                </td>
            </tr>

            <tr>
                <td class="lgridlist">商户号:</td>
                <td>${model.merchant}</td>
                <td class="lgridlist">终端号:</td>

                <td>${model.terminal}</td>
            </tr>
            <tr>
                <td class="lgridlist">柜员号:</td>
                <td>${model.userId}</td>
                <td class="lgridlist">柜员名称:</td>
                <td>${model.name}</td>

            </tr>
            <tr>
                <td class="lgridlist">柜员电话:</td>
                <td>${model.phone}</td>
                <td class="lgridlist">柜员级别:</td>
                <td>${model.level}</td>
            </tr>
        </table>
        <table class="b">
            <tr align="center">
                <td><input type="button" value="返回"
                           onclick="javascript:history.back()"/></td>
            </tr>
        </table>
    </mvc:form>
</fieldset>
</body>
</html>

