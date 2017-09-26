<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>易买网</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache" >
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link type="text/css" rel="stylesheet" href="${ctx}/statics/css/style.css" /> 
    <script type="text/javascript" src="${ctx}/statics/js/jquery-1.11.1.min_044d0927.js"></script>
	<script type="text/javascript" src="${ctx}/statics/js/jquery.bxslider_e88acd1b.js"></script>
    
    <script type="text/javascript" src="${ctx}/statics/js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="${ctx}/statics/js/menu.js"></script>    
        
	<script type="text/javascript" src="${ctx}/statics/js/select.js"></script>
    
	<script type="text/javascript" src="${ctx}/statics/js/lrscroll.js"></script>
    
    <script type="text/javascript" src="${ctx}/statics/js/iban.js"></script>
    <script type="text/javascript" src="${ctx}/statics/js/fban.js"></script>
    <script type="text/javascript" src="${ctx}/statics/js/f_ban.js"></script>
    <script type="text/javascript" src="${ctx}/statics/js/mban.js"></script>
    <script type="text/javascript" src="${ctx}/statics/js/bban.js"></script>
    <script type="text/javascript" src="${ctx}/statics/js/hban.js"></script>
    <script type="text/javascript" src="${ctx}/statics/js/tban.js"></script>
    
	<script type="text/javascript" src="${ctx}/statics/js/lrscroll_1.js"></script>
  </head>
  
  <body>
	<!--Begin Header Begin-->
<div class="soubg">
	<div class="sou">
    	<!--Begin 所在收货地区 Begin-->
    	<span class="s_city_b">
        	<span class="fl">送货至：</span>
            <span class="s_city">
            	<span>四川</span>
                <div class="s_city_bg">
                	<div class="s_city_t"></div>
                    <div class="s_city_c">
                    	<h2>请选择所在的收货地区</h2>
                        <table border="0" class="c_tab" style="width:235px; margin-top:10px;" cellspacing="0" cellpadding="0">
                          <tr>
                            <th>A</th>
                            <td class="c_h"><span>安徽</span><span>澳门</span></td>
                          </tr>
                          <tr>
                            <th>B</th>
                            <td class="c_h"><span>北京</span></td>
                          </tr>
                          <tr>
                            <th>C</th>
                            <td class="c_h"><span>重庆</span></td>
                          </tr>
                          <tr>
                            <th>F</th>
                            <td class="c_h"><span>福建</span></td>
                          </tr>
                          <tr>
                            <th>G</th>
                            <td class="c_h"><span>广东</span><span>广西</span><span>贵州</span><span>甘肃</span></td>
                          </tr>
                          <tr>
                            <th>H</th>
                            <td class="c_h"><span>河北</span><span>河南</span><span>黑龙江</span><span>海南</span><span>湖北</span><span>湖南</span></td>
                          </tr>
                          <tr>
                            <th>J</th>
                            <td class="c_h"><span>江苏</span><span>吉林</span><span>江西</span></td>
                          </tr>
                          <tr>
                            <th>L</th>
                            <td class="c_h"><span>辽宁</span></td>
                          </tr>
                          <tr>
                            <th>N</th>
                            <td class="c_h"><span>内蒙古</span><span>宁夏</span></td>
                          </tr>
                          <tr>
                            <th>Q</th>
                            <td class="c_h"><span>青海</span></td>
                          </tr>
                          <tr>
                            <th>S</th>
                            <td class="c_h"><span>上海</span><span>山东</span><span>山西</span><span class="c_check">四川</span><span>陕西</span></td>
                          </tr>
                          <tr>
                            <th>T</th>
                            <td class="c_h"><span>台湾</span><span>天津</span></td>
                          </tr>
                          <tr>
                            <th>X</th>
                            <td class="c_h"><span>西藏</span><span>香港</span><span>新疆</span></td>
                          </tr>
                          <tr>
                            <th>Y</th>
                            <td class="c_h"><span>云南</span></td>
                          </tr>
                          <tr>
                            <th>Z</th>
                            <td class="c_h"><span>浙江</span></td>
                          </tr>
                        </table>
                    </div>
                </div>
            </span>
        </span>
        <!--End 所在收货地区 End-->
        <span class="fr">
        	<c:if test="${USER==''}">
        		<span class="fl">你好，请
        		<a href="${ctx}/pre/Login.jsp">登录</a>&nbsp; 
        		<a href="Regist.html" style="color:#ff4e00;">免费注册</a>
        	</c:if>
        	<c:if test="${USER!='' }">
        		<span class="fl">${USER.userName}
        		&nbsp;|&nbsp;<a href="#">我的订单</a>&nbsp;|
        		<a href="${ctx}/productServlet?action=list">后台管理</a>&nbsp;|<a href="UserServlet?action=loginOut">注销</a></span>
        	</c:if>
           
        </span>
    </div>
