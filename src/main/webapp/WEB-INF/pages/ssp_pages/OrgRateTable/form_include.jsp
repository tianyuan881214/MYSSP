<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*" %>

<%-- <input type="hidden" name="orgId" value="${model.orgId}" /> --%>

<tr>
    <td class="lgridlist">机构:</td>
    <td>
        <select name="orgId"  id="orgId">
            <option value="">--请选择--</option>
            <c:forEach items="${lowerOrgs}" var="item">
                <option value="${item.orgId}">${item.name}</option>
            </c:forEach>
        </select>
        <span style="color: red" id="orgIdMess">*</span></td>
</tr>
<tr>
    <td class="lgridlist"><%=OrgRateTable.ALIPAY_RATE%></td>
    <td> <input data-dojo-type="dijit.form.ValidationTextBox"
                id="alipayRate" maxlength="11" name="alipayRate"
                data-dojo-props="trim:true,required:true,invalidMessage:'请输入数字，最多有四位整数六位小数点'"
                value="${model.alipayRate}"/>
        <span style="color: red" id="alipayRateMess">* 例如:"1%,写成0.01"</span></td>

</tr>
<tr>
    <td class="lgridlist"><%=OrgRateTable.WECHAT_RATE%></td>
    <td> <input data-dojo-type="dijit.form.ValidationTextBox"
                id="wechatRate" maxlength="11" name="wechatRate"
                data-dojo-props="trim:true,required:true ,invalidMessage:'请输入数字，最多有四位整数六位小数点'"
                value="${model.wechatRate}"/>
        <span style="color: red" id="wechatRateMess">* 例如:"1%,写成0.01"</span></td>

</tr>
<tr>
    <td class="lgridlist"><%=OrgRateTable.UNION_RATE%></td>
    <td> <input data-dojo-type="dijit.form.ValidationTextBox"
                id="unionRate" maxlength="11" name="unionRate"
                data-dojo-props="trim:true,required:true,invalidMessage:'请输入数字，最多有四位整数六位小数点'"
                value="${model.unionRate}"/>
        <span style="color: red" id="unionRateMess">* 例如:"1%,写成0.01"</span></td>

</tr>
<tr>
    <td class="lgridlist"><%=OrgRateTable.ACCOUNT_NO%></td>
    <td> <input data-dojo-type="dijit.form.ValidationTextBox"
                id="accountNo" maxlength="50" name="accountNo"
                data-dojo-props="trim:true,required:true"
                value="${model.accountNo}"/>
        <span style="color: red" id="accountNoMess">*</span></td>

</tr>
<tr>
    <td class="lgridlist"><%=OrgRateTable.REMARK%></td>
    <td> <input data-dojo-type="dijit.form.ValidationTextBox"
                id="remark" maxlength="100" name="remark"
                data-dojo-props="trim:true"
                value="${model.remark}"/>
</tr>
<tr>
    <td class="lgridlist"><%=OrgRateTable.ACCOUNT_NANME%></td>
    <td> <input data-dojo-type="dijit.form.ValidationTextBox"
                id="accountName" maxlength="100" name="accountName"
                data-dojo-props="trim:true"
                value="${model.accountName}"/>
</tr>



