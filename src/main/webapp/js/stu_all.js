$("#stus").click(function(){
	stus(1);
});

var page; //当前页
function stus(n){

$.ajax({
    url:"https://rammsteinlp.cn/educhain/Institution/getStudentsOfInstitution",
    type:"GET",
    async:false,
    data:{
        pageNum:n,
        idNumber:sessionStorage.getItem("userid"),
        pageSize:10
    },
    dataType:"json",
    success: function(data) {
        if(data.success==true){
            page=Math.ceil(data.studentsOfInstitution.totalRecord/10);
        var html="<thead><th>"+"序号"+"</th><th>"+"用户名"+"</th><th>"+"学号"+"</th><th>"+"性别"+"</th><th>"+"电话"+"</th></thead>";
        // var j= JSON.stringify(data); 
        for(var i=0;i<data.studentsOfInstitution.list.length;i++){
            var list = data.studentsOfInstitution.list[i];
            if(list.sex == 0){
                html +="<tr><td>"+list.userId+"</td><td>"+list.username+"</td><td>"+list.idNumber+"</td><td>"+"男"+"</td><td>"+list.tel+"</td></tr>";
            }else{
                html +="<tr><td>"+list.userId+"</td><td>"+list.username+"</td><td>"+list.idNumber+"</td><td>"+"女"+"</td><td>"+list.tel+"</td></tr>";
            }
            
    }
    $(".contest_list").html(html); 

    var x1=parseInt(n)-parseInt(2),x2=parseInt(n)-parseInt(1),x3=parseInt(n)+parseInt(1),x4=parseInt(n)+parseInt(2);
        if(page<5){
        var str2="<li><a id='last_page'>上一页</a></li>";
        for(var i=1;i<=page;i++){
        str2+="<li class='page_item'>"+i+"</li>";
        }
        str2+="<li><a id='next_page'>下一页</a></li>";
        $(".pageShow1").html(str2);
    }
    else if(x4<=page&&x1>=1){
        var str2="<li><a id='last_page'>上一页</a></li><li class='page_item'>"+x1+"</li><li class='page_item'>"+x2+"</li><li class='page_item'>"+n+"</li><li class='page_item'>"+x3+"</li><li class='page_item'>"+x4+"</li><li><a id='next_page'>下一页</a></li>"
        $(".pageShow1").html(str2);
    }
     else if(x4>page){
        var str2="<li><a id='last_page'>上一页</a></li><li class='page_item'>"+(page-4)+"</li><li class='page_item'>"+(page-3)+"</li><li class='page_item'>"+(page-2)+"</li><li class='page_item'>"+(page-1)+"</li><li class='page_item'>"+page+"</li><li><a id='next_page'>下一页</a></li>"
        $(".pageShow1").html(str2);
    }
    else if(x1<1){
        var str2="<li><a id='last_page'>上一页</a></li><li class='page_item'>"+1+"</li><li class='page_item'>"+2+"</li><li class='page_item'>"+3+"</li><li class='page_item'>"+4+"</li><li class='page_item'>"+5+"</li><li><a id='next_page'>下一页</a></li>"
        $(".pageShow1").html(str2);
    }stus_updatePage1(n);
    var liTotal=$(".pageShow1 li");
    for(var i=1;i<liTotal.length-1;i++){
        if($(".pageShow1 li").eq(i).text()==n){
            $(".pageShow1 li").eq(i).css("background-color","rgb(68, 93, 83)");
            $(".pageShow1 li").eq(i).css("color","rgb(255, 255, 255)");
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
})
}

function stus_updatePage1(n){
    var pageNum=$(".pageShow1 li");
    //上一页
    pageNum[0].onclick=function(){
        if(n>1){
            stus(parseInt(n)-parseInt(1));
        }
    }
    for(var i=1;i<pageNum.length-1;i++){
        pageNum[i].onclick=function(n){
            return function(){
                var j=pageNum[n].innerHTML; 
                stus(j);
            } 
        }(i)
    }
    // 下一页
    pageNum[pageNum.length-1].onclick=function(){
        if(n<page){
            stus(parseInt(n)+parseInt(1));
        }
    }
}
