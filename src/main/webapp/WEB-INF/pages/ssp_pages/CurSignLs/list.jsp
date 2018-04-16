<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*"%>
<html>
<head>
   <title><%=CurSignLs.TABLE_ALIAS%></title>
	<%@include file="../../base_pages/base.jsp"%>
	<script src="<c:url value="/js/teletext.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/js/jquery-1.4.1.js"/>" type="text/javascript"></script>
	<!--  <script src="http://code.jquery.com/jquery-1.4.1.js"></script> --> 
</head>

<body class="claro" >

<script type="text/javascript">
	function getPic(tranId)
	{
		$("#picbg").show();
		$("#alert").show();
		$("#imaPic").attr("src", "${ctx}/cursignls/getTicket.do?tranId=" + tranId);
		
		//alert("OK!!!!!!!"+"${ctx}/cursignls/getTicket.do?tranId=" + tranId);
		//var merch	antId=document.getElementsByName("merchantId")[0].value;
	}
	function hidDiv()
	{
		$("#picbg").hide();
		$("#alert").hide();
	}
	function printTicket()
	{
		if (confirm('确定[打印]小票?'))
		{
			window.document.body.innerHTML = document.getElementById("picprint").innerHTML;
			window.print();
			window.document.body.innerHTML = bdhtml;
		} else
		{
			window.print();
		}
	}
</script>
<div id="picbg" onclick="hidDiv()" 
	style="display: none; position: absolute; height: 240%; background: #000; width: 100%; top: 0; left: 0; filter: alpha(opacity = 50); opacity: 0.50;">
</div>

<div id="alert"
	style="display: none; position: absolute; top: 50%; left: 50%; margin-left: -100px; margin-top: -370px;">
	<div id="picprint">
		<img src="" id="imaPic" />
	</div>
	<div>
		<input type="button" value="打印" onclick="printTicket()">
	</div>
