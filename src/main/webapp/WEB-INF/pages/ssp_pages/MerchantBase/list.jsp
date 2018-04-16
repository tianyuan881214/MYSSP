<%@page import="com.yada.ssp.model.*" %>
<%@page import="java.net.*" %>
<%@ page import="com.yada.mybatis.paging.Page" %>
<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
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
        /**
         机构联动下级机构
         @param 机构ID
         */
        function findlowerOrg(orgId){
            if(orgId){

                //清空select,添加[--请选择--]option
                var node = dojo.byId("lowerOrgId");
                dojo.empty(node);

                /*---------------创建元素节点--------------*/
                dojo.create("option", {
                    value : "",
                    innerHTML : "--请选择--"
                }, node);

                dojo.xhrGet({
                    url: "AJAX_findlowerOrg.do",
                    sync: true,
                    content: {orgId: orgId, t: new Date().getTime()},
                    load: function(data){
                        //用户名可用
                        if("" != data){
                            //解析用户分组
                            dojo.forEach(dojo.fromJson(data), function(org){
                                dojo.create("option", {
                                    value : org.orgId,
                                    innerHTML : org.name
                                }, node);
                            });
                        }
                    },
                    error: function(error){
                        alert(error);
                    }
                });

                findGrpByOrg(orgId);
            }
        }

    </script>
</head>
<body class="claro">
<div id="dqwz">
    <p>
        当前位置：基本资料管理&nbsp;〉&nbsp;<%=MerchantBase.TABLE_ALIAS%>管理
    </p>
    <p class="line"></p>
</div>

