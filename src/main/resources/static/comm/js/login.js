

function login(){
    var username=$("#UserName").val();
    var password=$("#UserPassword").val();
    if(username==""||password==""){
        layer.msg("用户名密码或验证码不能为空！");
        return;
    }
    $.ajax({
            "url":"/user/msg/login",
            "data":$("#form-login").serialize(),
            "type":"POST",
            "dataType":"json",
            "success":function(json){
                if(json.status==200){
                    setCookie("username",json.data.UserNickname,"1");
                    location.href="./admin.html";
                }else{
                    layer.msg(json.msg)
                }
            }
        }
    )
}
var input=document.getElementById("UserPassword");
input.addEventListener("keyup",function(event){event.preventDefault();if(event.keyCode===13){login()}});