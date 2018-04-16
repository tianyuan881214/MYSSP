<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*" %>
<html>
<head>
    <title>支付宝清算报表
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
            var finishDateTimeBegin = document.getElementById("finishDateTimeBegin").value;
            var finishDateTimeEnd = document.getElementById("finishDateTimeEnd").value;

            if (finishDateTimeBegin == null || finishDateTimeBegin == '' || finishDateTimeEnd == null || finishDateTimeEnd == '') {
                check = false;
            }
            if (!check) {
                tranDate.innerHTML = "日期不可为空";
            } else {
                var d1 = new Date(finishDateTimeEnd.substring(0, 4) + "/" + finishDateTimeEnd.substring(4, 6) + "/" + finishDateTimeEnd.substring(6, 8));
                var d = new Date(finishDateTimeBegin.substring(0, 4) + "/" + finishDateTimeBegin.substring(4, 6) + "/" + finishDateTimeBegin.substring(6, 8));
                var m = (d1.getTime() - d.getTime()) / (1000 * 60 * 60 * 24);
                //alert(m);  //24
                if (m > 10) {
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
        当前位置：报表管理&nbsp;〉&nbsp;支付宝清算报表
    </p>
    <p class="line"></p>
</div>

<mvc:form id="queryForm" name="queryForm" action="list.do"
          method="post" style="display: inline;" commandName="query">

    <div id="content">
        <div class="biaoti">
            <p>
                <b>支付宝清算报表</b>
            </p>
        </div>
        <div class="biao">
            <table class="grid">

                <tr>
                    <td class="lgridlist" colspan="4">支付宝清算报表</td>
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
                    <td class="crosscolor_td">商户号
                    </td>
                    <td>
                        <input onkeyup="this.value=this.value.replace(/\D/g,'')"
                               onafterpaste="this.value=this.value.replace(/\D/g,'')"
                               type="text" value="${query.merchantId}" id="merchantId" name="merchantId"
                               maxlength="40" class=""/>
                    </td>
                    <td class="crosscolor_td">清算时间
                    </td>
                    <td>
                        <input id="finishDateTimeBegin" name="finishDateTimeBegin"
                               value="${query.finishDateTimeBegin}" maxlength="8"
                               class="Wdate" type="text"
                               onFocus="WdatePicker({dateFmt:'yyyyMMdd',maxDate:'#F{$dp.$D(\'finishDateTimeEnd\')}'})"/>
                        &nbsp;到&nbsp;
                        <input id="finishDateTimeEnd" name="finishDateTimeEnd"
                               value="${query.finishDateTimeEnd}" maxlength="8"
                               class="Wdate" type="text"
                               onFocus="WdatePicker({dateFmt:'yyyyMMdd',minDate:'#F{$dp.$D(\'finishDateTimeBegin\')}'})"/>
                        <span style="color: red" id="tranDateMsg">*</span>
                    </td>
                </tr>
                <tr>
                    <td>商户名称
                    </td>
                    <td>
                        <input type="text" value="${query.merchantCname}" id="merchantCname" name="merchantCname"
                               maxlength="40" class=""/>
                    </td>
                    <td class="crosscolor_td">所属机构</td>
                    <td>
                        <select id="orgId" name="orgId">
                            <option value="">--请选择--</option>
                            <c:forEach items="${orgs}" var="item" varStatus="status">
                                <option value="${item.orgId}">${item.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                        <%--<mvc:select path="orgId" id="orgId" >
                            <mvc:option value="">--请选择--</mvc:option>
                            <mvc:options items="${orgs}" itemValue="orgId" itemLabel="name"/>
                        </mvc:select>--%>
                        <%--<mvc:select path="pOrgId" id="lowerOrgId">
                            <mvc:option value="">--请选择--</mvc:option>
                            <mvc:options items="${lowerOrgs}" itemValue="orgId" itemLabel="name"/>
                        </mvc:select>--%>

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
                               onclick="if (checkOnSubmit(this)){ getReferenceForm(this).action='list.do';}else {return checkOnSubmit();}"/>
                    </td>
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
                        <th>商户号</th>
                        <th>商户名称</th>
                        <th>支付宝商户号</th>
                        <th>支付宝订单号</th>
                        <th>所属机构</th>
                        <th>二级机构</th>
                       <%-- <th>交易状态</th>--%>
                        <th>交易金额</th>
                        <th>总手续费</th>
                        <th>清算金额</th>
                        <th>支付宝服务费</th>
                            <%--<th>微信扣率</th>--%>
                        <th>其他分行分润</th>
                        <th>本行分润</th>
                        <th>公司分润</th>
                        <th>账号类型</th>
                        <th>交易日期</th>
                        <th>清算日期</th>
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
                            <td align="center"><c:out value='${item.storeId}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.outTradeNo}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.firsetName}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.secondName}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.orderAmout}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.amountFee}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.settleAmount}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.serviceCharge}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.myFee}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.othFee}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.gsFee}'/>&nbsp;</td>
                            <c:if test="${item.accountType ==0 }">
                                <td align="center"><c:out value='对公'/>&nbsp;</td>
                            </c:if>
                            <c:if test="${item.accountType ==1 }">
                                <td align="center"><c:out value='对私'/>&nbsp;</td>
                            </c:if>
                            <td align="center"><c:out value='${item.finishDate}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.settleDate}'/>&nbsp;</td>
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
