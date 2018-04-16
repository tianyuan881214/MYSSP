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
            <tr>
                <td class="lgridlist">商户订单号</td>
                <td><span>${model.outTradeNo}</span></td>
                <td class="lgridlist">撤销标识
                </td>
                <td><span>${model.undoFlag}</span></td>
            </tr>
            <tr>
                <td class="lgridlist">支付授权码
                </td>
                <td><span>${model.authCode}</span></td>
                <td class="lgridlist">终端批次号
                </td>
                <td><span>${model.authCode}</span></td>
            </tr>
            <tr>
                <td class="lgridlist">商户号
                </td>
                <td><span>${model.body}</span></td>
                <td class="lgridlist">买家支付宝账号
                </td>
                <td><span>${model.buyerLoginId}</span></td>
            </tr>

            <tr>
                <td class="lgridlist">买家付款的金额

                </td>
                <td><span>${model.buyerPayAmount}</span></td>
                <td class="lgridlist">买家在支付宝的用户
                </td>
                <td><span>${model.buyerUserId}</span></td>
            </tr>
            <tr>
                <td class="lgridlist">网关返回码
                </td>
                <td>${model.code}
                </td>
                <td class="lgridlist">交易支付时间
                </td>
                <td><span>${model.gmtPayment}</span></td>
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
                <td class="lgridlist">支付宝交易号
                </td>
                <td><span>${model.tradeNo}</span></td>
                <td class="lgridlist">商户编号
                </td>
                <td><span>${model.storeId}</span></td>
            </tr>

            <tr>
                <td class="lgridlist">终端编号
                </td>
                <td><span>${model.terminalId}</span></td>
                <td class="lgridlist">选填 6 订单允许的最晚付款时间取值范围：1m～15d
                </td>
                <td><span>${model.timeOutExpress}</span></td>
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
                <td class="lgridlist">默认为商户签约账号对应的支付宝用户ID
                </td>
                <td><span>${model.sellerId}</span></td>
                <td class="lgridlist">发送请求的日期
                </td>
                <td><span>${model.tranDate}</span></td>
            </tr>
            <tr>
                <td class="lgridlist">发送请求的时间
                </td>
                <td><span>${model.tranTime}</span></td>
                <td class="lgridlist">交易类型
                </td>
                <td>
                    <mytag:write dictName="D_TRAN_TYPE" value="${model.tranType}"/>
                </td>
            </tr>
            <tr>
                <td class="lgridlist">发生支付交易的商户门店名称
                </td>
                <td><span>${model.storeName}</span></td>
                <td class="lgridlist">业务返回码
                </td>
                <td>
                    ${model.subCode}
                </td>
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
                <td class="lgridlist">原商户订单号
                </td>
                <td><span>${model.oldOutTradeNo}</span></td>
            </tr>

            <tr>
                <td class="lgridlist">原终端号
                </td>
                <td><span>${model.oldTerminalId}</span></td>
                <td class="lgridlist">原支付宝交易号
                </td>
                <td><span>${model.oldTradeNo}</span></td>
            </tr>
            <tr>
                <td class="lgridlist">原批次号
                <td><span>${model.oldBatchNo}</span></td>
                <td class="lgridlist">交易是否成功</td>
                <td>
                    <c:if test="${model.code=='10000'}">成功</c:if>
                    <c:if test="${model.code!='10000'}">失败</c:if>
                </td>
            </tr>
            <tr>
                <td class="lgridlist">归属机构
                <td><span>${model.inOrg}</span></td>
                <td>&nbsp;&nbsp;</td>
                <td>
                    &nbsp;&nbsp;
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

