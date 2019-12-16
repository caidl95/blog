function reg(){
    var username=$("#UserName").val();
    var userPhone=$("#UserPhone").val();
    var password=$("#UserPassword").val();
    var RetypePassword=$("#RetypeUserPassword").val();
    if( username==""|| userPhone=="" || password=="" || RetypePassword==""){
        layer.msg("注册信息未填写完整！");
        return false;
    }
    if (password == RetypePassword) {
        layer.msg("两次密码不相同！");
        return false;
    }
    $.ajax({
        "url":"/user/msg/save",
        "data":$("#form-reg").serialize(),
        "type":"POST",
        "dataType":"json",
        "success":function(json){
            if(json.status==200){
                layer.msg(json.data);
                location.href="../../login.html";
            }else{
                layer.msg(json.msg);
            }
        }
    })

}


