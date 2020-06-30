$(".username").val(sessionStorage.getItem("username"));
$("#reg").css("background-color","rgb(44, 62, 55)");
$("#reg").click(function(){
    $(".refer").hide();
    $(".rectify").hide();
    $(".res").hide();
    $(".stus").hide();
    $(".add").hide();
    $(".reg").show();
    $("#reg").css("background-color","rgb(44, 62, 55)");
    $("#competition").css("background-color","rgb(71, 100, 89)");
    $("#rectify").css("background-color","rgb(71, 100, 89)");
    $("#refer").css("background-color","rgb(71, 100, 89)");
    $("#stus").css("background-color","rgb(71, 100, 89)");

});
$("#competition").click(function(){
    $(".refer").hide();
    $(".rectify").hide();
    $(".res").hide();
    $(".stus").hide();
    $(".reg").hide();
    $(".add").show();
    $("#reg").css("background-color","rgb(71, 100, 89)");
    $("#competition").css("background-color","rgb(44, 62, 55)");
    $("#rectify").css("background-color","rgb(71, 100, 89)");
    $("#refer").css("background-color","rgb(71, 100, 89)");
    $("#stus").css("background-color","rgb(71, 100, 89)");

});
$("#rectify").click(function(){
    $(".reg").hide();
    $(".add").hide();
    $(".refer").hide();
    $(".res").hide();
    $(".stus").hide();
    $(".rectify").show();
    $("#reg").css("background-color","rgb(71, 100, 89)");
    $("#competition").css("background-color","rgb(71, 100, 89)");
    $("#rectify").css("background-color","rgb(44, 62, 55)");
    $("#refer").css("background-color","rgb(71, 100, 89)");
    $("#stus").css("background-color","rgb(71, 100, 89)");

});
$("#refer").click(function(){
    $(".reg").hide();
    $(".add").hide();
    $(".rectify").hide();
    $(".stus").hide();
    $(".refer").show();
    $("#reg").css("background-color","rgb(71, 100, 89)");
    $("#competition").css("background-color","rgb(71, 100, 89)");
    $("#rectify").css("background-color","rgb(71, 100, 89)");
    $("#refer").css("background-color","rgb(44, 62, 55)");
    $("#stus").css("background-color","rgb(71, 100, 89)");
});
$("#stus").click(function(){
    $(".reg").hide();
    $(".add").hide();
    $(".refer").hide();
    $(".rectify").hide();
    $(".res").hide();
    $(".stus").show();
    $("#reg").css("background-color","rgb(71, 100, 89)");
    $("#competition").css("background-color","rgb(71, 100, 89)");
    $("#rectify").css("background-color","rgb(71, 100, 89)");
    $("#refer").css("background-color","rgb(71, 100, 89)");
    $("#stus").css("background-color","rgb(44, 62, 55)");

});

