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
    <legend><%=MerchantBaseFh.TABLE_ALIAS%>编辑</legend>
    <mvc:form action="update.do" theme="simple" method="post" data-dojo-type="dijit.form.Form" id="saveForm" disabled="disabled">

        <script type="text/javascript">

            function doSubmit() {
                var forma = document.forms.saveForm.disabled = false;
               var from =document.getElementById('saveForm');
                //alert(from==forma);
                forma.submit();
            }


        </script>
        <table class="grid">
            <%@ include file="form_include.jsp" %>
        </table>
        <table class="b">
            <tr align="center">
                    <%--<td><input id="submitButton" name="submitButton" type="submit" value="修改及入驻"/></td>--%>
                <td><input id="submit" type="submit" value="确认复核" onclick="doSubmit()"/></td>
                <td><input type="button" value="返回" onclick="javascript:history.back()"/></td>
            </tr>
        </table>
    </mvc:form>
</fieldset>
</body>
</html>
