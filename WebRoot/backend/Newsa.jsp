<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/common/backend/header.jsp"%>
<div class="i_bg bg_color">
	<div class="m_content">
		<%@include file="/common/backend/leftBar.jsp" %>
		<div class="m_right">
            <p></p>		
            
			<div class="mem_t">
            	<span class="m_num fr" style="margin-top:15px;"><a href="#">返回</a></span>商品列表
            </div>
			<table border="1" class="mem_tab" style="width:870px; text-align:center; margin-top:20px;" cellspacing="0" cellpadding="0">
              <tr><td>新闻信息 </td><td>详情信息</td></tr>
              <c:forEach items="${newList}" var="newc">
              		<tr>
              			<td>${newc.title}</td>
              			<td>${newc.createTime}</td>
              		
              		</tr>
              </c:forEach>
            </table>
            <%@ include file="/common/pagerBar.jsp" %>
        </div>
    </div>
</div>
<%@include file="/common/footer.jsp" %>

