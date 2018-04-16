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
            <input type="hidden" name="tranType" id="tranType" value="%{model.tranType}"/>
            <tr>
                <td colspan="4" class="tb_title">
                    <%=MerchantBase.TABLE_ALIAS%>信息
                </td>
            </tr>
            <tr>
                <td class="lgridlist"><%=MerchantBase.ALIAS_MERCHANT_ID%>
                </td>
                <td><span>${model.merchantId}</span></td>


                <td class="lgridlist"><%=MerchantBase.ALIAS_MERCHANT_CNAME%>
                </td>
                <td><span>${model.merchantCname}</span></td>
            </tr>
            <tr>
                <td class="lgridlist">
                    <%=MerchantBase.ALIAS_ADDRESS_CHN%>:
                </td>
                <td>
                    <span>${model.addressChn}</span>
                </td>
                <td class="lgridlist"><%=MerchantBase.ALIAS_ABBR_CNAME%></td>
                <td>${model.addressChn}</td>
            </tr>

            <tr>

                <td class="lgridlist">
                    <%=MerchantBase.ALIAS_CITY_CNAME%>:
                </td>
                <td>
                    <span>${model.cityCname}</span>
                </td>
                <td class="lgridlist">
                    <%=MerchantBase.ALIAS_TELEPHONE%>:
                </td>
                <td>
                    <span>${model.telephone}</span>
                </td>
            </tr>
                <%-- M3--%>
            <tr>
                <td class="lgridlist">商户入驻级别：</td>
                <td>
                    <span>${modelson.merchantLevel}</span>
                </td>
                <td class="lgridlist">商户所在省份邮编:</td>

                <td>${modelson.provinceCode}</td>
            </tr>

            <tr>
                <td class="lgridlist">商户所在市区邮编:</td>

                <td>${modelson.cityCode}</td>
                <td class="lgridlist">商户所在县份邮编:</td>

                <td>${modelson.districtCode}</td>
            </tr>

            <tr>
                <td class="lgridlist">联系人姓名:</td>

                <td>${modelson.contactName}</td>


                <td class="lgridlist">联系人类型:</td>

                <td>
                    <c:if test="${modelson.contactType=='LEGAL_PERSON'}">法人</c:if>
                    <c:if test="${modelson.contactType=='CONTROLLER'}">实际控制人</c:if>
                    <c:if test="${modelson.contactType=='AGENT'}">代理人</c:if>
                    <c:if test="${modelson.contactType=='OTHER'}">其他</c:if>
            </tr>
            <tr>
                <td class="lgridlist">身份证号:</td>

                <td>${modelson.idCard} </td>


                <td class="lgridlist">电子邮箱:</td>

                <td>${modelson.email}</td>
            </tr>
            <tr>
                <td class="lgridlist">营业执照:</td>

                <td>${modelson.businessLicense}</td>


                <td class="lgridlist">营业执照类型:</td>

                <td>
                    <c:if test="${modelson.businessLicenseType=='NATIONAL_LEGAL'}">营业执照</c:if>
                    <c:if test="${modelson.businessLicenseType=='NATIONAL_LEGAL_MERGE'}">营业执照（多证合一）</c:if>
                    <c:if test="${modelson.businessLicenseType=='INST_RGST_CTF'}">事业单位法人证书</c:if>
                </td>
            </tr>
            <tr>
                <td class="lgridlist">银行卡号:</td>

                <td>${modelson.cardNo}</td>


                <td class="lgridlist">持卡人姓名:</td>

                <td>${modelson.cardName}</td>
            </tr>
            <%--M3结束--%>

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
                <td class="lgridlist"><%=MerchantBase.ALIAS_MERCHANT_STAT%>
                </td>
                <td><mytag:write value="${model.merchantStat}" dictName="MERCHANT_STAT"/></td>

            </tr>
            <tr>
                <td class="lgridlist">开户行行号</td>
                <td>${modelson.openingBankNo}
                </td>
                <td class="lgridlist"><%=MerchantBase.ALIAS_ZBANK%>
                </td>
                <td><mytag:write value="${model.zbank}" dictName="D_ORG"/></td>
            </tr>
            <tr>
                <td class="lgridlist">是否为他行账户</td>
                <td><mytag:write value="${modelson.fax}" dictName="IN_BANK"/></td>

                <td class="lgridlist">开户人姓名</td>
                <td>${modelson.openingBank}
                </td>

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
                <td class="lgridlist"><%=MerchantBase.ALIAS_UPDATE_DATE%>
                </td>
                <td><span>${model.updateDate}</span></td>

                <td class="lgridlist"><%=MerchantBase.ALIAS_UPDATE_TIME%>
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
                <td class="lgridlist"><%=MerchantBase.ALLAS_ACCOUNT_TYPE%>
                </td>
                <td>
                    <c:if test="${model.accountType==0}" >对公账户</c:if>
                    <c:if test="${model.accountType==1}" >对私账户</c:if>
                    <c:if test="${model.accountType==2}" >BGL</c:if>
                </td>
            </tr>
            <tr>

                <td class="lgridlist"><%=MerchantBase.ALLAS_STATE%>
                </td>
                <td>
                    <c:if test="${model.state==0}" >已复合</c:if>
                    <c:if test="${model.state==1}" >未复合</c:if>
                </td>

                <td class="lgridlist"><%=MerchantBase.ALLAS_SCAN_TYPE%></td>
                <td>
                    <c:if test="${model.scanType==0}" >正扫</c:if>
                    <c:if test="${model.scanType==1}" >反扫</c:if>
                    <c:if test="${model.scanType==2}" >全扫</c:if>
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
