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
           // alert(check+"@");
            if(tranDateTimeBegin==null || tranDateTimeBegin ==''){
                check = false;
            }
           // alert(check+"B");
            if(tranDateTimeEnd==null || tranDateTimeEnd ==''){
                check = false;
            }
           // alert(check+"C");
            if (!check){
                tranDate.innerHTML = "日期不可为空";
            }
            //alert(check+"D");
            return check;
        }
        function showDialog() {
            document.getElementById("dialog").style.display = "block";
            document.getElementById("mask").style.display = "block";
        }
        function hideDialog1() {
            document.getElementById("dialog").style.display = "none";
            document.getElementById("mask").style.display = "none";
        }
        function hideDialog() {
            var check = false;
            document.getElementById("dialog").style.display = "none";
            document.getElementById("mask").style.display = "none";
            var reportLine = document.getElementsByName("reportLine");
            for (var i = 0; i < reportLine.length; i++) {
                if (reportLine[i].checked) {
                    check = true;
                }
            }
            if (!check){
                alert("请选择导出字段！");
            }
            return check;
        }
    </script>
</head>
<body class="claro">
<div id="dqwz">
    <p>
        当前位置：综合支付业务&nbsp;〉&nbsp;差错报表管理
    </p>
    <p class="line"></p>
</div>

<mvc:form id="queryForm" name="queryForm" action="list.do"
          method="post" style="display: inline;" commandName="query">

    <div id="content">
        <div class="biaoti">
            <p>
                <b>差错报表查询</b>
            </p>
        </div>
        <div class="biao">
            <table class="grid">

                <tr>
                    <td class="lgridlist" colspan="4">差错报表查询</td>
                </tr>
                <tr>
                    <td class="crosscolor_td">业务渠道
                    </td>
                    <td>
                        <mytag:select dictName="D_TRAN_SOURCES" name="tranSources" value="${query.tranSources}"
                                      notEmpty="false"></mytag:select>
                    </td>
                    <td class="crosscolor_td">对账关系</td>
                    <td>
                        <mytag:select dictName="D_ACCOUNT_RELATION" name="accountRelation"
                                      value="${query.accountRelation}"
                                      notEmpty="false"></mytag:select>
                    </td>
                </tr>
                <tr>
                    <td class="crosscolor_td">差错原因
                    </td>
                    <td>
                        <mytag:select dictName="D_ERROR_CAUSE" name="errorCause" value="${query.errorCause}"
                                      notEmpty="false"></mytag:select>
                    </td>
                    <td class="crosscolor_td">商户号</td>
                    <td>
                        <input type="text" name="merchantId" value="${query.merchantId}">
                    </td>
                </tr>
                <tr>

                    <td class="crosscolor_td">日期
                    </td>
                    <td colspan="3">
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
            </table>
            <table class="b">
                <tr align="center">
                    <td width="200px"></td>
                    <td><input type="submit" style="width: 80px" value="查询"
                               onclick="if (existDate(this)){ getReferenceForm(this).action='list.do';}else {return existDate();}"/></td>
                    <td><input type="button" style="width:80px" value="导出"
                               onclick="showDialog()"/></td>
                </tr>
            </table>
        </div>
        <div class="form">
            <div id="eXtremeTable" class="eXtremeTable">
                <table class="grid its">
                    <thead>
                    <tr>
                        <th>操作</th>
                        <th>业务渠道</th>
                        <%--所属机构--%>
                       <%-- <th><%=MerchantBase.ALIAS_ZBANK%>--%>
                        <th>商户号</th>
                        <th>对账关系</th>
                        <th>差错原因</th>
                        <th>交易类型</th>
                        <th>交易卡号</th>
                        <th>交易金额</th>
                        <th>批次号</th>
                        <th>交易日期</th>
                        <th>交易时间</th>
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
                                <a href="${ctx}/errortranls/show.do?id=${item.id}&<mytag:params includes="s_*" type="queryStringUtf"/>">查看>></a><%--
                                    &nbsp;|&nbsp;<a
                                        href="${ctx}/merchantbase/edit.do?id=${item.merchantId}&<mytag:params includes="s_*" type="queryStringUtf"/>">编辑|<< </a>
                                    &nbsp;|&nbsp;<a href="${ctx}/pages/MerchantBase/delete.do?merchantId=${item.merchantId}&" onclick="ajax_doDel(${item.merchantId });">删除>></a>--%>
                            </td>
                            <td align="center">
                                <mytag:write dictName="D_TRAN_SOURCES" value="${item.tranSources}"></mytag:write>
                            </td>
                            <td align="center"><c:out value='${item.merchantId}'/>&nbsp;</td>
                            <td align="center"><mytag:write dictName="D_ACCOUNT_RELATION" value="${item.accountRelation}"/></td>
                          <%--  <td align="center"><mytag:write value="${item.zbank}" dictName="D_ORG"/>&nbsp;</td>--%>
                            <td align="center"><mytag:write dictName="D_ERROR_CAUSE" value="${item.errorCause}"/></td>
                            <td align="center"><mytag:write dictName="D_TRAN_TYPE" value="${item.tranType}"/></td>
                            <td align="center"><c:out value='${item.cardNo}'/>&nbsp;</td>

                            <td align="center"><c:out value='${item.tranAmt}'></c:out>&nbsp;</td>
                            <td align="center"><c:out value='${item.batchNo}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.tranDate}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.tranTime}'/>&nbsp;</td>
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
<div id="mask"></div>
<div id="dialog">
    <div class="biaoti"><p><b>请选择要导出的列</b></p></div>
    <div class="biao">
        <div class="form">
            <div class="eXtremeTable">
                <form name="queryForm" method="post" action="downloadErrorTranLsReport.do">
                    <input type="hidden" name="query" value="${query}"/>
                    <input type="button" onClick="checkedChoose('reportLine', 0)" value="全选"/>
                    <input type="button" onClick="checkedChoose('reportLine', 2)" value="反选"/>
                    <input type="hidden" name="tranSources" value="${query.tranSources}"/>
                    <input type="hidden" name="accountRelation" value="${query.accountRelation}"/>
                    <input type="hidden" name="errorCause" value="${query.errorCause}"/>
                    <input type="hidden" name="merchantId" value="${query.merchantId}"/>
                    <input type="hidden" name="tranDateTimeBegin" value="${query.tranDateTimeBegin}"/>
                    <input type="hidden" name="tranDateTimeEnd" value="${query.tranDateTimeEnd}"/>
                    <table class="grid its">
                        <tbody>
                        <c:forEach items="${headers}" var="item" varStatus="status">
                            <c:if test="${status.count%2 == 1}">
                                <tr class="${status.count%4 == 1? 'even' : 'odd'}">
                            </c:if>
                            <td>
                                <label>
                                    <input type="checkbox" class="checkbox1" name="reportLine" value="${item.key}"/>
                                        ${item.value}
                                </label>
                            </td>
                            <c:if test="${status.count%2 == 0}">
                                </tr>
                            </c:if>
                        </c:forEach>
                        <c:if test="${headers.size()%2 == 1}">
                            <td></td>
                            </tr>
                        </c:if>
                        </tbody>
                    </table>
                    <table class="b">
                        <tr>
                            <td width="50px"></td>
                            <td><input type="button" style="width:80px" onclick="hideDialog1()" value="关闭"/></td>
                            <td><input type="submit" style="width:80px" onclick="return hideDialog();" value="确定"/></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
