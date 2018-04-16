<%@ taglib prefix="mytag" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*" %>

<%-- <input type="hidden" name="tranType" value="${model.tranType}" /> --%>

<tr>

    <td class="lgridlist"><%=MerchantBase.ALIAS_MERCHANT_ID%>:</td>

    <td><input data-dojo-type="dijit.form.ValidationTextBox"
               id="merchantId" maxlength="15" name="merchantId"
               data-dojo-props="trim:true,required:true,regExp:'^[0-9]{15}$',invalidMessage:'请输入15位数字的商户号'" value="${model.merchantId}" onblur="isMerchantIdExist(this.value);"/>
        <span style="color: red" id="merchantIdMsg">*</span></td>
    <td class="lgridlist"><%=MerchantBase.ALIAS_MERCHANT_CNAME%>:</td>
    <td><input data-dojo-type="dijit.form.ValidationTextBox"
               id="merchantCname" maxlength="40" name="merchantCname"
               data-dojo-props="trim:true,required:true"
               value="${model.merchantCname}"/> <span style="color: red"
                                                      id="systemCodeMess">*</span></td>
</tr>
<tr>
    <td class="lgridlist"><%=MerchantBase.ALIAS_MERCHANT_ENAME%>:</td>
    <td><input data-dojo-type="dijit.form.ValidationTextBox"
               id="merchantEname" maxlength="20" name="merchantEname"
               data-dojo-props="trim:true,required:false"
               value="${model.merchantEname}"/></td>
    <td class="lgridlist"><%=MerchantBase.ALIAS_ADDRESS_CHN%>:</td>
    <td><input data-dojo-type="dijit.form.ValidationTextBox"
               id="addressChn" maxlength="30" name="addressChn"
               data-dojo-props="trim:true,required:true" value="${model.addressChn}"/>
        <span style="color: red">*</span>
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

    <td class="lgridlist"><%=MerchantBase.ALIAS_POST_CODE%>:</td>
    <td><input data-dojo-type="dijit.form.ValidationTextBox"
               id="postCode" maxlength="6" name="postCode"
               data-dojo-props="trim:true,required:false" value="${model.postCode}"/>
    </td>
    <td class="lgridlist"><%=MerchantBase.ALIAS_FAX%>:</td>
    <td><input data-dojo-type="dijit.form.ValidationTextBox" id="fax"
               maxlength="20" name="fax" data-dojo-props="trim:true,required:false"
               value="${model.fax}"/></td>
</tr>

<tr>

    <td class="lgridlist"><%=MerchantBase.ALIAS_MANAGER%>:</td>
    <td><input data-dojo-type="dijit.form.ValidationTextBox"
               id="manager" maxlength="8" name="manager"
               data-dojo-props="trim:true,required:false" value="${model.manager}"/>
    </td>
    <td class="lgridlist"><%=MerchantBase.ALIAS_MERCHANT_STAT%>:</td>
    <td><mytag:select property="%{model.merchantStat}"
                      styleClass="required validate-selection" name="merchantStat"
                      notEmpty="true" dictName="MERCHANT_STAT" id="merchantStat"/>
        <span class="required" id="merchantStatMsg" style="color: red;">*</span>
    </td>
</tr>

<tr>

    <td class="lgridlist"><%=MerchantBase.ALIAS_MCC%>:</td>
    <td><input data-dojo-type="dijit.form.ValidationTextBox" id="mcc"
               maxlength="4" name="mcc" data-dojo-props="trim:true,required:false"
               value="${model.mcc}"/></td>
    <td class="lgridlist"><%=MerchantBase.ALIAS_ABBR_CNAME%>:</td>
    <td><input data-dojo-type="dijit.form.ValidationTextBox" id="abbrCname"
               maxlength="10" name="abbrCname" data-dojo-props="trim:true,required:true"
               value="${model.abbrCname}"/>
        <span style="color: red">*</span>
    </td>

