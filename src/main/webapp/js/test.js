$("#reg").css("background-color","rgb(44, 62, 55)");
$(".username").val(sessionStorage.getItem("username"));
$("#reg").click(function(){
    $(".reg").show();
    $(".rectify").hide();
    $(".refer").hide();
    $(".add").hide();
    $(".res").hide();
    $(".stus").hide();
    $("#reg").css("background-color","rgb(44, 62, 55)");
    $("#internship").css("background-color","rgb(71, 100, 89)");
    $("#rectify").css("background-color","rgb(71, 100, 89)");
    $("#refer").css("background-color","rgb(71, 100, 89)");
    $("#stus").css("background-color","rgb(71, 100, 89)");
});
$("#internship").click(function(){
            $(".add").show();
            $(".rectify").hide();
            $(".res").hide();
            $(".refer").hide();
            $(".stus").hide();
            $(".reg").hide();
            $("#reg").css("background-color","rgb(71, 100, 89)");
            $("#internship").css("background-color","rgb(44, 62, 55)");
            $("#rectify").css("background-color","rgb(71, 100, 89)");
            $("#refer").css("background-color","rgb(71, 100, 89)");
            $("#stus").css("background-color","rgb(71, 100, 89)");
        });
$("#rectify").click(function(){
    $(".add").hide();
    $(".rectify").show();
    $(".res").hide();
    $(".refer").hide();
    $(".stus").hide();
    $(".reg").hide();
    $("#reg").css("background-color","rgb(71, 100, 89)");
    $("#internship").css("background-color","rgb(71, 100, 89)");
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
    $("#internship").css("background-color","rgb(71, 100, 89)");
    $("#rectify").css("background-color","rgb(71, 100, 89)");
    $("#refer").css("background-color","rgb(44, 62, 55)");
    $("#stus").css("background-color","rgb(71, 100, 89)");
});
$("#stus").click(function(){
    $(".add").hide();
    $(".rectify").hide();
    $(".res").hide();
    $(".refer").hide();
    $(".stus").show();
    $("#internship").css("background-color","rgb(71, 100, 89)");
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

var res = document.getElementById('res');
var search=document.getElementById('search');
var back_btn = document.getElementById('back_btn');
var contentWidget = document.getElementById('contentWidget1');
var mainContent=document.getElementById('mainContent');
var pageManager=document.getElementById('pageManager');
var contentTable=document.getElementById('contentTable');
var contest_list=document.getElementById('contest_list');
var num = 0;
function internship0(){
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
    function internship1(){

        var tableHtml3 ="";
        tableHtml3 += '<tr id="tr'+num+'">'
                 +'<td><input class="addtd" id="studentId'+num+'"  type="text" name="studentId"/></td>'
                 +'<td><input class="addtd" id="companyName'+num+'"  type="text" name="companyName"/></td>'
                 +'<td><input class="addtd" id="job'+num+'"  type="text" name="job"/></td>'
                 +'<td><input class="addtd" id="period'+num+'"  type="text" name="period"/></td>'
                 +'<td><input class="addtd" id="remark'+num+'"  type="text" name="remark"/></td>'
                 +'<td><a class="opt-lk"  onclick="removeTr('+num+')">删除</a>'
                     // +'<a class="opt-lk edit" id="edit'+num+'" onclick="editDataByOne('+num+')">修改</a>'
                     // +'<a class="opt-lk hide" id="save'+num+'" onclick="saveByOne('+num+')">保存</a>'
                 +'</td>'
                 +'</tr>';
        
        var elements3 = $("#myTable3").children().length;    //表示id为“mtTable”的标签下的子标签的个数
        
        $("#myTable3").children().eq(elements3 - 1).after(tableHtml3); //在表头之后添加空白行
        num++;     
    }

     function internship2(){
        var tableHtml4 ="";
        tableHtml4 += '<tr id="tr'+num+'">'
                 +'<td><input class="addtd" id="update'+num+'"  type="text" name="update" /></td>'
                 +'<td><input class="addtd" id="studentId'+num+'"  type="text" name="studentId2"/></td>'
                 +'<td><input class="addtd" id="companyName'+num+'"  type="text" name="companyName"/></td>'
                 +'<td><input class="addtd" id="job'+num+'"  type="text" name="job"/></td>'
                 +'<td><input class="addtd" id="period'+num+'"  type="text" name="period"/></td>'
                 +'<td><input class="addtd" id="remark'+num+'"  type="text" name="remark"/></td>'
                 +'<td><a class="opt-lk"  onclick="removeTr('+num+')">删除</a>'
                     // +'<a class="opt-lk edit" id="edit'+num+'" onclick="editDataByOne('+num+')">修改</a>'
                     // +'<a class="opt-lk hide" id="save'+num+'" onclick="saveByOne('+num+')">保存</a>'
                 +'</td>'
                 +'</tr>';
        
        var elements4 = $("#myTable4").children().length;    //表示id为“mtTable”的标签下的子标签的个数
        
        $("#myTable4").children().eq(elements4 - 1).after(tableHtml4); //在表头之后添加空白行
        num++;     
    }
    //删除行
function removeTr(trNum){
    $("#tr"+trNum).remove();
}
$("#sbtInternship0").click(function(){
    var rows = $("#myTable0").find('tr').length,
        examData = [];

    var flag = true;   //是否全部输入  默认true
    $("#myTable0 input").each(function (){
        if($(this).val()==""){   //有空输入，将flag置为false
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




$("#sbtInternship1").click(function(){
    var rows = $("#myTable3").find('tr').length,
        internshipData = [],
        itData = [];
    var flag = true;    //是否全部输入  默认true
 
 $("#myTable3 input").each(function (){
 
  if($(this).val()==""){   //有空输入，将flag置为false
 
   flag = false;
 
  }
 
 });
 
 if(flag){
 
  for(var i = 0; i < rows-1; i++){
        var internship_data = {
            studentId:$.trim($("#studentId"+i).val()),
            companyName:$.trim($("#companyName"+i).val()),
            job:$.trim($("#job"+i).val()),
            period:$.trim($("#period"+i).val()),
            remark:$.trim($("#remark"+i).val())
        }
        // var itData = {
        //     companyName:$.trim($("#companyName"+i).val()),
        //     job:$.trim($("#job"+i).val()),
        //     period:$.trim($("#period"+i).val()),
        //     remark:$.trim($("#remark"+i).val())
        // }
        internshipData.push(internship_data);
        //itData.push(internship_data);
    }
    console.log(internshipData);
    var internshipData = JSON.stringify(internshipData);
    $.ajax({
        type:"POST",
        url:"https://rammsteinlp.cn/educhain/Institution/addInternship",
        data:{
            internshipData:internshipData
        },
        dataType:"JSON",
        success:function(res){
            if(res.success==true){
              alert("增加成功！");
              console.log(internshipData);
              var len = $("#myTable3").children().length;
                for(var i = 1; i < len; i++){
                    $("#myTable3").children().eq(i).html(" ");
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
                        key:internship_data.studentId,
                        value:res.ipfsHash

                    },
                    dataType:"JSON",
                    success:function(res){
                        console.log(res);
                    },
                    error:function(){
                        alert("ERROR!");
                        console.log(internshipData);
                        console.log(res);
                    }
                });
        },
        error:function(){
            alert("error!");
            console.log(internshipData);
            console.log(res);
        }

    });
 
 }else{
 
  alert("有空输入，不能提交!");
 
 }
    
});

$("#sbtInternship2").click(function(){
    var rows = $("#myTable4").find('tr').length,
        internshipData = [];
    var flag = true;
    $("#myTable4 input").each(function (){
 
  if($(this).val()==""){   //有空输入，将flag置为false
 
   flag = false;
 
  }
 
 });
    if(flag){
        for(var i = 0; i < rows-1; i++){
            var internship_data = {
                update:$.trim($("#update"+i).val()),
                studentId:$.trim($("#studentId"+i).val()),
                companyName:$.trim($("#companyName"+i).val()),
                job:$.trim($("#job"+i).val()),
                period:$.trim($("#period"+i).val()),
                remark:$.trim($("#remark"+i).val())
            }
            internshipData.push(internship_data);
        }
        console.log(internshipData);
        var internshipData = JSON.stringify(internshipData);
        $.ajax({
            type:"POST",
            url:"https://rammsteinlp.cn/educhain/Institution/updInternship",
            data:{
                internshipData:internshipData
            },
            dataType:"JSON",
            success:function(res){
                 if(res.success==true){
                  alert("修改成功！");
                  console.log(internshipData);
                  var len = $("#myTable4").children().length;
                    for(var i = 1; i < len; i++){
                        $("#myTable4").children().eq(i).html(" ");
                    }
            
                }else{
                    alert("修改失败！");
                }

            },
            error:function(){
                alert("error!");
                console.log(internshipData);
            }

        })
    }else{
         alert("有空输入，不能提交!");
 
    }
    
})
function information(){
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
                        alert("查询失败!");
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
                                    idNumber:$("#idNumber").val(),
                                    ipfsHash:res.ipfsHash,
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
                                    alert("查询失败!")
                                }
                                
                            },
                        error: function () {
                            alert("未连接!");
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
