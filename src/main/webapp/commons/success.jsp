<%@ page language="java" pageEncoding="GBK" contentType="text/html;charset=GBK"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>500</title>
<link href="../css/index.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
.f14 {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 14px;
	font-style: normal;
	line-height: 30px;
	font-weight: normal;
	color: #000000;
}
-->
</style>
<script> 
	function load()
	{
	  setTimeout("go()",2000);//1000为1秒
	}
	function go()
	{
	    var myForm=document.getElementById("form1");
	  	var m = 'm';
	    if('${type}' == m ){
	    	//跳转至商户
	    	myForm.action="${pageContext.request.contextPath}/pages/Merchant/list.do";
	    	myForm.submit();
	    }
	}
</script>

</head>
<body  onload="load()">
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<table width="60%" border="0" align="center" cellpadding="10"
	cellspacing="0">
  <tr>
    <td bgcolor="BEE9FD"><table width="100%" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td bgcolor="#FFFFFF"><table width="100%" border="0" cellpadding="15" cellspacing="1">
          <tr>
            <td width="20%" bgcolor="E0F4FF"><div align="center"><img src="${pageContext.request.contextPath}/commons/bao_cg.jpg"></div></td>
            <td width="80%" bgcolor="E0F4FF"><span class="f14"><strong>操作成功!<br></strong>${mess }</span></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
<p>&nbsp;</p>

<form id='form1'>
    </form>
</body>
</html>
