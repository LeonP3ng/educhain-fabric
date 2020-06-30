window.onload=function(){
	creatcode();
}
		var notice5=document.getElementById("notice5");
		var checkcode=document.getElementById("checkcode");
		var oyzm=document.getElementById("yzm");
		function yzm(){
			notice5.style.display="block";
			notice5.innerHTML="请填写验证码";
			notice5.style.color="lightgrey";
		}
		var icode;
		var e;
		function creatcode(){
			 icode = "";
			 var icodeLength = 4; //验证码的长度
			 var codeChars = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 
			 	'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
			      'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'); 
			 for(var i = 0; i < icodeLength; i++) 
			 {
			  var charNum = Math.floor(Math.random() * 52);
			  icode =icode+codeChars[charNum];
			 }

			 if(oyzm) 
			 {
			  checkcode.innerHTML = icode;
			 }
			 } 
			 
			 function validatecode(){
			 	var oyzm=document.getElementById("yzm");
			 	if(oyzm.value == ""){
			 	notice5.style.display="block";
			 	notice5.innerHTML="验证码不能为空";
			 	notice5.style.color="red";
			 }
			 else if(oyzm.value.toLowerCase() != icode.value.toLowerCase()) 
			 {
			  notice5.innerHTML="验证码错误";
			  notice5.style.color="red";
			  creatcode();
			 }
			 else 
			 {
			  notice5.style.display="none";
			  e=1;
			 }    
			 }

		function log(){ 
			$.ajax({
				url:"https://rammsteinlp.cn/educhain/user/login",/*请求的地址*/
	            type:"POST",/*请求的方式*/
	                data:{
	                	"username":$.trim($("#username").val()),
	                	"password":$.trim($("#password").val())
	                },
	                dataType:"json",
	                success:function(data){
	                	if(data.success == true){
	                		sessionStorage.setItem('username', data.user.username);
	                		sessionStorage.setItem('userid', data.user.idNumber);
	                		if(data.user.rating == 1){//学生
		                		// alert("登录成功！");
		                		console.log(data);
		                	    window.location.href='https://rammsteinlp.cn/educhain/stu_refer.html';
		                	}else if(data.user.rating == 2){//公司
		                		window.location.href='https://rammsteinlp.cn/educhain/company.html';
		                	}else if(data.user.rating == 3){//教师、学校
		                		window.location.href='https://rammsteinlp.cn/educhain/school.html';
		                	}else if(data.user.rating == 4){//竞赛机构
		                		window.location.href='https://rammsteinlp.cn/educhain/ins.html';
		                	}
	                	}
	                	else{
	                		alert("用户名或密码错误！");
	                	}
	                	
	                },
	                error:function(){
	                	alert("系统错误!");
	                }
			})
		}