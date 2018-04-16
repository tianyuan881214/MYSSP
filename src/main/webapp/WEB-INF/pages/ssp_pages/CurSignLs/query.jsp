<%@page import="com.yada.ssp.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<base href="<%=basePath%>">
	<title><%=CurSignLs.TABLE_ALIAS%>查询</title>
</head>

<body onload="quickSelectInit()" >

<s:form action="/pages/CurSignLs/list.do" method="post">
	<input type="submit" value="提交" onclick="return new Validation(document.forms[0]).validate();"/>
	<input type="button" value="返回列表" onclick="window.location='${ctx}/pages/CurSignLs/list.do'"/>
	<input type="button" value="后退" onclick="history.back();"/>
	
	<table class="formTable">
	
		<tr bgcolor="#FFFFFF">
		   <td class="tdLabel"><%=CurSignLs.ALIAS_CARD_NO%></td>
		   <td>
				<input  type="text" name="s_cardNo" size="30" maxlength="19" class=""/>
		   </td>
		</tr>
		<tr bgcolor="#FFFFFF">
		   <td class="tdLabel"><%=CurSignLs.ALIAS_TRAN_AMT%></td>
		   <td>
				<input  type="text" name="s_tranAmt" size="30" maxlength="30" class="validate-integer "/>
		   </td>
		</tr>
		<tr bgcolor="#FFFFFF">
		   <td class="tdLabel"><%=CurSignLs.ALIAS_TERMINAL_ID%></td>
		   <td>
				<input  type="text" name="s_terminalId" size="30" maxlength="8" class=""/>
		   </td>
		</tr>
		<tr bgcolor="#FFFFFF">
		   <td class="tdLabel"><%=CurSignLs.ALIAS_MERCHANT_ID%></td>
		   <td>
				<input  type="text" name="s_merchantId" size="30" maxlength="15" class=""/>
		   </td>
		</tr>
		<tr bgcolor="#FFFFFF">
		   <td class="tdLabel"><%=CurSignLs.ALIAS_TRACE_NO%></td>
		   <td>
				<input  type="text" name="s_traceNo" size="30" maxlength="6" class=""/>
		   </td>
		</tr>
		<tr bgcolor="#FFFFFF">
		   <td class="tdLabel"><%=CurSignLs.ALIAS_TRAN_RRN%></td>
		   <td>
				<input  type="text" name="s_tranRrn" size="30" maxlength="12" class=""/>
		   </td>
		</tr>
		<tr bgcolor="#FFFFFF">
		   <td class="tdLabel"><%=CurSignLs.ALIAS_BATCH_NO%></td>
		   <td>
				<input  type="text" name="s_batchNo" size="30" maxlength="6" class=""/>
		   </td>
		</tr>
		<tr bgcolor="#FFFFFF">
		   <td class="tdLabel"><%=CurSignLs.ALIAS_LOCAL_SYS_DATE%></td>
		   <td>
				<input  type="text" name="s_localSysDate" size="30" maxlength="8" class=""/>
		   </td>
		</tr>
		<tr bgcolor="#FFFFFF">
		   <td class="tdLabel"><%=CurSignLs.ALIAS_LOCAL_SYS_TIME%></td>
		   <td>
				<input  type="text" name="s_localSysTime" size="30" maxlength="6" class=""/>
		   </td>
		</tr>
		<tr bgcolor="#FFFFFF">
		   <td class="tdLabel"><%=CurSignLs.ALIAS_SETTLE_DATE%></td>
		   <td>
				<input  type="text" name="s_settleDate" size="30" maxlength="4" class=""/>
		   </td>
		</tr>
		<tr bgcolor="#FFFFFF">
		   <td class="tdLabel"><%=CurSignLs.ALIAS_TICKET_FL_NAME%></td>
		   <td>
				<input  type="text" name="s_ticketFlName" size="30" maxlength="30" class=""/>
		   </td>
		</tr>
		<tr bgcolor="#FFFFFF">
		   <td class="tdLabel"><%=CurSignLs.ALIAS_SIGN_FL_NAME%></td>
		   <td>
				<input  type="text" name="s_signFlName" size="30" maxlength="30" class=""/>
		   </td>
		</tr>
	
	</table>
</s:form>	
			
</body>

</html>