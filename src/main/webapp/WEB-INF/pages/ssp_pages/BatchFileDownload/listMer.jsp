<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*" %>
<html>
<head>
    <title><%=BusinessBase.TABLE_ALIAS%>
    </title>
    <%@include file="../../base_pages/base.jsp" %>
    <script src="<c:url value="/js/teletext.js"/>" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="../css/dqwz.css">
</head>
<body class="claro">
<div id="dqwz">
    <p>
        当前位置：入账文件下载&nbsp;〉&nbsp;商户对账文件下载
    </p>
    <p class="line"></p>
</div>

<mvc:form id="queryForm" name="queryForm" action="list.do"
          method="post" style="display: inline;">

    <div id="content">
        <div class="biaoti">
            <p>
                <b>商户对账文件下载</b>
            </p>
        </div>
        <div class="biao">
            <table class="grid">

                <tr>
                    <td class="lgridlist" colspan="4">商户对账文件下载</td>
                </tr>
                <tr>
                    <td class="crosscolor_td">文件创建日期
                    </td>
                  <%--  <td>
                        <input type="text" value="${fileDate}" id="fileDate" name="fileDate"
                               maxlength="8" class=""/><span style="color:red">日期格式:yyyyMMdd</span>
                    </td>--%>
                    <td>
                        <input id="fileDate" name="fileDate"
                               value="${fileDate}" maxlength="8"
                               class="Wdate" type="text"
                               onFocus="WdatePicker({dateFmt:'yyyyMMdd'})" />
                    </td>
                </tr>
                <tr>
                    <td class="crosscolor_td">商户号
                    </td>
                    <td>
                        <input type="text" value="${merchantId}" id="merchantId" name="merchantId"
                               maxlength="15" class=""/><span style="color:red">要下载文件的商户号</span>
                    </td>
                </tr>

            </table>
            <table class="b">
                <tr align="center">
                    <td width="200px"></td>
                    <td><input type="submit" style="width: 80px" value="查询"
                               onclick="getReferenceForm(this).action='listMer.do'"/></td>
                   <%-- <td><input type="button" style="width: 80px" value="新增"
                               onclick="window.location.href='create.do'"/></td>--%>
                </tr>
            </table>
        </div>
        <div class="form">
            <div id="eXtremeTable" class="eXtremeTable">
                <table class="grid its">
                    <thead>
                    <tr>
                        <th>操作</th>
                        <th>文件名称
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${files!=''}">
                        <tr class="${status.count % 2 == 0 ? 'odd' : 'even'}">
                            <td align="center">
                                <a href="${ctx}/batchfiledownload/downloadMer.do?fileName=${files}&<mytag:params includes="s_*" type="queryStringUtf"/>">下载>></a>
                                &nbsp;|&nbsp;

                            </td>

                            <td align="center"><c:out value='${files}'/>&nbsp;</td>
                        </tr>
                    </c:if>
                   <%-- <c:forEach items="${files}" var="item" varStatus="status">
                        <tr class="${status.count % 2 == 0 ? 'odd' : 'even'}">
                            <td align="center">
                                <a href="${ctx}/batchfiledownload/download.do?fileName=${item}&<mytag:params includes="s_*" type="queryStringUtf"/>">下载>></a>
                                &nbsp;|&nbsp;

                            </td>

                            <td align="center"><c:out value='${item}'/>&nbsp;</td>
                        </tr>
                    </c:forEach>--%>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</mvc:form>
</body>
</html>
