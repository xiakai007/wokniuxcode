layui.use(['form','layer','jquery'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer
        $ = layui.jquery;

    $(".loginBody .seraph").click(function(){
        layer.msg("这只是做个样式，至于功能，你见过哪个后台能这样登录的？还是老老实实的找管理员去注册吧",{
            time:5000
        });
    })

    //登录按钮
    form.on("submit(login)",function(data){
        var doclk=$(this);
        doclk.text("登录中...").attr("disabled","disabled").addClass("layui-disabled");//当单击完登录按钮后，登录按钮会处于不可点击的状态
         //这里添加向服务端发送登录的ajax代码
        $.ajax({
            url:"login",
            data:data.field,
            success:function(resp){
                console.log(resp);
                if(resp.code==405){
                    window.location.href="goIndex";
                }else if(resp.code==406){
                    doclk.text("登录").removeAttr("disabled").removeClass("layui-disabled");
                    layer.msg(resp.message);
                }
            }
        });
        return false;
    })

    //表单输入效果
    $(".loginBody .input-item").click(function(e){
        e.stopPropagation();
        $(this).addClass("layui-input-focus").find(".layui-input").focus();
    })
    $(".loginBody .layui-form-item .layui-input").focus(function(){
        $(this).parent().addClass("layui-input-focus");
    })
    $(".loginBody .layui-form-item .layui-input").blur(function(){
        $(this).parent().removeClass("layui-input-focus");
        if($(this).val() != ''){
            $(this).parent().addClass("layui-input-active");
        }else{
            $(this).parent().removeClass("layui-input-active");
        }
    })
})
