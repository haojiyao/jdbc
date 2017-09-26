<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/common/backend/header.jsp"%>
<div class="i_bg bg_color">
	<div class="m_content">
		<%@include file="/common/backend/leftBar.jsp" %>
		<div class="m_right">
            <p></p>		
            
			<div class="mem_t">
            	<span class="m_num fr" style="margin-top:15px;"><a href="#">返回</a></span>用户列表
            </div>
            <table border="1" class="mem_tab" style="width:870px; text-align:center; margin-top:20px;" cellspacing="0" cellpadding="0">
              <tr><td>用户名</td><td>身份证号</td><td>Email</td><td>联系电话</td><td colspan="2">操作</td></tr>
              <c:forEach items="${userList}" var="u">
              		<tr>
              			<td>${u.userName}</td>
              			<td>${u.identityCode}</td>
              			<td>${u.email}</td>
              			<td>${u.mobile}</td>
              			<td><a href="servlet?id=${u.id}">修改</a></td>
              			<td><a href="servlet?id=${u.id}">删除</a></td>
              		</tr>
              
              </c:forEach>
            </table>
            <%@include file="/common/pagerBar.jsp" %>
        </div>
    </div>
</div>
<%@include file="/common/footer.jsp" %>
