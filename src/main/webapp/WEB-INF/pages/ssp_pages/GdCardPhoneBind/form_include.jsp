<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*" %>


		    <tr>
		
               <td class="lgridlist">
			       <span class="required">*</span><%=GdCardPhoneBind.ALIAS_SMART_CARD%>:
		       </td>
			   <td >
		             <input data-dojo-type="dijit.form.ValidationTextBox" id="smartCard" maxlength="19" name="smartCard" data-dojo-props="trim:true,required:true" value="${model.smartCard}"/> 
		             <span style="color: red" id="smartCardMess">*</span>
		       </td>
        
               <td class="lgridlist">
			       <span class="required">*</span><%=GdCardPhoneBind.ALIAS_BANK_CARD%>:
		       </td>
			   <td >
		             <input data-dojo-type="dijit.form.ValidationTextBox" id="bankCard" maxlength="19" name="bankCard" data-dojo-props="trim:true,required:true" value="${model.bankCard}"/> 
		             <span style="color: red" id="bankCardMess">*</span>
		       </td>
        </tr>
		    <tr>
		
               <td class="lgridlist">
			       <%=GdCardPhoneBind.ALIAS_PHONE_NO%>:
		       </td>
			   <td >
		             <input data-dojo-type="dijit.form.ValidationTextBox" id="phoneNo" maxlength="11" name="phoneNo" data-dojo-props="trim:true,required:true" value="${model.phoneNo}"/> 
		             <span style="color: red" id="phoneNoMess">*</span>
		       </td>
        
               <td class="lgridlist">
			       <%=GdCardPhoneBind.ALIAS_PHONE_CODE%>:
		       </td>
			   <td >
		             <input data-dojo-type="dijit.form.ValidationTextBox" id="phoneCode" maxlength="6" name="phoneCode" data-dojo-props="trim:true,required:true" value="${model.phoneCode}"/> 
		             <span style="color: red" id="phoneCodeMess">*</span>
		       </td>
        </tr>
		    <tr>
		
               <td class="lgridlist">
			       <%=GdCardPhoneBind.ALIAS_USER_NAME%>:
		       </td>
			   <td >
		             <input data-dojo-type="dijit.form.ValidationTextBox" id="userName" maxlength="40" name="userName" data-dojo-props="trim:true,required:true" value="${model.userName}"/> 
		             <span style="color: red" id="userNameMess">*</span>
		       </td>
        
               <td class="lgridlist">
			       <%=GdCardPhoneBind.ALIAS_VALIDATE_FLAG%>:
		       </td>
			   <td >
		             <input data-dojo-type="dijit.form.ValidationTextBox" id="validateFlag" maxlength="1" name="validateFlag" data-dojo-props="trim:true,required:true" value="${model.validateFlag}"/> 
		             <span style="color: red" id="validateFlagMess">*</span>
		       </td>
        </tr>
		    <tr>
		
               <td class="lgridlist">
			       <%=GdCardPhoneBind.ALIAS_STATU_FLAG%>:
		       </td>
			   <td >
		             <input data-dojo-type="dijit.form.ValidationTextBox" id="statuFlag" maxlength="1" name="statuFlag" data-dojo-props="trim:true,required:true" value="${model.statuFlag}"/> 
		             <span style="color: red" id="statuFlagMess">*</span>
		       </td>
        
               <td class="lgridlist">
			       <%=GdCardPhoneBind.ALIAS_SIGN_DATE%>:
		       </td>
			   <td >
		             <input id="signDate" name="signDate" value="${model.signDate}"  
								   class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyyMMddHHmmss'})" />
		       </td>
        </tr>
		    <tr>
		
               <td class="lgridlist">
			       <%=GdCardPhoneBind.ALIAS_SIGN_TIME%>:
		       </td>
			   <td >
		             <input data-dojo-type="dijit.form.ValidationTextBox" id="signTime" maxlength="6" name="signTime" data-dojo-props="trim:true,required:true" value="${model.signTime}"/> 
		             <span style="color: red" id="signTimeMess">*</span>
		       </td>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
             </tr>
        
