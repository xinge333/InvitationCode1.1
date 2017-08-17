<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2017/8/13
  Time: 下午1:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="utf-8" %>
<html>
<head>
    <title>首页</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <style>body {
        padding-top: 60px;
    }</style>
    <link href="bootstrap3/css/bootstrap.css" rel="stylesheet"/>
    <link href="css/login-register.css" rel="stylesheet"/>
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">

    <script src="jquery/jquery-1.10.2.js" type="text/javascript"></script>
    <script src="bootstrap3/js/bootstrap.js" type="text/javascript"></script>
    <script src="js/login-register.js" type="text/javascript"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-4"></div>
        <div class="col-sm-4">
            <a class="btn big-login" data-toggle="modal" href="javascript:void(0)" onclick="openLoginModal();">登录</a>
            <a class="btn big-register" data-toggle="modal" href="javascript:void(0)"
               onclick="openRegisterModal();">注册</a></div>
        <div class="col-sm-4"></div>
    </div>


    <div class="modal fade login" id="loginModal">
        <div class="modal-dialog login animated">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="box">
                        <div class="content">
                            <div class="error"></div>
                            <div class="form loginBox">
                                <form id="longinForm" method="post" action="/login" accept-charset="UTF-8">
                                    <input id="userName" class="form-control" type="text" placeholder="UserName"
                                           name="userName">
                                    <input id="password" class="form-control" type="password" placeholder="Password"
                                           name="pwd">
                                    <input class="btn btn-default btn-login" type="submit" value="Login">
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="box">
                        <div class="content registerBox" style="display:none;">
                            <span id="tips" style="width: 150px;height:40px;text-align: left;font-size: 12px;"></span>
                            <div class="form">
                                <form id="registerForm" method="post" onsubmit="return register();"
                                      html="{:multipart=>true}" data-remote="true" action="/register"
                                      accept-charset="UTF-8">
                                    <tr>
                                        <select class="select selectpicker show-tick form-control" id="uprovince"
                                                name="province" onchange="">
                                            <option value="">选择省</option>
                                        </select>

                                        <select class="select selectpicker show-tick form-control" id="ucity"
                                                name="city" onchange="">
                                            <option value="">选择市</option>
                                        </select>

                                        <select class="select selectpicker show-tick form-control" id="udistrict"
                                                name="district" onchange="">
                                            <option value="">选择区</option>
                                        </select>
                                        <select class="select selectpicker show-tick form-control" id="usName"
                                                name="sName">
                                            <option value="">选择学校</option>
                                        </select>
                                        </td>
                                    </tr>
                                    <span>Not found your school
                                    <a href="javascript: showAddSchoolForm();">add an school</a>
                            			?</span>
                                    <br/>
                                    <br/>
                                    <input id="uname" onblur="return checkname();" class="form-control" type="text"
                                           placeholder="UserName" name="userName">
                                    <input id="upass" onblur="return checkpass();" class="form-control" type="password"
                                           placeholder="Password" name="pwd">
                                    <input id="upass_confirmation" onblur="return checkrpass();" class="form-control"
                                           type="password" placeholder="Repeat Password" name="rpwd">
                                    <input class="btn btn-default btn-register" type="submit" value="Create account"
                                           name="commit">
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="box">
                        <div class="content addSchoolBox" style="display:none;">
                            <div class="form">
                                <form id="addSchoolForm" method="post" html="{:multipart=>true}" data-remote="true"
                                      action="/addSchool" accept-charset="UTF-8">
                                    <tr>
                                        <select class="select selectpicker show-tick form-control" id="addProvince"
                                                name="province" onchange="">
                                            <option value="">选择省</option>
                                        </select>

                                        <select class="select selectpicker show-tick form-control" id="addCity"
                                                name="city" onchange="">
                                            <option value="">选择市</option>
                                        </select>

                                        <select class="select selectpicker show-tick form-control" id="addDistrict"
                                                name="district">
                                            <option value="">选择区</option>
                                        </select>
                                        </td>
                                    </tr>
                                    <br/>
                                    <input id="addSchoolName" onblur="return checkname();" class="form-control" type="text"
                                           placeholder="SchoolName" name="schoolName">
                                    <input class="btn btn-default btn-register" type="submit" value="Add School"
                                           name="commit">
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <div class="forgot login-footer">
                            <span>Looking to
                                 <a href="javascript: showRegisterForm();">create an account</a>
                            ?</span>
                    </div>
                    <div class="forgot register-footer" style="display:none">
                        <span>Already have an account?</span>
                        <a href="javascript: showLoginForm();">Login</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
