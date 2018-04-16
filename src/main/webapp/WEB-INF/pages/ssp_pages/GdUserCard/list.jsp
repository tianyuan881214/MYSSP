<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*"%>
<html>
<head>
   <title><%=GdUserCard.TABLE_ALIAS%></title>
	<%@include file="../../base_pages/base.jsp"%>
	<script src="<c:url value="/js/teletext.js"/>" type="text/javascript"></script>
</head>
<body class="claro" >
    <div id="dqwz">
		<p>
			当前位置：业务管理&nbsp;〉&nbsp;<%=GdUserCard.TABLE_ALIAS%>管理
		</p>
		<p class="line"></p>
	</div>
 
  <mvc:form id="queryForm" name="queryForm" action="list.do"
		method="post" style="display: inline;">

	<div id="content">
		<div class="biaoti">
			<p>
				<b><%=GdUserCard.TABLE_ALIAS%>查询</b>
			</p>
		</div>
		<div class="biao">
	     <table class="grid">
				 <tr>	
					<td class="lgridlist">
							<%=GdUserCard.ALIAS_CARD_NO%>
					</td>		
					<td>
						<input type="text" value="${query.cardNo}"  name="cardNo"  />
					</td>
					<td class="lgridlist">
							<%=GdUserCard.ALIAS_PHONE_NO%>
					</td>		
					<td>
						<input type="text" value="${query.phoneNo}"  name="phoneNo"  />
					</td>
				</tr>	
				 <tr>	
					<td class="lgridlist">
							<%=GdUserCard.ALIAS_USER_NAME%>
					</td>		
					<td>
						<input type="text" value="${query.userName}"  name="userName"  />
					</td>
					 <td>&nbsp;&nbsp;</td>
					 <td>&nbsp;&nbsp;</td>
				</tr>	
	     </table>
	     <table class="b">
			<tr align="center">
				<td width="200px"></td>
				<td><input type="submit" style="width: 80px" value="查询"
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
		                <th><%=GdUserCard.ALIAS_CARD_NO%></th>
		                <th><%=GdUserCard.ALIAS_PHONE_NO%></th>
		                <th><%=GdUserCard.ALIAS_USER_NAME%></th>
				 </tr>
			  </thead>
			  <tbody>
			    <c:if test="${page.totalCount == 0}">
					<tr class="even">
						<td align="center">没有数据</td>
			                <td align="center">&nbsp;</td>
			                <td align="center">&nbsp;</td>
			                <td align="center">&nbsp;</td>
					</tr>
				</c:if>
				<c:forEach items="${page.result}" var="item" varStatus="status">
					<tr class="${status.count % 2 == 0 ? 'odd' : 'even'}">
						<td align="center">
						<%-- &nbsp;|&nbsp; <a href="edit.do?id=${item.cardNo}">编辑>></a> --%>
							&nbsp;|&nbsp; <a href="show.do?id=${item.cardNo}">查看>></a>
						</td>
						   <td><c:out value='${item.cardNo}' />&nbsp;</td>
						   <td><c:out value='${item.phoneNo}' />&nbsp;</td>
						   <td><c:out value='${item.userName}' />&nbsp;</td>
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
