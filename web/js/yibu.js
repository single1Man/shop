/* 异步搜索填充  */
$("#search").keyup(function(){
    const word = $(this).val();
    var flag=!!word;
    var htm="";
    if(flag){
        $.ajax( {
            url:'WordPnameServlet',// 跳转到 action
            dataType : "json",
            data:{
                word : word
            },
            type:'post',
            success:function(data) {
                for(let i=0; i<data.length; i++){
                    const product = data[i];
                    var str = product.pname;
                    str=highlight(word,str);
                    //<li class="list-group-item">HTC Desire 826d 32G 臻珠白</li>
                    htm+="<li class='list-group-item'>"+str+"</li>";
                    // $("#itemul").append("<li class='list-group-item'>"+str+"</li>")
                }
                $("#itemul").html(htm);
                $("#wordShow").show();
            }
        });
    }else {
        $("#itemul").html(htm);
    }
})

function highlight(word,str){
    var start="";//记录不需要或已经替换后的内容
    var end =str;//自己了需要被替换的内容,默认是整个内容,循环一次红藕,为后半段没有被替换的内容
    for(let i=0; i<word.length; i++){
        //获得每一个关键字
        const w = word.substring(i, i + 1);
        //从目标字符串中截取需要的内容,并进行替换,将字符串三个部分
        const index = end.indexOf(w);
        //不需要或已经替换后的内容
        start+=end.substring(0,index);
        //需要使用的<font>
        start+="<font color='red'>"+w+"</font>";
        //需要继续处理剩下的内容
        end=end.substring(index+1,end.length);

    }
    //追加最后不用处理的数据
    start+=end;
    return start;
}