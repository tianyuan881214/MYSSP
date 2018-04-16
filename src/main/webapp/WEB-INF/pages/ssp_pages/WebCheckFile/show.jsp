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
                    微信对账信息
                </td>
            </tr>
            <tr>
                <td class="lgridlist">微信订单号</td>
                <td><span>${model.transactionId}</span></td>
                <td class="lgridlist">公众号Id
                <td><span>${model.appid}</span></td>
            </tr>

            <tr>
                <td class="lgridlist">商品名称
                </td>
                <td><span>${model.goodsName}</span></td>
                <td class="lgridlist">微信退款单号
                </td>
                <td><span>${model.refundId}</span></td>
            </tr>

            <tr>
                <td class="lgridlist">设备号
                </td>
                <td><span>${model.deviceNumber}</span></td>
                <td class="lgridlist">微信手续费
                </td>
                <td><span>${model.fee}</span></td>
            </tr>


            <tr>
                <td class="lgridlist">商户号
                </td>
                <td><span>${model.merchantId}</span></td>
                <td class="lgridlist">用户标识
                </td>
                <td><span>${model.userFlag}</span></td>
            </tr>

            <tr>
                <td class="lgridlist">商户退款单号

                </td>
                <td><span>${model.outRefundId}</span></td>
                <td class="lgridlist">商户订单号
                </td>
                <td><span>${model.outTradeNo}</span></td>
            </tr>
            <tr>
                <td class="lgridlist">微信费率
                </td>
                <td><span>${model.feeRate}</span></td>
                <td class="lgridlist">退款金额
                </td>
                <td><span>${model.returndAmt}</span></td>
            </tr>


            <tr>

                <td class="lgridlist">子商户好
                </td>
                <td><span>${model.subMerchantID}</span></td>
                <td class="lgridlist">订单金额
                </td>
                <td><span>${model.totalAmount}</span></td>
            </tr>

            <tr>
                <td class="lgridlist">交易类型
                </td>
                <td>
                    <span><mytag:write dictName="D_TRAN_TYPE" value="${model.tranStart}"/></span>
                </td>
                <td class="lgridlist">交易日期
                </td>
                <td><span>${model.tranTime}</span></td>
            </tr>
            <tr>
                <td class="lgridlist">银行手续费
                </td>
                <td>
                    <span>${model.bankServiceAmt}</span>
                </td>
                <td class="lgridlist">银行费率
                </td>
                <td><span>${model.bank_fee}</span></td>
            </tr>
            <tr>
                <td class="lgridlist">商户应入账金额
                </td>
                <td><span>${model.netMerAmt}</span></td>
                <td class="lgridlist">银行应入账金额
                </td>
                <td><span>${model.netBankAmt}</span></td>

            </tr>
            <tr>
            <td class="lgridlist">归宿机构
            </td>
            <td>
                <span>${model.inOrg}</span>            </td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
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

