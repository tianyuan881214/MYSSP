<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*" %>

<%-- <input type="hidden" name="tranType" value="${model.tranType}" /> --%>

<tr>
    <input type="hidden" name="feeId" value="${model.feeId}"/>
    <td class="lgridlist"><%=FeeTable.FEE%>:</td>
    <td><input data-dojo-type="dijit.form.ValidationTextBox"
               id="fee" maxlength="11" name="fee"
               data-dojo-props="trim:true,required:true,regExp:'^[0-9]{0,4}\\.[0-9]{1,6}$',invalidMessage:'请输入数字，最多有四位整数六位小数点'"
               value="${model.fee}"/> <span style="color: red"
                                            id="systemCodeMess">*</span></td>
    <td class="lgridlist"><%=FeeTable.FEE_SM%>:</td>

    <td><input data-dojo-type="dijit.form.ValidationTextBox"
               id="feeSm" maxlength="100" name="feeSm"
               data-dojo-props="trim:true,required:true" value="${model.feeSm}"/>
        <span style="color: red" id="systemCodeMess">*</span></td>
</tr>

