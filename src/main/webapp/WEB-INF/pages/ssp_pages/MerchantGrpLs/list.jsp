<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*" %>
<%@ page import="com.yada.common.dict.util.DictUtil" %>
<html>
<head>
    <title><%=MerchantBase.TABLE_ALIAS%>
    </title>
    <%@include file="../../base_pages/base.jsp" %>
    <script src="<c:url value="/js/teletext.js"/>" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="../css/dqwz.css">
    <script type="text/javascript">
        var message = '${message}';
        if (message!=null && message!=''){
            alert(message);
        }
    </script>
</head>
<body class="claro">
<div id="dqwz">
    <p>
        当前位置：基本资料管理&nbsp;〉&nbsp;商户分组管理
    </p>
    <p class="line"></p>
</div>

<mvc:form id="queryForm" name="queryForm" action="list.do"
          method="post" style="display: inline;">

    <div id="content">
        <div class="biaoti">
            <p>
                <b>商户分组查询</b>
            </p>
        </div>
        <div class="biao">
            <table class="grid">

                <tr>
                    <td class="lgridlist" colspan="4">商户分组查询</td>
                </tr>
                <tr>
                    <td class="crosscolor_td">分组名称</td>
                    <td>
                        <input type="text" value="${query.merGrpName}" id="merGrpName" name="merGrpName" maxlength="64"
                               class=""/>
                    </td>
                    <td class="crosscolor_td">锁标示</td>
                    <td>
                        <mytag:select dictName="D_STATUS" value="${query.lockMode}" name="lockMode" notEmpty="false"/>
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
                        <th>分组名称</th>
                        <th>全称</th>
                        <th>简称</th>
                        <th>联系人姓名</th>
                        <th>电话号码</th>
                        <th>锁标识</th>
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
                                <a href="${ctx}/merchantgrpls/show.do?id=${item.merGrpId}&<mytag:params includes="s_*" type="queryStringUtf"/>">查看>></a>
                                &nbsp;|&nbsp;<a
                                    href="${ctx}/merchantgrpls/edit.do?id=${item.merGrpId}&<mytag:params includes="s_*" type="queryStringUtf"/>">编辑|<< </a>
                                &nbsp;|&nbsp;<a href="${ctx}/merchantgrpls/delete.do?id=${item.merGrpId}&<mytag:params includes="s_*" type="queryStringUtf"/>" onclick="javascript:return window.confirm('你确认要删除吗？,如有商户已使用将无法删除！')">删除>></a>
                            </td>
                            <td align="center"><c:out value='${item.merGrpName}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.merchantName}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.abbrName}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.manager}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.telephone}'/>&nbsp;</td>
                            <td align="center"><mytag:write value="${item.lockMode}" dictName="D_STATUS"/>&nbsp;</td>
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
