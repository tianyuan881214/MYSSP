<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*"%>
<html>
<head>
   <title><%=GdCardPhoneBind.TABLE_ALIAS%></title>
	<%@include file="../../base_pages/base.jsp"%>
	<script src="<c:url value="/js/teletext.js"/>" type="text/javascript"></script>
</head>
<body class="claro" >
    <div id="dqwz">
		<p>
			当前位置：业务管理&nbsp;〉&nbsp;<%=GdCardPhoneBind.TABLE_ALIAS%>管理
		</p>
		<p class="line"></p>
	</div>
 
  <mvc:form id="queryForm" name="queryForm" action="list.do"
		method="post" style="display: inline;">

	<div id="content">
		<div class="biaoti">
			<p>
				<b><%=GdCardPhoneBind.TABLE_ALIAS%>查询</b>
			</p>
		</div>
		<div class="biao">
	     <table class="grid">
				 <tr>	
					<td class="lgridlist">
							<%=GdCardPhoneBind.ALIAS_SMART_CARD%>
					</td>		
					<td>
						<input type="text" value="${query.smartCard}"  name="smartCard"  />
					</td>
					<td class="lgridlist">
							<%=GdCardPhoneBind.ALIAS_BANK_CARD%>
					</td>		
					<td>
						<input type="text" value="${query.bankCard}"  name="bankCard"  />
					</td>
				</tr>	
				 <tr>	
					<td class="lgridlist">
							<%=GdCardPhoneBind.ALIAS_PHONE_NO%>
					</td>		
					<td>
						<input type="text" value="${query.phoneNo}"  name="phoneNo"  />
					</td>
					<td class="lgridlist">
							<%=GdCardPhoneBind.ALIAS_PHONE_CODE%>
					</td>		
					<td>
						<input type="text" value="${query.phoneCode}"  name="phoneCode"  />
					</td>
				</tr>	
				 <tr>	
					<td class="lgridlist">
							<%=GdCardPhoneBind.ALIAS_USER_NAME%>
					</td>		
					<td>
						<input type="text" value="${query.userName}"  name="userName"  />
					</td>
					<td class="lgridlist">
							<%=GdCardPhoneBind.ALIAS_VALIDATE_FLAG%>
					</td>		
					<td>
						<input type="text" value="${query.validateFlag}"  name="validateFlag"  />
					</td>
				</tr>	
				 <tr>	
					<td class="lgridlist">
							<%=GdCardPhoneBind.ALIAS_STATU_FLAG%>
					</td>		
					<td>
						<input type="text" value="${query.statuFlag}"  name="statuFlag"  />
					</td>
					<td class="lgridlist">
							<%=GdCardPhoneBind.ALIAS_SIGN_DATE%>
					</td>		
					<td>
						<input id="signDate" name="signDate" value="${query.signDate}"  
								   class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyyMMddHHmmss'})" />
					</td>
				</tr>	
				 <tr>	
					<td class="lgridlist">
							<%=GdCardPhoneBind.ALIAS_SIGN_TIME%>
					</td>		
					<td>
						<input type="text" value="${query.signTime}"  name="signTime"  />
					</td>
				</tr>	
	     </table>
	     <table class="b">
			<tr align="center">
				<td width="200px"></td>
				<td colspan="2"><input type="submit" style="width: 80px" value="查询"
					onclick="getReferenceForm(this).action='list.do'" /></td>
				<!-- <td><input type="button" style="width: 80px" value="新增"
					onclick="window.location.href='insert.do'" /></td> -->
			</tr>
		 </table>
      </div>
      <div class="form">
		 <div id="eXtremeTable" class="eXtremeTable">
			<table class="grid its">
			 <thead>
			   <tr>
				 <th>操作</th>
		                <th><%=GdCardPhoneBind.ALIAS_SMART_CARD%></th>
		                <th><%=GdCardPhoneBind.ALIAS_BANK_CARD%></th>
		                <th><%=GdCardPhoneBind.ALIAS_PHONE_NO%></th>
		                <th><%=GdCardPhoneBind.ALIAS_PHONE_CODE%></th>
		                <th><%=GdCardPhoneBind.ALIAS_USER_NAME%></th>
		                <th><%=GdCardPhoneBind.ALIAS_VALIDATE_FLAG%></th>
		                <th><%=GdCardPhoneBind.ALIAS_STATU_FLAG%></th>
		                <th><%=GdCardPhoneBind.ALIAS_SIGN_DATE%></th>
		                <th><%=GdCardPhoneBind.ALIAS_SIGN_TIME%></th>
				 </tr>
			  </thead>
			  <tbody>
			    <c:if test="${page.totalCount == 0}">
					<tr class="even">
						<td align="center">没有数据</td>
			                <td align="center">&nbsp;</td>
			                <td align="center">&nbsp;</td>
			                <td align="center">&nbsp;</td>
			                <td align="center">&nbsp;</td>
			                <td align="center">&nbsp;</td>
			                <td align="center">&nbsp;</td>
			                <td align="center">&nbsp;</td>
			                <td align="center">&nbsp;</td>
			                <td align="center">&nbsp;</td>
					</tr>
				</c:if>
				<c:forEach items="${page.result}" var="item" varStatus="status">
					<tr class="${status.count % 2 == 0 ? 'odd' : 'even'}">
						<td align="center">
						 <%--  &nbsp;|&nbsp; <a href="edit.do?id=${item.smartCard}">编辑>></a> --%>
							&nbsp;|&nbsp; <a href="show.do?id=${item.smartCard}">查看>></a>
						</td>
						   <td><c:out value='${item.smartCard}' />&nbsp;</td>
						   <td><c:out value='${item.bankCard}' />&nbsp;</td>
						   <td><c:out value='${item.phoneNo}' />&nbsp;</td>
						   <td><c:out value='${item.phoneCode}' />&nbsp;</td>
						   <td><c:out value='${item.userName}' />&nbsp;</td>
						   <td><c:out value='${item.validateFlag}' />&nbsp;</td>
						   <td><c:out value='${item.statuFlag}' />&nbsp;</td>
						   <td><c:out value='${item.signDate}' />&nbsp;</td>
						   <td><c:out value='${item.signTime}' />&nbsp;</td>
			         </tr>
				</c:forEach>
			  </tbody>
             </table>
				</div>
			</div>
			<simpletable:pageToolbar page="${page}">
			</simpletable:pageToolbar>
		</div>
	</mvc:form>
</body>
</html>
