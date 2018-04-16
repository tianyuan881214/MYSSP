<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*" %>
<html>
<head>
    <title><%=MerchantBase.TABLE_ALIAS%>
    </title>
    <%@include file="../../base_pages/base.jsp" %>
    <script src="<c:url value="/js/teletext.js"/>" type="text/javascript"></script>
    <script src="<c:url value="/js/jquery-1.4.1.js"/>" type="text/javascript"></script>
    <script src="<c:url value="/js/select_tree.js"/>" type="text/javascript"></script>
    <script src="<c:url value="/js/application.js"/>" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="../css/dqwz.css">
    <link rel="stylesheet" type="text/css" href="../css/dialog.css"/>
    <script type="text/javascript">
        function existDate() {
            var check = true;
            var tranDate = document.getElementById("tranDateMsg");
            var tranDateTimeBegin = document.getElementById("tranDateTimeBegin").value;
            var tranDateTimeEnd = document.getElementById("tranDateTimeEnd").value;
            if(tranDateTimeBegin==null || tranDateTimeBegin ==''){
                check = false;
            }
            if(tranDateTimeEnd==null || tranDateTimeEnd ==''){
                check = false;
            }
            if (!check){
                tranDate.innerHTML = "日期不可为空";
            }
            return check;
        }
        /**
         机构联动下级机构
         @param 机构ID
         */
        function findlowerOrg(orgId) {
            if (orgId) {

                //清空select,添加[--请选择--]option
                var node = dojo.byId("lowerOrgId");
                dojo.empty(node);

                /*---------------创建元素节点--------------*/
                dojo.create("option", {
                    value: "",
                    innerHTML: "--请选择--"
                }, node);

                dojo.xhrGet({
                    url: "AJAX_findlowerOrg.do",
                    sync: true,
                    content: {orgId: orgId, t: new Date().getTime()},
                    load: function (data) {
                        //用户名可用
                        if ("" != data) {
                            //解析用户分组
                            dojo.forEach(dojo.fromJson(data), function (org) {
                                dojo.create("option", {
                                    value: org.orgId,
                                    innerHTML: org.name
                                }, node);
                            });
                        }
                    },
                    error: function (error) {
                        alert(error);
                    }
                });

                findGrpByOrg(orgId);
            }
        }

    </script>
</head>
<body class="claro">
<div id="dqwz">
    <p>
        当前位置：综合支付业务&nbsp;〉&nbsp;对账汇总管理
    </p>
    <p class="line"></p>
</div>

