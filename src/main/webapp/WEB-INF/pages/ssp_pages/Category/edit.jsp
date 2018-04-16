<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*" %>
<html>
<head>
    <%@include file="../../base_pages/base.jsp" %>
    <script src="<c:url value="/js/teletext.js"/>" type="text/javascript"></script>
</head>
<body class="claro">
<fieldset style="margin: 10px 0; padding: 10px; border: #DDD 1px solid">
    <legend>商户经营类目编辑</legend>
    <mvc:form action="update.do" theme="simple" method="post" id="saveForm"
              data-dojo-type="dijit.form.Form">
        <script type="dojo/on" data-dojo-event="submit">
				if(this.validate()){
					if(check()){
					return confirm("确定保存？");
					}else{
					return false;
					}
					}else{
						return false;
					}



        </script>
        <script type="text/javascript">
            var form = document.forms.saveForm;
            var onsbmt = true;
            function checkOnSubmit() {
                onsbmt = true;
                if(!form || !dijit.byId("saveForm").validate()){
                    return false;
                }
                return onsbmt;
            }
        </script>
        <table class="grid">
            <tr>
                <td class="lgridlist">商户经营类目号:</td>
                <td>${model.id}</td>
                <input type="hidden" name="id" value="${model.id}">
                <td class="lgridlist">商户经营类目名称:</td>
                <td><input data-dojo-type="dijit.form.ValidationTextBox" maxlength="100" name="detail"
                           data-dojo-props="trim:true,required:true"
                           value="${model.detail}"/>
                    <span style="color: red">*</span>
                </td>
            </tr>
            <tr>
                <td class="lgridlist">需要证件:</td>
                <td colspan="3"><input maxlength="150" name="papers" value="${model.papers}"/></td>
            </tr>
        </table>
        <table class="b">
            <tr align="center">
                <td><input id="submit" type="submit" value="保存" onclick="return checkOnSubmit();"/></td>
                <td><input type="button" value="返回"
                           onclick="javascript:history.back()"/></td>
            </tr>
        </table>
    </mvc:form>
</fieldset>
</body>
</html>
