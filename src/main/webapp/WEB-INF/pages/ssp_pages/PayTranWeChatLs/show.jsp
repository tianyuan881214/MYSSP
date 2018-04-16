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
                    微信流水信息
                </td>
            </tr>
            <tr>
                <td class="lgridlist">商户订单号

                </td>
                <td><span>${model.outTradeNo}</span></td>
                <td class="lgridlist">原批次号
                <td><span>${model.oldBatchNo}</span></td>
            </tr>
            <tr>
                <td class="lgridlist">原终端流水号
                </td>
                <td><span>${model.oldTraceNo}</span></td>
                <td class="lgridlist">原交易日期
                </td>
                <td><span>${model.oldTranDate}</span></td>
            </tr>
            <tr>
                <td class="lgridlist">原交易时间
                </td>
                <td><span>${model.oldTranTime}</span></td>
                <td class="lgridlist">支付授权码
                </td>
                <td><span>${model.authCode}</span></td>
            </tr>
            <tr>
                <td class="lgridlist">终端批次号
                </td>
                <td><span>${model.batchNo}</span></td>
                <td class="lgridlist">错误代码
                </td>
                <td><span>${model.errCode}</span></td>
            </tr>
            <tr>
                <td class="lgridlist">微信支付分配的商户号
                </td>
                <td><span>${model.mchId}</span></td>
                <td class="lgridlist">商户编号
                </td>
                <td><span>${model.operatorId}</span></td>
            </tr>
            <tr>
                <td class="lgridlist">操作员号
                </td>
                <td><span>${model.operatorId}</span></td>
                <td class="lgridlist">退货标识
                </td>
                <td>
                    <c:if test="${model.refundFlag=='1'}">退货</c:if>
                </td>
            </tr>
            <tr>
                <td class="lgridlist">业务结果

                </td>
                <td>
                    <c:if test="${model.resultCode=='SUCCESS'}">成功</c:if>
                    <c:if test="${model.resultCode!='SUCCESS'}">失败</c:if>
                </td>
                <td class="lgridlist">返回状态码
                </td>
                <td><span>${model.returnCode}</span></td>
            </tr>
            <tr>
                <td class="lgridlist">签名失败
                </td>
                <td><span>${model.returnMsg}</span></td>
                <td class="lgridlist">终端编号
                </td>
                <td><span>${model.terminalId}</span></td>
            </tr>
            <tr>
                <td class="lgridlist">交易金额
                </td>
                <td><span>${model.totalAmount}</span></td>
                <td class="lgridlist">终端流水号
                </td>
                <td><span>${model.traceNo}</span></td>
            </tr>
            <tr>
                <td class="lgridlist">交易日期
                </td>
                <td><span>${model.tranDate}</span></td>
                <td class="lgridlist">交易时间
                </td>
                <td><span>${model.tranTime}</span></td>
            </tr>
            <tr>
                <td class="lgridlist">交易类型
                </td>
                <td>
                    <mytag:write dictName="D_TRAN_TYPE" value="${model.tranType}"/>
                </td>
                <td class="lgridlist">微信支付订单号
                </td>
                <td><span>${model.transactionId}</span></td>
            </tr>
            <tr>
                <td class="lgridlist">所属机构
                </td>
                <td><span>${model.inOrg}</span></td>
                <td class="lgridlist">交易是否成功
                </td>
                <td>
                    <c:if test="${model.resultCode=='SUCCESS' && model.returnCode=='SUCCESS'}">成功</c:if>
                    <c:if test="${model.resultCode!='SUCCESS' || model.returnCode!='SUCCESS'}">失败</c:if>
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

