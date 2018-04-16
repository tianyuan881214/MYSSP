<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*" %>
<html>
<head>
    <%@include file="../../base_pages/base.jsp" %>
    <script src="<c:url value="/js/teletext.js"/>" type="text/javascript"></script>
</head>
<body class="claro">
<fieldset style="margin: 10px 0;padding: 10px;border: #DDD 1px solid">
    <legend><%=BusinessBase.TABLE_ALIAS%>编辑</legend>
    <mvc:form action="update.do" theme="simple" method="post" data-dojo-type="dijit.form.Form" id="form1">
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
            var onsbmt = true;

            function er(error) {
                alert(error);
            }
            function is(mess) {
                //提示信息
                checkMsg.innerHTML = mess;
                if ("*" != mess) {
                    onsbmt = false;
                } else
                    onsbmt = true;
            }
            function check() {
                //var cvValue=dojo.byId("cvValue").value;
                //if(cvValue==""){
                //	dojo.byId("cvValue").innerHTML="请输入卡bin取值";
                //	return false;
                //}
                return onsbmt;
            }
        </script>
        <table class="grid">
            <input type="hidden" name="businessId" value="${model.businessId}"/>
            <tr>
                <td class="lgridlist"><%=BusinessBase.BUSINESS_NAME%>:</td>
                <td><input data-dojo-type="dijit.form.ValidationTextBox"
                           id="businessName" maxlength="32" name="businessName"
                           data-dojo-props="trim:true,required:true"
                           value="${model.businessName}"/> <span style="color: red"
                                                                 id="systemCodeMess">*</span></td>
                <td class="lgridlist"><%=BusinessBase.BUSINESS_SM%>:</td>

                <td><input data-dojo-type="dijit.form.ValidationTextBox"
                           id="businessSm" maxlength="100" name="businessSm"
                           data-dojo-props="trim:true,required:true" value="${model.businessSm}"/>
                    <span style="color: red" id="systemCodeMess">*</span></td>
            </tr>
        </table>
        <table class="b">
            <tr align="center">
                <td><input id="submitButton" name="submitButton" type="submit" value="保存"/></td>
                <td><input type="button" value="返回" onclick="javascript:history.back()"/></td>
            </tr>
        </table>
    </mvc:form>
</fieldset>
</body>
</html>
