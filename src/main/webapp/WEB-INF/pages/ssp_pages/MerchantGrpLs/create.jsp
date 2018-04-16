<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*" %>
<%@ page import="com.yada.common.dict.util.DictUtil" %>
<html>
<head>
    <%@include file="../../base_pages/base.jsp" %>
    <script src="<c:url value="/js/teletext.js"/>" type="text/javascript"></script>
</head>
<body class="claro">
<fieldset style="margin: 10px 0; padding: 10px; border: #DDD 1px solid">
    <legend>商户分组新增</legend>
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
                //锁标示不可为空
                dojo.byId("lockModeMsg").innerHTML = "*";
                if (!dojo.byId("lockMode").value) {
                    dojo.byId("lockMode").focus();
                    dojo.byId("lockModeMsg").innerHTML = "锁标示不可为空!";
                    onsbmt = false;
                }
                //清算模式不可为空
                dojo.byId("settleModeMsg").innerHTML = "*";
                if (!dojo.byId("settleMode").value) {
                    dojo.byId("settleMode").focus();
                    dojo.byId("settleModeMsg").innerHTML = "清算模式不可为空!";
                    onsbmt = false;
                }

                if(!form || !dijit.byId("saveForm").validate()){
                    return false;
                }
                return onsbmt;
            }
            function isExistMerGrpId(merGrpId) {
                //清空提示信息
                var merGrpIdMsg = dojo.byId("merGrpIdMsg");
                merGrpIdMsg.innerHTML = "*";

                //验证是否可用
                dojo.xhrGet({
                    url: "AJAX_isMerGrpIdExist.do",
                    sync: true,
                    content: {merGrpId: merGrpId},
                    load: function (data) {
                        //提示信息
                        merGrpIdMsg.innerHTML = data;
                        if ("*" != data) {
                            onsbmt = false;
                        }
                    },
                    error: function (error) {
                        alert(error);
                    }
                });
            }
        </script>
        <table class="grid">
            <tr>
                <td class="lgridlist">商户分组号:</td>

                <td><input data-dojo-type="dijit.form.ValidationTextBox" maxlength="15" name="merGrpId" id="merGrpId"
                           data-dojo-props="trim:true,required:true,regExp:'^[0-9]{15}$',invalidMessage:'请输入15位数字的商户分组号'" value="${model.merGrpId}" onblur="isExistMerGrpId(this.value);"/>
                    <span style="color: red" id="merGrpIdMsg">*</span>
                </td>
                <td class="lgridlist">分组名称:</td>

                <td><input data-dojo-type="dijit.form.ValidationTextBox" maxlength="32" name="merGrpName"
                           data-dojo-props="trim:true,required:true" value="${model.merGrpName}"/>
                    <span style="color: red">*</span>
                </td>
            </tr>
            <tr>
                <td class="lgridlist">全称:</td>
                <td><input data-dojo-type="dijit.form.ValidationTextBox" maxlength=20 name="merchantName"
                           data-dojo-props="trim:true,required:true"
                           value="${model.merchantName}"/>
                    <span style="color: red">*</span>
                </td>
                <td class="lgridlist">简称:</td>
                <td><input data-dojo-type="dijit.form.ValidationTextBox" maxlength="5" name="abbrName"
                           data-dojo-props="trim:true,required:true"
                           value="${model.abbrName}"/>
                    <span style="color: red">*</span>
                </td>

            </tr>
            <tr>
                <td class="lgridlist">地址:</td>
                <td><input data-dojo-type="dijit.form.ValidationTextBox" maxlength="15" name="addressChn"
                           data-dojo-props="trim:true,required:true" value="${model.addressChn}"/>
                    <span style="color: red">*</span>
                </td>
                <td class="lgridlist">备注信息:</td>
                <td><input data-dojo-type="dijit.form.ValidationTextBox" maxlength="20" name="memo"
                           data-dojo-props="trim:true,required:false" value="${model.memo}"/>
                </td>
            </tr>
            <tr>
                <td class="lgridlist">所在城市:</td>
                <td><input data-dojo-type="dijit.form.ValidationTextBox" maxlength="15" name="cityName"
                           data-dojo-props="trim:true,required:true" value="${model.cityName}"/>
                    <span style="color: red">*</span>
                </td>
                <td class="lgridlist">电话号码:</td>
                <td><input data-dojo-type="dijit.form.ValidationTextBox" maxlength="12" name="telephone"
                           data-dojo-props="trim:true,required:true,regExp:'^[0-9]+$',invalidMessage:'请输入数字'" value="${model.telephone}"/>
                    <span style="color: red">*</span>
                </td>
            </tr>
            <tr>
                <td class="lgridlist">邮编:</td>
                <td><input data-dojo-type="dijit.form.ValidationTextBox" minlength="6" maxlength="6" name="postCode"
                           data-dojo-props="trim:true,required:false,regExp:'^[0-9]{6}$',invalidMessage:'请输入6位数字'" value="${model.postCode}"/>
                </td>
                <td class="lgridlist">传真:</td>
                <td><input data-dojo-type="dijit.form.ValidationTextBox" maxlength="12" name="fax"
                           data-dojo-props="trim:true,required:false,regExp:'^[0-9]+$',invalidMessage:'请输入数字'" value="${model.fax}"/>
                </td>
            </tr>
            <tr>
                <td class="lgridlist">联系人姓名:</td>
                <td><input data-dojo-type="dijit.form.ValidationTextBox" maxlength="4" name="manager"
                           data-dojo-props="trim:true,required:true" value="${model.manager}"/>
                    <span style="color: red">*</span>
                </td>
                <td class="lgridlist">锁标示:</td>
                <td><mytag:select value="${model.lockMode}" name="lockMode" notEmpty="false" dictName="D_STATUS" id="lockMode"/>
                    <span class="required" style="color: red;" id="lockModeMsg">*</span>
                </td>
            </tr>
            <tr class="crosscolor_tr">
                <td class="lgridlist">清算模式:</td>
                <td><mytag:select  name="settleMode" value="${model.settleMode}" notEmpty="false" dictName="D_SETTLE_MODE" id="settleMode"/>
                    <span class="required" style="color: red;" id="settleModeMsg">*</span>
                </td>
                <td class="lgridlist">入账账号:</td>
                <td><input data-dojo-type="dijit.form.ValidationTextBox" maxlength="19" name="accountNo"
                           data-dojo-props="trim:true,required:true,regExp:'^[0-9]+$',invalidMessage:'请输入数字'" value="${model.accountNo}"/>
                    <span class="required" style="color: red;">*</span>
                </td>
            </tr>
            <tr>
                <td class="lgridlist">账号名称:</td>
                <td><input data-dojo-type="dijit.form.ValidationTextBox" maxlength="32" name="accountName"
                           data-dojo-props="trim:true,required:false" value="${model.accountName}"/>
                </td>
                <td class="lgridlist">账号开户行:</td>
                <td><input data-dojo-type="dijit.form.ValidationTextBox" maxlength="32" name="openingBank"
                           data-dojo-props="trim:true,required:false" value="${model.openingBank}"/>
                </td>
            </tr>
            <tr>
                <td class="lgridlist">开户行行号:</td>
                <td><input data-dojo-type="dijit.form.ValidationTextBox" maxlength="12" name="openingBankNo"
                           data-dojo-props="trim:true,required:false" value="${model.openingBankNo}"/>
                </td>
                <td class="lgridlist">开户行地址:</td>
                <td colspan="3"><input data-dojo-type="dijit.form.ValidationTextBox" maxlength="32" name="openingBankAddress"
                                       data-dojo-props="trim:true,required:false" value="${model.openingBankAddress}"/>
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
