<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*" %>
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
    <legend>柜员新增</legend>
    <mvc:form action="save.do" theme="simple" method="post" id="saveForm"
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
                //柜员级别不可为空
                dojo.byId("levelMsg").innerHTML = "*";
                if (!dojo.byId("level").value) {
                    dojo.byId("level").focus();
                    dojo.byId("levelMsg").innerHTML = "柜员级别不可为空!";
                    onsbmt = false;
                }

                if(!form || !dijit.byId("saveForm").validate()){
                    return false;
                }
                return onsbmt;
            }
        </script>
        <table class="grid">
            <tr>
                <td class="lgridlist">商户号:</td>

                <td><input data-dojo-type="dijit.form.ValidationTextBox" maxlength="15" name="merchant" id="merchant"
                           data-dojo-props="trim:true,required:true,regExp:'^[0-9]{1,15}$',invalidMessage:'请输入数字'" value="${model.merchant}"/>
                    <span style="color: red" id="merchantMsg">*</span>
                </td>
                <td class="lgridlist">柜员号:</td>

                <td><input data-dojo-type="dijit.form.ValidationTextBox" maxlength="16" name="userId"
                           data-dojo-props="trim:true,required:true,regExp:'^[0-9]+$',invalidMessage:'请输入数字'" value="${model.userId}"/>
                    <span style="color: red">*</span>
                </td>
            </tr>
            <tr>
                <td class="lgridlist">终端号:</td>
                <td><input data-dojo-type="dijit.form.ValidationTextBox" maxlength="8" name="terminal" data-dojo-props="trim:true,required:false,regExp:'^[0-9]{1,8}$',invalidMessage:'请输入数字'" value="${model.terminal}"/>
                </td>
                <td class="lgridlist">密码:</td>
                <td><input data-dojo-type="dijit.form.ValidationTextBox" maxlength="32" name="pwd"
                           data-dojo-props="trim:true,required:true,regExp:'^[0-9]{1,32}$',invalidMessage:'请输入数字'"
                           value="${model.pwd}"/>
                    <span style="color: red">*</span>
                </td>

            </tr>
            <tr>
                <td class="lgridlist">柜员名称:</td>
                <td><input maxlength="15" name="name" value="${model.name}"/>
                </td>
                <td class="lgridlist">柜员电话:</td>
                <td><input maxlength="15" name="phone" value="${model.phone}"/>
                </td>
            </tr>
            <tr>
                <td class="lgridlist">柜员级别:</td>
                <td colspan="3"><mytag:select dictName="D_NP_LEVEL" name="level" id="level" value="${model.level}"/>
                    <span style="color: red" id="levelMsg">*</span>
                </td>
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
