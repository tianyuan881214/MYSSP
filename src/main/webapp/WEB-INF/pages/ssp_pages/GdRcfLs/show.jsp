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
			<td class="lgridlist"><%=GdRcfLs.ALIAS_SYSTEM_CODE%></td>	
			<td><span>${model.systemCode}</span></td>
        
	    
			<td class="lgridlist"><%=GdRcfLs.ALIAS_FUCTION_CODE%></td>	
			<td><span>${model.fuctionCode}</span></td>
        </tr>
	    <tr>
			<td class="lgridlist"><%=GdRcfLs.ALIAS_TRACE_NO%></td>	
			<td><span>${model.traceNo}</span></td>
        
	    
			<td class="lgridlist"><%=GdRcfLs.ALIAS_CARD_NO%></td>	
			<td><span>${model.cardNo}</span></td>
        </tr>
	    <tr>
			<td class="lgridlist"><%=GdRcfLs.ALIAS_SMART_CARD%></td>	
			<td><span>${model.smartCard}</span></td>
        
	    
			<td class="lgridlist"><%=GdRcfLs.ALIAS_AMOUNT%></td>	
			<td><span>${model.amount}</span></td>
        </tr>
	    <tr>
			<td class="lgridlist"><%=GdRcfLs.ALIAS_SYS_DATE%></td>	
			<td><span>${model.sysDate}</span></td>
        
	    
			<td class="lgridlist"><%=GdRcfLs.ALIAS_SYS_TIME%></td>	
			<td><span>${model.sysTime}</span></td>
        </tr>
	    <tr>
			<td class="lgridlist"><%=GdRcfLs.ALIAS_RESP_CODE%></td>	
			<td><span>${model.respCode}</span></td>
        
	    
			<td class="lgridlist"><%=GdRcfLs.ALIAS_RESP_MSG%></td>	
			<td><span>${model.respMsg}</span></td>
        </tr>
	    <tr>
			<td class="lgridlist"><%=GdRcfLs.ALIAS_CSP_RESP_CODE%></td>	
			<td><span>${model.cspRespCode}</span></td>
        
	    
			<td class="lgridlist"><%=GdRcfLs.ALIAS_CSP_RESP_MSG%></td>	
			<td><span>${model.cspRespMsg}</span></td>
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

