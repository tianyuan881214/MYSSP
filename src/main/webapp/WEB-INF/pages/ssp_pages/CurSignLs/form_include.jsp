<%@page import="com.yada.ssp.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>

	<s:hidden id="lsId" name="lsId" />

		    <tr class="crosscolor_tr">
		
               <td class="crosscolor_td">
			       <%=CurSignLs.ALIAS_CARD_NO%>:
		       </td>
			   <td >
		             <s:textfield label="%{@vs@ALIAS_CARD_NO}" size="40" key="cardNo" value="%{model.cardNo}" cssClass="" required="false" maxlength="19" />
		       </td>
        
               <td class="crosscolor_td">
			       <%=CurSignLs.ALIAS_TRAN_AMT%>:
		       </td>
			   <td >
		             <s:textfield label="%{@vs@ALIAS_TRAN_AMT}" size="40" key="tranAmt" value="%{model.tranAmt}" cssClass="validate-integer " required="false" maxlength="30" />
		       </td>
        </tr>
		    <tr class="crosscolor_tr">
		
               <td class="crosscolor_td">
			       <%=CurSignLs.ALIAS_TERMINAL_ID%>:
		       </td>
			   <td >
		             <s:textfield label="%{@vs@ALIAS_TERMINAL_ID}" size="40" key="terminalId" value="%{model.terminalId}" cssClass="" required="false" maxlength="8" />
		       </td>
        
               <td class="crosscolor_td">
			       <%=CurSignLs.ALIAS_MERCHANT_ID%>:
		       </td>
			   <td >
		             <s:textfield label="%{@vs@ALIAS_MERCHANT_ID}" size="40" key="merchantId" value="%{model.merchantId}" cssClass="" required="false" maxlength="15" />
		       </td>
        </tr>
		    <tr class="crosscolor_tr">
		
               <td class="crosscolor_td">
			       <%=CurSignLs.ALIAS_TRACE_NO%>:
		       </td>
			   <td >
		             <s:textfield label="%{@vs@ALIAS_TRACE_NO}" size="40" key="traceNo" value="%{model.traceNo}" cssClass="" required="false" maxlength="6" />
		       </td>
        
               <td class="crosscolor_td">
			       <%=CurSignLs.ALIAS_TRAN_RRN%>:
		       </td>
			   <td >
		             <s:textfield label="%{@vs@ALIAS_TRAN_RRN}" size="40" key="tranRrn" value="%{model.tranRrn}" cssClass="" required="false" maxlength="12" />
		       </td>
        </tr>
		    <tr class="crosscolor_tr">
		
               <td class="crosscolor_td">
			       <%=CurSignLs.ALIAS_BATCH_NO%>:
		       </td>
			   <td >
		             <s:textfield label="%{@vs@ALIAS_BATCH_NO}" size="40" key="batchNo" value="%{model.batchNo}" cssClass="" required="false" maxlength="6" />
		       </td>
        
               <td class="crosscolor_td">
			       <%=CurSignLs.ALIAS_LOCAL_SYS_DATE%>:
		       </td>
			   <td >
		             <s:textfield label="%{@vs@ALIAS_LOCAL_SYS_DATE}" size="40" key="localSysDate" value="%{model.localSysDate}" cssClass="" required="false" maxlength="8" />
		       </td>
        </tr>
		    <tr class="crosscolor_tr">
		
               <td class="crosscolor_td">
			       <%=CurSignLs.ALIAS_LOCAL_SYS_TIME%>:
		       </td>
			   <td >
		             <s:textfield label="%{@vs@ALIAS_LOCAL_SYS_TIME}" size="40" key="localSysTime" value="%{model.localSysTime}" cssClass="" required="false" maxlength="6" />
		       </td>
        
               <td class="crosscolor_td">
			       <%=CurSignLs.ALIAS_SETTLE_DATE%>:
		       </td>
			   <td >
		             <s:textfield label="%{@vs@ALIAS_SETTLE_DATE}" size="40" key="settleDate" value="%{model.settleDate}" cssClass="" required="false" maxlength="4" />
		       </td>
        </tr>
		    <tr class="crosscolor_tr">
		
               <td class="crosscolor_td">
			       <%=CurSignLs.ALIAS_TICKET_FL_NAME%>:
		       </td>
			   <td >
		             <s:textfield label="%{@vs@ALIAS_TICKET_FL_NAME}" size="40" key="ticketFlName" value="%{model.ticketFlName}" cssClass="" required="false" maxlength="30" />
		       </td>
        
               <td class="crosscolor_td">
			       <%=CurSignLs.ALIAS_SIGN_FL_NAME%>:
		       </td>
			   <td >
		             <s:textfield label="%{@vs@ALIAS_SIGN_FL_NAME}" size="40" key="signFlName" value="%{model.signFlName}" cssClass="" required="false" maxlength="30" />
		       </td>
        </tr>
