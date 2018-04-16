<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*" %>

<%--<input type="hidden" name="orgId" value="${model.orgId}" />--%>
<tr>
    <td><%=OrgRateTable.ORG_ID%></td>
    <td>
    <select name="orgId" id="orgId">
        <option value="" disabled="disabled">--请选择--</option>
        <c:forEach items="${lowerOrgs}" var="item">
            <option
                    <c:if test="${model.orgId==item.orgId}">selected</c:if>
                    value="${item.orgId}">${item.name}</option>
        </c:forEach>
    </select>
        <span style="color: red" id="orgIdMsg">*</span>
    </td>

    <td></td><td></td>
</tr>
<tr>
    <td><%=OrgRateTable.ALIPAY_RATE%></td>
    <td> <input data-dojo-type="dijit.form.ValidationTextBox"
                id="alipayRate" maxlength="11" name="alipayRate"
                data-dojo-props="trim:true,required:true"
                value="${model.alipayRate}"/>
        <span style="color: red" id="alipayRateMess">* 例如:"0.4%,写成0.004"</span></td>
    <td></td>
    <td></td>
</tr>
<tr>
    <td><%=OrgRateTable.WECHAT_RATE%></td>
    <td> <input data-dojo-type="dijit.form.ValidationTextBox"
                id="wechatRate" maxlength="11" name="wechatRate"
                data-dojo-props="trim:true,required:true"
                value="${model.wechatRate}"/>
        <span style="color: red" id="wechatRateMess">* 例如:"0.4%,写成0.004"</span></td>
    <td></td>
    <td></td>
</tr>
<tr>
    <td><%=OrgRateTable.UNION_RATE%></td>
    <td> <input data-dojo-type="dijit.form.ValidationTextBox"
                id="unionRate" maxlength="11" name="unionRate"
                data-dojo-props="trim:true,required:true"
                value="${model.unionRate}"/>
        <span style="color: red" id="unionRateMess">* 例如:"0.4%,写成0.004"</span></td>
    <td></td>
    <td></td>
</tr>
<tr>
    <td><%=OrgRateTable.ACCOUNT_NO%></td>
    <td> <input data-dojo-type="dijit.form.ValidationTextBox"
                id="accountNo" maxlength="50" name="accountNo"
                data-dojo-props="trim:true,required:true"
                value="${model.accountNo}"/>
        <span style="color: red" id="accountNoMess">*</span></td>
    <td></td>
    <td></td>
</tr>
<tr>
    <td><%=OrgRateTable.REMARK%></td>
    <td> <input data-dojo-type="dijit.form.ValidationTextBox"
                id="remark" maxlength="100" name="remark"
                data-dojo-props="trim:true"
                value="${model.remark}"/>
    <td></td>
    <td></td>
</tr>
<tr>
    <td><%=OrgRateTable.ACCOUNT_NANME%></td>
    <td> <input data-dojo-type="dijit.form.ValidationTextBox"
                id="accountName" maxlength="50" name="accountName"
                data-dojo-props="trim:true,required:true"
                value="${model.accountName}"/>
        <span style="color: red" id="accountNameMess">*</span></td>
    <td></td>
    <td></td>
</tr>


