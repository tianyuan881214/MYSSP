<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*" %>

<%--<input type="hidden" name="cityCname" value="${model.cityCname}" />--%>
<input type="hidden" name="merGrpId" value="${modelson.merGrpId}" />
<%--<input type="hidden" name="categoryId" value="${enterAlipay.category_id}" />--%>

<tr>

    <td class="lgridlist"><%=MerchantBase.ALIAS_MERCHANT_ID%>:</td>

    <td><input type="hidden" value="${model.merchantId}" name="merchantId"/>${model.merchantId}</td>
    <td class="lgridlist"><%=MerchantBase.ALIAS_MERCHANT_CNAME%>:</td>
    <td><input data-dojo-type="dijit.form.ValidationTextBox"
               id="merchantCname" maxlength="32" name="merchantCname"
               data-dojo-props="trim:true,required:true"
               value="${model.merchantCname}" readonly="true"/> <span style="color: red" id="systemCodeMess">*</span></td>
</tr>

<tr>
    <td class="lgridlist"><%=MerchantBase.ALIAS_ADDRESS_CHN%>:</td>
    <td><input data-dojo-type="dijit.form.ValidationTextBox"
               id="addressChn" maxlength="15" name="addressChn"
               data-dojo-props="trim:true,required:false" value="${model.addressChn}" readonly="true"/>

    <td class="lgridlist"><%=MerchantBase.ALIAS_ABBR_CNAME%>
    </td>
    <td><input data-dojo-type="dijit.form.ValidationTextBox" id="abbrCname"
               maxlength="6" max="16" name="abbrCname" data-dojo-props="trim:true,required:true"
               value="${model.abbrCname}" readonly="true"/>
        <span style="color: red">*简称为6个汉字</span>
    </td>
</tr>
<tr>
    <td class="lgridlist"><%=MerchantBase.ALIAS_CITY_CNAME%>:</td>
    <td>
        <input data-dojo-type="dijit.form.ValidationTextBox"
               id="cityCname" maxlength="32" name="cityCname"
               data-dojo-props="trim:true,required:true"
               value="${model.cityCname}" readonly="true"/>
        <span style="color: red">*</span>
    </td>
    <td class="lgridlist"><%=MerchantBase.ALIAS_TELEPHONE%>:</td>
    <td><input data-dojo-type="dijit.form.ValidationTextBox"
               id="telephone" maxlength="32" name="telephone"
               data-dojo-props="trim:true,required:true"
               value="${model.telephone}" readonly="true"/>
        <span style="color: red">*</span>
    </td>
</tr>

<tr>
    <td class="lgridlist">入账账号</td>
    <td><input data-dojo-type="dijit.form.ValidationTextBox" id="accountNo" value="${modelson.accountNo}"
               maxlength="30" max="30" name="accountNo"
               data-dojo-props="trim:true,required:true,regExp:'^[0-9]+$',invalidMessage:'请输入数字'" readonly="true"/>
        <span style="color: red">*</span>
    </td>
    <td class="lgridlist">账户名称</td>
    <td><input data-dojo-type="dijit.form.ValidationTextBox" id="accountName" value="${modelson.accountName}"
               maxlength="32" max="32" name="accountName" data-dojo-props="trim:true,required:true" readonly="true"/>
        <span style="color:red;">*</span>
    </td>
</tr>

<!-- 一下是扩展业务-------------------------------------------------------------------------------------- -->
<tr>

    <td class="lgridlist">账户开户行</td>
    <td><input data-dojo-type="dijit.form.ValidationTextBox" id="openingBank" value="${modelson.cardHolderName}"
               maxlength="32" max="32" name="cardHolderName" data-dojo-props="trim:true,required:true" readonly="true"/>
        <span style="color:red;">*</span>
    </td>
    <td class="lgridlist"><%=MerchantBase.ALIAS_MERCHANT_STAT%>:</td>
    <td><mytag:select property="%{model.merchantStat}"
                      styleClass="required validate-selection" name="merchantStat" id="merchantStat"
                      notEmpty="false" dictName="MERCHANT_STAT" value="${model.merchantStat}"  />
        <span class="required" style="color: red;" id="merchantStatMsg">*</span>
    </td>