$("#out").click(function(){
            $.ajax({
                url:"https://rammsteinlp.cn/educhain/user/invalide",
                type:"GET",
                success:function(data){
                    if(data.success==true){
                        sessionStorage.clear();
                        window.location.href='https://rammsteinlp.cn/educhain/login.html'
                    }else{
                        alert("退出失败！");
                    }
                }
            })
        });
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
$("#chaxun_btn").click(function(){
    $(".stus").hide();
});
var num = 0;
function competition0(){
        var tableHtml0 ="";
        tableHtml0 += '<tr id="tr'+num+'">'
                 +'<td><input class="addtd" id="studentId'+num+'"  type="text" name="studentId"/></td>'
                 +'<td><a class="opt-lk"  onclick="removeTr('+num+')">删除</a>'
                 +'</td>'
                 +'</tr>';
        
        var elements0 = $("#myTable0").children().length;    //表示id为“mtTable”的标签下的子标签的个数
        
        $("#myTable0").children().eq(elements0 - 1).after(tableHtml0); //在表头之后添加空白行
        num++;     
    }
 $("#competitionBtn").click(function(){
        var tableHtml2 ="";
        tableHtml2 += '<tr id="tr'+num+'">'
                 +'<td><input class="addtd" id="studentId'+num+'"  type="text" name="studentId"/></td>'
                 +'<td><input class="addtd" id="competitionName'+num+'"  type="text" name="competitionName"/></td>'
                 +'<td><input class="addtd" id="competitionDegree'+num+'"  type="text" name="competitionDegree"/></td>'
                 +'<td><input class="addtd" id="achievement'+num+'"  type="text" name="achievement"/></td>'
                 +'<td><input class="addtd" id="remark'+num+'"  type="text" name="remark"/></td>'
                 +'<td><a class="opt-lk"  onclick="removeTr('+num+')">删除</a>'
                     // +'<a class="opt-lk edit" id="edit'+num+'" onclick="editDataByOne('+num+')">修改</a>'
                     // +'<a class="opt-lk hide" id="save'+num+'" onclick="saveByOne('+num+')">保存</a>'
                 +'</td>'
                 +'</tr>';
        
        var elements2 = $("#myTable2").children().length;    //表示id为“mtTable”的标签下的子标签的个数
        
        $("#myTable2").children().eq(elements2 - 1).after(tableHtml2); //在表头之后添加空白行
        num++;     
});
$("#sbtCompetition0").click(function(){
    var rows = $("#myTable0").find('tr').length,
        examData = [];

    var flag = true;//是否全部输入  默认true
    $("#myTable0 input").each(function (){
        if($(this).val()==""){//有空输入，将flag置为false
            flag = false;//
        }
    });
 
    if(flag){
        for(var i = 0; i < rows-1; i++){
        examData.push( $.trim($("#studentId"+i).val()));
    }
    console.log(examData);
    var examData = JSON.stringify(examData);
    $.ajax({
        type:"POST",
        url:"https://rammsteinlp.cn/educhain/Institution/insertStudentOfInstitution",
        data:{
            studentIdNumber:examData,
            institutionIdNumber: sessionStorage.getItem("userid") 
        },
        dataType:"JSON",
        success:function(res){
          if(res.success==true){
              alert("注册成功！");
              console.log(examData);
              var len = $("#myTable0").children().length;
                for(var i = 1; i < len; i++){
                    $("#myTable0").children().eq(i).html(" ");
                }  

        }else{
          alert("注册失败！");
          }
        },
                
        error:function(){
            alert("error!");
            console.log(examData);
        }

    });
    }else{
        alert("有空输入，不能提交!");
    }

    
})
$("#sbtCompetition").click(function(){
    var rows = $("#myTable2").find('tr').length,
        competitionData = [];
    var flag = true;//是否全部输入  默认true
 
 $("#myTable2 input").each(function (){
 
  if($(this).val()==""){//有空输入，将flag置为false
 
   flag = false;//
 
  }
 
 });
 
 if(flag){
 
  for(var i = 0; i < rows-1; i++){
        var competition_data = {
            studentId:$.trim($("#studentId"+i).val()),
            competitionName:$.trim($("#competitionName"+i).val()),
            competitionDegree:$.trim($("#competitionDegree"+i).val()),
            achievement:$.trim($("#achievement"+i).val()),
            remark:$.trim($("#remark"+i).val())
        }
        competitionData.push(competition_data);
    }
    console.log(competitionData);
    var competitionData = JSON.stringify(competitionData);
    $.ajax({
        type:"POST",
        url:"https://rammsteinlp.cn/educhain/Institution/addCompetition",
        data:{
            competitionData:competitionData
        },
        dataType:"JSON",
        success:function(res){
            if(res.success==true){
              alert("增加成功！");
              console.log(competitionData);
              var len = $("#myTable2").children().length;
              for(var i = 1; i < len; i++){
                  $("#myTable2").children().eq(i).html(" ");
              }
            }else{
                alert("增加失败！");
            }

            $.ajax({
                    type:"POST",
                    url:"http://localhost:8031/chaincode/invoke",
                    data:{
                        userName:"leon",
                        passWord:"123",
                        belongWithOrg:"peerOrg1",
                        peerWithOrgs:"peerOrg1",
                        channelName:"mychannel",
                        chainCodeName:"test",
                        chainCodeVersion:1.0,
                        function:"invoke",
                        funcinvoke:"insertData",
                        key:competition_data.studentId,
                        value:res.ipfsHash

                    },
                    dataType:"JSON",
                    success:function(res){
                        console.log(res);
                    },
                    error:function(){
                        alert("ERROR!");
                        console(res);
                        console.log(internshipData);
                    }
                });
        },
        error:function(){
            alert("error!");
            console.log(competitionData);
        }

    });
 
 }else{
 
  alert("有空输入，不能提交!");
 
 }
 
    
});

