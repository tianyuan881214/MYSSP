<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*" %>
<html>
<head>
    <%@include file="../../base_pages/base.jsp" %>
    <script src="<c:url value="/js/teletext.js"/>" type="text/javascript"></script>
</head>
<body class="claro">
<fieldset style="margin: 10px 0; padding: 10px; border: #DDD 1px solid">
    <legend>商户信息查看
    </legend>
    <mvc:form action="save.do" theme="simple" method="post" id="form1"
              data-dojo-type="dijit.form.Form">
        <table class="grid">
            <input type="hidden" name="merchantId" id="merchantId" value="${model.merchantId}"/>
            <tr>
                <td colspan="4" class="tb_title">
                    <%=MerchantBaseFh.TABLE_ALIAS%>信息
                </td>
            </tr>
            <tr>
                <td class="lgridlist"><%=MerchantBaseFh.ALIAS_MERCHANT_ID%>
                </td>
                <td><span>${model.merchantId}</span></td>


                <td class="lgridlist"><%=MerchantBaseFh.ALIAS_MERCHANT_CNAME%>
                </td>
                <td><span>${model.merchantCname}</span></td>
            </tr>
            <tr>
                <td class="lgridlist">
                    <%=MerchantBaseFh.ALIAS_ADDRESS_CHN%>:
                </td>
                <td>
                    <span>${model.addressChn}</span>
                </td>
                <td class="lgridlist"><%=MerchantBaseFh.ALIAS_ABBR_CNAME%></td>
                <td>${model.abbrCname}</td>
            </tr>

            <tr>

                <td class="lgridlist">
                    <%=MerchantBaseFh.ALIAS_CITY_CNAME%>:
                </td>
                <td>
                    <span>${model.cityCname}</span>
                </td>
                <td class="lgridlist">
                    <%=MerchantBaseFh.ALIAS_TELEPHONE%>:
                </td>
                <td>
                    <span>${model.telephone}</span>
                </td>
            </tr>

            <!-- 以下是扩展业务-------------------------------------------------------------------------------------------------- -->
            <tr>
                <td class="lgridlist">入账账号</td>
                <td>
                        ${modelson.accountNo}
                </td>

                <td class="lgridlist">账户名称</td>
                <td>
                        ${modelson.accountName}
                </td>
            </tr>
            <tr>
                <td class="lgridlist">账户开户行</td>
                <td>${modelson.cardHolderName}
                </td>
                <td class="lgridlist"><%=MerchantBaseFh.ALIAS_MERCHANT_STAT%>
                </td>
                <td><mytag:write value="${model.merchantStat}" dictName="MERCHANT_STAT"/></td>

            </tr>
            <tr>
                <td class="lgridlist">开户行行号</td>
                <td>${modelson.openingBankNo}
                </td>
                <td class="lgridlist"><%=MerchantBaseFh.ALIAS_ZBANK%>
                </td>
                <td><mytag:write value="${model.zbank}" dictName="D_ORG"/></td>
            </tr>
            <tr>
                <td class="lgridlist">支付宝内的唯一标识
                </td>
                <td>${enterAiliMerchant.sub_merchant_id}</td>
                <td class="lgridlist">入驻结果</td>
                <td>
                    <c:if test="${enterAiliMerchant.sub_merchant_id==null || enterAiliMerchant.sub_merchant_id=='' }">入驻失败</c:if>
                    <c:if test="${enterAiliMerchant.sub_merchant_id!=null && enterAiliMerchant.sub_merchant_id!='' }">入驻成功</c:if>
                </td>
            </tr>
            <tr>
                <td class="lgridlist">微信内的唯一标识</td>
                <td align="lgridlist"><c:out value='${model.sub_mch_id}'/>&nbsp;</td>
                <td class="lgridlist">入驻结果</td>
                <td>
                    <c:if test="${model.sub_mch_id==null || model.sub_mch_id=='' }">入驻失败</c:if>
                    <c:if test="${model.sub_mch_id!=null && model.sub_mch_id!='' }">入驻成功</c:if>
                </td>
            </tr>
            <tr>
                <td class="lgridlist"><%=MerchantBaseFh.ALIAS_UPDATE_DATE%>
                </td>
                <td><span>${model.updateDate}</span></td>

                <td class="lgridlist"><%=MerchantBaseFh.ALIAS_UPDATE_TIME%>
                </td>
                <td><span>${model.updateTime}</span></td>
            </tr>
            <c:forEach items="${FeeBusiness}" var="item">
                <tr>
                    <td class="lgridlist">业务名称</td>
                    <td>${item.businessBases.businessName}</td>
                    <td class="lgridlist">${item.businessBases.businessName}费率</td>
                    <td>${item.feeTables.fee}</td>
                </tr>
            </c:forEach>
            <tr>
                <td class="lgridlist">经营类目</td>
                <td> <span>${model.detail}</span></td>

           <%--     <td class="lgridlist">商户分组</td>
                <td>${merchantGrp.merGrpName}</td>--%>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
        </table>
        <table class="b">
            <tr align="center">
                <td><input type="submit" style="width: 80px" value="驳回"
                           onclick="getReferenceForm(this).action='updateReview.do?state=1'" /></td>
                <td><input type="submit" style="width: 80px" value="审核通过"
                           onclick="getReferenceForm(this).action='updateReview.do?state=0'" /></td>
            </tr>
        </table>
    </mvc:form>
</fieldset>
</body>
</html>
