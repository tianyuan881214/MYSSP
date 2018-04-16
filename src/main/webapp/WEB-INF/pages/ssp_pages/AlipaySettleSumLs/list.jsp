<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*" %>
<html>
<head>
    <title>支付宝对账汇总
    </title>
    <%@include file="../../base_pages/base.jsp" %>
    <script src="<c:url value="/js/teletext.js"/>" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="../css/dqwz.css">
    <script type="text/javascript">
        function existDate() {
            var check = true;
            var tranDate = document.getElementById("tranDateMsg");
            var settleDateTimeBegin = document.getElementById("settleDateTimeBegin").value;
            var settleDateTimeEnd = document.getElementById("settleDateTimeEnd").value;
            if(settleDateTimeBegin==null || settleDateTimeBegin ==''){
                check = false;
            }
            if(settleDateTimeEnd==null || settleDateTimeEnd ==''){
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
        当前位置：综合支付业务&nbsp;〉&nbsp;支付宝对账汇总
    </p>
    <p class="line"></p>
</div>

<mvc:form id="queryForm" name="queryForm" action="list.do"
          method="post" style="display: inline;" commandName="query">

    <div id="content">
        <div class="biaoti">
            <p>
                <b>账汇总查询</b>
            </p>
        </div>
        <div class="biao">
            <table class="grid">

                <tr>
                    <td class="lgridlist" colspan="4">对账汇总查询</td>
                </tr>
                <tr>
                    <td class="crosscolor_td">商户号
                    </td>
                    <td>
                        <input type="text" value="${query.storeId}" id="storeId" name="storeId"
                               maxlength="30" class=""/>
                    </td>
                    <td class="crosscolor_td">交易时间
                    </td>
                    <td>
                        <input id="settleDateTimeBegin" name="settleDateTimeBegin"
                               value="${query.settleDateTimeBegin}" maxlength="8"
                               class="Wdate" type="text"
                               onFocus="WdatePicker({dateFmt:'yyyyMMdd',maxDate:'#F{$dp.$D(\'settleDateTimeEnd\')}'})" />
                        &nbsp;到&nbsp;
                        <input id="settleDateTimeEnd" name="settleDateTimeEnd"
                               value="${query.settleDateTimeEnd}" maxlength="8"
                               class="Wdate" type="text"
                               onFocus="WdatePicker({dateFmt:'yyyyMMdd',minDate:'#F{$dp.$D(\'settleDateTimeBegin\')}'})" />
                        <span style="color: red" id="tranDateMsg">*</span>
                    </td>
                </tr>
                <td class="crosscolor_td">业务渠道
                </td>
                <td>
                    <mytag:select dictName="D_SOURCE" name="businessBase" value="${query.businessBase}"
                                  notEmpty="false"></mytag:select>
                </td>
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
                    </td>
                </tr>
            </table>
        </div>
        <div class="form">
            <div id="eXtremeTable" class="eXtremeTable">
                <table class="grid its">
                    <thead>
                <tr>
                    <th>业务渠道</th>
                    <th>门店编号</th>
                    <th>门店名称</th>
                    <th>订单金额（元）</th>
                    <th>商家实收（订单金额-退款金额）</th>
                    <th>服务费（元）</th>
                    <th>实收净额（元）</th>
                    <th>结算日期</th>
                    <th>归属机构</th>
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
                        </tr>
                    </c:if>
                    <c:forEach items="${page.result}" var="item" varStatus="status">
                        <tr class="${status.count % 2 == 0 ? 'odd' : 'even'}">
                            <td align="center"><mytag:write dictName="D_SOURCE" value="${item.businessBase}"/>&nbsp;</td>
                            <td align="center"><c:out value='${item.storeId}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.storeName}'/>&nbsp;</td>
                                <td align="center"><c:out value='${item.orderSumAmt}'/>&nbsp;</td>
                                <td align="center"><c:out value='${item.merchantSettleAmt}'/>&nbsp;</td>
                                <td align="center"><c:out value='${item.serviceAmt}'/>&nbsp;</td>
                                <td align="center"><c:out value='${item.netAmount}'/>&nbsp;</td>
                                <td align="center"><c:out value='${item.settleDate}'/>&nbsp;</td>
                                <td align="center"><c:out value='${item.inOrg}'/>&nbsp;</td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <th>合计：</th>
                        <th></th>
                        <th></th>
                        <th>订单金额合计：
                            <c:if test="${alipaySettleSumLs.orderSumAmt == null || alipaySettleSumLs.orderSumAmt == ''}">0</c:if>
                            <c:if test="${alipaySettleSumLs.orderSumAmt != null && alipaySettleSumLs.orderSumAmt != ''}">${alipaySettleSumLs.orderSumAmt}</c:if>
                        </th>
                        <th>商家实收合计：
                            <c:if test="${alipaySettleSumLs.merchantSettleAmt == null || alipaySettleSumLs.merchantSettleAmt == ''}">0</c:if>
                            <c:if test="${alipaySettleSumLs.merchantSettleAmt != null && alipaySettleSumLs.merchantSettleAmt != ''}">${alipaySettleSumLs.merchantSettleAmt}</c:if>
                        </th>

                        <th>服务费合计：
                            <c:if test="${alipaySettleSumLs.serviceAmt == null || alipaySettleSumLs.serviceAmt == ''}">0</c:if>
                            <c:if test="${alipaySettleSumLs.serviceAmt != null && alipaySettleSumLs.serviceAmt != ''}">${alipaySettleSumLs.serviceAmt}</c:if>
                        </th>
                        <th>实收净额合计：
                            <c:if test="${alipaySettleSumLs.netAmount == null || alipaySettleSumLs.netAmount == ''}">0</c:if>
                            <c:if test="${alipaySettleSumLs.netAmount != null && alipaySettleSumLs.netAmount != ''}">${alipaySettleSumLs.netAmount}</c:if>
                        </th>
                        <th></th>
                        <th></th>
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
