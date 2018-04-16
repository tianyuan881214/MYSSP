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
    <link rel="stylesheet" type="text/css" href="../css/dqwz.css">
    <script type="text/javascript">
        function existDate() {
            var check = true;
            var tranDate = document.getElementById("tranDateMsg");
            var tranDateTimeBegin = document.getElementById("tranDateTimeBegin").value;
            var tranDateTimeEnd = document.getElementById("tranDateTimeEnd").value;
            if (tranDateTimeBegin == null || tranDateTimeBegin == '') {
                check = false;
            }
            if (tranDateTimeEnd == null || tranDateTimeEnd == '') {
                check = false;
            }
            if (!check) {
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
        当前位置：综合支付业务&nbsp;〉&nbsp;本地商户汇总管理
    </p>
    <p class="line"></p>
</div>

<mvc:form id="queryForm" name="queryForm" action="list.do"
          method="post" style="display: inline;" commandName="query">

    <div id="content">
        <div class="biaoti">
            <p>
                <b>本地商户汇总查询</b>
            </p>
        </div>
        <div class="biao">
            <table class="grid">

                <tr>
                    <td class="lgridlist" colspan="4">本地商户汇总查询</td>
                </tr>
                <tr>
                    <td class="crosscolor_td">业务渠道
                    </td>
                    <td>
                        <mytag:select dictName="D_SOURCE" name="source" value="${query.source}"
                                      notEmpty="false"></mytag:select>
                    </td>
                    <td class="crosscolor_td">商户号</td>
                    <td>
                        <input type="text" value="${query.merchantId}" id="merchantId" name="merchantId"
                               maxlength="15" class=""/>
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


                    <td class="crosscolor_td">日期
                    </td>
                    <td>
                        <input id="tranDateTimeBegin" name="tranDateTimeBegin" value="${query.tranDateTimeBegin}"
                               maxlength="8" class="Wdate" type="text"
                               onFocus="WdatePicker({dateFmt:'yyyyMMdd',maxDate:'#F{$dp.$D(\'tranDateTimeEnd\')}'})"/>
                        &nbsp;到&nbsp;
                        <input id="tranDateTimeEnd" name="tranDateTimeEnd" value="${query.tranDateTimeEnd}"
                               maxlength="8" class="Wdate" type="text"
                               onFocus="WdatePicker({dateFmt:'yyyyMMdd',minDate:'#F{$dp.$D(\'tranDateTimeBegin\')}'})"/>
                        <span style="color: red" id="tranDateMsg">*</span>
                    </td>

                </tr>
            </table>
            <table class="b">
                <tr align="center">
                    <td width="200px"></td>
                    <td><input type="submit" style="width: 80px" value="查询"
                               onclick="if (existDate(this)){ getReferenceForm(this).action='list.do';}else {return existDate();}"/>
                    </td>
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
                            <%--<th>操作</th>--%>
                        <th>业务渠道</th>
                        <th>商户号</th>
                        <th>商户名称</th>
                        <th>消费总笔数</th>
                        <th>消费总金额</th>
                        <th>退款总笔数</th>
                        <th>退款总金额</th>
                        <th>撤销总笔数</th>
                        <th>撤销总金额</th>
                        <th>所属机构</th>
                        <th>日期</th>
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
                                <mytag:write dictName="D_SOURCE" value="${item.source}"/>
                            </td>
                            <td align="center"><c:out value='${item.merchantId}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.merchantCname}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.sumConsume}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.sumConsumeAmt}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.sumRefund}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.sumRefundAmt}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.sumUndo}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.sumUndoAmt}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.name}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.date}'/>&nbsp;</td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <th>合计：</th>
                        <th></th>

                        <th>消费总笔数合计：
                            <c:if test="${tranSummer.sumConsume == null || tranSummer.sumConsume == ''}">0</c:if>
                            <c:if test="${tranSummer.sumConsume != null && tranSummer.sumConsume != ''}">${tranSummer.sumConsume}</c:if>
                        </th>
                        <th>消费总金额合计：
                            <c:if test="${tranSummer.sumConsumeAmt == null || tranSummer.sumConsumeAmt == ''}">0</c:if>
                            <c:if test="${tranSummer.sumConsumeAmt != null && tranSummer.sumConsumeAmt != ''}">${tranSummer.sumConsumeAmt}</c:if>
                        </th>
                        <th>退款总笔数合计：
                            <c:if test="${tranSummer.sumRefund == null || tranSummer.sumRefund == ''}">0</c:if>
                            <c:if test="${tranSummer.sumRefund != null && tranSummer.sumRefund != ''}">${tranSummer.sumRefund}</c:if>
                        </th>
                        <th>退款总金额合计：
                            <c:if test="${tranSummer.sumRefundAmt == null || tranSummer.sumRefundAmt == ''}">0</c:if>
                            <c:if test="${tranSummer.sumRefundAmt != null && tranSummer.sumRefundAmt != ''}">${tranSummer.sumRefundAmt}</c:if>
                        </th>
                        <th>撤销总笔数合计：
                            <c:if test="${tranSummer.sumUndo == null || tranSummer.sumUndo == ''}">0</c:if>
                            <c:if test="${tranSummer.sumUndo != null && tranSummer.sumUndo != ''}">${tranSummer.sumUndo}</c:if>
                        </th>
                        <th>撤销总金额合计：
                            <c:if test="${tranSummer.sumUndoAmt == null || tranSummer.sumUndoAmt == ''}">0</c:if>
                            <c:if test="${tranSummer.sumUndoAmt != null && tranSummer.sumUndoAmt != ''}">${tranSummer.sumUndoAmt}</c:if>
                        </th>
                        <th></th>
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
