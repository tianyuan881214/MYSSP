<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.yada.ssp.model.*" %>
<html>
<head>
    <%@include file="../../base_pages/base.jsp" %>
    <script src="<c:url value="/js/teletext.js"/>" type="text/javascript"></script>
    <script type="text/javascript">
        var message='${message}';
        if (message != null && message != ''){
            alert(message);
        }

        function findOrgName(orgName) {

            var node = dojo.byId("orgId");
            dojo.empty(node);

            /*---------------创建元素节点--------------*/
            dojo.create("option", {
                value: "",
                innerHTML: "--请选择--"
            }, node);

            //验证是否可用
            dojo.xhrGet({
                url: "AJAX_findByLikeOrgName.do",
                sync: true,
                content: {orgName: orgName},
                load: function (data) {
                    if ("" != data) {
                        //解析用户分组
                        dojo.forEach(dojo.fromJson(data), function (org) {
                            dojo.create("option", {
                                value: org.orgId,
                                innerHTML: org.name
                            }, node);
                        });
                    }
                },
                error: function (error) {
                    alert(error);
                }
            });
        }
    </script>
</head>
<body class="claro">
<fieldset style="margin: 10px 0;padding: 10px;border: #DDD 1px solid">
    <legend><%=MerchantBase.TABLE_ALIAS%>编辑</legend>
    <mvc:form action="update.do" theme="simple" method="post" data-dojo-type="dijit.form.Form" id="saveForm">
        <script type="dojo/on" data-dojo-event="submit">

				if(this.validate()){
					if(check()){	
					return confirm("确定保存？");
					}else{
					return false;
					}
					}else{
						return false;
					}

        </script>
        <script type="text/javascript">
            var form = document.forms.saveForm;
            var onsbmt = true;
            function check() {
                var fax=document.getElementById("fax").value;
                if(fax ==""){
                    document.getElementById("faxMsg").innerHTML="是否他行账户不可为空!";
                    return false;
                }
                var scanType=document.getElementById("scanType").value;
                if(scanType ==""){
                    document.getElementById("scanTypeMess").innerHTML="扫描方式描不可为空!";
                    return false;
                }
                var accountType=document.getElementById("accountType").value;
                if(accountType ==""){
                    document.getElementById("accountTypeMess").innerHTML="账户类型不可为空!";
                    return false;
                }
                var belongOrgId=document.getElementById("belongOrgId").value;
                if(belongOrgId ==""){
                    document.getElementById("belongOrgIdMsg").innerHTML="所属二级行不可为空!";
                    return false;
                }
                var orgId=document.getElementById("orgId").value;
                if(orgId ==""){
                    document.getElementById("orgIdMsg").innerHTML="商户所属机构不可为空!";
                    return false;
                }
                /*var merchantStat=document.getElementById("merchantStat").value;
                 if(merchantStat ==""){
                 document.getElementById("merchantStatMsg").innerHTML="商户状态不可为空!";
                 return false;
                 }
                 var categoryId=document.getElementById("categoryId").value;
                 if(categoryId ==""){
                 document.getElementById("categoryIdMsg").innerHTML="商户经营类目不可为空!";
                 return false;
                 }*/

                return onsbmt;
            }
            function cardNoExist(value) {
                if (!value || !/^[1-9][0-9]{5}(19[0-9]{2}|200[0-9]|2010)(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])[0-9]{3}[0-9xX]$/i.test(value)) {
                    alert("身份证号格式错误");
                }
            }

            /**
             机构联动下级机构
             @param 机构ID
             */
            function findlowerOrg(orgId) {
                if (orgId) {

                    //清空select,添加[--请选择--]option
                    var node = dojo.byId("lowerOrgId");
                    dojo.empty(node);

                    /*---------------创建元素节点--------------*/
                    dojo.create("option", {
                        value: "",
                        innerHTML: "--请选择--"
                    }, node);
                    dojo.xhrGet({
                        url: "AJAX_findlowerOrg.do",
                        sync: true,
                        content: {orgId: orgId, t: new Date().getTime()},
                        load: function (data) {
                            //用户名可用
                            if ("" != data) {
                                //解析用户分组
                                dojo.forEach(dojo.fromJson(data), function (org) {
                                    dojo.create("option", {
                                        value: org.orgId,
                                        innerHTML: org.name
                                    }, node);
                                });
                            }
                        },
                        error: function (error) {
                            alert(error);
                        }
                    });

                    findGrpByOrg(orgId);
                }
            }

            function isMerchantIdExist(merchantId) {
                //清空提示信息
                var merchantIdMsg = dojo.byId("merchantIdMsg");
                merchantIdMsg.innerHTML = "*";

                //验证是否可用
                dojo.xhrGet({
                    url: "AJAX_isMerchantIdExist.do",
                    sync: true,
                    content: {merchantId: merchantId, t: new Date().getTime()},
                    load: function (data) {
                        //提示信息
                        merchantIdMsg.innerHTML = data;
                        if ("*" != data) {
                            onsbmt = false;
                        }else
                            onsbmt=true;
                    },
                    error: function (error) {
                        alert(error);
                    }
                });
            }
            function isBelongOrgIdExist(belongOrgId){

                dojo.xhrGet({
                    url: "AJAX_isBelongOrgId.do",
                    sync: true,
                    handleAs: "json",
                    content: {belongOrgId: belongOrgId},
                    load: function(data){
                        dojo.empty("orgId");
                        var option=document.createElement("option");
                        option.innerHTML="请选择";
                        option.value="";
                        document.getElementById("orgId").appendChild(option);
                        for (var i = 0; i < data.length; i++) {
                            var option=document.createElement("option");
                            option.value=data[i].orgId;
                            option.innerHTML=data[i].name;
                            document.getElementById("orgId").appendChild(option);
                        }
                    },
                    error: function(error){
                        alert("没有二级机构");
                    }
                });

            }

            function isTo(fax) {
                if (fax == '1') {
                    dojo.query(".merMaxLevellyf").style("display", "block");
                } else if (fax == '0'){
                    dojo.query(".merMaxLevellyf").style("display", "none");
                }
            }

            /* //判断银联缴费
             function isTos(ids) {
             if(ids ==000000000000004){
             dojo.query(".unionSubmchids").style("display", "block");
             }
             else if (ids == 000000000000004 && ids==000000000000003){
             dojo.query(".unionSubmchids").style("display", "block");
             }
             else if (ids == 000000000000004 && ids==000000000000003 && 000000000000002){
             dojo.query(".unionSubmchids").style("display", "block");
             }
             else{
             dojo.query(".unionSubmchids").style("display", "none");

             }
             }*/
            //增加入驻信息
            function changeMerchantMessage() {
                var type = dojo.query("[name=merchantLevel]")[0].value;
                if (type == 'M1') {
                    dojo.query(".merLevel").style("display", "none");
                    dojo.query(".merMaxLevel").style("display", "none");
                } else if (type == 'M2') {
                    dojo.query(".merLevel").style("display", "block");
                    dojo.query(".merMaxLevel").style("display", "none");
                } else if (type == 'M3') {
                    dojo.query(".merLevel").style("display", "block");
                    dojo.query(".merMaxLevel").style("display", "block");
                }
            }
            ;

            dojo.ready(function () {
                changeMerchantMessage();
                isTo(${modelson.fax})
            });
        </script>
        <table class="grid">
            <%@ include file="form_include.jsp" %>
        </table>
        <table class="b">
            <tr align="center">
                    <%--<td><input id="submitButton" name="submitButton" type="submit" value="修改及入驻"/></td>--%>
                <td><input id="submit" type="submit" value="修改及入驻" onclick="return checkOnSubmit();"/></td>
                <td><input type="button" value="返回" onclick="javascript:history.back()"/></td>
            </tr>
        </table>
    </mvc:form>
</fieldset>
</body>
</html>
