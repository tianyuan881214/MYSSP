<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*" %>

<%--<input type="hidden" name="cityCname" value="${model.cityCname}" />--%>
<input type="hidden" name="merGrpId" value="${modelson.merGrpId}" />
<%--<input type="hidden" name="categoryId" value="${enterAlipay.category_id}" />--%>
<tr>
    <td class="lgridlist">所属二级行:</td>
    <td>
        <select name="belongOrgId"  id="belongOrgId" onchange="isBelongOrgIdExist(this.value);">
            <option value="">--请选择--</option>
            <c:forEach items="${BelongcOrg}" var="item" >
                <option
                        <c:if test="${model.belongOrgId==item.orgId}">selected</c:if>
                        value="${item.orgId}">${item.name}</option>
            </c:forEach>
        </select>
        <span style="color: red" id="belongOrgIdMsg">*</span>

    </td>
    <td class="lgridlist">商户所属机构:</td>
    <td>
        <select name="orgId" id="orgId" >
            <option >--请选择--</option>
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

    <td class="lgridlist"><%=MerchantBase.ALIAS_MERCHANT_ID%>:</td>

    <td><input type="hidden" value="${model.merchantId}" name="merchantId"/>${model.merchantId}</td>

    <td class="lgridlist"><%=MerchantBase.ALIAS_MERCHANT_CNAME%>:</td>
    <td><input data-dojo-type="dijit.form.ValidationTextBox"
               id="merchantCname" maxlength="28" name="merchantCname"
               data-dojo-props="trim:true,required:true"
               value="${model.merchantCname}"/> <span style="color: red" id="systemCodeMess">*</span></td>
</tr>

<tr>
    <td class="lgridlist"><%=MerchantBase.ALIAS_ADDRESS_CHN%>:</td>
    <td><input data-dojo-type="dijit.form.ValidationTextBox"
               id="addressChn" maxlength="64" name="addressChn"
               data-dojo-props="trim:true,required:false" value="${model.addressChn}"/>

    <td class="lgridlist"><%=MerchantBase.ALIAS_ABBR_CNAME%>
    </td>
    <td><input data-dojo-type="dijit.form.ValidationTextBox" id="abbrCname"
               maxlength="16" max="16" name="abbrCname" data-dojo-props="trim:true,required:true"
               value="${model.abbrCname}"/>
        <span style="color: red">*简称为16个汉字</span>
    </td>
</tr>
<tr>
    <td class="lgridlist"><%=MerchantBase.ALIAS_CITY_CNAME%>:</td>
    <td>
        <input data-dojo-type="dijit.form.ValidationTextBox"
               id="cityCname" maxlength="30" name="cityCname"
               data-dojo-props="trim:true,required:true"
               value="${model.cityCname}"/>
        <span style="color: red">*</span>
    </td>
    <td class="lgridlist"><%=MerchantBase.ALIAS_TELEPHONE%>:</td>
    <td><input data-dojo-type="dijit.form.ValidationTextBox"
               id="telephone" maxlength="12" name="telephone"
               data-dojo-props="trim:true,required:true"
               value="${model.telephone}"/>
        <span style="color: red">*</span>
    </td>
</tr>

<tr>
    <td class="lgridlist">入账账号</td>
    <td><input data-dojo-type="dijit.form.ValidationTextBox" id="accountNo" value="${modelson.accountNo}"
               maxlength="30" max="30" name="accountNo"
               data-dojo-props="trim:true,required:true,regExp:'^[0-9]+$',invalidMessage:'请输入数字'"/>
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
    <td><input data-dojo-type="dijit.form.ValidationTextBox" id="openingBank" value="${modelson.cardHolderName}"
               maxlength="64" max="64" name="cardHolderName" data-dojo-props="trim:true,required:true"/>
        <span style="color:red;">*</span>
    </td>
    <td class="lgridlist"><%=MerchantBase.ALIAS_MERCHANT_STAT%>:</td>
    <td><mytag:select property="%{model.merchantStat}"
                      styleClass="required validate-selection" name="merchantStat" id="merchantStat"
                      notEmpty="true" dictName="MERCHANT_STAT" value="${model.merchantStat}"/>
        <span class="required" style="color: red;" id="merchantStatMsg">*</span>
    </td>