</tr>
<tr>
    <td class="lgridlist">开户行行号</td>
    <td><input data-dojo-type="dijit.form.ValidationTextBox" value="${modelson.openingBankNo}"
               maxlength="30" max="30" name="openingBankNo"
               data-dojo-props="trim:true,required:true,regExp:'^[0-9]+$',invalidMessage:'请输入数字'" readonly="true"/>
        <span style="color:red;">*</span>
    </td>
    <td class="lgridlist">机构:</td>
    <td>
        <select name="orgId" id="orgId" >
            <option value="">--请选择--</option>
            <c:forEach items="${orgs}" var="item">
                <option
                        <c:if test="${model.zbank==item.orgId}">selected</c:if>
                        value="${item.orgId}">${item.name}</option>
            </c:forEach>
        </select>
        <span style="color: red" id="orgIdMsg">*</span>
    </td>
</tr>
<tr>
    <td class="lgridlist">是否他行账户</td>
    <td><mytag:select   name="fax" value="${modelson.fax}"
                        notEmpty="false" dictName="IN_BANK" />
        <span class="required" id="faxMsg" style="color: red;">*</span>
    </td>

    <%--  document.getElementById("openName").style.visibility="hidden";
      document.getElementById("opening").style.visibility="hidden";--%>
    <td class="lgridlist" id = "openName" >开户人姓名</td>
    <td id = "opening" >
        <input data-dojo-type="dijit.form.ValidationTextBox" value="${modelson.openingBank}"
               maxlength="32" max="32" name="openingBank"  />
        <span style="color:red;">*入账账号为他行账户时填写！</span>
    </td>

</tr>
<c:forEach items="${BusinessList}" var="u">
    <tr>
    <td class="lgridlist">业务及费率</td>
    <td>
        <input type="checkbox"
               name="ids" value="${u.businessId}"
            ${u.checked==true?"checked='checked'":'' }  /> ${u.businessName}

        <select id="${u.businessId}" name="${u.businessId}" value="${u.businessId}" >
            <option value="">请选择</option>
            <c:forEach items="${feeList}" var="b">
                <option
                        <c:if test="${u.feeid==b.fee}">selected="selected"</c:if>
                        value="${b.feeId }"> ${b.fee} </option>
            </c:forEach>
        </select>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
</c:forEach>
</tr>
<tr>
    </td>
    <td class="lgridlist">商户经营类目</td>
    <td>
        <mytag:select styleClass="required validate-selection" name="categoryId" id="categoryId"
                      notEmpty="true" value="${enterAlipay.category_id}" dictName="D_CATEGORY" />
    </td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <%--编辑页面--%>
</tr>

<tr>
    <td class="lgridlist">支付宝内的唯一标识
    </td>
    <td><input type="text" name="alisub_merchant_ids" id = "alisub_merchant_ids" value="${enterAiliMerchant.sub_merchant_id}"  readonly="true"/></td>
    <td class="lgridlist">入驻结果</td>
    <td>
        <c:if test="${enterAiliMerchant.sub_merchant_id==null || enterAiliMerchant.sub_merchant_id=='' }">入驻失败</c:if>
        <c:if test="${enterAiliMerchant.sub_merchant_id!=null && enterAiliMerchant.sub_merchant_id!='' }">入驻成功</c:if>
    </td>

</tr>
<tr>
    <td class="lgridlist">微信内的唯一标识</td>
    <td>
        <input type="text" name="Wsub_mch_id" id = "Wsub_mch_id"  value="${model.sub_mch_id}" readonly="true"/>
    </td>

    <td class="lgridlist">入驻结果</td>
    <td>
        <c:if test="${model.sub_mch_id==null || model.sub_mch_id=='' }">入驻失败</c:if>
        <c:if test="${model.sub_mch_id!=null && model.sub_mch_id!='' }">入驻成功</c:if>
    </td>

</tr>

