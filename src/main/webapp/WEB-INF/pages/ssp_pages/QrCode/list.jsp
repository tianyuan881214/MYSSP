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
    <script type="text/javascript">
        var message = '${message}';
        if (message!=null && message !=''){
            alert(message);
        }
    </script>
</head>
<body class="claro">
<div id="dqwz">
    <p>
        当前位置：基本资料管理&nbsp;〉&nbsp;二维码下载
    </p>
    <p class="line"></p>
</div>

<mvc:form id="queryForm" name="queryForm" action="qrCode.do"
          method="post" style="display: inline;">
    <div id="content">
        <div class="biaoti">
            <p>
                <b>二维码下载</b>
            </p>
        </div>
        <div class="biao">

            <table class="b">
               <%-- <tr align="center">
                    <td width="200px"></td>
                    <td>
                        <input type="submit" style="width: 80px" value="下载"
                               onclick="getReferenceForm(this).action='qrCode.do'"/>
                    </td>
                </tr>--%>
                <tr>
                   <td>
                       输入商户号：
                       <input id="merchantId" maxlength="15" name="merchantId" type="text" />
                    </td>
                </tr>
            </table>
            <table class="b">
                <tr align="center">
                    <td><input id="submit" type="submit" value="下载" onclick="return checkOnSubmit();"/></td>
                </tr>
            </table>
        </div>
       <%-- <div class="biaoti">
            <p>
                <b>二维码展示</b>
            </p>
        </div>
        <div class="biao">
            <table class="grid">
            </table>
            <table class="b">
                <tr align="center">
                    <td width="200px"></td>
                    <td>
                        <img src="placeQrOrder.do"/>
                    </td>
                </tr>
            </table>
        </div>--%>
    </div>
</mvc:form>

</body>
</html>
