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
                    支付宝对账信息
                </td>
            </tr>
            <tr>
                <td class="lgridlist">支付宝交易号

                </td>
                <td><span>${model.tradeNo}</span></td>
                <td class="lgridlist">商户订单号
                <td><span>${model.outTradeNo}</span></td>
            </tr>
            <tr>
                <td class="lgridlist">业务类型
                </td>
                <td><span>${model.tranType}</span></td>
                <td class="lgridlist">创建时间
                </td>
                <td><span>${model.createDate}</span></td>
            </tr>
            <tr>
                <td class="lgridlist">完成时间
                </td>
                <td><span>${model.finishDate}</span></td>
                <td class="lgridlist">商户号
                </td>
                <td><span>${model.storeId}</span></td>
            </tr>
            <tr>
                <td class="lgridlist">商户名称
                </td>
                <td><span>${model.storeName}</span></td>
                <td class="lgridlist">操作员号
                </td>
                <td><span>${model.operatorId}</span></td>
            </tr>
            <tr>
                <td class="lgridlist">终端号
                </td>
                <td><span>${model.terminalId}</span></td>
                <td class="lgridlist">对方账户
                </td>
                <td><span>${model.oppositeId}</span></td>
            </tr>
            <tr>
                <td class="lgridlist">订单金额
                </td>
                <td><span>${model.orderAmount}</span></td>
                <td class="lgridlist">支付宝服务费
                </td>
                <td><span>${model.serviceCharge}</span></td>
            </tr>
            <tr>
                <td class="lgridlist">银行应入账金额
                </td>
                <td><span>${model.merchantPaidAmount}</span></td>
                <td class="lgridlist">银行服务费
                </td>
                <td><span>${model.bankServiceAmt}</span></td>
            </tr>
            <tr>
                <td class="lgridlist">银行扣率
                </td>
                <td><span>${model.bank_fee}</span></td>
                <td class="lgridlist">商户应入账金额
                </td>
                <td><span>${model.netMerAmt}</span></td>
            </tr>


            <tr>
                <td class="lgridlist">退款批次号
                </td>
                <td><span>${model.refundBatchNo}</span></td>
                <td class="lgridlist">商户识别号
                </td>
                <td><span>${model.merchantDiscernNo}</span></td>
            </tr>
            <tr>
                <td class="lgridlist">交易方式</td>
                <td><span>${model.tranWay}</span></td>
                <td class="lgridlist">所属机构</td>
                <td>${model.name}</td>
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

