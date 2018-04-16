<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*" %>

<%-- <input type="hidden" name="tranType" value="${model.tranType}" /> --%>

<tr>
    <td class="lgridlist"><%=BusinessBase.BUSINESS_NAME%>:</td>
    <td><input data-dojo-type="dijit.form.ValidationTextBox"
               id="businessName" maxlength="32" name="businessName"
               data-dojo-props="trim:true,required:true"
               value="${model.businessName}"/>
        <span style="color: red" id="businessNameMess">*</span></td>
    <td class="lgridlist"><%=BusinessBase.BUSINESS_SM%>:</td>

    <td><input data-dojo-type="dijit.form.ValidationTextBox"
               id="businessSm" maxlength="100" name="businessSm"
               data-dojo-props="trim:true,required:true" value="${model.businessSm}"/>
        <span style="color: red" id="systemCodeMess">*</span></td>
</tr>
