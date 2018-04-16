<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*"%>
<html>
<head>
	<%@include file="../../base_pages/base.jsp"%>
	<script src="<c:url value="/js/teletext.js"/>" type="text/javascript"></script>
</head>
<body class="claro" >
<fieldset style="margin: 10px 0; padding: 10px; border: #DDD 1px solid">
		<legend><%=GdUserCard.TABLE_ALIAS%>查看
		</legend>
		<mvc:form action="save.do" theme="simple" method="post" id="form1"
			data-dojo-type="dijit.form.Form">
			<table class="grid">
	               <input type="hidden" name="cardNo" id="cardNo" value="%{model.cardNo}"/>
	               <input type="hidden" name="phoneNo" id="phoneNo" value="%{model.phoneNo}"/>
	    <tr>
			<td class="lgridlist"><%=GdUserCard.ALIAS_CARD_NO%></td>	
			<td><span>${model.cardNo}</span></td>
        
	    
			<td class="lgridlist"><%=GdUserCard.ALIAS_PHONE_NO%></td>	
			<td><span>${model.phoneNo}</span></td>
        </tr>
	    <tr>
			<td class="lgridlist"><%=GdUserCard.ALIAS_USER_NAME%></td>	
			<td><span>${model.userName}</span></td>
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

