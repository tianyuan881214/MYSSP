<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*" %>
<html>
<head>
    <title>EACQ对账
    </title>
    <%@include file="../../base_pages/base.jsp" %>
    <script src="<c:url value="/js/teletext.js"/>" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="../css/dqwz.css">
    <script type="text/javascript">
        function existDate() {
            var check = true;
            var tranDate = document.getElementById("tranDateMsg");
            var tranDateTimeBegin = document.getElementById("tranDateTimeBegin").value;
            var tranDateTimeEnd = document.getElementById("tranDateTimeEnd").value;
            if(tranDateTimeBegin==null || tranDateTimeBegin ==''){
                check = false;
            }
            if(tranDateTimeEnd==null || tranDateTimeEnd ==''){
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
        当前位置：综合支付业务&nbsp;〉&nbsp;EACQ对账管理
    </p>
    <p class="line"></p>
</div>

<mvc:form id="queryForm" name="queryForm" action="list.do"
          method="post" style="display: inline;">

    <div id="content">
        <div class="biaoti">
            <p>
                <b>EACQ对账查询</b>
            </p>
        </div>
        <div class="biao">
            <table class="grid">

                <tr>
                    <td class="lgridlist" colspan="4">EACQ对账查询</td>
                </tr>
                    <tr>
                        <td class="crosscolor_td">商户号
                        </td>
                        <td>
                            <input type="text" value="${query.merchantId}" id="merchantId" name="merchantId"
                                   maxlength="15" class=""/>
                        </td>
                        <td class="crosscolor_td">卡号
                        </td>
                        <td>
                            <input type="text" value="${query.cardNo}" id="cardNo" name="cardNo"
                                   maxlength="32" class=""/>
                        </td>
                    </tr>
                <tr>
                    <td class="crosscolor_td">批次号
                    </td>
                    <td>
                        <input type="text" value="${query.batchNo}" id="batchNo" name="batchNo"
                               maxlength="6" class=""/>
                    </td>
                    <td class="crosscolor_td">终端号
                    </td>
                    <td>
                        <input type="text" value="${query.terminalId}" id="terminalId" name="terminalId"
                               maxlength="8" class=""/>
                    </td>
                </tr>
                <tr>
                    <td class="crosscolor_td">交易时间
                    </td>
                    <td colspan="3">
                        <input id="tranDateTimeBegin" name="tranDateTimeBegin"
                               value="${query.tranDateTimeBegin}" maxlength="8"
                               class="Wdate" type="text"
                               onFocus="WdatePicker({dateFmt:'yyyyMMdd',maxDate:'#F{$dp.$D(\'tranDateTimeEnd\')}'})" />
                        &nbsp;到&nbsp;
                        <input id="tranDateTimeEnd" name="tranDateTimeEnd"
                               value="${query.tranDateTimeEnd}" maxlength="8"
                               class="Wdate" type="text"
                               onFocus="WdatePicker({dateFmt:'yyyyMMdd',minDate:'#F{$dp.$D(\'tranDateTimeBegin\')}'})" />
                        <span style="color: red" id="tranDateMsg">*</span>
                    </td>
                </tr>

            </table>
            <table class="b">
                <tr align="center">
                    <td width="200px"></td>
                    <td><input type="submit" style="width: 80px" value="查询"
                               onclick="return existDate();"/></td>
                </tr>
            </table>
        </div>
        <div class="form">
            <div id="eXtremeTable" class="eXtremeTable">
                <table class="grid its">
                    <thead>
                    <tr>
                        <th>操作</th>
                        <th>商户号</th>
                        <th>终端号</th>
                        <th>批次号</th>
                        <th>卡号</th>
                        <th>交易金额</th>
                        <th>手续费</th>
                        <th>交易日期</th>
                        <th>交易时间</th>
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
                        </tr>
                    </c:if>
                    <c:forEach items="${page.result}" var="item" varStatus="status">
                        <tr class="${status.count % 2 == 0 ? 'odd' : 'even'}">
                            <td align="center">
                                <a href="${ctx}/bossettlels/show.do?id=${item.recordId}">查看>></a>
                            <td align="center"><c:out value='${item.merchantId}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.terminalId}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.batchNo}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.cardNo}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.tranAmt}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.tranFee}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.tranData}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.tranTime}'/>&nbsp;</td>
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
