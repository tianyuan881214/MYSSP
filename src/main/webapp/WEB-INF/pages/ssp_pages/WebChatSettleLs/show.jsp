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
                    银联对账信息
                </td>
            </tr>
            <tr>
                <td class="lgridlist">商户订单号</td>
                <td><span>${model.orderId}</span></td>
            </tr>

            <tr>
                <td class="lgridlist">账单号码
                </td>
                <td><span>${model.billNo}</span></td>
                <td class="lgridlist">账单类型
                </td>
                <td><span>${model.accType}</span></td>
            </tr>

            <tr>
                <td class="lgridlist">业务类型
                </td>
                <td><span>${model.billType}</span></td>
                <td class="lgridlist">优惠金额
                </td>
                <td><span>${model.discountAmt}</span></td>
            </tr>


            <tr>
                <td class="lgridlist">交互方式
                </td>
                <td><span>${model.interactMode}</span></td>
                <td class="lgridlist">清算净额
                </td>
                <td><span>${model.liquindationAmt}</span></td>
            </tr>

            <tr>
                <td class="lgridlist">清算日期

                </td>
                <td><span>${model.liquidationTime}</span></td>
                <td class="lgridlist">商户代码
                </td>
                <td><span>${model.mercatCode}</span></td>
            </tr>
            <tr>
                <td class="lgridlist">商户手续费
                </td>
                <td><span>${model.merchantFee}</span></td>
                <td class="lgridlist">结算金额
                </td>
                <td><span>${model.settleementAmt}</span></td>
            </tr>

            <tr>
                <td class="lgridlist">交易时间
                </td>
                <td><span>${model.oldTxnTime}</span></td>
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

