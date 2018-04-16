<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*" %>
<%@ page import="com.yada.common.dict.util.DictUtil" %>
<html>
<head>
    <%@include file="../../base_pages/base.jsp" %>
    <script src="<c:url value="/js/teletext.js"/>" type="text/javascript"></script>
    <script type="text/javascript">
        var message = '${message}';
        if (message!=null && message !=''){
            alert(message);
        }
    </script>
</head>
<body class="claro">
<fieldset style="margin: 10px 0; padding: 10px; border: #DDD 1px solid">
    <legend>商户经营类目新增</legend>
    <mvc:form action="save.do" theme="simple" method="post" id="saveForm"
              data-dojo-type="dijit.form.Form">
        <script type="dojo/on" data-dojo-event="submit">
        <% DictUtil.remove("D_CATEGORY"); %>
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

                <td><input data-dojo-type="dijit.form.ValidationTextBox" maxlength="20" name="id"
                           data-dojo-props="trim:true,required:true,regExp:'^[0-9]{1,20}$',invalidMessage:'请输入数字'" value="${model.id}"/>
                    <span style="color: red">*</span>
                </td>
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
