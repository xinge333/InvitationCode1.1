<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2017/8/13
  Time: 下午2:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>申请邀请码</title>
</head>
<html>
<head>
    <meta charset="utf-8">
    <link href="bootstrap3/css/bootstrap.css" rel="stylesheet"/>
    <link href="css/login-register.css" rel="stylesheet"/>
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">

</head>
<body>
    <div class="gtco-container" style="text-align:center;">
        <div class="row animate-box">
            <div class="col-md-8 col-md-offset-2 text-center gtco-heading">
                <h2>获取邀请码</h2>
            </div>
        </div>
        <div class="row animate-box">
            <form class="form-inline">

                <div class="form-group">
                    <input type="text" class="form-control" type="text" id="Invicode" style="width:250px;">
                </div>
                <br/>
                <br/>
                <button type="button" class="btn btn-primary btn-lg" id='btn-get' class="btn btn-default btn-block">申请
                </button>
            </form>
        </div>
    </div>
</body>

<!-- jQuery -->
<script src="js/jquery.min.js"></script>


<script>
    $("#btn-get").click(function () {
        $.ajax({
            url: "apply",
            method: "post",
            success: function (data) {
                $("#Invicode").val(data);
            }
        })
    })
</script>
</html>
