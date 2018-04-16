<%@ taglib prefix="color" uri="http://www.springframework.org/tags/form" %>
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
				}
        </script>
        <script type="text/javascript">
            var message = '${message}';
            if (message!=null && message !=''){
                alert(message);
            }
            var form = document.forms.saveForm;
            var onsbmt = true;
            function check() {
                var fax=document.getElementById("fax").value;
                if(fax ==""){
                    document.getElementById("faxMsg").innerHTML="是否他行账户不可为空!";
                    return false;
                }
                var scanType=document.getElementById("scanType").value;
                if(scanType ==""){
                    document.getElementById("scanTypeMess").innerHTML="扫描方式描不可为空!";
                    return false;
                }
                var accountType=document.getElementById("accountType").value;
                if(accountType ==""){
                    document.getElementById("accountTypeMess").innerHTML="账户类型不可为空!";
                    return false;
                }
                var belongOrgId=document.getElementById("belongOrgId").value;
                if(belongOrgId ==""){
                    document.getElementById("belongOrgIdMsg").innerHTML="所属二级行不可为空!";
                    return false;
                }
                var orgId=document.getElementById("orgId").value;
                if(orgId ==""){
                    document.getElementById("orgIdMsg").innerHTML="商户所属机构不可为空!";
                    return false;
                }
                /*var merchantStat=document.getElementById("merchantStat").value;
                if(merchantStat ==""){
                    document.getElementById("merchantStatMsg").innerHTML="商户状态不可为空!";
                    return false;
                }
                var categoryId=document.getElementById("categoryId").value;
                if(categoryId ==""){
                    document.getElementById("categoryIdMsg").innerHTML="商户经营类目不可为空!";
                    return false;
                }*/
                return onsbmt;
            }
            function cardNoExist(value) {
                if (!value || !/^[1-9][0-9]{5}(19[0-9]{2}|200[0-9]|2010)(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])[0-9]{3}[0-9xX]$/i.test(value)) {
                    alert("身份证号格式错误");
                }
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
                var merchantIdMsg = dojo.byId("merchantIdMsg");
                merchantIdMsg.innerHTML = "*";

                //验证是否可用
                dojo.xhrGet({
                    url: "AJAX_isMerchantIdExist.do",
                    sync: true,
                    content: {merchantId: merchantId, t: new Date().getTime()},
                    load: function (data) {
                        //提示信息
                        merchantIdMsg.innerHTML = data;
                        if ("*" != data) {
                            onsbmt = false;
                        }else
                            onsbmt=true;
                    },
                    error: function (error) {
                        alert(error);
                    }
                });
            }
            function isBelongOrgIdExist(belongOrgId){

                dojo.xhrGet({
                    url: "AJAX_isBelongOrgId.do",
                    sync: true,
                    handleAs: "json",
                    content: {belongOrgId: belongOrgId},
                    load: function(data){
                        dojo.empty("orgId");
                        var option=document.createElement("option");
                        option.innerHTML="请选择";
                        option.value="";
                        document.getElementById("orgId").appendChild(option);
                        for (var i = 0; i < data.length; i++) {
                            var option=document.createElement("option");
                            option.value=data[i].orgId;
                            option.innerHTML=data[i].name;
                            document.getElementById("orgId").appendChild(option);
                        }
                    },
                    error: function(error){
                        alert("没有二级机构");
                    }
                });

            }

            function isTo(fax) {
                if (fax == '1') {
                    dojo.query(".merMaxLevellyf").style("display", "block");
                } else if (fax == '0'){
                    dojo.query(".merMaxLevellyf").style("display", "none");
                }
            }

            /*//判断银联缴费
            function isTos(ids) {
                if(ids ==000000000000004){
                    dojo.query(".unionSubmchids").style("display", "block");
                }

            }*/
            //增加入驻信息
            function changeMerchantMessage() {
                var type = dojo.query("[name=merchantLevel]")[0].value;
                if (type == 'M1') {
                    dojo.query(".merLevel").style("display", "none");
                    dojo.query(".merMaxLevel").style("display", "none");
                } else if (type == 'M2') {
                    dojo.query(".merLevel").style("display", "block");
                    dojo.query(".merMaxLevel").style("display", "none");
                } else if (type == 'M3') {
                    dojo.query(".merLevel").style("display", "block");
                    dojo.query(".merMaxLevel").style("display", "block");
                }
            }
            ;

            dojo.ready(function () {
                changeMerchantMessage();
                isTo(0)
            });
        </script>
        <table class="grid">
            <tr>
                <td class="lgridlist">所属二级行:</td>
                <td>
                    <select name="belongOrgId"  id="belongOrgId"  onchange="isBelongOrgIdExist(this.value);">
                        <option value="">--请选择--</option>
                        <c:forEach items="${BelongcOrg}" var="item">
                            <option value="${item.orgId}">${item.name}</option>
                        </c:forEach>
                    </select>
                    <span style="color: red" id="belongOrgIdMsg">*</span>
                </td>
                <td class="lgridlist">商户所属机构:</td>
                <td>
                    <select name="orgId"  id="orgId">
                        <option value="">--请选择--</option>
                      <%--  <c:forEach items="${lowerOrgs}" var="item">
                            <option value="${item.orgId}">${item.name}</option>
                        </c:forEach>--%>
                    </select>
                    <span style="color: red" id="orgIdMsg">*</span>
                </td>
            </tr>
            <tr>

                <td class="lgridlist"><%=MerchantBase.ALIAS_MERCHANT_ID%>:</td>

                <td><input data-dojo-type="dijit.form.ValidationTextBox"
                           id="merchantId" maxlength="15" name="merchantId"
                           data-dojo-props="trim:true,required:true,regExp:'^[0-9]{15}$',invalidMessage:'请输入15位数字的商户号'"
                           value="${model.merchantId}" onblur="isMerchantIdExist(this.value);"/>
                    <span style="color: red" id="merchantIdMsg"></span>
                    <span style="color: red" >*商户号长度为15位</span></td>
                <td class="lgridlist"><%=MerchantBase.ALIAS_MERCHANT_CNAME%>:</td>
                <td><input data-dojo-type="dijit.form.ValidationTextBox"
                           id="merchantCname" maxlength="28" name="merchantCname"
                           data-dojo-props="trim:true,required:true"
                           value="${model.merchantCname}"/>
                    <span style="color: red" id="systemCodeMess">*</span>
                    <span style="color: red" >请填写中文全称</span></td>
                </td>
            </tr>
            <tr>
                <td class="lgridlist"><%=MerchantBase.ALIAS_ADDRESS_CHN%>:</td>
                <td><input data-dojo-type="dijit.form.ValidationTextBox"
                           id="addressChn" maxlength="64" name="addressChn"
                           data-dojo-props="trim:true,required:false" value="${model.addressChn}"/>
                </td>
                <td class="lgridlist"><%=MerchantBase.ALIAS_ABBR_CNAME%>:</td>
                <td><input data-dojo-type="dijit.form.ValidationTextBox" id="abbrCname"
                           maxlength="16" name="abbrCname" data-dojo-props="trim:true,required:true"
                           value="${model.abbrCname}"/>
                    <span style="color: red">*简称为16个汉字</span>
                </td>
            </tr>
            <tr>
                <td class="lgridlist"><%=MerchantBase.ALIAS_CITY_CNAME%>:</td>
                <td><input data-dojo-type="dijit.form.ValidationTextBox"
                           id="cityCname" maxlength="30" name="cityCname"
                           data-dojo-props="trim:true,required:true" value="${model.cityCname}"/>
                    <span style="color: red">*</span>
                </td>
                <td class="lgridlist"><%=MerchantBase.ALIAS_TELEPHONE%>:</td>
                <td><input data-dojo-type="dijit.form.ValidationTextBox"
                           id="telephone" maxlength="12" name="telephone"
                           data-dojo-props="trim:true,required:true" value="${model.telephone}"/>
                    <span style="color: red">*</span>

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
                           maxlength="64" max="64" name="accountName" data-dojo-props="trim:true,required:true"/>
                    <span style="color:red;">*</span>
                </td>

            </tr>

            <!-- 一下是扩展业务-------------------------------------------------------------------------------------- -->
            <tr>
                <td class="lgridlist">账户开户行</td>
                <td><input data-dojo-type="dijit.form.ValidationTextBox" id="cardHolderName" value="${modelson.cardHolderName}"
                           maxlength="64" max="64" name="cardHolderName" data-dojo-props="trim:true,required:true"/>
                    <span style="color:red;">*</span>
                </td>
                <td class="lgridlist"><%=MerchantBase.ALIAS_MERCHANT_STAT%>:</td>
                <td><mytag:select  name="merchantStat"  id="merchantStat" value="${model.merchantStat}"
                                   notEmpty="true" dictName="MERCHANT_STAT" />
                    <span class="required" id="merchantStatMsg" style="color: red;">*</span>
                </td>

            </tr>
            <tr>
                <td class="lgridlist">开户行行号</td>
                <td><input data-dojo-type="dijit.form.ValidationTextBox" value="${modelson.openingBankNo}"
                           maxlength="30" max="30" name="openingBankNo" data-dojo-props="trim:true,required:true,regExp:'^[0-9]+$',invalidMessage:'请输入数字'"/>
                    <span style="color:red;">*</span>
                </td>
                <span style="color:red;">*</span>
                </td>
                <td></td><td></td>
            </tr>
            <tr>
                <td class="lgridlist">是否他行账户</td>
                <td><mytag:select  id="fax" name="fax" value="${modelson.fax}"
                                   notEmpty="false" dictName="IN_BANK"   onchange="isTo(this.value);"/>
                    <span class="required" id="faxMsg" style="color: red;">*</span>
                </td>
                <td></td><td></td>

            </tr>
            <tr class="merMaxLevellyf">
                <td class="lgridlist" >开户人姓名</td>
                <td>
                    <input  data-dojo-type="dijit.form.ValidationTextBox" value="${modelson.openingBank}"
                            maxlength="64" max="64" name="openingBank"  />
                    <span style="color:red;">*入账账号为他行账户时填写！</span>
                </td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
                <%--增加M3--%>
            <tr>
                <td class="lgridlist">商户入驻级别：</td>
                <td>
                    <select name="merchantLevel" onchange="changeMerchantMessage()">
                        <option <c:if test="${modelson.merchantLevel=='M1'}">selected</c:if> value="M1">M1</option>
                        <option <c:if test="${modelson.merchantLevel=='M2'}">selected</c:if> value="M2">M2</option>
                        <option <c:if test="${modelson.merchantLevel=='M3'}">selected</c:if> value="M3">M3</option>
                    </select>
                </td>
                <td></td><td></td>
            </tr>
            <tr class="merLevel">
                <td class="lgridlist">商户所在省份邮编:</td>

                <td><input data-dojo-type="dijit.form.ValidationTextBox"
                           id="provinceCode" maxlength="10" name="provinceCode"
                           data-dojo-props="trim:true,required:false,regExp:'^[0-9]+$',invalidMessage:'请输入1数字'"
                           value="${modelson.provinceCode}"/>
                    <span style="color: red" id="provinceCodeMsg">*M2入驻级别必选</span></td>


                <td class="lgridlist">商户所在市区邮编:</td>

                <td><input data-dojo-type="dijit.form.ValidationTextBox"
                           id="cityCode" maxlength="10" name="cityCode"
                           data-dojo-props="trim:true,required:false,regExp:'^[0-9]+$',invalidMessage:'请输入1数字'"
                           value="${modelson.cityCode}"/>
                    <span style="color: red" id="cityCodeMsg">*M2入驻级别必选</span></td>
            </tr>
            <tr class="merLevel">

                <td class="lgridlist">商户所在县邮编:</td>

                <td colspan="3">
                    <input data-dojo-type="dijit.form.ValidationTextBox"
                           id="districtCode" maxlength="10" name="districtCode"
                           data-dojo-props="trim:true,required:false,regExp:'^[0-9]+$',invalidMessage:'请输入1数字'"
                           value="${modelson.districtCode}"/>
                    <span style="color: red" id="districtCodeMsg">*M2入驻级别必选</span></td>
            </tr>

            <tr class="merMaxLevel">
                <td class="lgridlist">联系人姓名:</td>

                <td><input data-dojo-type="dijit.form.ValidationTextBox"
                           id="contactName" maxlength="128" name="contactName"
                           data-dojo-props="trim:true,required:false" value="${modelson.contactName}"/>
                    <span style="color: red">*M3入驻级别必选</span>

                </td>


                <td class="lgridlist">联系人类型:</td>

                <td>
                    <select name="contactType">
                        <option <c:if test="${modelson.contactType=='LEGAL_PERSON'}">selected</c:if> value="LEGAL_PERSON">法人</option>
                        <option <c:if test="${modelson.contactType=='CONTROLLER'}">selected</c:if> value="CONTROLLER">实际控制人</option>
                        <option <c:if test="${modelson.contactType=='AGENT'}">selected</c:if> value="AGENT">代理人</option>
                        <option <c:if test="${modelson.contactType=='OTHER'}">selected</c:if> value="OTHER">其他</option>
                    </select>
                    <span style="color: red" >*M3入驻级别必选</span></td>
            </tr>
            <tr class="merMaxLevel">
                <td class="lgridlist">身份证号:</td>

                <td><input data-dojo-type="dijit.form.ValidationTextBox"
                           id="idCard" maxlength="18" name="idCard" value="${modelson.idCard}"
                           data-dojo-props="trim:true,required:false,regExp:'^[0-9a-zA-Z]+$',invalidMessage:'请输入正确格式'"
                           onblur="cardNoExist(this.value)"/>
                    <span style="color: red">*M3入驻级别必选</span>

                </td>


                <td class="lgridlist">电子邮箱:</td>

                <td><input data-dojo-type="dijit.form.ValidationTextBox"
                           id="email" maxlength="40" name="email" value="${modelson.email}"
                           data-dojo-props="trim:true,required:false"/>
                    <span style="color: red">*M3入驻级别必选</span>
                </td>
            </tr>
            <tr class="merMaxLevel">
                <td class="lgridlist">营业执照:</td>

                <td><input data-dojo-type="dijit.form.ValidationTextBox" value="${modelson.businessLicense}"
                           id="business_license" maxlength="20" name="businessLicense"
                           data-dojo-props="trim:true,required:false"/>
                    <span style="color: red">*M3入驻级别必选</span>

                </td>


                <td class="lgridlist">营业执照类型:</td>

                <td>
                    <select name="businessLicenseType">
                        <option <c:if test="${modelson.businessLicenseType=='NATIONAL_LEGAL'}">selected</c:if> value="NATIONAL_LEGAL">营业执照
                        </option>
                        <option <c:if test="${modelson.businessLicenseType=='NATIONAL_LEGAL_MERGE'}">selected</c:if> value="NATIONAL_LEGAL_MERGE">
                            营业执照（多证合一）</option>
                        <option <c:if test="${modelson.businessLicenseType=='INST_RGST_CTF'}">selected</c:if> value="INST_RGST_CTF">事业单位法人证
                            书</option>
                    </select>
                    <span style="color: red">*M3入驻级别必选</span>
                </td>
            </tr>
            <tr class="merMaxLevel">
                <td class="lgridlist">银行卡号:</td>

                <td><input data-dojo-type="dijit.form.ValidationTextBox"
                           id="cardNo" maxlength="20" name="cardNo"  value="${modelson.cardNo}"
                           data-dojo-props="trim:true,required:false,regExp:'^[0-9]+$',invalidMessage:'请输入数字'"/>
                    <span style="color: red">*M3入驻级别必选</span>
                </td>
                <td class="lgridlist">持卡人姓名:</td>

                <td><input data-dojo-type="dijit.form.ValidationTextBox"
                           id="cardName" maxlength="32" name="cardName" value="${modelson.cardName}"
                           data-dojo-props="trim:true,required:false"/>
                    <span style="color: red">*M3入驻级别必选</span>

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
            <tr>
                <td class="lgridlist">支持功能</td>
                <td>
                    <select id="scanType" name="scanType" styleClass="required validate-selection"
                            notEmpty="true" >
                        <option value="">请选择</option>
                        <option value="0">正扫</option>
                        <option value="1"> 反扫</option>
                        <option value="2"> 全部</option>
                    </select>
                    <span class="required" id="scanTypeMess" style="color: red;">*请选择支持功能</span>
                </td>
                <td class="lgridlist">账户类型</td>
                <td>
                    <select id="accountType" name="accountType"
                            notEmpty="true" >
                        <option value="">请选择</option>
                        <option value="0">对公账户</option>
                        <option value="1">对私账户</option>
                        <option value="2">BGL</option>
                    </select>
                    <span class="required" id="accountTypeMess" style="color: red;">*请选择账户类型</span>
                </td>
            </tr>
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
