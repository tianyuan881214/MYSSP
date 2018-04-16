<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<base href="<%=basePath%>">
	<title><%=CurSignLs.TABLE_ALIAS%>编辑</title>
</head>

<body onload="quickSelectInit()" >

<s:form action="/pages/CurSignLs/update.do"  theme="simple"  method="post">
    <input type="hidden" name="returnUrl" value="!/pages/CurSignLs/list.do?<mytag:params includes="s_*" type="queryStringUtf"/>" />
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	        <tr>
				      <td colspan="4" class="tb_title"> 
							<%=CurSignLs.TABLE_ALIAS%>编辑
				     </td>
		    </tr>
	               <%@ include file="form_include.jsp" %>
	        <tr >
					 <td colspan="4" class="tb_bottom">
	                        <input id="submitButton" name="submitButton" type="submit" value="保存" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/CurSignLs/list.do?<mytag:params includes="s_*" type="queryStringUtf"/>'"/>
					 </td>
			</tr>
	</table>
</s:form>

<script>
	
	new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
		var finalResult = result;
		
		//在这里添加自定义验证
		
		return disableSubmit(finalResult,'submitButton');
	}});
</script>

</body>

</html>