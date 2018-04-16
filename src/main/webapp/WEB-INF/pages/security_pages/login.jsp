<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK"/>
    <meta charset="UTF-8">
    <title>登录中国银行SSP管理平台</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css">
    <script language="javascript" src="js/jquery-1.4.1.min.js"></script>
    <script type="text/javascript" language="javascript">
        if (top.location !== self.location) {
            top.location = self.location;
        }

        function refreshimg() {
            var p = $("#checkcode").parent();
            $("#checkcode").remove();
            p.append("<img src='CheckCode?random = " + Math.random()+ "' id='checkcode'/>");
        }
    </script>
</head>

<body>
    <div class="head">
        <img src="../images/logo1.png" />
    </div>

    <div class="bg">
    	<div class="login">
        	<div class="h3">中国银行SSP管理平台</div>
                        <form action="${pageContext.request.contextPath}/login/validate.do" method="post"
                              onsubmit="return validate()">

				<input type="text" name="loginName" value="请输入用户名"
					onblur="if(this.value == '')this.value='请输入用户名';"
					onclick="if(this.value == '请输入用户名')this.value='';" /> 
				<input type="password" value="111111" name="pwd" id="password"
					onblur="if(this.value == '')this.value='111111';"
					onclick="if(this.value == '111111')this.value='';" />
				<button type="submit">登 &nbsp; &nbsp; 录</button></br>

				<!--               <div class="whitef12"> -->
                            <!--                 <table> -->
                            <!--                   <tr> -->
                            <!--                     <td width="80">&nbsp;</td> -->
                            <!--                     <td><input type="checkbox" id="check1" name="checkset" value="1" tabindex="1"/></td> -->
                            <!--                     <td>记住我</td> -->
                            <!--                     <td width="30">&nbsp;</td> -->
                            <!--                     <td><input type="checkbox" id="check1" name="checkset" value="1" tabindex="1"/></td> -->
                            <!--                     <td>强制登录</td> -->
                            <!--                  </tr> -->
                            <!--                 </table> -->
                            <!--               </div> -->
							<span id="mess" style="color: red;">${returnMessage }</span>
                        </form>
                    </div>
      </div>
         <div class="line">
        Copyright© BANK OF CHINA(BOC) All Rights Reserved.
    </div>

<javascript formName="AccountForm" dynamicJavascript="true" staticJavascript="false"/>
</body>
</html>
<script language="JavaScript" type="text/JavaScript">
    function validateAccountForm1(form) {
        if (bCancel)
            return true;
        else
            var formValidationResult;
        formValidationResult = validateRequired(form);
        if (formValidationResult == 1) {
            document.getElementById("loading").style.display = "";
            document.getElementById("login").disabled = true;
        }
        return (formValidationResult == 1);
    }
    function validate() {
        var name = $("input[name='loginName']").val();
        var pwd = $("#password").val();
        if (name == '') {
            $("#mess").text("请输入用户名!");
            return false;
        }
        if (pwd == '') {
            $("#mess").text("请输入密码!");
            return false;
        }
    }
</script>
