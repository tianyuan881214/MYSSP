<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*"%>
<html>
<head>
	<%@include file="../../base_pages/base.jsp"%>
	<script src="<c:url value="/js/teletext.js"/>" type="text/javascript"></script>
</head>
<body class="claro" >
<fieldset style="margin: 10px 0; padding: 10px; border: #DDD 1px solid">
		<mvc:form action="save.do" theme="simple" method="post" id="form1"
			data-dojo-type="dijit.form.Form">
<table class="grid">
	               <input type="hidden" name="tranType" id="tranType" value="%{model.tranType}"/>
	    <tr>
				  <td colspan="4" class="tb_title"> 
							<%=BusinessBase.TABLE_ALIAS%>信息
				  </td>
		</tr>
	    <tr>
			<td class="lgridlist"><%=BusinessBase.BUSINESS_NAME%></td>
			<td><span>${model.businessName}</span></td>
        </tr>
	    <tr>
			<td class="lgridlist"><%=BusinessBase.BUSINESS_SM%></td>	
			<td><span>${model.businessSm}</span></td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
        </tr>
	    </table>
	    <table class="b">
				<tr align="center">
					<td><input type="button" value="返回"
						onclick="javascript:history.back()"/></td>
				</tr>
			</table>
		</mvc:form>
	</fieldset>
</body>
</html>

