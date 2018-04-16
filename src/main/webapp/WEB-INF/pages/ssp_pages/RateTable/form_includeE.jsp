<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*" %>

<input type="hidden" name="rateId" value="${model.rateId}" />
<tr>
    <td class="lgridlist">机构:</td>
    <td>
            <select name="orgId" id="orgId">
            <option value="">--请选择--</option>
            <c:forEach items="${lowerOrgs}" var="item">
                <option value="${item.orgId} ${item.orgId==model.rateId?"selected='selected'":""}">${item.name} </option>
            </c:forEach>
        </select>
    <td></td>
    <td></td>
</tr>
<c:forEach items="${BusinessList}" var="u">
    <tr>
        <td class="lgridlist">业务及费率</td>

        <td>
            <input type="hidden" name="businessId" id="businessId" value="${u.businessId}"
                ${u.checked==true?"checked='checked'":'' } /> ${u.businessName}
            <input data-dojo-type="dijit.form.ValidationTextBox"
                   id="rate" maxlength="11" name="rate"
                   data-dojo-props="trim:true,required:true,regExp:'^[0-9]{0,4}\\.[0-9]{1,6}$',invalidMessage:'请输入数字，最多有四位整数六位小数点'"
                   value="${model.rate}"/>
            <span style="color: red" id="systemCodeMess">* 例如:"0.4%,写成0.004"</span>
        </td>

        <td></td><td></td>
    </tr>
</c:forEach>
<tr>
    <td class="lgridlist"><%=RateTable.ACCOUNT_NO%>:</td>
    <td><input data-dojo-type="dijit.form.ValidationTextBox"
               id="accountNo" maxlength="100" name="accountNo"
               data-dojo-props="trim:true,required:true" value="${model.accountNo}"/>
    <td></td><td></td>
</tr>
<tr>
    <td class="lgridlist"><%=RateTable.RATE_DESCRIPTION%>:</td>
    <td><input data-dojo-type="dijit.form.ValidationTextBox"
               id="rateDescription" maxlength="100" name="rateDescription"
               data-dojo-props="trim:true,required:true" value="${model.rateDescription}"/>
        <span style="color: red" id="rateDescriptionMess">* </span>
    <td>
   </td><td></td>
</tr>
