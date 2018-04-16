<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*"%>
<html>
<head>
	<%@include file="../../base_pages/base.jsp"%>
	<script src="<c:url value="/js/teletext.js"/>" type="text/javascript"></script>
</head>
<body class="claro" >
<fieldset style="margin: 10px 0;padding: 10px;border: #DDD 1px solid" >
	<legend><%=GdRcfLs.TABLE_ALIAS%>编辑</legend>
	<mvc:form action="update.do" theme="simple"  method="post" data-dojo-type="dijit.form.Form" id="form1">
		<script type="dojo/on" data-dojo-event="submit">
				if(this.validate()){
					if(check()){	
					return confirm("确定保存？");
					}else{
					return false;
					}
					}else{
						return false;
					}
			</script>
			<script type="text/javascript">
			    var onsbmt = true;
				function check(){
					//var cvValue=dojo.byId("cvValue").value;
					//if(cvValue==""){
					//	dojo.byId("cvValue").innerHTML="请输入卡bin取值";
					//	dojo.byId("cvValue").innerHTML="";
					//	return false;
					//}
					return onsbmt;
				}
			</script>
			<table class="grid">
			     <%@ include file="form_include.jsp" %>
			</table>
			<table class="b">
				<tr  align="center">
					<td><input id="submitButton" name="submitButton" type="submit"  value="保存" /></td>
					<td><input type="button" value="返回" onclick="window.location='list.do'"/></td>
				</tr>
			</table>
	</mvc:form>
</fieldset>	
</body>
</html>
