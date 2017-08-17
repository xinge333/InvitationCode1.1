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

    $('#loginModal .addSchoolBox').fadeOut('fast',function(){
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

    $('#loginModal .addSchoolBox').fadeOut('fast',function(){
    });

    $('.error').removeClass('alert alert-danger').html('');
}

//添加学校
function showAddSchoolForm(){
    $('#loginModal .registerBox').fadeOut('fast',function(){
        $('.addSchoolBox').fadeIn('fast');
        $('.register-footer').fadeOut('fast',function(){
            $('#loginModal .loginBox').fadeOut('fast',function(){
            });
        });

        $('.modal-title').html('AddSchool with');
    });
    $('.error').removeClass('alert alert-danger').html('');
    //获取省份
    $.ajax({
        url:"getProvince",
        method:"post",
        success:function (data) {
            var list_province = JSON.parse(data);

            for(var i=0;i<list_province.length;i++){
                var item=$("<option ids='"+list_province[i]+"'>"+list_province[i]+"</option>");
                $("#addProvince").append(item);
            }

        }
    })
}


//
// //登录页面加载时
// $(function () {
//
//     $("#province").change(function () {
//         $("#city").empty();
//         var enp=$("<option checked >选择市</option>");
//         $("#city").append(enp);
//         $("#district").empty();
//         var enp=$("<option checked >选择区</option>");
//         $("#district").append(enp);
//         $("#sName").empty();
//         var enp=$("<option checked >选择学校</option>");
//         $("#sName").append(enp);
//         var val=$(this).val();
//         $.ajax({
//             url: "getCity",
//             data:{province:val},
//             method:"post",
//             success:function (data) {
//                 $("#city").empty();
//                 var item=JSON.parse(data);
//              var enp=$("<option checked >选择市</option>");
//              $("#city").append(enp);
//                 for(var i=0;i<item.length;i++){
//                     var items=$("<option  ids='"+item[i]+"'>"+item[i]+"</option>");
//                     $("#city").append(items);
//                 }
//
//             }
//         })
//     });
//
//
//
//     $("#city").change(function () {
//
//         $("#district").empty();
//         var enp=$("<option checked >选择区</option>");
//         $("#district").append(enp);
//         $("#sName").empty();
//         var enp=$("<option checked >选择学校</option>");
//         $("#sName").append(enp);
//
//
//         var val_pro=$("#province").val();
//         var val_city=$("#city").val();
//         $.ajax({
//             url:'getDistrict',
//             data :{province:val_pro,city:val_city},
//             method:"post",
//             success:function (data) {
//                 $("#district").empty();
//                 var item=JSON.parse(data);
//                 var enp=$("<option checked >选择区</option>");
//                 $("#district").append(enp);
//                 for(var i=0;i<item.length;i++){
//                     var items=$("<option ids='"+item[i]+"'>"+item[i]+"</option>");
//                     $("#district").append(items);
//                 }
//             }
//         })
//     });
//
//
//     $("#district").change(function () {
//
//         $("#sName").empty();
//         var enp=$("<option checked >选择学校</option>");
//         $("#sName").append(enp);
//         var val_pro=$("#province").val();
//         var val_city=$("#city").val();
//         var val_dis=$("#district").val();
//         $.ajax({
//             url:'getSchool',
//             data :{province:val_pro,city:val_city,district:val_dis},
//             method:"post",
//             success:function (data) {
//                 $("#sName").empty();
//                 var item=JSON.parse(data);
//                 var enp=$("<option checked >选择学校</option>");
//                 $("#sName").append(enp);
//                 for(var i=0;i<item.length;i++){
//                     var items=$("<option ids='"+item[i]+"'>"+item[i]+"</option>");
//                     $("#sName").append(items);
//                 }
//             }
//         })
//     });
//
// })



//注册页面加载时候
$(function() {
    $("#uprovince").change(function () {
        $("#ucity").empty();
        var enp=$("<option checked >选择市</option>");
        $("#ucity").append(enp);
        $("#udistrict").empty();
        var enp=$("<option checked >选择区</option>");
        $("#udistrict").append(enp);
        $("#usName").empty();
        var enp=$("<option checked >选择学校</option>");
        $("#usName").append(enp);
        var val=$(this).val();
        $.ajax({
            url: "getCity",
            data:{province:val},
            method:"post",
            success:function (data) {
                $("#ucity").empty();
                var item=JSON.parse(data);
                var enp=$("<option checked >选择市</option>");
                $("#ucity").append(enp);
                for(var i=0;i<item.length;i++){
                    var items=$("<option  ids='"+item[i]+"'>"+item[i]+"</option>");
                    $("#ucity").append(items);
                }

            }
        })
    });



    $("#ucity").change(function () {

        $("#udistrict").empty();
        var enp=$("<option checked >选择区</option>");
        $("#udistrict").append(enp);
        $("#usName").empty();
        var enp=$("<option checked >选择学校</option>");
        $("#usName").append(enp);


        var val_pro=$("#uprovince").val();
        var val_city=$("#ucity").val();
        $.ajax({
            url:'getDistrict',
            data :{province:val_pro,city:val_city},
            method:"post",
            success:function (data) {
                $("#udistrict").empty();
                var item=JSON.parse(data);
                var enp=$("<option checked >选择区</option>");
                $("#udistrict").append(enp);
                for(var i=0;i<item.length;i++){
                    var items=$("<option ids='"+item[i]+"'>"+item[i]+"</option>");
                    $("#udistrict").append(items);
                }
            }
        })
    });


    $("#udistrict").change(function () {

        $("#usName").empty();
        var enp=$("<option checked >选择学校</option>");
        $("#usName").append(enp);
        var val_pro=$("#uprovince").val();
        var val_city=$("#ucity").val();
        var val_dis=$("#udistrict").val();
        $.ajax({
            url:'getSchool',
            data :{province:val_pro,city:val_city,district:val_dis},
            method:"post",
            success:function (data) {
                $("#usName").empty();
                var item=JSON.parse(data);
                var enp=$("<option checked >选择学校</option>");
                $("#usName").append(enp);
                for(var i=0;i<item.length;i++){
                    var items=$("<option ids='"+item[i]+"'>"+item[i]+"</option>");
                    $("#usName").append(items);
                }
            }
        })
    });

})


//添加学校页面加载
$(function() {
    $("#addProvince").change(function () {
        $("#addCity").empty();
        var enp=$("<option checked >选择市</option>");
        $("#addCity").append(enp);
        $("#addDistrict").empty();
        var enp=$("<option checked >选择区</option>");
        $("#addDistrict").append(enp);
        var val=$(this).val();
        $.ajax({
            url: "getCity",
            data:{province:val},
            method:"post",
            success:function (data) {
                $("#addCity").empty();
                var item=JSON.parse(data);
                var enp=$("<option checked >选择市</option>");
                $("#addCity").append(enp);
                for(var i=0;i<item.length;i++){
                    var items=$("<option  ids='"+item[i]+"'>"+item[i]+"</option>");
                    $("#addCity").append(items);
                }

            }
        })
    });



    $("#addCity").change(function () {

        $("#addDistrict").empty();
        var enp=$("<option checked >选择区</option>");
        $("#addDistrict").append(enp);

        var val_pro=$("#addProvince").val();
        var val_city=$("#addCity").val();
        $.ajax({
            url:'getDistrict',
            data :{province:val_pro,city:val_city},
            method:"post",
            success:function (data) {
                $("#addDistrict").empty();
                var item=JSON.parse(data);
                var enp=$("<option checked >选择区</option>");
                $("#addDistrict").append(enp);
                for(var i=0;i<item.length;i++){
                    var items=$("<option ids='"+item[i]+"'>"+item[i]+"</option>");
                    $("#addDistrict").append(items);
                }
            }
        })
    });

})





function openLoginModal(){
    showLoginForm();
    $.ajax({
        url:"getProvince",
        method:"post",
        success:function (data) {
            var list_province = JSON.parse(data);

            for(var i=0;i<list_province.length;i++){
                var item=$("<option ids='"+list_province[i]+"'>"+list_province[i]+"</option>");
                $("#province").append(item);
            }

        }
    })
    setTimeout(function(){
        $('#loginModal').modal('show');
    }, 230);

}

function openRegisterModal(){
    showRegisterForm();
    $.ajax({
        url:"getProvince",
        method:"post",
        success:function (data) {
            var list_province = JSON.parse(data);
            for(var i=0;i<list_province.length;i++){
                var item=$("<option ids='"+list_province[i]+"'>"+list_province[i]+"</option>");
                $("#uprovince").append(item);
            }

        }
    })
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
