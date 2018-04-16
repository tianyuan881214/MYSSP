<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*" %>
<html>
<head>
    <%@include file="../../base_pages/base.jsp" %>
    <script src="<c:url value="/js/teletext.js"/>" type="text/javascript"></script>
</head>
<body class="claro">
<fieldset style="margin: 10px 0; padding: 10px; border: #DDD 1px solid">
    <legend>商户分组查看
    </legend>
    <mvc:form action="save.do" theme="simple" method="post" id="form1"
              data-dojo-type="dijit.form.Form">
        <table class="grid">
            <input type="hidden" name="tranType" id="tranType" value="%{model.tranType}"/>
            <tr>
                <td colspan="4" class="tb_title">
                    商户分组信息
                </td>
            </tr>

            <tr>
                <td class="lgridlist">商户分组号:</td>
                <td>${model.merGrpId}</td>
                <td class="lgridlist">分组名称:</td>

                <td>${model.merGrpName}</td>
            </tr>
            <tr>
                <td class="lgridlist">全称:</td>
                <td>${model.merchantName}</td>
                <td class="lgridlist">简称:</td>
                <td>${model.abbrName}</td>

            </tr>
            <tr>
                <td class="lgridlist">地址:</td>
                <td>${model.addressChn}</td>
                <td class="lgridlist">备注信息:</td>
                <td>${model.memo}</td>
            </tr>
            <tr>
                <td class="lgridlist">所在城市:</td>
                <td>${model.cityName}</td>
                <td class="lgridlist">电话号码:</td>
                <td>${model.telephone}</td>
            </tr>
            <tr>
                <td class="lgridlist">邮编:</td>
                <td>${model.postCode}</td>
                <td class="lgridlist">传真:</td>
                <td>${model.fax}</td>
            </tr>
            <tr>
                <td class="lgridlist">联系人姓名:</td>
                <td>${model.manager}</td>
                <td class="lgridlist">锁标示:</td>
                <td><mytag:write value="${model.lockMode}" dictName="D_STATUS"/></td>
            </tr>
            <tr class="crosscolor_tr">
                <td class="lgridlist">清算模式:</td>
                <td><mytag:write value="${model.settleMode}" dictName="D_SETTLE_MODE"/></td>
                <td class="lgridlist">入账账号:</td>
                <td>${model.accountNo}</td>
            </tr>
            <tr>
                <td class="lgridlist">账号名称:</td>
                <td>${model.accountName}</td>
                <td class="lgridlist">账号开户行:</td>
                <td>${model.openingBank}</td>
            </tr>
            <tr>
                <td class="lgridlist">开户行行号:</td>
                <td>${model.openingBankNo}</td>
                <td class="lgridlist">开户行地址:</td>
                <td>${model.openingBankAddress}</td>
            </tr>
            <tr>
                <td class="lgridlist">更新日期:</td>
                <td>${model.updateDate}</td>
                <td class="lgridlist">更新时间:</td>
                <td>${model.updateTime}</td>
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

