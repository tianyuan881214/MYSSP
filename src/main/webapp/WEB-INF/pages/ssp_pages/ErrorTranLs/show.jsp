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
                    对账差错信息
                </td>
            </tr>
            <tr>
                <td class="lgridlist">业务渠道</td>
                <td><mytag:write dictName="D_TRAN_SOURCES" value="${model.tranSources}"/> </td>
                <td class="lgridlist">对账关系</td>
                <td><mytag:write dictName="D_ACCOUNT_RELATION" value="${model.accountRelation}"/></td>
            </tr>
            <tr>
                <td class="lgridlist">差错原因
                </td>
                <td><mytag:write dictName="D_ERROR_CAUSE" value="${model.errorCause}"/></td>
                <td class="lgridlist">流水号
                </td>
                <td><span>${model.tranNo}</span></td>
            </tr>
            <tr>
                <td class="lgridlist">交易类型
                </td>
                <td><mytag:write dictName="D_TRAN_TYPE" value="${model.tranType}"/></td>
                <td class="lgridlist">交易日期
                </td>
                <td><span>${model.tranDate}</span></td>
            </tr>
            <tr>
                <td class="lgridlist">交易时间
                </td>
                <td><span>${model.tranTime}</span></td>
                <td class="lgridlist">交易卡号
                </td>
                <td><span>${model.cardNo}</span></td>
            </tr>
            <tr>
                <td class="lgridlist">商户号
                </td>
                <td><span>${model.merchantId}</span></td>
                <td class="lgridlist">终端号
                </td>
                <td><span>${model.terminalNo}</span></td>
            </tr>
            <tr>
                <td class="lgridlist">终端流水号
                </td>
                <td><span>${model.terminalLsNo}</span></td>
                <td class="lgridlist">交易金额
                </td>
                <td><span>${model.tranAmt}</span></td>
            </tr>
            <tr>
                <td class="lgridlist">批次号

                </td>
                <td><span>${model.batchNo}</span></td>
                <td class="lgridlist">操作员号
                </td>
                <td><span>${model.operNo}</span></td>
            </tr>
            <tr>
                <td class="lgridlist">退货单号
                </td>
                <td><span>${model.refundNo}</span></td>
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

