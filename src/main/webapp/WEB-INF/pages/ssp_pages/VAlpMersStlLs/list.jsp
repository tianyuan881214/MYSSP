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
        当前位置：报表管理&nbsp;〉&nbsp;商户对账报表
    </p>
    <p class="line"></p>
</div>

<mvc:form id="queryForm" name="queryForm" action="list.do"
          method="post" style="display: inline;" commandName="query">

    <div id="content">
        <div class="biaoti">
            <p>
                <b>商户对账报表查询</b>
            </p>
        </div>
        <div class="biao">
            <table class="grid">

                <tr>
                    <td class="lgridlist" colspan="4">商户对账报表查询</td>
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
                    <c:if test="${orgLev=='1'}">
                        <td class="crosscolor_td">所属机构</td>
                        <td colspan="3">
                            <mvc:select path="orgId" id="orgId" onchange="findlowerOrg(this.value);">
                                <mvc:option value="">--请选择--</mvc:option>
                                <mvc:options items="${orgs}" itemValue="orgId" itemLabel="name"/>
                            </mvc:select>
                            <mvc:select path="pOrgId" id="lowerOrgId">
                                <mvc:option value="">--请选择--</mvc:option>
                                <mvc:options items="${lowerOrgs}" itemValue="orgId" itemLabel="name"/>
                            </mvc:select>

                        </td>
                    </c:if>
                    <c:if test="${orgLev=='2'}">
                        <td class="crosscolor_td">所属机构</td>
                        <td colspan="3">
                            <select name="pOrgId">
                                <option value="">--请选择--</option>
                                <c:forEach items="${orgs}" var="item">
                                    <option value="${item.orgId}" <c:if test="${query.pOrgId==item.orgId}">selected</c:if>>${item.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </c:if>
                    <c:if test="${orgLev=='3'}">
                        <td class="crosscolor_td">所属机构</td>
                        <td colspan="3">
                            <input type="hidden" value="${org.orgId}" name="pOrgId"/>
                                ${org.name}
                        </td>
                    </c:if>

                </tr>
            </table>
            <table class="b">
                <tr align="center">
                    <td width="200px"></td>

                    <td><input type="submit" style="width: 80px" value="查询"
                               onclick="if (existDate(this)){ getReferenceForm(this).action='list.do';}else {return existDate();}"/></td>
                    <td>
                        <input type="submit" style="width: 80px" value="导出"
                               onclick="if (existDate(this)){ getReferenceForm(this).action='downloadVAlpMersStlLsReport.do';}else {return existDate();}">
                    </td>
                </tr>
            </table>
        </div>
        <div class="form">
            <div id="eXtremeTable" class="eXtremeTable">
                <table class="grid its">
                    <thead>
                    <tr>
                        <th>商户号</th>
                        <th>商户名称</th>
                        <th>终端号</th>
                        <th>批次号</th>
                        <th>交易卡号</th>
                        <th>交易日期</th>
                        <th>交易时间</th>
                        <th>交易金额</th>
                        <th>手续费</th>
                        <th>结算金额</th>
                        <th>授权码</th>
                        <th>交易码</th>
                        <th>分期期数</th>
                        <th>卡别</th>
                        <th>参考码</th>
                        <th>机构名称</th>
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
                            <td align="center">&nbsp;</td>
                            <td align="center">&nbsp;</td>
                            <td align="center">&nbsp;</td>
                            <td align="center">&nbsp;</td>
                            <td align="center">&nbsp;</td>
                        </tr>
                    </c:if>
                    <c:forEach items="${page.result}" var="item" varStatus="status">
                        <tr class="${status.count % 2 == 0 ? 'odd' : 'even'}">
                            <td align="center"><c:out value='${item.merchantId}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.merchantCname}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.terminalId}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.batchNo}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.oppositeId}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.tranDate}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.tranTime}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.tranAmt}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.tranFee}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.settleAmt}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.authNo}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.tranCode}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.fqqs}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.cardType}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.tradeNo}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.name}'/>&nbsp;</td>
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
