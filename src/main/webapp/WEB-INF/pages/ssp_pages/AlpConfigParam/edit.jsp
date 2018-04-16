<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <%@include file="../../base_pages/base.jsp" %>
    <script src="<c:url value="/js/teletext.js"/>" type="text/javascript"></script>
    <script type="text/javascript">
        var message = '${message}';
        if (message !=null && message !="") {
            alert("支付宝账户修改成功！");
        }
    </script>
</head>
<body class="claro">
<fieldset style="margin: 10px 0;padding: 10px;border: #DDD 1px solid">
    <legend>支付宝账户信息编辑</legend>
    <mvc:form action="update.do" theme="simple" method="post" data-dojo-type="dijit.form.Form" id="saveForm">
        <script type="dojo/on" data-dojo-event="submit">
				if(this.validate()){
					if(check()){
					return confirm("确认修改？");
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
                //合作者身份ID不可为空
                 /*dojo.byId("pidMsg").innerHTML = "*";
                 if (!dojo.byId("pid").value) {
                 dojo.byId("pid").focus();
                 dojo.byId("pidMsg").innerHTML = "合作者身份ID（PID）不可为空!";
                 onsbmt = false;
                 }
                 //应用ID（appId）不可为空!
                 dojo.byId("appIdMsg").innerHTML = "*";
                 if (!dojo.byId("appId").value) {
                 dojo.byId("appId").focus();
                 dojo.byId("appIdMsg").innerHTML = "应用ID（appId）不可为空!";
                 onsbmt = false;
                 }*/
                 //RSA私钥不可为空
                 dojo.byId("privateKeyMsg").innerHTML = "*";
                 if (!dojo.byId("privateKey").value) {
                 dojo.byId("privateKey").focus();
                 dojo.byId("privateKeyMsg").innerHTML = "RSA私钥不可为空!";
                 onsbmt = false;
                 }
                 //RSA公钥钥不可为空
                 dojo.byId("publicKeyMsg").innerHTML = "*";
                 if (!dojo.byId("publicKey").value) {
                 dojo.byId("publicKey").focus();
                 dojo.byId("publicKeyMsg").innerHTML = "RSA公钥不可为空!";
                 onsbmt = false;
                 }
                 //支付宝公钥不可为空
                 dojo.byId("alpPublicKeyMsg").innerHTML = "*";
                 if (!dojo.byId("alpPublicKey").value) {
                 dojo.byId("alpPublicKey").focus();
                 dojo.byId("alpPublicKeyMsg").innerHTML = "支付宝公钥不可为空!";
                 onsbmt = false;
                 }

                if (!form || !dijit.byId("saveForm").validate()) {
                    return false;
                }
                return onsbmt;
            }

        </script>
        <table class="grid">
            <tr>
                <td class="lgridlist">合作者身份ID（PID）:</td>
                <td><input data-dojo-type="dijit.form.ValidationTextBox"
                           id="pid" maxlength="16" name="pid"
                           data-dojo-props="trim:true,required:true" value="${alpConfigParam.pid}"/>
                    <span style="color: red" id="pidMsg">*</span>
                </td>
                <td class="lgridlist">应用ID（appId）:</td>
                <td><input data-dojo-type="dijit.form.ValidationTextBox" id="appId"
                           maxlength=16 name="appId" data-dojo-props="trim:true,required:true"
                           value="${alpConfigParam.appId}"/>
                    <span style="color: red" id="appIdMsg">*</span>
                </td>
            </tr>

            <tr>
                <td class="lgridlist">RSA私钥：</td>
                <td colspan="3">
                    <textarea id="privateKey" wrap="physical" maxlength="1024" name="privateKey">${alpConfigParam.privateKey}</textarea>
                    <%--<input data-dojo-type="dijit.form.ValidationTextBox"
                                       id="privateKey" maxlength="2000" name="privateKey"
                                       data-dojo-props="trim:true,required:true" value="${alpConfigParam.privateKey}"/>--%>
                    <span style="color: red" id="privateKeyMsg">*</span>
                </td>
            </tr>
            <tr>
                <td class="lgridlist">公钥:</td>
                <td colspan="3">
                    <textarea id="publicKey" wrap="physical" maxlength="1024" name="publicKey">${alpConfigParam.publicKey}</textarea>
                    <%--<input data-dojo-type="dijit.form.ValidationTextBox"
                                       id="publicKey" maxlength="1000" name="publicKey"
                                       data-dojo-props="trim:true,required:true" value="${alpConfigParam.publicKey}"/>--%>
                    <span style="color: red" id="publicKeyMsg">*</span>
                </td>
            </tr>
            <tr>
                <td class="lgridlist">支付宝公钥:</td>
                <td colspan="3">
                    <textarea id="alpPublicKey" wrap="virtual" maxlength="1024" name="alpPublicKey">${alpConfigParam.alpPublicKey}</textarea>
                    <%--<input data-dojo-type="dijit.form.ValidationTextBox"
                                       id="alpPublicKey" maxlength="1000" name="alpPublicKey"
                                       data-dojo-props="trim:true,required:true"
                                       value="${alpConfigParam.alpPublicKey}"/>--%>
                    <span style="color: red" id="alpPublicKeyMsg">*</span>
                </td>
            </tr>
        </table>
        <table class="b">
            <tr align="center">
                    <%--<td><input id="submitButton" name="submitButton" type="submit" value="修改及入驻"/></td>--%>
                <td><input id="submit" type="submit" value="修改" onclick="return checkOnSubmit();"/></td>
                <%--<td><input type="button" value="返回" onclick="javascript:history.back()"/></td>--%>
            </tr>
        </table>
    </mvc:form>
</fieldset>
</body>
</html>
