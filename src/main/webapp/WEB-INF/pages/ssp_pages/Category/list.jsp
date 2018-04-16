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
    <script type="text/javascript">
        window.onload=function() {
            // 分页需要依赖的初始化动作
            window.simpleTable = new SimpleTable('queryForm',${page.thisPageNumber},${page.pageSize},'${pageRequest.sortColumns}');
        };
    </script>
    <link rel="stylesheet" type="text/css" href="../css/dqwz.css">
</head>
<body class="claro">
<div id="dqwz">
    <p>
        当前位置：基本资料管理&nbsp;〉&nbsp;商户经营类目管理
    </p>
    <p class="line"></p>
</div>

<mvc:form id="queryForm" name="queryForm" action="list.do"
          method="post" style="display: inline;">

    <div id="content">
        <div class="biaoti">
            <p>
                <b>商户经营类目查询</b>
            </p>
        </div>
        <div class="biao">
            <table class="grid">

                <tr>
                    <td class="lgridlist" colspan="4">商户经营类目查询</td>
                </tr>
                <tr>
                    <td class="crosscolor_td">商户经营类目号
                    </td>
                    <td>
                        <input type="text" value="${query.id}" name="id"/>
                    </td>
                    <td class="crosscolor_td">商户经营类目名称</td>
                    <td>
                        <input type="text" value="${query.detail}" name="detail"/>
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
                        <th>商户经营类目号</th>
                        <th>商户经营类目名称</th>
                        <th>需要证件</th>
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
                                <a href="${ctx}/category/edit.do?id=${item.id}&<mytag:params includes="s_*" type="queryStringUtf"/>">编辑>>| </a>
                                &nbsp;|&nbsp;
                                <a href="${ctx}/category/delete.do?id=${item.id}&<mytag:params includes="s_*" type="queryStringUtf"/>" onclick="window.confirm('你确定删除此类目吗？')">删除|<< </a>
                            </td>
                            <td align="center"><c:out value='${item.id}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.detail}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.papers}'/>&nbsp;</td>
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