<mvc:form id="queryForm" name="queryForm" action="list.do"
          method="post" style="display: inline;" commandName="query">

    <div id="content">
        <div class="biaoti">
            <p>
                <b>对账汇总查询</b>
            </p>
        </div>
        <div class="biao">
            <table class="grid">

                <tr>
                    <td class="lgridlist" colspan="4">对账汇总查询</td>
                </tr>
                <tr>
                    <td class="crosscolor_td">商户号</td>
                    <td>
                        <input type="text" value="${query.merchantId}" id="merchantId" name="merchantId"
                               maxlength="15" class=""/>
                    </td>
                    <td class="crosscolor_td">日期
                    </td>
                    <td>
                        <input id="tranDateTimeBegin" name="tranDateTimeBegin"
                               value="${query.tranDateTimeBegin}" maxlength="8"
                               class="Wdate" type="text"
                               onFocus="WdatePicker({dateFmt:'yyyyMMdd',maxDate:'#F{$dp.$D(\'tranDateTimeEnd\')}'})"/>
                        &nbsp;到&nbsp;
                        <input id="tranDateTimeEnd" name="tranDateTimeEnd"
                               value="${query.tranDateTimeEnd}" maxlength="8"
                               class="Wdate" type="text"
                               onFocus="WdatePicker({dateFmt:'yyyyMMdd',minDate:'#F{$dp.$D(\'tranDateTimeBegin\')}'})"/>
                        <span style="color: red" id="tranDateMsg">*</span>
                    </td>
                </tr>
                <tr>
                    <td class="crosscolor_td">所属机构</td>
                    <td>
                        <mvc:select path="orgId" id="orgId" >
                            <mvc:option value="">--请选择--</mvc:option>
                            <mvc:options items="${orgs}" itemValue="orgId" itemLabel="name"/>
                        </mvc:select>
                            <%--<mvc:select path="pOrgId" id="lowerOrgId">
                                <mvc:option value="">--请选择--</mvc:option>
                                <mvc:options items="${lowerOrgs}" itemValue="orgId" itemLabel="name"/>
                            </mvc:select>--%>

                    </td>
                    <td class="crosscolor_td">业务渠道
                    </td>
                    <td>
                        <mytag:select dictName="D_SOURCE" name="businessBase" value="${query.businessBase}"
                                      notEmpty="false"></mytag:select>
                    </td>
                </tr>

            </table>
            <table class="b">
                <tr align="center">
                    <td width="200px"></td>

                    <td><input type="submit" style="width: 80px" value="查询"
                               onclick="if (existDate(this)){ getReferenceForm(this).action='list.do';}else {return existDate();}"/></td>
                    <td>
                        <input type="submit" style="width: 80px" value="导出"
                               onclick="if (existDate(this)){ getReferenceForm(this).action='downloadErrorTranLsReport.do';}else {return existDate();}">
                        <%--window.location.href('downloadErrorTranLsReport.do')--%>
                    </td>
                </tr>
            </table>
        </div>
        <div class="form">
            <div id="eXtremeTable" class="eXtremeTable">
                <table class="grid its">
                    <thead>
                    <tr>
                        <th>业务名称</th>
                        <th>商户号</th>
                        <th>商户名</th>
                        <th>交易金额</th>
                        <th>支付宝收银行手续费</th>
                        <th>支付宝清算至银行金额</th>
                        <th>银行净收益（总手续费-支付宝手续费）</th>
                        <th>商户付总手续费</th>
                        <th>银行清算至商户金额</th>
                        <th>所属机构</th>
                        <th>交易日期</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${page.totalCount == 0}">
                        <tr class="even">
                            <td>没有数据</td>
                            <td align="center">&nbsp;</td>
                            <td align="center">&nbsp;</td>
                            <td align="center">&nbsp;</td>
                            <td align="center">&nbsp;</td>
                            <td align="center">&nbsp;</td>
                            <td align="center">&nbsp;</td>
                            <td align="center">&nbsp;</td>
                            <td align="center">&nbsp;</td>
                            <td align="center">&nbsp;</td>
                            <td align="center">&nbsp;</td>
                        </tr>
                    </c:if>
                    <c:forEach items="${page.result}" var="item" varStatus="status">
                        <tr class="${status.count % 2 == 0 ? 'odd' : 'even'}">
                            <td align="center"><mytag:write dictName="D_SOURCE" value="${item.businessBase}"/>&nbsp;</td>
                            <td align="center"><c:out value='${item.merchantId}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.merchantCname}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.orderSumAmt}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.serviceAmt}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.netAmount}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.merFee}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.merServiceAmt}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.settleAmt}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.name}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.tranDate}'/>&nbsp;</td>
                        </tr>
                    </c:forEach>
                        <tr>
                            <th>合计：</th>
                            <th></th>
                            <th></th>
                            <th>交易金额合计：
                                <c:if test="${vAlpBocStl.orderSumAmt == null || vAlpBocStl.orderSumAmt == ''}">0</c:if>
                                <c:if test="${vAlpBocStl.orderSumAmt != null && vAlpBocStl.orderSumAmt != ''}">${vAlpBocStl.orderSumAmt}</c:if>
                            </th>
                            <th>支付宝收银行手续费合计：
                                <c:if test="${vAlpBocStl.serviceAmt == null || vAlpBocStl.serviceAmt == ''}">0</c:if>
                                <c:if test="${vAlpBocStl.serviceAmt != null && vAlpBocStl.serviceAmt != ''}">${vAlpBocStl.serviceAmt}</c:if>
                            </th>
                            <th>支付宝清算至银行金额合计：
                                <c:if test="${vAlpBocStl.netAmount == null || vAlpBocStl.netAmount == ''}">0</c:if>
                                <c:if test="${vAlpBocStl.netAmount != null && vAlpBocStl.netAmount != ''}">${vAlpBocStl.netAmount}</c:if>
                            </th>
                            <th>银行净收益（总手续费-支付宝手续费）合计：
                                <c:if test="${vAlpBocStl.merFee == null || vAlpBocStl.merFee == ''}">0</c:if>
                                <c:if test="${vAlpBocStl.merFee != null && vAlpBocStl.merFee != ''}">${vAlpBocStl.merFee}</c:if>
                            </th>
                            <th>商户总付手续费 合计：
                                <c:if test="${vAlpBocStl.merServiceAmt == null || vAlpBocStl.merServiceAmt == ''}">0</c:if>
                                <c:if test="${vAlpBocStl.merServiceAmt != null && vAlpBocStl.merServiceAmt != ''}">${vAlpBocStl.merServiceAmt}</c:if>
                            </th>
                            <th>银行清算至商户金额合计：
                                <c:if test="${vAlpBocStl.settleAmt == null || vAlpBocStl.settleAmt == ''}">0</c:if>
                                <c:if test="${vAlpBocStl.settleAmt != null && vAlpBocStl.settleAmt != ''}">${vAlpBocStl.settleAmt}</c:if>
                            </th>
                            <th>&nbsp;</th>
                            <th>&nbsp;</th>

                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <simpletable:pageToolbar page="${page}">
        </simpletable:pageToolbar>
    </div>
</mvc:form>

</body>
</html>
