<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*" %>
<html>
<head>
    <title>二级行清算
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

            if (tranDateTimeBegin == null || tranDateTimeBegin == ''||tranDateTimeEnd == null || tranDateTimeEnd == '') {
                check = false;
            }
            if (!check) {
                tranDate.innerHTML = "日期不可为空";
            }else{
                var  d1   =new Date (tranDateTimeBegin.substring(0,4)+"/"+tranDateTimeBegin.substring(4,6)+"/"+tranDateTimeBegin.substring(6,8));
                var  d   = new Date (tranDateTimeEnd.substring(0,4)+"/"+tranDateTimeEnd.substring(4,6)+"/"+tranDateTimeEnd.substring(6,8));
                var m = (d.getTime()-d1.getTime())/(1000*60*60*24);
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
                                if(org.orgId!='union'){
                                    dojo.create("option", {
                                        value: org.orgId,
                                        innerHTML: org.name
                                    }, node);
                                }
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


<mvc:form id="queryForm" name="queryForm" action="list.do"
          method="post" style="display: inline;" commandName="query">

    <div id="content">
        <div class="biaoti">
            <p>
                <b>二级行清算</b>
            </p>
        </div>
        <div class="biao">
            <table class="grid">

                <tr>
                    <td class="lgridlist" colspan="4">二级行清算</td>
                </tr>
                <tr>
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
                    <td></td><td></td>
                </tr>
                <tr>
                    <td class="crosscolor_td">所属机构</td>
                    <td>
                        <mvc:select path="orgId" id="orgId" >
                            <mvc:option value="">--请选择--</mvc:option>
                            <mvc:options items="${orgs}" itemValue="orgId" itemLabel="name"/>
                        </mvc:select>

                    </td>
                    <td class="crosscolor_td">业务渠道
                    </td>
                    <td>
                        <select id="businessBase" name="businessBase">
                            <option value="">请选择</option>
                            <option value="alipay" <c:if test="${query.businessBase == 'alipay'}">selected</c:if>>支付宝 </option>
                            <option value="webchant" <c:if test="${query.businessBase == 'webchant'}">selected</c:if>>微信 </option>
                        </select>
                 <%--       <mytag:select dictName="D_SOURCE" name="businessBase" value="${query.businessBase}"
                                      notEmpty="false"></mytag:select>--%>
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
                        <th>二级行机构号</th>
                        <th>二级行机构名称</th>
                        <th>总交易笔数</th>
                        <th>总交易金额</th>
                        <th>总手续费</th>
                        <th>服务费</th>
                        <th>其他行分润</th>
                        <th>公司分润</th>
                        <th>本行分润</th>
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
                           <%-- <td align="center">&nbsp;</td>
                            <td align="center">&nbsp;</td>--%>
                        </tr>
                    </c:if>
                    <c:forEach items="${page.result}" var="item" varStatus="status">
                        <tr class="${status.count % 2 == 0 ? 'odd' : 'even'}">
                            <%--<td align="center"><mytag:write dictName="D_SOURCE" value="${item.businessBase}"/>&nbsp;</td>--%>
                            <td align="center"><c:out value='${item.orgId}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.name}'/>&nbsp;</td>
                            <%--<td align="center"><c:out value='${item.firstOrgId}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.firstName}'/>&nbsp;</td>--%>
                            <td align="center"><c:out value='${item.tCount}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.totalAmount}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.amountFee}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.fee}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.othFee}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.gsFee}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.myFee}'/>&nbsp;</td>
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
