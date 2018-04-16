<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*" %>
<html>
<head>
    <title><%=MerchantBase.TABLE_ALIAS%>
    </title>
    <%@include file="../../base_pages/base.jsp" %>
    <script src="<c:url value="/js/teletext.js"/>" type="text/javascript"></script>
    <script type="text/javascript" src="<c:url value='/js/jquery-1.4.1.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/application.js'/>"></script>
    <link rel="stylesheet" type="text/css" href="../css/dqwz.css">
</head>
<body class="claro">
<div id="dqwz">
    <p>
        当前位置：基本资料管理&nbsp;〉&nbsp;柜员管理
    </p>
    <p class="line"></p>
</div>

<mvc:form id="queryForm" name="queryForm" action="list.do"
          method="post" style="display: inline;">

    <div id="content">
        <div class="biaoti">
            <p>
                <b>柜员查询</b>
            </p>
        </div>
        <div class="biao">
            <table class="grid">

                <tr>
                    <td class="lgridlist" colspan="4">柜员查询</td>
                </tr>
                <tr>
                    <td class="crosscolor_td">商户号
                    </td>
                    <td>
                        <input type="text" value="${query.merchant}" id="merchant" name="merchant"/>
                    </td>
                    <td class="crosscolor_td">柜员号</td>
                    <td>
                        <input type="text" value="${query.userId}" id="userId" name="userId"/>
                    </td>
                </tr>
                <tr>
                    <td class="crosscolor_td">终端号</td>
                    <td>
                        <input type="text" value="${query.terminal}" id="terminal" name="terminal"/>
                    </td>
                    <td class="crosscolor_td">柜员名称</td>
                    <td>
                        <input type="text" value="${query.name}" id="name" name="name"/>
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
                        <th>商户号</th>
                        <th>终端号</th>
                        <th>柜员号</th>
                        <th>柜员名称</th>
                        <th>柜员电话</th>
                        <th>柜员级别</th>
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
                        </tr>
                    </c:if>
                    <c:forEach items="${page.result}" var="item" varStatus="status">
                        <tr class="${status.count % 2 == 0 ? 'odd' : 'even'}">
                            <td align="center">
                                <a href="${ctx}/netpayperson/edit.do?merchant=${item.merchant}&userId=${item.userId}&<mytag:params includes="s_*" type="queryStringUtf"/>">编辑>>| </a>
                                &nbsp;|&nbsp;
                                <a href="${ctx}/netpayperson/delete.do?merchant=${item.merchant}&userId=${item.userId}&<mytag:params includes="s_*" type="queryStringUtf"/>" onclick="return window.confirm('你确定删除此柜员吗？')">删除|<< </a>
                            </td>

                            <td align="center"><c:out value='${item.merchant}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.terminal}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.userId}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.name}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.phone}'/>&nbsp;</td>
                            <td align="center"><mytag:write dictName="D_NP_LEVEL" value="${item.level}"/></td>
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
