/*
 * login-register modal
 */
function showRegisterForm(){
    $('.loginBox').fadeOut('fast',function(){
        $('.registerBox').fadeIn('fast');
        $('.login-footer').fadeOut('fast',function(){
            $('.register-footer').fadeIn('fast');
        });
        $('.modal-title').html('Register with');
    });
    $('.error').removeClass('alert alert-danger').html('');

}
function showLoginForm(){
    $('#loginModal .registerBox').fadeOut('fast',function(){
        $('.loginBox').fadeIn('fast');
        $('.register-footer').fadeOut('fast',function(){
            $('.login-footer').fadeIn('fast');
        });

        $('.modal-title').html('Login with');
    });
    $('.error').removeClass('alert alert-danger').html('');
}

function openLoginModal(){
    showLoginForm();
    setTimeout(function(){
        $('#loginModal').modal('show');
    }, 230);

}
function openRegisterModal(){
    showRegisterForm();
    setTimeout(function(){
        $('#loginModal').modal('show');
    }, 230);

}


//登录校验
function login() {
    // console.info("点击了登录");
    var userName = $("#userName").val();
    // console.info(userName)
    var userPass = $("#password").val();
    // console.info(userPass);
    if (userName == "" || userName == null) {
        alert("用户名不能为空");
        return false;
    } else if (userPass == "" || userPass == null) {
        alert("密码不能为空");
        return false;
    } else {
        return true;
    }
}

//注册校验
function register() {
    if(!checkname()){
        return false;
    }else if (!checkpass()) {
        return false;
    } else if(!checkemail()){
        return false;
    }
    return true;
}

function checkname()
{
    var name = document.getElementById("uname").value;
    var tips = document.getElementById("tips");
    if(name.length<0|| name.length>15)
    {
        tips.innerHTML ="用户名长度须在0-15之间!";
        tips.style.color="red";
        return false;
    }
    $.post("checkUserName.action", {" userName": name },function(data){
        var d = $.parseJSON(data);
        //console.log(d.success);
        if(d.success!=true){
            tips.innerHTML ='用户名已存在!';
            tips.style.color='red';
            return true;
        }
    });
    tips.innerHTML ='用户名可以使用！';
    tips.style.color='green';
    return true;
}
function checkpass(){
    var userPass = $("#upass").val();

    var tips = document.getElementById("tips");

    if(userPass.length<6 || userPass.length >15)
    {
        tips.innerHTML ="密码长度须在6-15之间!";
        tips.style.color="red";
        return false;
    }
    tips.innerHTML ="密码可以使用!";
    tips.style.color="green";
    return true;
}
function checkrpass(){
    var userPass = $("#upass").val();
    var userRPass = $("#upass_confirmation").val();
    var tips =  document.getElementById("tips");
    if (userPass != userRPass) {
        tips.innerHTML="两次密码输入不一致!";
        tips.style.color="red";
        return false;
    }
    tips.innerHTML ="输入一致!";
    tips.style.color="green";
    return true;
}
