<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*"%>
<html>
<head>
   <title><%=GdRcfLs.TABLE_ALIAS%></title>
	<%@include file="../../base_pages/base.jsp"%>
	<script src="<c:url value="/js/teletext.js"/>" type="text/javascript"></script>
</head>
<body class="claro" >
    <div id="dqwz">
		<p>
			当前位置：业务管理&nbsp;〉&nbsp;<%=GdRcfLs.TABLE_ALIAS%>管理
		</p>
		<p class="line"></p>
	</div>
 
  <mvc:form id="queryForm" name="queryForm" action="list.do"
		method="post" style="display: inline;">

	<div id="content">
		<div class="biaoti">
			<p>
				<b><%=GdRcfLs.TABLE_ALIAS%>查询</b>
			</p>
		</div>
		<div class="biao">
	     <table class="grid">
				 <tr>	
					<td class="lgridlist">
							<%=GdRcfLs.ALIAS_SYSTEM_CODE%>
					</td>		
					<td>
						<input type="text" value="${query.systemCode}"  name="systemCode"  />
					</td>
				</tr>	
				 <tr>	
					<td class="lgridlist">
							<%=GdRcfLs.ALIAS_FUCTION_CODE%>
					</td>		
					<td>
						<input type="text" value="${query.fuctionCode}"  name="fuctionCode"  />
					</td>
					<td class="lgridlist">
							<%=GdRcfLs.ALIAS_TRACE_NO%>
					</td>		
					<td>
						<input type="text" value="${query.traceNo}"  name="traceNo"  />
					</td>
				</tr>	
				 <tr>	
					<td class="lgridlist">
							<%=GdRcfLs.ALIAS_CARD_NO%>
					</td>		
					<td>
						<input type="text" value="${query.cardNo}"  name="cardNo"  />
					</td>
					<td class="lgridlist">
							<%=GdRcfLs.ALIAS_SMART_CARD%>
					</td>		
					<td>
						<input type="text" value="${query.smartCard}"  name="smartCard"  />
					</td>
				</tr>	
				 <tr>	
					<td class="lgridlist">
							<%=GdRcfLs.ALIAS_AMOUNT%>
					</td>		
					<td>
						<input type="text" value="${query.amount}"  name="amount"  />
					</td>
					<td class="lgridlist">
							<%=GdRcfLs.ALIAS_SYS_DATE%>
					</td>		
					<td>
						<input id="sysDate" name="sysDate" value="${query.sysDate}"  
								   class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyyMMddHHmmss'})" />
					</td>
				</tr>	
				 <tr>	
					<td class="lgridlist">
							<%=GdRcfLs.ALIAS_SYS_TIME%>
					</td>		
					<td>
						<input type="text" value="${query.sysTime}"  name="sysTime"  />
					</td>
					<td class="lgridlist">
							<%=GdRcfLs.ALIAS_RESP_CODE%>
					</td>		
					<td>
						<input type="text" value="${query.respCode}"  name="respCode"  />
					</td>
				</tr>	
				 <tr>	
					<td class="lgridlist">
							<%=GdRcfLs.ALIAS_RESP_MSG%>
					</td>		
					<td>
						<input type="text" value="${query.respMsg}"  name="respMsg"  />
					</td>
					<td class="lgridlist">
							<%=GdRcfLs.ALIAS_CSP_RESP_CODE%>
					</td>		
					<td>
						<input type="text" value="${query.cspRespCode}"  name="cspRespCode"  />
					</td>
				</tr>	
				 <tr>	
					<td class="lgridlist">
							<%=GdRcfLs.ALIAS_CSP_RESP_MSG%>
					</td>		
					<td>
						<input type="text" value="${query.cspRespMsg}"  name="cspRespMsg"  />
					</td>
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
		                <th><%=GdRcfLs.ALIAS_SYSTEM_CODE%></th>
		                <th><%=GdRcfLs.ALIAS_FUCTION_CODE%></th>
		                <th><%=GdRcfLs.ALIAS_TRACE_NO%></th>
		                <th><%=GdRcfLs.ALIAS_CARD_NO%></th>
		                <th><%=GdRcfLs.ALIAS_SMART_CARD%></th>
		                <th><%=GdRcfLs.ALIAS_AMOUNT%></th>
		                <th><%=GdRcfLs.ALIAS_SYS_DATE%></th>
		                <th><%=GdRcfLs.ALIAS_SYS_TIME%></th>
		                <th><%=GdRcfLs.ALIAS_RESP_CODE%></th>
		                <th><%=GdRcfLs.ALIAS_RESP_MSG%></th>
		                <th><%=GdRcfLs.ALIAS_CSP_RESP_CODE%></th>
		                <th><%=GdRcfLs.ALIAS_CSP_RESP_MSG%></th>
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
			                <td align="center">&nbsp;</td>
			                <td align="center">&nbsp;</td>
			                <td align="center">&nbsp;</td>
					</tr>
				</c:if>
				<c:forEach items="${page.result}" var="item" varStatus="status">
					<tr class="${status.count % 2 == 0 ? 'odd' : 'even'}">
						<td align="center">
						<%-- &nbsp;|&nbsp; <a href="edit.do?id=${item.tranType}">编辑>></a> --%>
							&nbsp;|&nbsp; <a href="show.do?id=${item.tranType}">查看>></a>
						</td>
						   <td><c:out value='${item.systemCode}' />&nbsp;</td>
						   <td><c:out value='${item.fuctionCode}' />&nbsp;</td>
						   <td><c:out value='${item.traceNo}' />&nbsp;</td>
						   <td><c:out value='${item.cardNo}' />&nbsp;</td>
						   <td><c:out value='${item.smartCard}' />&nbsp;</td>
						   <td><c:out value='${item.amount}' />&nbsp;</td>
						   <td><c:out value='${item.sysDate}' />&nbsp;</td>
						   <td><c:out value='${item.sysTime}' />&nbsp;</td>
						   <td><c:out value='${item.respCode}' />&nbsp;</td>
						   <td><c:out value='${item.respMsg}' />&nbsp;</td>
						   <td><c:out value='${item.cspRespCode}' />&nbsp;</td>
						   <td><c:out value='${item.cspRespMsg}' />&nbsp;</td>
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