<mvc:form id="queryForm" name="queryForm" action="list.do"
          method="post" style="display: inline;" commandName="query" >

    <!--用于获取发送入驻信息的返回代码-->
    <input id="data" value="${sendStatus}" type="hidden"/>

    <div id="content">
        <div class="biaoti">
            <p>
                <b><%=MerchantBase.TABLE_ALIAS%>查询</b>
            </p>
        </div>
        <div class="biao">
            <table class="grid">

                <tr>
                    <td class="lgridlist" colspan="4"><%=MerchantBase.TABLE_ALIAS%>查询</td>
                </tr>
                <tr>


                    <td class="crosscolor_td"><%=MerchantBase.ALIAS_MERCHANT_ID%>
                    </td>
                    <td>
                        <input type="text" value="${query.merchantId}" id="merchantId" name="merchantId" maxlength="15"
                               class=""/>
                    </td>
                    <td class="crosscolor_td"><%=MerchantBase.ALIAS_MERCHANT_CNAME%></td>
                    <td>
                        <input type="text" value="${query.merchantCname}" id="merchantCname" name="merchantCname"
                               maxlength="40" class=""/>
                    </td>


                </tr>
                <tr>
                    <td class="crosscolor_td"><%=MerchantBase.ALIAS_MERCHANT_STAT%>
                    </td>
                    <td>
                        <mytag:select name="merchantStat"
                                      value="${query.merchantStat}" notEmpty="false"
                                      dictName="MERCHANT_STAT"/>
                    </td>
                    <td>&nbsp;&nbsp;</td>
                    <td>&nbsp;&nbsp;</td>
                </tr>
               <%-- <tr>
               <tr
                    <td class="crosscolor_td"><%=MerchantBase.ALIAS_MERCHANT_STAT%>
                    </td>
                    <td>
                        <mytag:select name="merchantStat"
                                      value="${query.merchantStat}" notEmpty="false"
                                      dictName="MERCHANT_STAT"/>
                    </td>

                    <c:if test="${orgLev=='1'}">
                        <td class="crosscolor_td">所属机构</td>
                        <td>
                            <mvc:select path="orgId" id="orgId" onchange="findlowerOrg(this.value);">
                                <mvc:option value="">--请选择--</mvc:option>
                                <mvc:options items="${orgs}" itemValue="orgId" itemLabel="name"/>
                            </mvc:select>
                            <mvc:select path="pOrgId" id="lowerOrgId">
                                <mvc:option value="">--请选择--</mvc:option>
                                <mvc:options items="${lowerOrgs}" itemValue="orgId" itemLabel="name"/>
                            </mvc:select>

                        </td>
                    </c:if>
                    <c:if test="${orgLev=='2'}">
                        <td class="crosscolor_td">所属机构</td>
                        <td>
                            <select name="pOrgId">
                                <option value="">--请选择--</option>
                                <c:forEach items="${orgs}" var="item">
                                    <option value="${item.orgId}" selected="<c:if test="${query.pOrgId==item.orgId}">selected</c:if>">${item.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </c:if>
                    <c:if test="${orgLev=='3'}">
                        <td class="crosscolor_td">所属机构</td>
                        <td>
                            <input type="hidden" value="${org.orgId}" name="pOrgId"/>
                            ${org.name}
                        </td>
                    </c:if>
                </tr>--%>
                <tr>
                    <td class="crosscolor_td">入账账号
                    </td>
                    <td>
                        <input type="text" value="${query.accountNo}" name="accountNo" maxlength="30"
                               class=""/>
                    </td>

                    <td class="crosscolor_td">日期
                    </td>
                    <td>
                        <input id="tranDateTimeBegin" name="tranDateTimeBegin"
                               value="${query.tranDateTimeBegin}" maxlength="8"
                               class="Wdate" type="text"
                               onFocus="WdatePicker({dateFmt:'yyyyMMdd',maxDate:'#F{$dp.$D(\'tranDateTimeEnd\')}'})"/>
                        &nbsp;到&nbsp;
                        <input id="tranDateTimeEnd" name="tranDateTimeEnd"
                               value="${query.tranDateTimeEnd}" maxlength="8"
                               class="Wdate" type="text"
                               onFocus="WdatePicker({dateFmt:'yyyyMMdd',minDate:'#F{$dp.$D(\'tranDateTimeBegin\')}'})"/>
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
                        <th><%=MerchantBase.ALIAS_MERCHANT_ID%>
                        </th>
                        <th><%=MerchantBase.ALIAS_MERCHANT_CNAME%>
                        </th>
                        <th><%=MerchantBase.ALLAS_BELONG_ORG_ID%>
                        </th>
                        <th><%=MerchantBase.ALIAS_ZBANK%>
                        </th>
                        <th><%=MerchantBase.ALIAS_MERCHANT_STAT%>
                        </th>
                        <th>支付宝返回的唯一标识
                        </th>
                        <th>入账账号
                        </th>
                        <th>入驻日期
                        </th>
                        <th>入驻时间
                        </th>
                        <c:forEach items="${businessBases}" var="itemfee">
                            <th>${itemfee.businessName}扣率</th>
                        </c:forEach>
                        <th>经营类目</th>
                        <th>微信返回的唯一标识</th>
                        <th>发送状态</th>
                        <th>扫描方式</th>
                        <th>账户类型</th>
                        <th><%=MerchantBase.ALLAS_STATE%>

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
                            <td align="center">&nbsp;</td>
                            <td align="center">&nbsp;</td>
                            <td align="center">&nbsp;</td>
                            <td align="center">&nbsp;</td>
                            <td align="center">&nbsp;</td>
                            <td align="center">&nbsp;</td>
                            <td align="center">&nbsp;</td>
                            <td align="center">&nbsp;</td>
                            <td align="center">&nbsp;</td>

                            <c:forEach items="${businessBases}" var="item">
                                <td>&nbsp;</td>
                            </c:forEach>
                        </tr>
                    </c:if>

                    <c:forEach items="${page.result}" var="item" varStatus="status">

                        <tr class="${status.count % 2 == 0 ? 'odd' : 'even'}">
                            <td align="center">
                                <c:if test="${item.state eq 0}">
                                    &nbsp;|&nbsp;
                                    <a href="${ctx}/merchantbase/sendData.do?merchantNo=${item.merchantId}&aliMerchantNo=${item.enterAiliMerchant.sub_merchant_id}&wechatMerchantNo=${item.sub_mch_id}&merchantCname=${ URLEncoder.encode(item.merchantCname,"utf-8")}&scanType=${item.scanType==0}&accountType=${item.accountType}">入驻通知|>> </a>
                                </c:if>
                                <a href="${ctx}/merchantbase/edit.do?id=${item.merchantId}&<mytag:params includes="s_*" type="queryStringUtf"/>">编辑|<< </a>
                                &nbsp;|&nbsp;
                                <a id="redirectUrl" href="${ctx}/merchantbase/qrCode.do?merchantId=${item.merchantId}&merchantCname=${ URLEncoder.encode(item.merchantCname,   "utf-8")  } ">下载二维码 </a>
                                &nbsp;|&nbsp;
                                <a href="${ctx}/merchantbase/show.do?id=${item.merchantId}&<mytag:params includes="s_*" type="queryStringUtf"/>">查看>></a>

                            </td>

                            <td align="center"><c:out value='${item.merchantId}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.merchantCname}'/>&nbsp;</td>
                            <td align="center"><mytag:write value="${item.belongOrgId}" dictName="D_ORG"/>&nbsp;</td>
                            <td align="center"><mytag:write value="${item.zbank}" dictName="D_ORG"/>&nbsp;</td>
                            <td align="center"><mytag:write value="${item.merchantStat}" dictName="MERCHANT_STAT"/>&nbsp;</td>
                            <td align="center"><c:out value='${item.enterAiliMerchant.sub_merchant_id}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.accountNo}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.updateDate}'/>&nbsp;</td>
                            <td align="center"><c:out value='${item.updateTime}'/>&nbsp;</td>
                            <c:forEach items="${businessBases}" var="business">
                                <td>
                                    <c:forEach items="${item.merchantBusinesses}" var="mb">
                                        <c:if test="${business.businessId==mb.businessBases.businessId}">${mb.feeTables.fee}</c:if>
                                    </c:forEach>
                                </td>
                            </c:forEach>
                            <td align="center"><c:out value='${item.detail}'/>&nbsp;</td>
                           <td align="center"><c:out value='${item.sub_mch_id}'/>&nbsp;</td>
                            <td>
                                <c:if test="${item.sendStatus==0}" >未发送</c:if>
                                <c:if test="${item.sendStatus==1}" >已发送</c:if>
                            </td>
                            <td>
                                <c:if test="${item.scanType==0}" >正扫</c:if>
                                <c:if test="${item.scanType==1}" >反扫</c:if>
                                <c:if test="${item.scanType==2}" >全扫</c:if>
                            </td>
                            <td>
                                <c:if test="${item.accountType==0}" >对公账户</c:if>
                                <c:if test="${item.accountType==1}" >对私账户</c:if>
                                <c:if test="${item.accountType==2}" >BGL</c:if>
                            </td>
                            <td>
                                <c:if test="${item.state==0}" >已复合</c:if>
                                <c:if test="${item.state==1}" >未复合</c:if>
                            </td>
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
<script type="text/javascript">

    var a = document.getElementById("data").value;
    if(a == "0"){
        alert("发送失败");
    }
    if(a == "1"){
        alert("发送成功")
    }
</script>
</html>
</html>
