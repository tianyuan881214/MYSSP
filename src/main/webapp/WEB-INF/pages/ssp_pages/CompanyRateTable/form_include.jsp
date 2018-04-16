<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*" %>

<%-- <input type="hidden" name="companyId" value="${model.companyId}" /> --%>
<tr>

    <td class="lgridlist"><%=CompanyRateTable.RATE%>:</td>
    <td><input data-dojo-type="dijit.form.ValidationTextBox"
               id="rate" maxlength="11" name="rate"
               data-dojo-props="trim:true,required:true"
               value="${model.rate}"/>
        <span style="color: red" id="rateCodeMess">* 如维护扣率格式:"0.4%,写成0.004"</span>
    </td>
    <td class="lgridlist"><%=CompanyRateTable.COMPANY_DESCRIPTION%>:</td>

    <td><input data-dojo-type="dijit.form.ValidationTextBox"
               id="companyDescription" maxlength="100" name="companyDescription"
               data-dojo-props="trim:true,required:true" value="${model.companyDescription}"/>
        <span style="color: red" id="companyDescriptionCodeMess">* </span>
    </td>

</tr>


