<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title><%=RateTable.TABLE_ALIAS%>
    </title>
    <%@include file="../../base_pages/base.jsp" %>
    <script src="<c:url value="/js/teletext.js"/>" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="../css/dqwz.css">
</head>
<body class="claro">
<div id="dqwz">
    <p>
        当前位置：业务管理&nbsp;〉&nbsp;<%=RateTable.TABLE_ALIAS%>管理
    </p>
    <p class="line"></p>
</div>

<mvc:form id="queryForm" name="queryForm" action="list.do"
          method="post" style="display: inline;">

    <div id="content">
        <div class="biaoti">
            <p>
                <b><%=RateTable.TABLE_ALIAS%>查询</b>
            </p>
        </div>
        <div class="biao">
            <table class="grid">

                <tr>
                    <td class="lgridlist" colspan="4"><%=RateTable.TABLE_ALIAS%>查询</td>
                </tr>
                <tr>
                    <td class="crosscolor_td"><%=RateTable.RATE%>
                    </td>
                    <td>
                        <input type="text" value="${query.rate}" id="rate" name="rate" maxlength="11"/>
                    </td>
                </tr>

            </table>
            <table class="b">
                <tr align="center">
                    <td width="200px"></td>
                    <td><input type="submit" style="width: 80px" value="查询"
                               onclick="getReferenceForm(this).action='list.do'"/></td>
                    <td><input type="button" style="width: 80px" value="新增"
                               onclick="window.location.href='create.do'"/></td>
                </tr>
            </table>
        </div>
        <div class="form">
            <div id="eXtremeTable" class="eXtremeTable">
                <table class="grid its">
                    <thead>
                    <tr>
                      <%--  <th>操作</th>--%>
                           <th><%=RateTable.RATE_ID%>
                           </th>
                        <th><%=RateTable.RATE%>
                        </th>
                          <th><%=RateTable.BUSINESS_ID%>
                           </th>
                           <th><%=RateTable.ACCOUNT_NO%>
                           </th>
                        <th><%=RateTable.RATE_DESCRIPTION%>
                        </th>
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
                            <%--<td align="center">&nbsp;</td>--%>
                        </tr>
                    </c:if>
                    <c:forEach items="${rateList}" var="item" varStatus="status">
                        <tr class="${status.count % 2 == 0 ? 'odd' : 'even'}">
                        <%--    <td align="center">
                               &lt;%&ndash; <a href="edit.do?rateId=${item.rateId}">编辑</a>&ndash;%&gt;
                            </td>--%>
                                <td align="center"><mytag:write value="${item.rateId}" dictName="D_ORG"/>&nbsp;</td>
                                <td align="center"><c:out value='${item.rate}'/>&nbsp;</td>
                                <%--<td align="center"><c:out value='${item.businessId}'/>&nbsp;</td>--%>
                                <c:set var="channel1" value="${fn:replace(item.businessId,'000000000000003','微信')}" />
                                <c:set var="channel2" value="${fn:replace(channel1,'000000000000002','支付宝')}" />
                                <c:set var="channel3" value="${fn:replace(channel2,'000000000000085','银联')}" />
                                <td>${channel3}&nbsp;</td>
                                <td align="center"><c:out value='${item.accountNo}'/>&nbsp;</td>
                                <td align="center"><c:out value='${item.rateDescription}'/>&nbsp;</td>
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
