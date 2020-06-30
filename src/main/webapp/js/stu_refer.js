window.onload=function(){
	information();
}
		var res = document.getElementById('res');
		var search=document.getElementById('search');
		var back_btn = document.getElementById('back_btn');
		var contentWidget = document.getElementById('contentWidget');
		var mainContent=document.getElementById('mainContent');
		var pageManager=document.getElementById('pageManager');
		var contentTable=document.getElementById('contentTable');
		var contest_list=document.getElementById('contest_list');
		$(".username").val(sessionStorage.getItem("username"));

		$("#bc_btn").click(function(){
			res.style.display="none";
			mainContent.style.display="block";

		});
		$("#back_btn").click(function(){
			// var a=$("#idNumber").val();
			contentWidget.style.display="none";
			res.style.display="block";
			search.style.display="block";

		});
		$("#out").click(function(){
			$.ajax({
				url:"https://rammsteinlp.cn/educhain/user/invalide",
				type:"GET",
				success:function(data){
					if(data.success==true){
						window.location.href='https://rammsteinlp.cn/educhain/login.html'
					}else{
						alert("退出失败！");
					}
				}
			})
		});
		function information(){
			// console.log(a);
			$.ajax({
				url:"https://rammsteinlp.cn/educhain/student/getInfoHeaderById",
				type:"GET",
				data:{
					"idNumber":sessionStorage.getItem("userid"),
				},
				dataType:"JSON",
				success:function(data){
					if(data.success==true){
						res.style.display="block";
						search.style.display="block";
						mainContent.style.display="none";
						var protect = data.infoHeader.dataProtect?"信息已保护":"信息未被保护!";
                        var check = data.infoHeader.dataCheck?"数据信息一致":"数据信息不一致!";
                        //var str="<table><tr><td>"+"录入时间："+data.infoHeader.insertTime+"</td><td>"+"修改时间："+data.infoHeader.updateTime+"</td></tr><tr><td>"+"档案编号："+data.infoHeader.idNumber+"</td><td>"+"文件标题："+data.infoHeader.dirTitle+"</td></tr><tr><td>"+"区块高度："+data.infoHeader.blockHeight+"</td><td>"+"合约地址："+data.infoHeader.contractAddress+"</td></tr><tr><td>"+"保护状态："+data.infoHeader.dataProtect+"</td><td>"+"数据一致性："+data.infoHeader.dataCheck+"</td></tr></table>";
                        //var str="<table><tr><td>"+"录入时间："+data.infoHeader.insertTime+"</td><td>"+"修改时间："+data.infoHeader.updateTime+"</td></tr><tr><td>"+"档案编号："+data.infoHeader.idNumber+"</td><td>"+"文件标题："+data.infoHeader.dirTitle+"</td></tr><tr><td>"+"区块高度："+data.infoHeader.blockHeight+"</td><td>"+"合约地址："+data.infoHeader.contractAddress+"</td></tr><tr><td>"+"保护状态："+data.infoHeader.dataProtect?"信息已保护":"信息未被保护!"+"</td><td>"+"数据一致性："+data.infoHeader.dataCheck?"数据信息一致":"数据信息不一致!"+"</td></tr></table>";
                        var str="<table><tr><td>"+"录入时间："+data.infoHeader.insertTime+"</td><td>"+"修改时间："+data.infoHeader.updateTime+"</td></tr><tr><td>"+"档案编号："+data.infoHeader.idNumber+"</td><td>"+"文件标题："+data.infoHeader.dirTitle+"</td></tr><tr><td>"+"区块高度："+data.infoHeader.blockHeight+"</td><td>"+"合约地址："+data.infoHeader.contractAddress+"</td></tr><tr><td>"+"保护状态："+protect+"</td><td>"+"数据一致性："+check+"</td></tr></table>";
                        $('#status').html(str);
					}
					else{
						alert("查询失败");
					}
					// console.log(data.infoHeader.dataProtect);
					// console.log(data.infoHeader.idNumber);
					// console.log(data.infoHeader.contractAddress);
					
				},
				error:function(data){
					alert("未连接！");
				}
			})
		}

		var page; //当前页
		function score(n){
			contentWidget.style.display="block";
			back_btn.style.display="block";
			search.style.display="none";
			 $.ajax({
                        url:"http://localhost:8031/chaincode/query",
                        type:"GET",
                        data:{
                            userName : "leon",
                            passWord : 123,
                            peerWithOrg : "peerOrg1",
                            channelName : "mychannel",
                            chainCodeName : "test",
                            chainCodeVersion : 1.0,
                            function : "invoke",
                            fucinvoke : "query",
                            studentId : $("#idNumber").val()
                        },
                        dataType:"JSON",
                        success:function(res){
                            console.log(res);

                            $.ajax({
	                url:"https://rammsteinlp.cn/educhain/student/getExamInfo",
	                type:"GET",
	                async:false,
	                data:{
	                	pageNum:n,
	                	idNumber:sessionStorage.getItem("userid"),
						pageSize:10,
						ipfsHash:res.ipfsHash
	                },
	                dataType:"json",
	                success: function(data) {
	                	if(data.success==true){
	                		page=Math.ceil(data.exam.totalRecord/10);
	                	var html="<thead><th>"+"序号"+"</th><th>"+"操作时间"+"</th><th>"+"操作人"+"</th><th>"+"学号"+"</th><th>"+"年级"+"</th><th>"+"考试名称"+"</th><th>"+"考试科目"+"</th><th>"+"考试分数"+"</th><th>"+"备注"+"</th></thead>";
	                	// var j= JSON.stringify(data); 
        	  		 	for(var i=0;i<data.exam.list.length;i++){
	                        var list = data.exam.list[i]; 
	                        html +="<tr><td>"+list.id+"</td><td>"+list.recordTime+"</td><td>"+list.recorderId+"</td><td>"+list.studentId+"</td><td>"+list.grade+"</td><td>"+list.examName+"</td><td>"+list.subject+"</td><td>"+list.score+"</td><td>"+list.remark+"</td></tr>";
                    }
                    $(".contest_list").html(html); 

                    var x1=parseInt(n)-parseInt(2),x2=parseInt(n)-parseInt(1),x3=parseInt(n)+parseInt(1),x4=parseInt(n)+parseInt(2);
                    	if(page<5){
                    	var str2="<li><a id='last_page'>上一页</a></li>";
                    	for(var i=1;i<=page;i++){
                        str2+="<li class='page_item'>"+i+"</li>";
                    	}
	                    str2+="<li><a id='next_page'>下一页</a></li>";
	                    $(".pageShow").html(str2);
	                }
	                else if(x4<=page&&x1>=1){
	                    var str2="<li><a id='last_page'>上一页</a></li><li class='page_item'>"+x1+"</li><li class='page_item'>"+x2+"</li><li class='page_item'>"+n+"</li><li class='page_item'>"+x3+"</li><li class='page_item'>"+x4+"</li><li><a id='next_page'>下一页</a></li>"
	                    $(".pageShow").html(str2);
	                }
	                 else if(x4>page){
	                    var str2="<li><a id='last_page'>上一页</a></li><li class='page_item'>"+(page-4)+"</li><li class='page_item'>"+(page-3)+"</li><li class='page_item'>"+(page-2)+"</li><li class='page_item'>"+(page-1)+"</li><li class='page_item'>"+page+"</li><li><a id='next_page'>下一页</a></li>"
	                    $(".pageShow").html(str2);
	                }
	                else if(x1<1){
	                    var str2="<li><a id='last_page'>上一页</a></li><li class='page_item'>"+1+"</li><li class='page_item'>"+2+"</li><li class='page_item'>"+3+"</li><li class='page_item'>"+4+"</li><li class='page_item'>"+5+"</li><li><a id='next_page'>下一页</a></li>"
	                    $(".pageShow").html(str2);
	                }updatePage1(n);
	                var liTotal=$(".pageShow li");
	                for(var i=1;i<liTotal.length-1;i++){
	                	if($(".pageShow li").eq(i).text()==n){
	                		$(".pageShow li").eq(i).css("background-color","rgb(68, 93, 83)");
	                		$(".pageShow li").eq(i).css("color","rgb(255, 255, 255)");
	                	}
	                }
	                	}
	                	else{
	                		alert("查询失败");
	                	}
	                	
	            },
            	  	error: function () {
              			alert("未连接");
        }
	});

                        },
                        error:function(){
                        	alert("ERROR!");
                        }
                    });
		}


		function competition(n){
			contentWidget.style.display="block";
			back_btn.style.display="block";
			search.style.display="none";
			$.ajax({
                        url:"http://localhost:8031/chaincode/query",
                        type:"GET",
                        data:{
                            userName : "leon",
                            passWord : 123,
                            peerWithOrg : "peerOrg1",
                            channelName : "mychannel",
                            chainCodeName : "test",
                            chainCodeVersion : 1.0,
                            function : "invoke",
                            fucinvoke : "query",
                            studentId : $("#idNumber").val()
                        },
                        dataType:"JSON",
                        success:function(res){
                            console.log(res);

                            $.ajax({
	                url:"https://rammsteinlp.cn/educhain/student/getCompetitionInfo",
	                type:"GET",
	                dataType:"json",
	                async:false,
	                data:{
	                	pageNum:n,
	                	idNumber:sessionStorage.getItem("userid"),
						pageSize:5
	                },
	                success: function(data) {
	                	if(data.success==true){
	                		page=Math.ceil(data.competition.totalRecord/5);
	                	var html2 ="<thead><th>"+"序号"+"</th><th>"+"操作时间"+"</th><th>"+"操作人"+"</th><th>"+"学号"+"</th><th>"+"竞赛名称"+"</th><th>"+"竞赛等级"+"</th><th>"+"获奖情况"+"</th><th>"+"备注"+"</th></thead>";
	                	// $(".contest_list").append(html2);
	                	// var j= JSON.stringify(data);
	                    // console.log(data.exam.list);
	                    // console.log(data.exam.list.length);
        	  		 	for(var i=0;i<data.competition.list.length;i++){
	                        var list = data.competition.list[i]; 
	                        html2 +="<tr><td>"+list.id+"</td><td>"+list.recordTime+"</td><td>"+list.recorderId+"</td><td>"+list.studentId+"</td><td>"+list.competitionName+"</td><td>"+list.competitionDegree+"</td><td>"+list.achievement+"</td><td>"+list.remark+"</td></tr>";
                    	}
                    	// pageManager.style.display="block";
	                    $(".contest_list").html(html2);

                    	var x1=parseInt(n)-parseInt(2),x2=parseInt(n)-parseInt(1),x3=parseInt(n)+parseInt(1),x4=parseInt(n)+parseInt(2);
                    	if(page<5){
                    	var str2="<li><a id='last_page'>上一页</a></li>";
                    	for(var i=1;i<=page;i++){
                        str2+="<li class='page_item'>"+i+"</li>";
                    	} 
	                    str2+="<li><a id='next_page'>下一页</a></li>";
	                    $(".pageShow").html(str2);
	                }
	                else if(x4<=page&&x1>=1){
	                    var str2="<li><a id='last_page'>上一页</a></li><li class='page_item'>"+x1+"</li><li class='page_item'>"+x2+"</li><li class='page_item'>"+n+"</li><li class='page_item'>"+x3+"</li><li class='page_item'>"+x4+"</li><li><a id='next_page'>下一页</a></li>"
	                    $(".pageShow").html(str2);
	                }
	                 else if(x4>page){
	                    var str2="<li><a id='last_page'>上一页</a></li><li class='page_item'>"+(page-4)+"</li><li class='page_item'>"+(page-3)+"</li><li class='page_item'>"+(page-2)+"</li><li class='page_item'>"+(page-1)+"</li><li class='page_item'>"+page+"</li><li><a id='next_page'>下一页</a></li>"
	                    $(".pageShow").html(str2);
	                }
	                else if(x1<1){
	                    var str2="<li><a id='last_page'>上一页</a></li><li class='page_item'>"+1+"</li><li class='page_item'>"+2+"</li><li class='page_item'>"+3+"</li><li class='page_item'>"+4+"</li><li class='page_item'>"+5+"</li><li><a id='next_page'>下一页</a></li>"
	                    $(".pageShow").html(str2);
	                    $(".pageShow").html()
	                }updatePage2(n);
	                var liTotal=$(".pageShow li");
	                for(var i=1;i<liTotal.length-1;i++){
	                	if($(".pageShow li").eq(i).text()==n){
	                		$(".pageShow li").eq(i).css("background-color","rgb(68, 93, 83)");
	                		$(".pageShow li").eq(i).css("color","rgb(255, 255, 255)");
	                	}
	                }
	                	}
	                	else{
	                		alert("查询失败");
	                	}
	                	
	            },
            	  	error: function () {
              			alert("未连接");
        }
	});

                        },
                        error:function(){
                        	console.log(res);
                        }
                    });


		}

		function practice(n){
			contentWidget.style.display="block";
			back_btn.style.display="block";
			search.style.display="none";
			$.ajax({
                        url:"http://localhost:8031/chaincode/query",
                        type:"GET",
                        data:{
                            userName : "leon",
                            passWord : 123,
                            peerWithOrg : "peerOrg1",
                            channelName : "mychannel",
                            chainCodeName : "test",
                            chainCodeVersion : 1.0,
                            function : "invoke",
                            fucinvoke : "query",
                            studentId : $("#idNumber").val()
                        },
                        dataType:"JSON",
                        success:function(res){
                            console.log(res);

                            $.ajax({
	                url:"https://rammsteinlp.cn/educhain/student/getInternshipInfo",
	                type:"GET",
	                async:false,
	                data:{
	                	idNumber:sessionStorage.getItem("userid"),
						pageNum:n,
						pageSize:10
	                },
	                dataType:"json",
	                success: function(data) {
	                	if(data.success==true){
	                		console.log(data);
	                	page=Math.ceil(data.internship.totalRecord/10);
	                	var html3="<thead><th>"+"序号"+"</th><th>"+"操作时间"+"</th><th>"+"操作人"+"</th><th>"+"学号"+"</th><th>"+"实习时间"+"</th><th>"+"实习职位"+"</th><th>"+"实习公司"+"</th><th>"+"备注"+"</th></thead>";
	                	// var j= JSON.stringify(data); 
        	  		 	for(var i=0;i<data.internship.list.length;i++){
	                        var list = data.internship.list[i]; 
	                        html3 +="<tr><td>"+list.id+"</td><td>"+list.recordTime+"</td><td>"+list.recorderId+"</td><td>"+list.studentId+"</td><td>"+list.period+"</td><td>"+list.position+"</td><td>"+list.companyame+"</td><td>"+list.remark+"</td></tr>";
                    }
                    $(".contest_list").html(html3); 

                    var x1=parseInt(n)-parseInt(2),x2=parseInt(n)-parseInt(1),x3=parseInt(n)+parseInt(1),x4=parseInt(n)+parseInt(2);
                    	if(page<5){
                    	var str2="<li><a id='last_page'>上一页</a></li>";
                    	for(var i=1;i<=page;i++){
                        str2+="<li class='page_item'>"+i+"</li>";
                    	}
	                    str2+="<li><a id='next_page'>下一页</a></li>";
	                    $(".pageShow").html(str2);
	                }
	                else if(x4<=page&&x1>=1){
	                    var str2="<li><a id='last_page'>上一页</a></li><li class='page_item'>"+x1+"</li><li class='page_item'>"+x2+"</li><li class='page_item'>"+n+"</li><li class='page_item'>"+x3+"</li><li class='page_item'>"+x4+"</li><li><a id='next_page'>下一页</a></li>"
	                    $(".pageShow").html(str2);
	                }
	                 else if(x4>page){
	                    var str2="<li><a id='last_page'>上一页</a></li><li class='page_item'>"+(page-4)+"</li><li class='page_item'>"+(page-3)+"</li><li class='page_item'>"+(page-2)+"</li><li class='page_item'>"+(page-1)+"</li><li class='page_item'>"+page+"</li><li><a id='next_page'>下一页</a></li>"
	                    $(".pageShow").html(str2);
	                }
	                else if(x1<1){
	                    var str2="<li><a id='last_page'>上一页</a></li><li class='page_item'>"+1+"</li><li class='page_item'>"+2+"</li><li class='page_item'>"+3+"</li><li class='page_item'>"+4+"</li><li class='page_item'>"+5+"</li><li><a id='next_page'>下一页</a></li>"
	                    $(".pageShow").html(str2);
	                }updatePage1(n);
	                var liTotal=$(".pageShow li");
	                for(var i=1;i<liTotal.length-1;i++){
	                	if($(".pageShow li").eq(i).text()==n){
	                		$(".pageShow li").eq(i).css("background-color","rgb(68, 93, 83)");
	                		$(".pageShow li").eq(i).css("color","rgb(255, 255, 255)");
	                	}
	                }

	                	}
	                	else{
	                		alert("查询失败")
	                	}
	                	
	            },
            	  	error: function () {
              			alert("未连接");
        }
	});


                        },
                        error:function(){
                        	alert("ERROR!");
                        }
                    });
		}

		function updatePage1(n){
			        var pageNum=$(".pageShow li");
			        //上一页
			        pageNum[0].onclick=function(){
			            if(n>1){
			                score(parseInt(n)-parseInt(1));
			            }
			        }
			        for(var i=1;i<pageNum.length-1;i++){
			            pageNum[i].onclick=function(n){
			                return function(){
			                    var j=pageNum[n].innerHTML; 
			                    score(j);
			                } 
			            }(i)
			        }
			        // 下一页
			        pageNum[pageNum.length-1].onclick=function(){
			            if(n<page){
			                score(parseInt(n)+parseInt(1));
			            }
			        }
			    }

		function updatePage2(n){
			        var pageNum=$(".pageShow li");
			        //上一页
			        pageNum[0].onclick=function(){
			            if(n>1){
			                competition(parseInt(n)-parseInt(1));
			            }
			        }
			        for(var i=1;i<pageNum.length-1;i++){
			            pageNum[i].onclick=function(n){
			                return function(){
			                    var j=pageNum[n].innerHTML; 
			                    competition(j);
			                } 
			            }(i)
			        }
			        // 下一页
			        pageNum[pageNum.length-1].onclick=function(){
			            if(n<page){
			                competition(parseInt(n)+parseInt(1));
			            }
			        }
			    }
				
			    function updatePage3(n){
			        var pageNum=$(".pageShow li");
			        //上一页
			        pageNum[0].onclick=function(){
			            if(n>1){
			                practice(parseInt(n)-parseInt(1));
			            }
			        }
			        for(var i=1;i<pageNum.length-1;i++){
			            pageNum[i].onclick=function(n){
			                return function(){
			                    var j=pageNum[n].innerHTML; 
			                    practice(j);
			                } 
			            }(i)
			        }
			        // 下一页
			        pageNum[pageNum.length-1].onclick=function(){
			            if(n<page){
			                practice(parseInt(n)+parseInt(1));
			            }
			        }
			    }
			    