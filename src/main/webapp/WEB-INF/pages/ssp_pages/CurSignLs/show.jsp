<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*"%>
<html>
<head>
	<%@include file="../../base_pages/base.jsp"%>
	<script src="<c:url value="/js/teletext.js"/>" type="text/javascript"></script>
</head>
<body class="claro" >
<fieldset style="margin: 10px 0; padding: 10px; border: #DDD 1px solid">
		<legend><%=GdRcfLs.TABLE_ALIAS%>查看
		</legend>
		<mvc:form action="save.do" theme="simple" method="post" id="form1"
			data-dojo-type="dijit.form.Form">
			<table class="grid">
	               <input type="hidden" name="tranType" id="tranType" value="%{model.tranType}"/>

			<tr>
				<td class="lgridlist"><%=CurSignLs.ALIAS_CARD_NO%></td>
				<td><span>${model.cardNo} <span/></td>

				<td class="lgridlist"><%=CurSignLs.ALIAS_TRAN_AMT%></td>
				<td><span>${model.tranAmt} <span/></td>
			</tr>
			<tr>
				<td class="lgridlist"><%=CurSignLs.ALIAS_TERMINAL_ID%></td>
				<td><span>${model.terminalId} <span/></td>


				<td class="lgridlist"><%=CurSignLs.ALIAS_MERCHANT_ID%></td>
				<td><span>${model.merchantId} <span/></td>
			</tr>
			<tr>
				<td class="lgridlist"><%=CurSignLs.ALIAS_TRACE_NO%></td>
				<td><span>${model.traceNo} <span/></td>


				<td class="lgridlist"><%=CurSignLs.ALIAS_TRAN_RRN%></td>
				<td><span>${model.tranRrn} <span/></td>
			</tr>
			<tr>
				<td class="lgridlist"><%=CurSignLs.ALIAS_BATCH_NO%></td>
				<td><span>${model.batchNo} <span/></td>


				<td class="lgridlist"><%=CurSignLs.ALIAS_LOCAL_SYS_DATE%></td>
				<td><span>${model.localSysDate} <span/></td>
			</tr>
			<tr>
				<td class="lgridlist"><%=CurSignLs.ALIAS_LOCAL_SYS_TIME%></td>
				<td><span>${model.localSysTime} <span/></td>


				<td class="lgridlist"><%=CurSignLs.ALIAS_SETTLE_DATE%></td>
				<td><span>${model.settleDate} <span/></td>
			</tr>
			<tr>
				<td class="lgridlist"><%=CurSignLs.ALIAS_TICKET_FL_NAME%></td>
				<td><span>${model.ticketFlName} <span/></td>


				<td class="lgridlist"><%=CurSignLs.ALIAS_SIGN_FL_NAME%></td>
				<td><span>${model.signFlName} <span/></td>
			</tr>
			</table>
			<table class="b">
				<tr align="center">
					<td><input type="button" value="返回"
						onclick="window.location='list.do'"/></td>
				</tr>
			</table>
		</mvc:form>
	</fieldset>
</body>
</html>

