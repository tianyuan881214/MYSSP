<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*" %>


		    <tr>
		
               <td class="lgridlist">
			       <span class="required">*</span><%=GdUserCard.ALIAS_CARD_NO%>:
		       </td>
			   <td >
		             <input data-dojo-type="dijit.form.ValidationTextBox" id="cardNo" maxlength="19" name="cardNo" data-dojo-props="trim:true,required:true" value="${model.cardNo}"/> 
		             <span style="color: red" id="cardNoMess">*</span>
		       </td>
        
               <td class="lgridlist">
			       <span class="required">*</span><%=GdUserCard.ALIAS_PHONE_NO%>:
		       </td>
			   <td >
		             <input data-dojo-type="dijit.form.ValidationTextBox" id="phoneNo" maxlength="11" name="phoneNo" data-dojo-props="trim:true,required:true" value="${model.phoneNo}"/> 
		             <span style="color: red" id="phoneNoMess">*</span>
		       </td>
        </tr>
		    <tr>
		
               <td class="lgridlist">
			       <%=GdUserCard.ALIAS_USER_NAME%>:
		       </td>
			   <td >
		             <input data-dojo-type="dijit.form.ValidationTextBox" id="userName" maxlength="12" name="userName" data-dojo-props="trim:true,required:true" value="${model.userName}"/> 
		             <span style="color: red" id="userNameMess">*</span>
		       </td>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
             </tr>
        