</tr>
<!-- 一下是扩展业务-------------------------------------------------------------------------------------- -->
<tr>
    <td class="lgridlist">入账账户</td>
    <td><input data-dojo-type="dijit.form.ValidationTextBox" id="accountNo"
               maxlength="19" max="19" name="accountNo" data-dojo-props="trim:true,required:true"/>
        <span style="color: red">*</span>
    </td>

    <td class="lgridlist">账户名称</td>
    <td><input data-dojo-type="dijit.form.ValidationTextBox" id="accountName"
               maxlength="64" max="64" name="accountName" data-dojo-props="trim:true,required:true"/>
        <span style="color:red;">*</span>
    </td>

</tr>
<tr>
    <td class="lgridlist">账户开户行</td>
    <td><input data-dojo-type="dijit.form.ValidationTextBox" id="openingBankNo"
               maxlength="64" max="64" name="openingBankNo" data-dojo-props="trim:true,required:false"/>
    </td>
    <td class="lgridlist">开户行地址</td>
    <td>
        <input data-dojo-type="dijit.form.ValidationTextBox" name="openingBankAddress"
               data-dojo-props="trim:true,required:false" maxlength="64">
    </td>
</tr>
<tr>
    <td class="lgridlist">账户所属人/机构</td>
    <td><input data-dojo-type="dijit.form.ValidationTextBox" id="cardHolderName"
               maxlength="64" max="64" name="cardHolderName" data-dojo-props="trim:true,required:true"/>
        <span style="color: red">*</span>
    </td>
    <td class="lgridlist">所属组</td>
    <td>
        <mytag:select name="merGrpId" id="merGrpId"
                      notEmpty="false" dictName="D_MER_GRP_ID"/>
        <span style="color:red;" id="merGrpIdMag">*</span>
    </td>
</tr>
<tr>
    <td class="lgridlist">账号所属人/机构手机</td>
    <td><input data-dojo-type="dijit.form.ValidationTextBox" maxlength="11" max="11" name="cardHolderMobile"
               data-dojo-props="trim:true,required:false"/></td>

    <td class="lgridlist">账号所属人/机构电话</td>
    <td><input data-dojo-type="dijit.form.ValidationTextBox" maxlength="11" max="11" name="cardHolderTelephone"
               data-dojo-props="trim:true,required:false"/></td>
</tr>
<tr>
    <td class="lgridlist">账号所属人/机构中文地址</td>
    <td><input data-dojo-type="dijit.form.ValidationTextBox" id="cardHolderAddressChn"
               maxlength="64" max="64" name="cardHolderAddressChn" data-dojo-props="trim:true,required:false"/></td>

    <td class="lgridlist">账号所属人/机构英文地址</td>
    <td><input data-dojo-type="dijit.form.ValidationTextBox" id="addressEng" maxlength="64" max="64" name="addressEng"
               data-dojo-props="trim:true,required:false"/></td>
</tr>
<tr>
    <td class="lgridlist">账号所属人/机构邮箱</td>
    <td>
        <input data-dojo-type="dijit.form.ValidationTextBox" id="email"
               maxlength="40" max="40" name="email" data-dojo-props="trim:true,required:false"/>
    </td>
    <td class="lgridlist">账号所属人身份证号</td>
    <td><input data-dojo-type="dijit.form.ValidationTextBox" id="idCard" maxlength="18" max="18" name="idCard"
               data-dojo-props="trim:true,required:false"/>
    </td>
</tr>
<tr>
    <td class="lgridlist">营业执照编号</td>
    <td>
        <input data-dojo-type="dijit.form.ValidationTextBox" id="businessLicense"
               maxlength="20" max="20" name="businessLicense" data-dojo-props="trim:true,required:false"/>
    </td>
    <td class="lgridlist">备注信息</td>
    <td>
        <input data-dojo-type="dijit.form.ValidationTextBox" id="memo"
               maxlength="40" max="40" name="memo" data-dojo-props="trim:true,required:false"/>
    </td>
</tr>
<tr>
    <td class="lgridlist">商户经营类目</td>
    <td>
        <mytag:select styleClass="required validate-selection" name="categoryId" id="categoryId"
                      notEmpty="false" dictName="D_CATEGORY"/>
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