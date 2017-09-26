var jq = jQuery.noConflict();//让渡$
//登陆的方法
function login(){
	var name=jq(".l_user").val();
	var pwd=jq(".l_pwd").val();
	jq.post("UserServlet","action=login&userName="+name+"&pwd="+pwd,function(data){
		   var json= eval("("+data+")");//把字符串转换成json
			//alert(json.result);
			if(json.result=="chenggong"){
				location.href="../MyEasyBuy/index.jsp";
			}else{
				alert(json.msg);
			}
		
	});
}
