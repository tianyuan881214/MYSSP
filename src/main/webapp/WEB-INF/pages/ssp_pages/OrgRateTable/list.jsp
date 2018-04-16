<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title><%=OrgRateTable.TABLE_ALIAS%>
    </title>
    <%@include file="../../base_pages/base.jsp" %>
    <script src="<c:url value="/js/teletext.js"/>" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="../css/dqwz.css">
</head>
<body class="claro">
<div id="dqwz">
    <p>
        当前位置：业务管理&nbsp;〉&nbsp;<%=OrgRateTable.TABLE_ALIAS%>管理
    </p>
    <p class="line"></p>
</div>

<mvc:form id="queryForm" name="queryForm" action="list.do"
          method="post" style="display: inline;">

    <div id="content">
        <div class="biaoti">
            <p>
                <b><%=OrgRateTable.TABLE_ALIAS%>查询</b>
            </p>
        </div>
        <div class="biao">
            <table class="grid">

                <tr>
                    <td class="lgridlist" colspan="4"><%=OrgRateTable.TABLE_ALIAS%>查询</td>
                </tr>
                <tr>
                    <td class="crosscolor_td">所属机构</td>
                    <td>
                        <select name="orgId" id="orgId">
                            <option value="">--请选择--</option>
                            <c:forEach items="${orgs}" var="item">
                                <option value="${item.orgId}">${item.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td class="crosscolor_td"><%=OrgRateTable.ACCOUNT_NO%>
                    </td>
                    <td>
                        <input type="text" value="${query.accountNo}" name="accountNo" maxlength="30"/>
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
                        <th>操作</th>
                        <th><%=OrgRateTable.ORG_ID%>
                        </th>
                        <th><%=OrgRateTable.ALIPAY_RATE%>
                        </th>
                        <th><%=OrgRateTable.WECHAT_RATE%>
                        </th>
                        <th><%=OrgRateTable.UNION_RATE%>
                        </th>
                        <th><%=OrgRateTable.ACCOUNT_NO%>
                        <th><%=OrgRateTable.ACCOUNT_NANME%>
                        </th>
                        </th>
                        <th><%=OrgRateTable.REMARK%>
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
                            <td align="center">&nbsp;</td>
                            <td align="center">&nbsp;</td>
                        </tr>
                    </c:if>
                    <c:forEach items="${page.result}" var="item" varStatus="status">
                        <tr class="${status.count % 2 == 0 ? 'odd' : 'even'}">
                            <td align="center">
                                <a href="edit.do?orgId=${item.orgId}">编辑</a>
                            </td>
                            <td align="center"><mytag:write value="${item.orgId}" dictName="D_ORG"/>&nbsp;</td>
                            <td align="center"><c:out value='${item.alipayRate}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.wechatRate}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.unionRate}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.accountNo}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.accountName}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.remark}'/>&nbsp;</td>

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
