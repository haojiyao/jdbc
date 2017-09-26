// JavaScript Document

var jq = jQuery.noConflict();
jQuery(function(){
	jq(".leftNav ul li").hover(
		function(){
			jq(this).find(".fj").addClass("nuw");
			jq(this).find(".zj").show();
			//获取当前分类的id
			var id=jq(this).find("#proCateId").val();
			 
			//ajax
			jq(".zj_l_c").load("procate?action=selpro","id="+id);
		}
		,
		function(){
			jq(this).find(".fj").removeClass("nuw");
			jq(this).find(".zj").hide();
		}
	)
})
