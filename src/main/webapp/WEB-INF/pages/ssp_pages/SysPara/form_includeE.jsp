<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*" %>


 <input type="hidden" name="paraId" value="${model.paraId}" />
<tr>

    <td class="lgridlist"><%=SysPara.PARA_VALUE%>:</td>
    <td><input data-dojo-type="dijit.form.ValidationTextBox"
               id="paraValue" maxlength="30" name="paraValue"
               data-dojo-props="trim:true,required:true"
               value="${model.paraValue}"/>
    </td>
    <td class="lgridlist"><%=SysPara.REMARK%>:</td>

    <td><input data-dojo-type="dijit.form.ValidationTextBox"
               id="remark" maxlength="50" name="remark"
               data-dojo-props="trim:true,required:true" value="${model.remark}"/>
    </td>

</tr>
