if(window!=top){    //注意window不能有s
    top.location.href=location.href
}

 $('#btn').click(function(){
//$('#btn').on('click',function (){
    //shift f5强制刷新
    console.log('提交')
    let data = $('#form').serialize()
    $.ajax({
        url:'/admin/login',
        data,
        success(data){
            bootbox.alert({ //异步对话框,alert是同步的
                title:'结果',
                message: data.message,
                size: 'small',
                callback() {    //要在按钮点击后callback
                    if(data.success){
                        //3.刷新页面
                        sessionStorage.setItem("admin",JSON.stringify(data.object))//需要把JSON对象转成字符串
                        location = 'main.jsp'
                    }
                }
            });
        }
    })
})