</tr>
<tr>
    <td class="lgridlist">开户行行号</td>
    <td><input data-dojo-type="dijit.form.ValidationTextBox" value="${modelson.openingBankNo}"
               maxlength="30" max="30" name="openingBankNo"
               data-dojo-props="trim:true,required:true,regExp:'^[0-9]+$',invalidMessage:'请输入数字'"/>
        <span style="color:red;">*</span>
    </td>
    <td></td><td></td>
</tr>
        <%--M3--%>
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
               data-dojo-props="trim:true,required:false,regExp:'^[0-9]+$',invalidMessage:'请输入1数字'" value="${modelson.provinceCode}"/>
        <span style="color: red" id="provinceCodeMsg">*M2入驻级别必选</span></td>


    <td class="lgridlist">商户所在市区邮编:</td>

    <td><input data-dojo-type="dijit.form.ValidationTextBox"
               id="cityCode" maxlength="10" name="cityCode"
               data-dojo-props="trim:true,required:false,regExp:'^[0-9]+$',invalidMessage:'请输入1数字'" value="${modelson.cityCode}"/>
        <span style="color: red" id="cityCodeMsg">*M2入驻级别必选</span></td>
</tr>
<tr class="merLevel">

    <td class="lgridlist">商户所在省份邮编:</td>

    <td colspan="3">
        <input data-dojo-type="dijit.form.ValidationTextBox"
               id="districtCode" maxlength="10" name="districtCode"
               data-dojo-props="trim:true,required:false,regExp:'^[0-9]+$',invalidMessage:'请输入1数字'" value="${modelson.districtCode}"/>
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
               data-dojo-props="trim:true,required:false,regExp:'^[0-9a-zA-Z]+$',invalidMessage:'请输入正确格式'"  onblur="cardNoExist(this.value)"/>
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
            <option <c:if test="${modelson.businessLicenseType=='NATIONAL_LEGAL'}">selected</c:if> value="NATIONAL_LEGAL">营业执照</option>
            <option <c:if test="${modelson.businessLicenseType=='NATIONAL_LEGAL_MERGE'}">selected</c:if> value="NATIONAL_LEGAL_MERGE">营业执照（多证合一）</option>
            <option <c:if test="${modelson.businessLicenseType=='INST_RGST_CTF'}">selected</c:if> value="INST_RGST_CTF">事业单位法人证书</option>
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
   <%--M3结束--%>
<tr>
    <td class="lgridlist">是否他行账户</td>
    <td><mytag:select   name="fax" value="${modelson.fax}"
                        notEmpty="false" dictName="IN_BANK"   onchange="isTo(this.value);"/>
        <span class="required" id="faxMsg" style="color: red;">*</span>
    </td>
    <td></td><td></td>

    <%--  document.getElementById("openName").style.visibility="hidden";
      document.getElementById("opening").style.visibility="hidden";--%>


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
<tr>
    </td>
    <td class="lgridlist">商户经营类目</td>
    <td>
        <mytag:select styleClass="required validate-selection" name="categoryId" id="categoryId"
                      notEmpty="true" value="${enterAlipay.category_id}" dictName="D_CATEGORY"/>
    </td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <%--编辑页面--%>
</tr>
<c:forEach items="${BusinessList}" var="u">
    <tr>
    <td class="lgridlist">业务及费率</td>
    <td>
        <input type="checkbox"
               name="ids" value="${u.businessId}"
            ${u.checked==true?"checked='checked'":'' } /> ${u.businessName}

        <select id="${u.businessId}" name="${u.businessId}" value="${u.businessId}">
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
<tr>
    <td class="lgridlist">扫描方式</td>
    <td>
        <select id="scanType" name="scanType" >
        <option value="">请选择</option>
        <option <c:if test="${model.scanType=='0'}">selected</c:if> value="0">正扫</option>
        <option <c:if test="${model.scanType=='1'}">selected</c:if> value="1">反扫</option>
        <option <c:if test="${model.scanType=='2'}">selected</c:if> value="2">全扫</option>
    </select>
        <span style="color:red;" id="scanTypeMess">*</span>
    </td>
    <td class="lgridlist">账户类型</td>
    <td>
        <select id="accountType" name="accountType"
                notEmpty="true" >
            <option value="">请选择</option>
            <option <c:if test="${model.accountType=='0'}">selected</c:if> value="0">对公账户</option>
            <option <c:if test="${model.accountType=='1'}">selected</c:if> value="1">对私账户</option>
            <option <c:if test="${model.accountType=='2'}">selected</c:if> value="2">BGL</option>
        </select>
        <span style="color:red;" id="accountTypeMess">*</span>
    </td>

</tr>



