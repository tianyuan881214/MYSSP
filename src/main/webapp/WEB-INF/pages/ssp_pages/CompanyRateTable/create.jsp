<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*" %>
<html>
<head>
    <%@include file="../../base_pages/base.jsp" %>
    <script src="<c:url value="/js/teletext.js"/>" type="text/javascript"></script>
</head>
<body class="claro">
<fieldset style="margin: 10px 0; padding: 10px; border: #DDD 1px solid">
    <legend><%=CompanyRateTable.TABLE_ALIAS%>新增
    </legend>
    <mvc:form action="save.do" theme="simple" method="post" id="form1"
              data-dojo-type="dijit.form.Form">
        <script type="dojo/on" data-dojo-event="submit">
				if(this.validate()){
					if(check()){	
					return confirm("确定保存？");
					}else{
					return false;
					}
				}

        </script>
        <script type="text/javascript">

        </script>
        <table class="grid">
            <%@include file="form_include.jsp" %>
        </table>
        <table class="b">
            <tr align="center">
                <td><input id="submitButton" name="submitButton" type="submit"
                           value="保存"/></td>
                <td><input type="button" value="返回"
                           onclick="javascript:history.back()"/></td>
            </tr>
        </table>
    </mvc:form>
</fieldset>
</body>
</html>
