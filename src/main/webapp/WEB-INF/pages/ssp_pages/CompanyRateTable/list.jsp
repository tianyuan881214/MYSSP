<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title><%=CompanyRateTable.TABLE_ALIAS%>
    </title>
    <%@include file="../../base_pages/base.jsp" %>
    <script src="<c:url value="/js/teletext.js"/>" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="../css/dqwz.css">
</head>
<body class="claro">
<div id="dqwz">
    <p>
        当前位置：业务管理&nbsp;〉&nbsp;<%=CompanyRateTable.TABLE_ALIAS%>管理
    </p>
    <p class="line"></p>
</div>

<mvc:form id="queryForm" name="queryForm" action="list.do"
          method="post" style="display: inline;">

    <div id="content">
        <div class="biaoti">
            <p>
                <b><%=CompanyRateTable.TABLE_ALIAS%>查询</b>
            </p>
        </div>
        <div class="biao">
            <table class="grid">

                <tr>
                    <td class="lgridlist" colspan="4"><%=CompanyRateTable.TABLE_ALIAS%>查询</td>
                </tr>
            <%--    <tr>
                    <td class="crosscolor_td"><%=CompanyRateTable.RATE%>
                    </td>
                    <td>
                        <input type="text" value="${query.rate}" id="rate" name="rate" maxlength="11"/>
                    </td>
                </tr>--%>

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
                        <th>操作</th>
                           <th><%=CompanyRateTable.COMPANY_ID%>
                           </th>
                        <th><%=CompanyRateTable.RATE%>
                        </th>
                        <th><%=CompanyRateTable.COMPANY_DESCRIPTION%>
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
                        </tr>
                    </c:if>
                    <c:forEach items="${page.result}" var="item" varStatus="status">
                        <tr class="${status.count % 2 == 0 ? 'odd' : 'even'}">
                            <td align="center">
                                <a href="edit.do?companyId=${item.companyId}">编辑</a>
                            </td>
                            <td align="center"><c:out value='${item.companyId}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.rate}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.companyDescription}'/>&nbsp;</td>
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