$("#competitionBtn1").click(function(){
    var tableHtml3 ="";
        tableHtml3 += '<tr id="tr'+num+'">'
                 +'<td><input class="addtd" id="update'+num+'"  type="text" name="update" /></td>'
                 +'<td><input class="addtd" id="studentId'+num+'"  type="text" name="studentId2"/></td>'
                 +'<td><input class="addtd" id="competitionName'+num+'"  type="text" name="competitionName"/></td>'
                 +'<td><input class="addtd" id="remark'+num+'"  type="text" name="remark"/></td>'
                 +'<td><a class="opt-lk"  onclick="removeTr('+num+')">删除</a>'
                     // +'<a class="opt-lk edit" id="edit'+num+'" onclick="editDataByOne('+num+')">修改</a>'
                     // +'<a class="opt-lk hide" id="save'+num+'" onclick="saveByOne('+num+')">保存</a>'
                 +'</td>'
                 +'</tr>';
        
        var elements3 = $("#myTable3").children().length;    //表示id为“mtTable”的标签下的子标签的个数
        
        $("#myTable3").children().eq(elements3 - 1).after(tableHtml3); //在表头之后添加空白行
        num++;     
})

$("#sbtCompetition1").click(function(){
    var rows = $("#myTable3").find('tr').length,
        competitionData = [];
    var flag = true;
     $("#myTable3 input").each(function (){
        if($(this).val()==""){//有空输入，将flag置为false
            flag = false;//
        }
    });
     if(flag){
        for(var i = 0; i < rows-1; i++){
            var competition_data = {
                update:$.trim($("#update"+i).val()),
                studentId:$.trim($("#studentId"+i).val()),
                competitionName:$.trim($("#competitionName"+i).val()),
                remark:$.trim($("#remark"+i).val())
            }
            competitionData.push(competition_data);
        }
        console.log(competitionData);
        var competitionData = JSON.stringify(competitionData);
        $.ajax({
            type:"POST",
            url:"https://rammsteinlp.cn/educhain/Institution/updCompetition",
            data:{
                competitionData:competitionData
            },
            dataType:"JSON",
            success:function(res){
                if(res.success==true){
                    alert("修改成功！");
                    var len = $("#myTable3").children().length;
                    for(var i = 1; i < len; i++){
                        $("#myTable3").children().eq(i).html(" ");
                    }
            
                    console.log(competitionData);
                }else{
                    alert("修改失败！");
                }      
            },
            error:function(){
                alert("error!");
                console.log(competitionData);
            }

        })
    }else{
        alert("有空输入，不能提交!");
    }
    
});
var res = document.getElementById('res');
var search=document.getElementById('search');
var back_btn = document.getElementById('back_btn');
var contentWidget = document.getElementById('contentWidget1');
var mainContent=document.getElementById('mainContent');
var pageManager=document.getElementById('pageManager');
var contentTable=document.getElementById('contentTable');
var contest_list=document.getElementById('contest_list');
function information(){
        // contentWidget.style.display = "none";
        var a=$("#idNumber").val();
            // console.log(a);
            $.ajax({
                url:"https://rammsteinlp.cn/educhain/student/getInfoHeaderById",
                type:"GET",
                data:{
                    "idNumber":a,
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
                            studentId : $("#idNumber").val(),
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
                    idNumber:$("#idNumber").val(),
                    ipfsHash:res.ipfsHash,
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
                            alert("ERROR!");
                        }
                    });
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
            