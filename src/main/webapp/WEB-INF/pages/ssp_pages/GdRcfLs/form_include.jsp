<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*" %>

	<input type="hidden" name="tranType" value="${model.tranType}" />

		    <tr>
		
               <td class="lgridlist">
			       <%=GdRcfLs.ALIAS_SYSTEM_CODE%>:
		       </td>
			   <td >
		             <input data-dojo-type="dijit.form.ValidationTextBox" id="systemCode" maxlength="20" name="systemCode" data-dojo-props="trim:true,required:true" value="${model.systemCode}"/> 
		             <span style="color: red" id="systemCodeMess">*</span>
		       </td>
        
               <td class="lgridlist">
			       <%=GdRcfLs.ALIAS_FUCTION_CODE%>:
		       </td>
			   <td >
		             <input data-dojo-type="dijit.form.ValidationTextBox" id="fuctionCode" maxlength="20" name="fuctionCode" data-dojo-props="trim:true,required:true" value="${model.fuctionCode}"/> 
		             <span style="color: red" id="fuctionCodeMess">*</span>
		       </td>
        </tr>
		    <tr>
		
               <td class="lgridlist">
			       <%=GdRcfLs.ALIAS_TRACE_NO%>:
		       </td>
			   <td >
		             <input data-dojo-type="dijit.form.ValidationTextBox" id="traceNo" maxlength="32" name="traceNo" data-dojo-props="trim:true,required:true" value="${model.traceNo}"/> 
		             <span style="color: red" id="traceNoMess">*</span>
		       </td>
        
               <td class="lgridlist">
			       <%=GdRcfLs.ALIAS_CARD_NO%>:
		       </td>
			   <td >
		             <input data-dojo-type="dijit.form.ValidationTextBox" id="cardNo" maxlength="19" name="cardNo" data-dojo-props="trim:true,required:true" value="${model.cardNo}"/> 
		             <span style="color: red" id="cardNoMess">*</span>
		       </td>
        </tr>
		    <tr>
		
               <td class="lgridlist">
			       <%=GdRcfLs.ALIAS_SMART_CARD%>:
		       </td>
			   <td >
		             <input data-dojo-type="dijit.form.ValidationTextBox" id="smartCard" maxlength="19" name="smartCard" data-dojo-props="trim:true,required:true" value="${model.smartCard}"/> 
		             <span style="color: red" id="smartCardMess">*</span>
		       </td>
        
               <td class="lgridlist">
			       <%=GdRcfLs.ALIAS_AMOUNT%>:
		       </td>
			   <td >
		             <input data-dojo-type="dijit.form.ValidationTextBox" id="amount" maxlength="12" name="amount" data-dojo-props="trim:true,required:true" value="${model.amount}"/> 
		             <span style="color: red" id="amountMess">*</span>
		       </td>
        </tr>
		    <tr>
		
               <td class="lgridlist">
			       <%=GdRcfLs.ALIAS_SYS_DATE%>:
		       </td>
			   <td >
		             <input id="sysDate" name="sysDate" value="${model.sysDate}"  
								   class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyyMMddHHmmss'})" />
		       </td>
        
               <td class="lgridlist">
			       <%=GdRcfLs.ALIAS_SYS_TIME%>:
		       </td>
			   <td >
		             <input data-dojo-type="dijit.form.ValidationTextBox" id="sysTime" maxlength="6" name="sysTime" data-dojo-props="trim:true,required:true" value="${model.sysTime}"/> 
		             <span style="color: red" id="sysTimeMess">*</span>
		       </td>
        </tr>
		    <tr>
		
               <td class="lgridlist">
			       <%=GdRcfLs.ALIAS_RESP_CODE%>:
		       </td>
			   <td >
		             <input data-dojo-type="dijit.form.ValidationTextBox" id="respCode" maxlength="2" name="respCode" data-dojo-props="trim:true,required:true" value="${model.respCode}"/> 
		             <span style="color: red" id="respCodeMess">*</span>
		       </td>
        
               <td class="lgridlist">
			       <%=GdRcfLs.ALIAS_RESP_MSG%>:
		       </td>
			   <td >
		             <input data-dojo-type="dijit.form.ValidationTextBox" id="respMsg" maxlength="100" name="respMsg" data-dojo-props="trim:true,required:true" value="${model.respMsg}"/> 
		             <span style="color: red" id="respMsgMess">*</span>
		       </td>
        </tr>
		    <tr>
		
               <td class="lgridlist">
			       <%=GdRcfLs.ALIAS_CSP_RESP_CODE%>:
		       </td>
			   <td >
		             <input data-dojo-type="dijit.form.ValidationTextBox" id="cspRespCode" maxlength="7" name="cspRespCode" data-dojo-props="trim:true,required:true" value="${model.cspRespCode}"/> 
		             <span style="color: red" id="cspRespCodeMess">*</span>
		       </td>
        
               <td class="lgridlist">
			       <%=GdRcfLs.ALIAS_CSP_RESP_MSG%>:
		       </td>
			   <td >
		             <input data-dojo-type="dijit.form.ValidationTextBox" id="cspRespMsg" maxlength="100" name="cspRespMsg" data-dojo-props="trim:true,required:true" value="${model.cspRespMsg}"/> 
		             <span style="color: red" id="cspRespMsgMess">*</span>
		       </td>
        </tr>
