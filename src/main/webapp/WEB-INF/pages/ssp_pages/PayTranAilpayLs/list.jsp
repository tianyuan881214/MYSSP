<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*" %>
<html>
<head>
    <title>支付宝流水
    </title>
    <%@include file="../../base_pages/base.jsp" %>
    <script src="<c:url value="/js/teletext.js"/>" type="text/javascript"></script>
    <script src="<c:url value="/js/application.js"/>" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="../css/dqwz.css">
    <script type="text/javascript">
        var form = document.forms.queryForm;
        var onsbmt = true;
        function checkOnSubmit() {
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
        function checkMax() {
            var date = new Date();
            var vYear = date.getFullYear();
            var vMon = date.getMonth() + 1;
            var vDay = date.getDate();
            var today=vYear+vMon+vDay;
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
        当前位置：综合支付业务&nbsp;〉&nbsp;支付宝流水
    </p>
    <p class="line"></p>
</div>

<mvc:form id="queryForm" name="queryForm" action="list.do"
          method="post" style="display: inline;" data-dojo-type="dijit.form.Form" commandName="query">

    <div id="content">
        <div class="biaoti">
            <p>
                <b>支付宝流水查询</b>
            </p>
        </div>
        <div class="biao">
            <table class="grid">

                <tr>
                    <td class="lgridlist" colspan="4">支付宝流水查询</td>
                </tr>
                <tr>
                    <td class="crosscolor_td">商户编号
                    </td>
                    <td>
                        <input type="text" value="${query.storeId}" id="storeId" name="storeId" maxlength="15" class=""/>
                        <%--<span style="color: red" id="storeIdMsg">*</span>--%>
                    </td>
                    <td class="crosscolor_td">商户订单号
                    </td>
                    <td>
                        <input type="text" value="${query.outTradeNo}" id="outTradeNo" name="outTradeNo"
                               maxlength="32" class=""/>
                    </td>
                </tr>
                <tr>
                    <td class="crosscolor_td">入账账号
                    </td>
                    <td>
                        <input type="text" value="${query.accountNo}" id="accountNo" name="accountNo"
                               class=""/>
                    </td>
                    <td class="crosscolor_td">终端号
                    </td>
                    <td>
                        <input type="text" value="${query.terminalId}" id="terminalId" name="terminalId"
                               class=""/>
                    </td>
                </tr>
                <tr>
                    <td class="crosscolor_td">支付宝交易号
                    </td>
                    <td>
                        <input type="text" value="${query.tradeNo}" id="tradeNo" name="tradeNo"
                               maxlength="64" class=""/>
                    </td>
                    <td class="crosscolor_td">买家支付宝账号
                    </td>
                    <td>
                        <input type="text" value="${query.buyerLoginId}" id="buyerLoginId" name="buyerLoginId"
                               maxlength="50" class=""/>
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


                    <td class="crosscolor_td">交易日期
                    </td>
                    <td>
                        <input id="tranDateTimeBegin" name="tranDateTimeBegin"
                               value="${query.tranDateTimeBegin}" maxlength="8"
                               class="Wdate" type="text"
                               onFocus="WdatePicker({dateFmt:'yyyyMMdd',maxDate:'#F{$dp.$D(\'tranDateTimeEnd\')}'})" />
                        &nbsp;到&nbsp;
                        <input id="tranDateTimeEnd" name="tranDateTimeEnd"
                               value="${query.tranDateTimeEnd}" maxlength="8"
                               class="Wdate" type="text"
                               onFocus="WdatePicker({dateFmt:'yyyyMMdd',minDate:'#F{$dp.$D(\'tranDateTimeBegin\')}'})" />
                        <span style="color: red" id="tranDateMsg">*</span>
                    </td>
                </tr>
            </table>
            <table class="b">
                <tr align="center">
                    <td width="200px"></td>
                    <td><input type="submit" style="width: 80px" value="查询"
                               onclick="if (checkOnSubmit(this)){ getReferenceForm(this).action='list.do';}else {return checkOnSubmit();}"/></td>
                   <%-- <td>
                        <input type="submit" style="width: 80px" value="导出"
                               onclick="if (checkOnSubmit(this)){ getReferenceForm(this).action='downloadPayTranAlipayLsReport.do';}else {return checkOnSubmit();}">
                    </td>--%>
                </tr>
            </table>
        </div>
        <div class="form">
            <div id="eXtremeTable" class="eXtremeTable">
                <table class="grid its">
                    <thead>
                    <tr>
                        <th>操作</th>
                        <th>商户号</th>
                        <th>商户名称</th>
                        <th>商户订单号</th>
                        <th>支付宝交易号</th>
                        <th>交易金额</th>
                        <th>交易类型</th>
                        <th>交易日期</th>
                        <th>交易时间</th>
                        <th>交易结果</th>
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
                            <td align="center">&nbsp;</td>
                            <td align="center">&nbsp;</td>
                        </tr>
                    </c:if>
                    <c:forEach items="${page.result}" var="item" varStatus="status">
                        <tr class="${status.count % 2 == 0 ? 'odd' : 'even'}">
                            <td align="center">
                                <a href="${ctx}/paytranalipayls/show.do?id=${item.outTradeNo}">查看>></a>
                            <td align="center"><c:out value='${item.storeId}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.storeName}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.outTradeNo}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.tradeNo}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.totalAmount}'/>&nbsp;</td>
                            <td align="center"><mytag:write dictName="D_TRAN_TYPE" value="${item.tranType}"/>
                                &nbsp;</td>
                            <td align="center"><c:out value='${item.tranDate}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.tranTime}'/>&nbsp;</td>
                            <td align="center">
                                <c:if test="${item.code=='10000'}">成功</c:if>
                                <c:if test="${item.code!='10000'}">失败</c:if>
                            </td>
                            <td align="center"><c:out value='${item.inOrg}'/>&nbsp;</td>
                        </tr>
                    </c:forEach>
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
