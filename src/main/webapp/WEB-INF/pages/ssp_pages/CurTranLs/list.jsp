<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*" %>
<html>
<head>
    <title>银联卡流水
    </title>
    <%@include file="../../base_pages/base.jsp" %>
    <script src="<c:url value="/js/teletext.js"/>" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="../css/dqwz.css">
    <script type="text/javascript">
        var form = document.forms.queryForm;
        var onsbmt = true;
        function checkOnSubmit() {
            var check = true;
            var tranDate = document.getElementById("tranDateMsg");
            var localSysDateTimeBegin = document.getElementById("localSysDateTimeBegin").value;
            var localSysDateTimeEnd = document.getElementById("localSysDateTimeEnd").value;
            if(localSysDateTimeBegin==null || localSysDateTimeBegin ==''){
                check = false;
            }
            if(localSysDateTimeEnd==null || localSysDateTimeEnd ==''){
                check = false;
            }
            if (!check){
                tranDate.innerHTML = "日期不可为空";
            }
            return check;
        }
    </script>
</head>
<body class="claro">
<div id="dqwz">
    <p>
        当前位置：综合支付业务&nbsp;〉&nbsp;银联卡流水管理
    </p>
    <p class="line"></p>
</div>

<mvc:form id="queryForm" name="queryForm" action="list.do"
          method="post" style="display: inline;">
<div id="content">
    <div class="biaoti">
        <p>
            <b>银联卡流水查询</b>
        </p>
    </div>
    <div class="biao">
        <table class="grid">

            <tr>
                <td class="lgridlist" colspan="4">银联卡流水查询</td>
            </tr>
            <tr>
                <td class="crosscolor_td">商户号</td>
                <td>
                    <input type="text" value="${query.merchantId}" id="merchantId" name="merchantId" maxlength="15"/>
                    <%--<span style="color: red" id="merchantIdMsg">*</span>--%>
                </td>
                <td class="crosscolor_td">卡号
                </td>
                <td>
                    <input type="text" value="${query.cardNo}" id="cardNo" name="cardNo"
                           maxlength="19" class=""/>
                </td>
            </tr>
            <tr>
                <td class="crosscolor_td">交易日期
                </td>
                <td colspan="3">
                    <input id="localSysDateTimeBegin" name="localSysDateTimeBegin"
                           value="${query.localSysDateTimeBegin}" maxlength="8"
                           class="Wdate" type="text"
                           onFocus="WdatePicker({dateFmt:'yyyyMMdd',maxDate:'#F{$dp.$D(\'localSysDateTimeEnd\')}'})" />
                    &nbsp;到&nbsp;
                    <input id="localSysDateTimeEnd" name="localSysDateTimeEnd"
                           value="${query.localSysDateTimeEnd}" maxlength="8"
                           class="Wdate" type="text"
                           onFocus="WdatePicker({dateFmt:'yyyyMMdd',minDate:'#F{$dp.$D(\'localSysDateTimeBegin\')}'})" />
                    <span style="color: red" id="tranDateMsg">*</span>
                </td>
            </tr>
        </table>
        <table class="b">
            <tr align="center">
                <td width="200px"></td>
                <td><input type="submit" style="width: 80px" value="查询"
                           onclick="return checkOnSubmit();"/></td>
            </tr>
        </table>
    </div>

    <div class="form">
        <div id="eXtremeTable" class="eXtremeTable">
            <table class="grid its">
                <thead>

                <tr>
                    <th>操作</th>
                    <th>交易类型</th>
                    <th><%=CurTranLs.ALIAS_MERCHANT_ID%></th>
                    <th><%=CurTranLs.ALIAS_CARD_NO%></th>
                    <th><%=CurTranLs.ALIAS_TERMINAL_ID%></th>
                    <th><%=CurTranLs.ALIAS_TRACE_NO%></th>
                    <th><%=CurTranLs.ALIAS_TRAN_RRN%>
                    <th><%=CurTranLs.ALIAS_TRAN_AMT%></th>
                    <th><%=CurTranLs.ALIAS_LOCAL_SYS_DATE%></th>
                    <th><%=CurTranLs.ALIAS_LOCAL_SYS_TIME%></th>
                    </th>
                    <th>交易结果</th>
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
                        <td align="center">
                            <a href="${ctx}/curtranls/show.do?id=${item.lsId}">查看>></a>
                        <td>
                            <c:if test="${item.msgId == '0200' && item.procCode == '000000'}">消费</c:if>
                            <c:if test="${item.msgId == '0200' && item.procCode == '200000'}">撤销</c:if>
                            <c:if test="${item.msgId == '0220' && item.procCode == '270000'}">退货</c:if>
                        </td>
                        <td align="center"><c:out value='${item.merchantId}'/>&nbsp;</td>
                        <td align="center"><c:out value='${item.cardNo}'/>&nbsp;</td>
                        <td align="center"><c:out value='${item.terminalId}'/>&nbsp;</td>
                        <td align="center"><c:out value='${item.traceNo}'/>&nbsp;</td>
                        <td align="center"><c:out value='${item.tranRrn}'/>&nbsp;</td>
                        <td align="center"><c:out value='${item.tranAmt}'/>&nbsp;</td>
                        <td align="center"><c:out value='${item.localSysDate}'/>&nbsp;</td>
                        <td align="center"><c:out value='${item.localSysTime}'/>&nbsp;</td>
                        <td align="center">
                            <c:if test="${item.respCode=='00'&&item.tranFlag=='0'&&item.safFlag=='0'}">成功</c:if>
                            <c:if test="${item.respCode!='00'||item.tranFlag!='0'||item.safFlag!='0'}">失败</c:if>
                        </td>
                    </tr>

                </c:forEach>
                </tbody>
            </table>

            <simpletable:pageToolbar page="${page}">
            </simpletable:pageToolbar>
        </div>
        </mvc:form>


