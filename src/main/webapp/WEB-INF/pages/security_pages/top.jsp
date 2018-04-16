<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags"  prefix="s" %>   
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="mvc"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <meta http-equiv='Content-Type' content='text/html; charset=gb2312'>


    <link href="../css/style.css" rel="stylesheet" type="text/css">


    <script language="javascript">
        function mouseOn(x) {
            x.className = "focus";
        }

        function mouseOff(x) {
            x.className = "plane";
        }
        function home() {
            window.parent.frames["main"].location.href = "main.do";
        }
        function logout() {
            document.location.href = "${pageContext.request.contextPath}/login/logout.do";
        }
        function resetPassWord(userId) {
            window.open("${pageContext.request.contextPath}/user/updateUserPwd.do?userId=" + userId, "main");
        }

        function lgoClo() {
            top.opener = null;
            top.close();

            window.onbeforeunload = function () {
                document.location.href = "Account.do?method=close";
            };
        }

    </script>

</head>

<body>
<div class="top">
    <img src="../images/logo1.png" title="中国银行">
    <span class="title">中国银行SSP管理平台</span>
</div>
<div class="admin">
    <div><a href="#" onclick="lgoClo();"><img src="../images/tubiao_2.gif">退出</a></div>
    <div><a href="#" onclick="logout()"><img src="../images/tubiao_1.gif">注销</a></div>
    <div><a href="#" onclick="resetPassWord(${curUser.userId})"><img src="../images/tubiao_4.gif">修改密码</a></div>
    <div><img src="../images/tubiao_3.gif">当前登录用户：<span><shiro:principal/></span></div>
</div>
</body>
</html>

