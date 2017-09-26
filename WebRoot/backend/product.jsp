<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/common/backend/header.jsp"%>
<div class="i_bg bg_color">
	<div class="m_content">
		<%@include file="/common/backend/leftBar.jsp" %>
		<div class="m_right">
			${msg}
            <p></p>		
            
			<div class="mem_t">
            	<span class="m_num fr" style="margin-top:15px;"><a href="#">返回</a></span>商品列表
            </div>
            <table border="1" class="mem_tab" style="width:870px; text-align:center; margin-top:20px;" cellspacing="0" cellpadding="0">
              <tr><td>商品名称 </td><td>商品图片</td><td>库存</td><td>价格</td><td colspan="2">操作</td></tr>
              <c:forEach items="${proList}" var="pro">
              		<tr>
              			<td>${pro.name }</td>
              			<td><img src="/statics/images/${pro.fileName}"/></td>
              			<td>${pro.stock}</td>
              			<td>${pro.price }</td>
              			<td><a href="productServlet?id=${pro.id}">修改</a></td>
              			<td><a href="productServlet?id=${pro.id}&action=delete">删除</a></td>
              		</tr>
              
              </c:forEach>
            </table>
            <%@include file="/common/pagerBar.jsp" %>
        </div>
    </div>
</div>

<%@include file="/common/footer.jsp" %>
