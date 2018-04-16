<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*" %>
<html>
<head>
    <%@include file="../../base_pages/base.jsp" %>
    <script src="<c:url value="/js/teletext.js"/>" type="text/javascript"></script>
</head>
<body class="claro">
<fieldset style="margin: 10px 0; padding: 10px; border: #DDD 1px solid">
    <mvc:form action="save.do" theme="simple" method="post" id="form1"
              data-dojo-type="dijit.form.Form">
        <table class="grid">
            <input type="hidden" name="tranType" id="tranType" value="%{model.tranType}"/>
            <tr>
                <td colspan="4" class="tb_title">
                    支付宝流水信息
                </td>
            </tr>
            <tr class="crosscolor_tr">
                <td class="crosscolor_td"><%=CurTranLs.ALIAS_MERCHANT_ID%>
                </td>
                <td>${model.merchantId}</td>


                <td class="crosscolor_td"><%=CurTranLs.ALIAS_TERMINAL_ID%>
                </td>
                <td>${model.terminalId}</td>
            </tr>
            <tr class="crosscolor_tr">
                <td class="crosscolor_td"><%=CurTranLs.ALIAS_MSG_ID%>
                </td>
                <td>${model.msgId}</td>


                <td class="crosscolor_td"><%=CurTranLs.ALIAS_PROC_CODE%>
                </td>
                <td>${model.procCode}</td>
            </tr>
            <tr class="crosscolor_tr">
                <td class="crosscolor_td"><%=CurTranLs.ALIAS_CARD_NO%>
                </td>
                <td>${model.cardNo}</td>


                <td class="crosscolor_td"><%=CurTranLs.ALIAS_EXP_DATE%>
                </td>
                <td>${model.expDate}</td>
            </tr>
            <tr class="crosscolor_tr">
                <td class="crosscolor_td"><%=CurTranLs.ALIAS_LOCAL_SYS_DATE%>
                </td>
                <td>${model.localSysDate}</td>
                <td class="crosscolor_td"><%=CurTranLs.ALIAS_LOCAL_SYS_TIME%>
                </td>
                <td>${model.localSysTime}</td>
            </tr>
            <tr class="crosscolor_tr">
                <td class="crosscolor_td"><%=CurTranLs.ALIAS_TRAN_AMT%>
                </td>
                <td>${model.tranAmt}</td>
                <td class="crosscolor_td"><%=CurTranLs.ALIAS_TRACE_NO%>
                </td>
                <td>${model.traceNo}</td>
            </tr>
            <tr class="crosscolor_tr">
                <td class="crosscolor_td"><%=CurTranLs.ALIAS_TRAN_RRN%>
                </td>
                <td>${model.tranRrn}</td>
                <td class="crosscolor_td"><%=CurTranLs.ALIAS_BATCH_NO%>
                </td>
                <td>${model.batchNo}</td>
            </tr>
            <tr class="crosscolor_tr">
                <td class="crosscolor_td"><%=CurTranLs.ALIAS_AUTH_NO%>
                </td>
                <td>${model.authNo}</td>
                <td class="crosscolor_td"><%=CurTranLs.ALIAS_RESP_CODE%>
                </td>
                <td>${model.respCode}</td>
            </tr>
            <tr class="crosscolor_tr">
                <td class="crosscolor_td"><%=CurTranLs.ALIAS_TRAN_FLAG%>
                </td>
                <td>${model.tranFlag}</td>
                <td class="crosscolor_td"><%=CurTranLs.ALIAS_SAF_FLAG%>
                </td>
                <td>${model.safFlag}</td>
            </tr>
            <tr class="crosscolor_tr">
                <td class="crosscolor_td">交易结果
                </td>
                <td><c:if test="${model.respCode=='00'&&model.tranFlag=='0'&&model.safFlag=='0'}">成功</c:if>
                    <c:if test="${model.respCode!='00'||model.tranFlag!='0'||model.safFlag!='0'}">失败</c:if></td>
                <td class="crosscolor_td">交易类型
                </td>
                <td>
                    <c:if test="${model.msgId == '0200' && model.procCode == '000000'}">消费</c:if>
                    <c:if test="${model.msgId == '0200' && model.procCode == '200000'}">撤销</c:if>
                    <c:if test="${model.msgId == '0220' && model.procCode == '270000'}">退货</c:if>
                </td>
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

