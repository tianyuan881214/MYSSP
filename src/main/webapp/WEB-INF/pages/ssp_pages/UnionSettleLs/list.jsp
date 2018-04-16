<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*" %>
<html>
<head>
    <title>银联对账文件
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
            var finishDateTimeBegin = document.getElementById("tranDateTimeBegin").value;
            var finishDateTimeEnd = document.getElementById("tranDateTimeEnd").value;

            if (finishDateTimeBegin == null || finishDateTimeBegin == ''||finishDateTimeEnd == null || finishDateTimeEnd == '') {
                check = false;
            }
            if (!check) {
                tranDate.innerHTML = "日期不可为空";
            }else{
                var  d1   =new Date (finishDateTimeEnd.substring(0,4)+"/"+finishDateTimeEnd.substring(4,6)+"/"+finishDateTimeEnd.substring(6,8));
                var  d   = new Date (finishDateTimeBegin.substring(0,4)+"/"+finishDateTimeBegin.substring(4,6)+"/"+finishDateTimeBegin.substring(6,8));
                var m = (d1.getTime()-d.getTime())/(1000*60*60*24);
                //alert(m);  //24
                if(m>10) {
                    tranDate.innerHTML = "时间间隔不能大于10天";
                    check = false;
                }
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
        当前位置：报表管理&nbsp;〉&nbsp;银联对账报表
    </p>
    <p class="line"></p>
</div>

<mvc:form id="queryForm" name="queryForm" action="list.do"
          method="post" style="display: inline;" commandName="query">

    <div id="content">
        <div class="biaoti">
            <p>
                <b>银联对账查询</b>
            </p>
        </div>
        <div class="biao">
            <table class="grid">

                <tr>
                    <td class="lgridlist" colspan="4">银联对账报表</td>
                </tr>
                   <%-- <tr>
                        <td class="crosscolor_td">交易类型
                        </td>
                        <td>
                            <mytag:select property="%{model.tranStart}"
                                          styleClass="required validate-selection" name="tranStart"
                                          notEmpty="false" dictName="D_TRAN_TYPE_W" id="tranStart"/>
                        </td>
                        <td class="crosscolor_td">商户号
                        </td>
                        <td>
                            <input type="text" value="${query.merchantId}" id="merchantId" name="merchantId"
                                   maxlength="15" class=""/>
                        </td>
                    </tr>--%>
                <tr>
                    <td class="crosscolor_td">商户订单号
                    </td>
                    <td>
                        <input type="text" value="${query.orderId}" id="outTradeNo" name="orderId"
                               maxlength="64" class=""/>
                    </td>
                    <td class="crosscolor_td">交易时间
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
                <tr>
                    <td >商户名称
                    </td>
                    <td>
                        <input type="text" value="${query.merchantCname}" id="merchantCname" name="merchantCname"
                               maxlength="64" class=""/>
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

               <%-- <tr>
                    <td class="crosscolor_td">所属机构</td>
                    <td>
                        <mvc:select path="orgId" id="orgId" >
                            <mvc:option value="">--请选择--</mvc:option>
                            <mvc:options items="${orgs}" itemValue="orgId" itemLabel="name"/>
                        </mvc:select>
                            &lt;%&ndash;<mvc:select path="pOrgId" id="lowerOrgId">
                                <mvc:option value="">--请选择--</mvc:option>
                                <mvc:options items="${lowerOrgs}" itemValue="orgId" itemLabel="name"/>
                            </mvc:select>&ndash;%&gt;

                    </td>

                    <td >&nbsp;</td>
                    <td >&nbsp;</td>
                </tr>--%>
            </table>
            <table class="b">
                <tr align="center">
                    <td width="200px"></td>
                    <td><input type="submit" style="width: 80px" value="查询"
                               onclick="if (checkOnSubmit(this)){ getReferenceForm(this).action='list.do';}else {return checkOnSubmit();}"/></td>
                    <td>
                        <input type="submit" style="width: 80px" value="导出"
                               onclick="if (checkOnSubmit(this)){ getReferenceForm(this).action='downloadWebCheckFileReport.do';}else {return checkOnSubmit();}">
                    </td>
                </tr>
            </table>
        </div>
        <div class="form">
            <div id="eXtremeTable" class="eXtremeTable">
                <table class="grid its">
                    <thead>
                    <tr>
                       <%-- <th>操作</th>--%>
                            <th>商户号</th>
                           <th>商户订单号</th>
                           <th>商户名称</th>
                           <th>账单号码</th>
                           <th>账单类型</th>
                           <th>业务类型</th>
                           <th>清算净额</th>
                           <th>结算金额</th>
                           <th>商户手续费</th>
                           <th>他行手续费</th>
                           <th>本行手续费</th>
                           <th>公司手续费</th>
                           <th>总手续费</th>
                           <th>银行类别</th>
                           <th>所属机构</th>
                           <th>清算日期</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${page.totalCount == 0}">
                        <tr class="even">
                            <td>没有数据</td>
                            <td align="center">&nbsp;</td>
                            <%--<td align="center">&nbsp;</td>
                            <td align="center">&nbsp;</td>--%>
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
                                <%--  <td align="center">&nbsp;</td>--%>
                        </tr>
                    </c:if>
                    <c:forEach items="${page.result}" var="item" varStatus="status">
                        <tr class="${status.count % 2 == 0 ? 'odd' : 'even'}">
                                     <%-- <td><a href="${ctx}/unionSettleLs/show.do?id=${item.orderId}">查看|>></a></td>--%>
                                       <td align="center"><c:out value='${item.merchantId}'/>&nbsp;</td>
                                       <td align="center"><c:out value='${item.orderId}'/>&nbsp;</td>
                                         <td align="center"><c:out value='${item.merchantCname}'/>&nbsp;</td>
                                        <td align="center"><c:out value='${item.billNo}'/>&nbsp;</td>
                                         <td align="center"><c:out value='${item.accType}'/>&nbsp;</td>
                                        <td align="center"><c:out value='${item.bizType}'/>&nbsp;</td>
                                     <td align="center"><c:out value='${item.liquindationAmt}'/>&nbsp;</td>
                                          <td align="center"><c:out value='${item.settleementAmt}'/>&nbsp;</td>
                                         <td align="center"><c:out value='${item.merchantFee}'/>&nbsp;</td>
                                          <td align="center"><c:out value='${item.othFee}'/>&nbsp;</td>
                                          <td align="center"><c:out value='${item.myFee}'/>&nbsp;</td>
                                          <td align="center"><c:out value='${item.gsFee}'/>&nbsp;</td>
                                          <td align="center"><c:out value='${item.amoutFee}'/>&nbsp;</td>
                                            <c:if test="${item.isOthAccount == 0}">
                                                <td align="center"><c:out value='本行账号'/>&nbsp;</td>
                                            </c:if>
                                            <c:if test="${item.isOthAccount == 1}">
                                                <td align="center"><c:out value='他行账号'/>&nbsp;</td>
                                            </c:if>
                                <td align="center"><c:out value='${item.name}'/>&nbsp;</td>
                                         <td align="center"><c:out value='${item.liquidationTime}'/>&nbsp;</td>

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
