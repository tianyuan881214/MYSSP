<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*" %>
<%@ page import="com.yada.common.dict.util.DictUtil" %>
<html>
<head>
    <%@include file="../../base_pages/base.jsp" %>
    <script src="<c:url value="/js/teletext.js"/>" type="text/javascript"></script>
    <script type="text/javascript">
        var message='${message}';
        if (message != null && message != ''){
            alert(message);
        }
    </script>
</head>
<body class="claro">
<fieldset style="margin: 10px 0; padding: 10px; border: #DDD 1px solid">
    <legend><%=MerchantBase.TABLE_ALIAS%>新增</legend>
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
                //商户状态
                dojo.byId("merchantStatMsg").innerHTML = "*";
                if (!dojo.byId("merchantStat").value) {
                    dojo.byId("merchantStat").focus();
                    dojo.byId("merchantStatMsg").innerHTML = "商户状态不可为空!";
                    onsbmt = false;
                }
                //所属组不可为空
                dojo.byId("merGrpIdMsg").innerHTML = "*";
                if (!dojo.byId("merGrpId").value) {
                    dojo.byId("merGrpId").focus();
                    dojo.byId("merGrpIdMsg").innerHTML = "所属组不可为空!";
                    onsbmt = false;
                }
                //商户经营类目不可为空
                dojo.byId("categoryIdMsg").innerHTML = "*";
                if (!dojo.byId("categoryId").value) {
                    dojo.byId("categoryId").focus();
                    dojo.byId("categoryIdMsg").innerHTML = "商户经营类目不可为空!";
                    onsbmt = false;
                }

                if(!form || !dijit.byId("saveForm").validate()){
                    return false;
                }
                return onsbmt;
            }

            function check() {
                //var cvValue=dojo.byId("cvValue").value;
                //if(cvValue==""){
                //	dojo.byId("cvValue").innerHTML="请输入卡bin取值";
                //	return false;
                //}
                return onsbmt;
            }

            /**
             机构联动下级机构
             @param 机构ID
             */
            function findlowerOrg(orgId) {
                if (orgId) {

                    //清空select,添加[--请选择--]option
                    var node = dojo.byId("lowerOrgId");
                    dojo.empty(node);

                    /*---------------创建元素节点--------------*/
                    dojo.create("option", {
                        value: "",
                        innerHTML: "--请选择--"
                    }, node);
                    dojo.xhrGet({
                        url: "AJAX_findlowerOrg.do",
                        sync: true,
                        content: {orgId: orgId, t: new Date().getTime()},
                        load: function (data) {
                            //用户名可用
                            if ("" != data) {
                                //解析用户分组
                                dojo.forEach(dojo.fromJson(data), function (org) {
                                    dojo.create("option", {
                                        value: org.orgId,
                                        innerHTML: org.name
                                    }, node);
                                });
                            }
                        },
                        error: function (error) {
                            alert(error);
                        }
                    });

                    findGrpByOrg(orgId);
                }
            }

            function isMerchantIdExist(merchantId) {
                //清空提示信息
                /* var merchantIdMsg = dojo.byId("merchantIdMsg");
                 merchantIdMsg.innerHTML = "*";*/

                //验证是否可用
                dojo.xhrGet({
                    url: "AJAX_isMerchantIdExist.do",
                    sync: true,
                    content: {merchantId: merchantId},
                    load: function (data) {
                        //提示信息
                        merchantIdMsg.innerHTML = data;
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

                <td class="lgridlist"><%=MerchantBase.ALIAS_MERCHANT_ID%>:</td>

                <td><input data-dojo-type="dijit.form.ValidationTextBox"
                           id="merchantId" maxlength="15" name="merchantId"
                           data-dojo-props="trim:true,required:true,regExp:'^[0-9]{15}$',invalidMessage:'请输入15位数字的商户号'" value="${model.merchantId}" onblur="isMerchantIdExist(this.value);"/>
                    <span style="color: red" id="merchantIdMsg"></span>
                    <span style="color: red" >*商户号长度为15位</span></td>
                <td class="lgridlist"><%=MerchantBase.ALIAS_MERCHANT_CNAME%>:</td>
                <td><input data-dojo-type="dijit.form.ValidationTextBox"
                           id="merchantCname" maxlength="32" name="merchantCname"
                           data-dojo-props="trim:true,required:true"
                           value="${model.merchantCname}"/>
                    <span style="color: red" id="systemCodeMess">*</span>
                    <span style="color: red" >请填写中文全称</span></td>
                </td>
            </tr>
            <tr>
                <td class="lgridlist"><%=MerchantBase.ALIAS_ADDRESS_CHN%>:</td>
                <td><input data-dojo-type="dijit.form.ValidationTextBox"
                           id="addressChn" maxlength="32" name="addressChn"
                           data-dojo-props="trim:true,required:false" value="${model.addressChn}"/>
                        <%--<span style="color: red">*</span>--%>
                </td>
                <td class="lgridlist"><%=MerchantBase.ALIAS_ABBR_CNAME%>:</td>
                <td><input data-dojo-type="dijit.form.ValidationTextBox" id="abbrCname"
                           maxlength="6" name="abbrCname" data-dojo-props="trim:true,required:true"
                           value="${model.abbrCname}"/>
                    <span style="color: red">*简称为6个汉字</span>
                </td>
            </tr>
            <tr>
                <td class="lgridlist"><%=MerchantBase.ALIAS_CITY_CNAME%>:</td>
                <td><input data-dojo-type="dijit.form.ValidationTextBox"
                           id="cityCname" maxlength="15" name="cityCname"
                           data-dojo-props="trim:true,required:true" value="内蒙"/>
                    <span style="color: red">*</span>
                </td>
                <td class="lgridlist"><%=MerchantBase.ALIAS_TELEPHONE%>:</td>
                <td><input data-dojo-type="dijit.form.ValidationTextBox"
                           id="telephone" maxlength="32" name="telephone"
                           data-dojo-props="trim:true,required:true" value="${model.telephone}"/>
                    <span style="color: red">*</span>
                    <span style="color: red">电话号为12位</span>
                </td>
            </tr>
            <tr>
                <td class="lgridlist">入账账号</td>
                <td><input data-dojo-type="dijit.form.ValidationTextBox" id="accountNo" value="${modelson.accountNo}"
                           maxlength="30" max="30" name="accountNo" data-dojo-props="trim:true,required:true,regExp:'^[0-9]+$',invalidMessage:'请输入数字'"/>
                    <span style="color: red">*</span>
                </td>
                <td class="lgridlist">账户名称</td>
                <td><input data-dojo-type="dijit.form.ValidationTextBox" id="accountName" value="${modelson.accountName}"
                           maxlength="32" max="32" name="accountName" data-dojo-props="trim:true,required:true"/>
                    <span style="color:red;">*</span>
                </td>

            </tr>

            <!-- 一下是扩展业务-------------------------------------------------------------------------------------- -->
            <tr>
                <td class="lgridlist">账户开户行</td>
                <td><input data-dojo-type="dijit.form.ValidationTextBox" id="cardHolderName" value="${modelson.cardHolderName}"
                           maxlength="32" max="32" name="cardHolderName" data-dojo-props="trim:true,required:true"/>
                    <span style="color:red;">*</span>
                </td>
                <td class="lgridlist"><%=MerchantBase.ALIAS_MERCHANT_STAT%>:</td>
                <td><mytag:select  name="merchantStat" value="${model.merchantStat}"
                                   notEmpty="true" dictName="MERCHANT_STAT" id="merchantStat"/>
                    <span class="required" id="merchantStatMsg" style="color: red;">*</span>
                </td>

            </tr>
            <tr>
                <td class="lgridlist">开户行行号</td>
                <td><input data-dojo-type="dijit.form.ValidationTextBox" value="${modelson.openingBankNo}"
                           maxlength="30" max="30" name="openingBankNo" data-dojo-props="trim:true,required:true,regExp:'^[0-9]+$',invalidMessage:'请输入数字'"/>
                    <span style="color:red;">*</span>
                </td>
                <td class="lgridlist">机构:</td>
                <td>
                    <select name="orgId" onchange="findlowerOrg(this.value);" id="orgId">
                        <option value="">--请选择--</option>
                        <c:forEach items="${lowerOrgs}" var="item">
                            <option value="${item.orgId}">${item.name}</option>
                        </c:forEach>
                    </select>
                    <select name="zbank" id="lowerOrgId">
                        <option value="">--请选择--</option>
                        <c:forEach items="${orgs}" var="item">
                            <option value="${item.orgId}">${item.name}</option>
                        </c:forEach>
                    </select>
                    <span style="color: red" id="orgMsg">创建本机构用户时不用选择机构</span>
                </td>
            </tr>
            <tr>
                <td class="lgridlist">商户经营类目
                </td>
                <td><%--enterAlipay--%>
                    <mytag:select styleClass="required validate-selection" name="categoryId" id="categoryId"
                                  notEmpty="true" value="${enterAlipay.category_id}" dictName="D_CATEGORY"/>
                    <span style="color:red;" id="categoryIdMsg">*</span>
                </td>
               <%-- <td class="lgridlist">商户分组</td>
                <td>
                    <select name="merchantGrpLs " id="merGrpId">
                    <option value="">请选择</option>
                        <c:forEach items="${merchantGrpLsList}" var="m">
                            <option value="${m.merGrpId }"> ${m.merGrpName} </option>
                        </c:forEach>
                    </select>
                </td>--%>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
            <c:forEach items="${BusinessList}" var="u">
                <tr>
                    <td class="lgridlist">业务及费率</td>
                    <td>
                        <input type="checkbox" name="ids" value="${u.businessId}"
                            ${u.checked==true?"checked='checked'":'' } /> ${u.businessName}

                        <select id="${u.businessId}" name="${u.businessId}" value="${u.businessId}">
                            <option value="">请选择</option>
                            <c:forEach items="${feeList}" var="b">
                                <option value="${b.feeId }"> ${b.fee} </option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
            </c:forEach>
        </table>
        <table class="b">
            <tr align="center">
                <td><input id="submit" type="submit" value="保存及入驻" onclick="return checkOnSubmit();"/></td>
                <td><input type="button" value="返回"
                           onclick="javascript:history.back()"/></td>
            </tr>
        </table>
    </mvc:form>
</fieldset>
</body>
</html>