</div>

    <div id="dqwz">
		<p>
			当前位置：业务管理&nbsp;〉&nbsp;<%=CurSignLs.TABLE_ALIAS%>管理
		</p>
		<p class="line"></p>
	</div>
 
  <mvc:form id="queryForm" name="queryForm" action="list.do"
		method="post" style="display: inline;">

	<div id="content">
		<div class="biaoti">
			<p>
				<b><%=CurSignLs.TABLE_ALIAS%>查询</b>
			</p>
		</div>
		<div class="biao">
		
		<table class="grid">
				<tr>
					<td class="tb_title" colspan="4"><%=CurSignLs.TABLE_ALIAS%>查询</td>
				</tr>
				
				<tr>
					<td class="lgridlist"><%=CurSignLs.ALIAS_MERCHANT_ID%></td>
					<td><input type="text"  value="${query.merchantId}" name="merchantId"
						name="s_merchantId" maxlength="15" class="" /> <input
						type="hidden" name="getAll" value="yes"></td>
					<td class="lgridlist"><%=CurSignLs.ALIAS_TERMINAL_ID%></td>
					<td><input type="text"  value="${query.terminalId}" name="terminalId"
						name="s_terminalId" maxlength="8" class="" /></td>
				</tr>
				<tr>
					<td class="lgridlist"><%=CurSignLs.ALIAS_CARD_NO%></td>
					<td><input type="text"  value="${query.cardNo}" name="cardNo" name="s_cardNo"
						maxlength="19" class="" /></td>
					<td class="lgridlist"><%=CurSignLs.ALIAS_TRAN_AMT%></td>
					<td><input  type="text" value="${query.tranAmt}" name="tranAmt"
						name="s_tranAmt" maxlength="30" class="validate-integer " /></td>
				</tr>
				<tr>
					<td class="lgridlist"><%=CurSignLs.ALIAS_TRACE_NO%></td>
					<td><input  type="text" value="${query.traceNo}" name="traceNo"
						name="s_traceNo" maxlength="6" class="" /></td>
					<td class="lgridlist"><%=CurSignLs.ALIAS_TRAN_RRN%></td>
					<td><input type="text"  value="${query.tranRrn}" name="tranRrn"
						name="s_tranRrn" maxlength="12" class="" /></td>
				</tr>
				<tr>
					<td class="lgridlist"><%=CurSignLs.ALIAS_BATCH_NO%></td>
					<td><input  type="text" value="${query.batchNo}" name="batchNo"
						name="s_batchNo" maxlength="6" class="" /></td>
					<td class="lgridlist"></td>
					<td></td>
				</tr>
				<tr>
					<td class="lgridlist"><%=CurSignLs.ALIAS_START_TIME%></td>
					<td>
						<input  type="text" id="startDate" name="startDate" value="${query.startDate}"  
								   class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyyMMddHHmmss'})" />
					</td>
					
					<td class="lgridlist"><%=CurSignLs.ALIAS_END_TIME%></td>
					<td>
						<input  type="text" id="endDate" name="endDate" value="${query.endDate}"  
								   class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyyMMddHHmmss'})" />
					</td>
					
				</tr>
			</table>
	     
	     <table class="b">
			<tr align="center">
				<td width="200px"></td>
				<td colspan="2"><input type="submit" style="width: 80px" value="查询"
					onclick="getReferenceForm(this).action='list.do'" /></td>
				<td colspan="2"> <input type="button" style="width: 80px" value="返回"
						onclick="window.location='list.do'"/></td>
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
		                <th><%=CurSignLs.ALIAS_CARD_NO%></th>
						<th><%=CurSignLs.ALIAS_TRAN_AMT%></th>
						<th><%=CurSignLs.ALIAS_TERMINAL_ID%></th>
						<th><%=CurSignLs.ALIAS_MERCHANT_ID%></th>
						<th><%=CurSignLs.ALIAS_TRACE_NO%></th>
						<th><%=CurSignLs.ALIAS_TRAN_RRN%></th>
						<th><%=CurSignLs.ALIAS_BATCH_NO%></th>
						<th><%=CurSignLs.ALIAS_LOCAL_SYS_DATE%></th>
						<th><%=CurSignLs.ALIAS_LOCAL_SYS_TIME%></th>
						<th><%=CurSignLs.ALIAS_SETTLE_DATE%></th>
				 </tr>
			  </thead>
			  <tbody>
			    <c:if test="${page.totalCount == 0}">
					<tr class="even">
						<td>没有数据</td>
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
							<td align="center"><a
								href="${ctx}/cursignls/show.do?id=${item.lsId}&<mytag:params includes="s_*" type="queryStringUtf"/>">查看>></a>
								&nbsp;|&nbsp;<a href="#"
								onclick="getPic('${item.lsId}');return false;">查看小票>></a></td>
							<td align="center"><c:out value='${item.cardNo}' />&nbsp;</td>
							<td align="center"><c:out value='${item.tranAmt}' />&nbsp;</td>
							<td align="center"><c:out value='${item.terminalId}' />&nbsp;</td>
							<td align="center"><c:out value='${item.merchantId}' />&nbsp;</td>
							<td align="center"><c:out value='${item.traceNo}' />&nbsp;</td>
							<td align="center"><c:out value='${item.tranRrn}' />&nbsp;</td>
							<td align="center"><c:out value='${item.batchNo}' />&nbsp;</td>
							<td align="center"><c:out value='${item.localSysDate}' />&nbsp;</td>
							<td align="center"><c:out value='${item.localSysTime}' />&nbsp;</td>
							<td align="center"><c:out value='${item.settleDate}' />&nbsp;</td>
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
	

<script>
	function goList()
	{
		var form = document.forms.repl;
		if (!form)
			return;
		form.action = '${ctx}/pages/CurSignLs/list.do';
		form.submit();
	}

	function doDel()
	{
		return confirm('确定执行[删除]操作?');
	}

	var minTxt, maxTxt;
	minTxt = document.getElementById("s_inTime_start");
	maxTxt = document.getElementById("s_inTime_end");
</script>
</body>

</html>
