<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*" %>
<html>
<head>
    <%@include file="../../base_pages/base.jsp" %>
    <script src="<c:url value="/js/teletext.js"/>" type="text/javascript"></script>
</head>
<body class="claro">
<fieldset style="margin: 10px 0; padding: 10px; border: #DDD 1px solid">
    <legend>私钥详情查看
    </legend>
    <mvc:form action="save.do" theme="simple" method="post" id="form1"
              data-dojo-type="dijit.form.Form">
        <table class="grid">
            <tr>
                <td colspan="4" class="tb_title">
                    私钥详细信息
                </td>
            </tr>

            <tr>
                <td>版本号:</td>
                <td>${model.keyVer}</td>
            </tr>
            <tr>
                <td>公钥指数:</td>
                <td>${model.publicE}</td>
            </tr>
            <tr>
                <td>公钥膜:</td>
                <td>${model.publicM}</td>
            </tr>
            <tr>
                <td>私钥指数:</td>
                <td>${model.privateD}</td>
            </tr>
            <tr>
                <td>私钥膜:</td>
                <td>${model.privateM}</td>
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