</div>
<div class="top">
    <div class="logo"><a href="Index.html"><img src="${ctx}/statics/images/logo.png" /></a></div>
    <div class="search">
    	<form>
        	<input type="text" value="" class="s_ipt" />
            <input type="submit" value="搜索" class="s_btn" />
        </form>                      
        <span class="fl"><a href="#">咖啡</a><a href="#">iphone 6S</a><a href="#">新鲜美食</a><a href="#">蛋糕</a><a href="#">日用品</a><a href="#">连衣裙</a></span>
    </div>
    <div class="i_car">
    	<div class="car_t">购物车 [ <span>3</span> ]</div>
        <div class="car_bg">
       		<!--Begin 购物车未登录 Begin-->
        	<div class="un_login">还未登录！<a href="${ctx}/pre/Login.jsp" style="color:#ff4e00;">马上登录</a> 查看购物车！</div>
            <!--End 购物车未登录 End-->
            <!--Begin 购物车已登录 Begin-->
            <ul class="cars">
            	<li>
                	<div class="img"><a href="#"><img src="${ctx}/statics/images/car1.jpg" width="58" height="58" /></a></div>
                    <div class="name"><a href="#">法颂浪漫梦境50ML 香水女士持久清新淡香 送2ML小样3只</a></div>
                    <div class="price"><font color="#ff4e00">￥399</font> X1</div>
                </li>
                <li>
                	<div class="img"><a href="#"><img src="${ctx}/statics/images/car2.jpg" width="58" height="58" /></a></div>
                    <div class="name"><a href="#">香奈儿（Chanel）邂逅活力淡香水50ml</a></div>
                    <div class="price"><font color="#ff4e00">￥399</font> X1</div>
                </li>
                <li>
                	<div class="img"><a href="#"><img src="${ctx}/statics/images/car2.jpg" width="58" height="58" /></a></div>
                    <div class="name"><a href="#">香奈儿（Chanel）邂逅活力淡香水50ml</a></div>
                    <div class="price"><font color="#ff4e00">￥399</font> X1</div>
                </li>
            </ul>
            <div class="price_sum">共计&nbsp; <font color="#ff4e00">￥</font><span>1058</span></div>
            <div class="price_a"><a href="#">去购物车结算</a></div>
            <!--End 购物车已登录 End-->
        </div>
    </div>
</div>
<!--End Header End--> 
<!--Begin Menu Begin-->
<div class="menu_bg">
	<div class="menu">
    	<!--Begin 商品分类详情 Begin-->    
    	<div class="nav">
        	<div class="nav_t">全部商品分类</div>
            <div class="leftNav">
                <ul>      
                    <%-- <li>
                    	<div class="fj">
                        	<span class="n_img"><span></span><img src="${ctx}/statics/images/nav1.png" /></span>
                            <span class="fl">进口食品、生鲜</span>
                        </div>
                        <div class="zj">
                            <div class="zj_l">
                                <div class="zj_l_c">
                                    <h2>零食 / 糖果 / 巧克力</h2>
                                    <a href="#">坚果</a>|<a href="#">蜜饯</a>|<a href="#">红枣</a>|<a href="#">牛肉干</a>|<a href="#">巧克力</a>|
                                    <a href="#">口香糖</a>|<a href="#">海苔</a>|<a href="#">鱼干</a>|<a href="#">蜜饯</a>|<a href="#">红枣</a>|
                                    <a href="#">蜜饯</a>|<a href="#">红枣</a>|<a href="#">牛肉干</a>|<a href="#">蜜饯</a>|
                                </div>
                               
                            </div>
                            <div class="zj_r">
                                <a href="#"><img src="${ctx}/statics/images/n_img1.jpg" width="236" height="200" /></a>
                                <a href="#"><img src="${ctx}/statics/images/n_img2.jpg" width="236" height="200" /></a>
                            </div>
                        </div>
                    </li> --%>
                    <c:forEach items="${PRO_CATE}" var="proCate">
                    	<li>
                    		<input type="hidden" id="proCateId" value="${proCate.id}"/>
                   			<div class="fj">
                        		<span class="n_img"><span></span><img src="${ctx}/statics/images/${proCate.iconClass}" /></span>
                            	<span class="fl">${proCate.name}</span>
                       	 	</div>
                       	 	     <div class="zj">
                            <div class="zj_l">
                                <div class="zj_l_c">
                                     
                                </div>
                               
                            </div>
                            <div class="zj_r">
                                <a href="#"><img src="${ctx}/statics/images/n_img1.jpg" width="236" height="200" /></a>
                                <a href="#"><img src="${ctx}/statics/images/n_img2.jpg" width="236" height="200" /></a>
                            </div>
                        </div>
                  	 </li>
                    </c:forEach>
                   
          	
          	
                </ul>            
            </div>
        </div>  
        <!--End 商品分类详情 End-->                                                     
    	<ul class="menu_r">     
    		<li><a href="${ctx}/statics/pre/main.jsp">首页</a></li>   
    		<c:forEach items="${PRO_CATE}" var="proCate" >
    			<li><a href="${ctx}/procate?action=sreach&id=${proCate.id}">${proCate.name}</a></li>
    		</c:forEach>                                                                                                                                       
        	<!-- <li><a href="Index.html">首页</a></li>
            <li><a href="Food.html">美食</a></li>
            <li><a href="Fresh.html">生鲜</a></li>
            <li><a href="HomeDecoration.html">家居</a></li>
            <li><a href="SuitDress.html">女装</a></li>
            <li><a href="MakeUp.html">美妆</a></li>
            <li><a href="Digital.html">数码</a></li>
            <li><a href="GroupBuying.html">团购</a></li> -->
        </ul>
        <div class="m_ad">中秋送好礼！</div>
    </div>
</div>
<!--End Menu End--> 