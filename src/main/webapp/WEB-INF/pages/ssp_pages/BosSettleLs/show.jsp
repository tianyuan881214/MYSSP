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
                    EACQ对账信息
                </td>
            </tr>
            <tr>
                <td class="lgridlist">ID

                </td>
                <td><span>${model.recordId}</span></td>
                <td class="lgridlist">清算日期
                <td><span>${model.settleDate}</span></td>
            </tr>
            <tr>
                <td class="lgridlist">商户号
                </td>
                <td><span>${model.merchantId}</span></td>
                <td class="lgridlist">终端号
                </td>
                <td><span>${model.terminalId}</span></td>
            </tr>

            <tr>
                <td class="lgridlist">批次号
                </td>
                <td><span>${model.batchNo}</span></td>
                <td class="lgridlist">卡号
                </td>
                <td><span>${model.cardNo}</span></td>
            </tr>
            <tr>
                <td class="lgridlist">交易日期
                </td>
                <td><span>${model.tranData}</span></td>
                <td class="lgridlist">交易时间
                </td>
                <td><span>${model.tranTime}</span></td>
            </tr>
            <tr>
                <td class="lgridlist">交易金额
                </td>
                <td><span>${model.tranAmt}</span></td>
                <td class="lgridlist">手续费
                </td>
                <td><span>${model.tranFee}</span></td>
            </tr>
            <tr>
                <td class="lgridlist">结算金额
                </td>
                <td><span>${model.settleAmt}</span></td>
                <td class="lgridlist">授权码
                </td>
                <td><span>${model.authNo}</span></td>
            </tr>
            <tr>
                <td class="lgridlist">交易码

                </td>
                <td><span>${model.tranCode}</span></td>
                <td class="lgridlist">参考号
                </td>
                <td><span>${model.referenceNo}</span></td>
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

