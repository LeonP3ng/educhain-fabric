$(".username").val(sessionStorage.getItem("username"));
$("#reg_stu").css("background-color","rgb(44, 62, 55)");
$("#reg_stu").click(function(){
    $(".reg").show();
    $(".rectify").hide();
    $(".refer").hide();
    $(".add").hide();
    $(".res").hide();
    $(".stus").hide();
    $("#reg_stu").css("background-color","rgb(44, 62, 55)");
    $("#add_stu").css("background-color","rgb(71, 100, 89)");
    $("#re_stu").css("background-color","rgb(71, 100, 89)");
    $("#refer_stu").css("background-color","rgb(71, 100, 89)");
    $("#stus").css("background-color","rgb(71, 100, 89)");
});
$("#add_stu").click(function(){
    $(".reg").hide();
    $(".rectify").hide();
    $(".refer").hide();
    $(".res").hide();
    $(".add").show();
    $(".stus").hide();
    $("#reg_stu").css("background-color","rgb(71, 100, 89)");
    $("#add_stu").css("background-color","rgb(44, 62, 55)");
    $("#re_stu").css("background-color","rgb(71, 100, 89)");
    $("#refer_stu").css("background-color","rgb(71, 100, 89)");
    $("#stus").css("background-color","rgb(71, 100, 89)");
});
$("#re_stu").click(function(){
    $(".reg").hide();
    $(".add").hide();
    $(".refer").hide();
    $(".stus").hide();
    $(".res").hide();
    $(".rectify").show();
    $("#reg_stu").css("background-color","rgb(71, 100, 89)");
    $("#add_stu").css("background-color","rgb(71, 100, 89)");
    $("#re_stu").css("background-color","rgb(44, 62, 55)");
    $("#refer_stu").css("background-color","rgb(71, 100, 89)");
    $("#stus").css("background-color","rgb(71, 100, 89)");

});
$("#refer_stu").click(function(){
    $(".reg").hide();
    $(".add").hide();
    $(".rectify").hide();
    $(".stus").hide();
    $(".res").hide();
    $(".refer").show();
    $("#reg_stu").css("background-color","rgb(71, 100, 89)");
    $("#add_stu").css("background-color","rgb(71, 100, 89)");
    $("#re_stu").css("background-color","rgb(71, 100, 89)");
    $("#refer_stu").css("background-color","rgb(44, 62, 55)");
    $("#stus").css("background-color","rgb(71, 100, 89)");


});
$("#chaxun_btn").click(function(){
    $(".stus").hide();
});
$("#stus").click(function(){
    $(".stus").show();
    $(".reg").hide();
    $(".add").hide();
    $(".rectify").hide();
    $(".refer").hide();
    $("#res").hide();
    $("#reg_stu").css("background-color","rgb(71, 100, 89)");
    $("#add_stu").css("background-color","rgb(71, 100, 89)");
    $("#re_stu").css("background-color","rgb(71, 100, 89)");
    $("#refer_stu").css("background-color","rgb(71, 100, 89)");
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

var res = document.getElementById('res');
var search=document.getElementById('search');
var back_btn = document.getElementById('back_btn');
var contentWidget = document.getElementById('contentWidget1');
var mainContent=document.getElementById('mainContent');
var pageManager=document.getElementById('pageManager');
var contentTable=document.getElementById('contentTable');
var contest_list=document.getElementById('contest_list');
var num = 0;
function exam0(){
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
function exam1(){
        var tableHtml1 ="";
        tableHtml1 += '<tr id="tr'+num+'">'
                 +'<td><input class="addtd" id="studentId'+num+'"  type="text" name="studentId"/></td>'
                 +'<td><input class="addtd" id="subject'+num+'"  type="text" name="subject"/></td>'
                 +'<td><input class="addtd" id="grade'+num+'"  type="text" name="grade"/></td>'
                 +'<td><input class="addtd" id="examName'+num+'"  type="text" name="examName"/></td>'
                 +'<td><input class="addtd" id="score'+num+'"  type="text" name="score"/></td>'
                 +'<td><input class="addtd" id="remark'+num+'"  type="text" name="remark"/></td>'
                 +'<td><a class="opt-lk"  onclick="removeTr('+num+')">删除</a>'
                     // +'<a class="opt-lk edit" id="edit'+num+'" onclick="editDataByOne('+num+')">修改</a>'
                     // +'<a class="opt-lk hide" id="save'+num+'" onclick="saveByOne('+num+')">保存</a>'
                 +'</td>'
                 +'</tr>';
        
        var elements1 = $("#myTable1").children().length;    //表示id为“mtTable”的标签下的子标签的个数
        
        $("#myTable1").children().eq(elements1 - 1).after(tableHtml1); //在表头之后添加空白行
        num++;     
    }

function exam2(){
        var tableHtml2 ="";
        tableHtml2 += '<tr id="tr'+num+'">'
                 +'<td><input class="addtd" id="update'+num+'"  type="text" name="update" /></td>'
                 +'<td><input class="addtd" id="studentId'+num+'"  type="text" name="studentId2"/></td>'
                 +'<td><input class="addtd" id="subject'+num+'"  type="text" name="subject"/></td>'
                 +'<td><input class="addtd" id="grade'+num+'"  type="text" name="grade"/></td>'
                 +'<td><input class="addtd" id="examName'+num+'"  type="text" name="examName"/></td>'
                 +'<td><input class="addtd" id="remark'+num+'"  type="text" name="remark"/></td>'
                 +'<td><a class="opt-lk"  onclick="removeTr('+num+')">删除</a>'
                     // +'<a class="opt-lk edit" id="edit'+num+'" onclick="editDataByOne('+num+')">修改</a>'
                     // +'<a class="opt-lk hide" id="save'+num+'" onclick="saveByOne('+num+')">保存</a>'
                 +'</td>'
                 +'</tr>';
        
        var elements2 = $("#myTable2").children().length;    //表示id为“mtTable”的标签下的子标签的个数
        
        $("#myTable2").children().eq(elements2 - 1).after(tableHtml2); //在表头之后添加空白行
        num++;     
    }

function removeTr(trNum){
    $("#tr"+trNum).remove();
}
$("#sbtExam0").click(function(){
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
$("#sbtExam1").click(function(){
    var rows = $("#myTable1").find('tr').length,
        examData = [];

    var flag = true;//是否全部输入  默认true
    $("#myTable1 input").each(function (){
        if($(this).val()==""){//有空输入，将flag置为false
            flag = false;//
        }
    });
 
    if(flag){
        for(var i = 0; i < rows-1; i++){
        var exam_data = {
            studentId:$.trim($("#studentId"+i).val()),
            subject:$.trim($("#subject"+i).val()),
            grade:$.trim($("#grade"+i).val()),
            examName:$.trim($("#examName"+i).val()),
            score:$.trim($("#score"+i).val()),
            remark:$.trim($("#remark"+i).val())
        }
        examData.push(exam_data);
    }
    console.log(examData);
    var examData = JSON.stringify(examData);
    $.ajax({
        type:"POST",
        url:"https://rammsteinlp.cn/educhain/Institution/addExam",
        data:{
            examData:examData
        },
        dataType:"JSON",
        success:function(res){
           if(res.success==true){
              alert("增加成功！");
              console.log(examData);
              var len = $("#myTable1").children().length;
                for(var i = 1; i < len; i++){
                    $("#myTable1").children().eq(i).html(" ");
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
                        key:exam_data.studentId,
                        value:res.ipfsHash

                    },
                    dataType:"JSON",
                    success:function(res){
                        console.log(res);
                    },
                    error:function(){
                        alert("ERROR!");
                        //console.log(internshipData);
                        console.log(res);
                    }
                });
        },
                
        error:function(){
            alert("error!");
            console.log(examData);
        }

    });
    }else{
        alert("有空输入，不能提交!");
    }

    
});

$("#sbtExam2").click(function(){
    var rows = $("#myTable2").find('tr').length,
        examData = [];
    var flag = true;
    $("#myTable2 input").each(function (){
        if($(this).val()==""){//有空输入，将flag置为false
            flag = false;//
        }
    });
    if(flag){
        for(var i = 0; i < rows-1; i++){
            var exam_data = {
                update:$.trim($("#update"+i).val()),
                studentId:$.trim($("#studentId"+i).val()),
                subject:$.trim($("#subject"+i).val()),
                grade:$.trim($("#grade"+i).val()),
                examName:$.trim($("#examName"+i).val()),
                
                remark:$.trim($("#remark"+i).val())
            }
            examData.push(exam_data);
        }
        console.log(examData);
        var examData = JSON.stringify(examData);
        $.ajax({
            type:"POST",
            url:"https://rammsteinlp.cn/educhain/Institution/updExam",
            data:{
                examData:examData
            },
            dataType:"JSON",
            success:function(){
                alert("修改成功！");
                console.log(examData);
                 var len = $("#myTable2").children().length;
                for(var i = 1; i < len; i++){
                    $("#myTable2").children().eq(i).html(" ");
                }
            
            },
            error:function(){
                alert("error!");
                console.log(examData);

            }

        })
    }else{
        alert("有空输入，不能提交！");
    }
    
})

function information(){
        contentWidget.style.display = "none";
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
                            studentId : $("#idNumber").val(),
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
                        idNumber:$("#idNumber").val(),
                        ipfsHash:res.ipfsHash,
                        pageSize:10
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
                    }else if(x4<=page&&x1>=1){
                        var str2="<li><a id='last_page'>上一页</a></li><li class='page_item'>"+x1+"</li><li class='page_item'>"+x2+"</li><li class='page_item'>"+n+"</li><li class='page_item'>"+x3+"</li><li class='page_item'>"+x4+"</li><li><a id='next_page'>下一页</a></li>"
                        $(".pageShow").html(str2);
                    }else if(x4>page){
                        var str2="<li><a id='last_page'>上一页</a></li><li class='page_item'>"+(page-4)+"</li><li class='page_item'>"+(page-3)+"</li><li class='page_item'>"+(page-2)+"</li><li class='page_item'>"+(page-1)+"</li><li class='page_item'>"+page+"</li><li><a id='next_page'>下一页</a></li>"
                        $(".pageShow").html(str2);
                    }else if(x1<1){
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
                        }(i);
                    }
                    // 下一页
                    pageNum[pageNum.length-1].onclick=function(){
                        console.log(pageNum);
                        if(n<page){
                            score(parseInt(n)+parseInt(1));
                        }
                    }
                }

