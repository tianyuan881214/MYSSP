<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*"%>
<html>
<head>
	<%@include file="../../base_pages/base.jsp"%>
	<script src="<c:url value="/js/teletext.js"/>" type="text/javascript"></script>
</head>
<body class="claro" >
<fieldset style="margin: 10px 0; padding: 10px; border: #DDD 1px solid">
		<legend><%=GdCardPhoneBind.TABLE_ALIAS%>查看
		</legend>
		<mvc:form action="save.do" theme="simple" method="post" id="form1"
			data-dojo-type="dijit.form.Form">
			<table class="grid">
	               <input type="hidden" name="smartCard" id="smartCard" value="%{model.smartCard}"/>
	               <input type="hidden" name="bankCard" id="bankCard" value="%{model.bankCard}"/>
	    <tr>
			<td class="lgridlist"><%=GdCardPhoneBind.ALIAS_SMART_CARD%></td>	
			<td><span>${model.smartCard}</span></td>
        
	    
			<td class="lgridlist"><%=GdCardPhoneBind.ALIAS_BANK_CARD%></td>	
			<td><span>${model.bankCard}</span></td>
        </tr>
	    <tr>
			<td class="lgridlist"><%=GdCardPhoneBind.ALIAS_PHONE_NO%></td>	
			<td><span>${model.phoneNo}</span></td>
        
	    
			<td class="lgridlist"><%=GdCardPhoneBind.ALIAS_PHONE_CODE%></td>	
			<td><span>${model.phoneCode}</span></td>
        </tr>
	    <tr>
			<td class="lgridlist"><%=GdCardPhoneBind.ALIAS_USER_NAME%></td>	
			<td><span>${model.userName}</span></td>
        
	    
			<td class="lgridlist"><%=GdCardPhoneBind.ALIAS_VALIDATE_FLAG%></td>	
			<td><span>${model.validateFlag}</span></td>
        </tr>
	    <tr>
			<td class="lgridlist"><%=GdCardPhoneBind.ALIAS_STATU_FLAG%></td>	
			<td><span>${model.statuFlag}</span></td>
        
	    
			<td class="lgridlist"><%=GdCardPhoneBind.ALIAS_SIGN_DATE%></td>	
			<td><span>${model.signDate}</span></td>
        </tr>
	    <tr>
			<td class="lgridlist"><%=GdCardPhoneBind.ALIAS_SIGN_TIME%></td>	
			<td><span>${model.signTime}</span></td>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
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

