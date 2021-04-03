<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<link href="static/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
<style type="text/css">
		   #form1{
		      width:500px;
		      margin:100px auto;
		   }
		</style>
</head>
<body>
  <div class="container-fluid">
		    <div class="row" style="background-color:black;color:white;height:100px;">
		       <div class="col-lg-12">
		          <h1 align="center">后台管理系统-新用户注册</h1>
		       </div>
		    </div>
		    <div class="row" style="height:400px;">
		       <div class="col-lg-12">
		       <!-- BS中的水平表单 -->
					<form class="form-horizontal" action="register.do" method="post" id="form1" onsubmit="return checkData()">
					  <div class="form-group">
					   <label  class="col-lg-3 control-label">新用户名：</label>
					   <div class="col-lg-9">
					      <input type="text" class="form-control" required="required" name="newUserName">
					    </div>
					  </div>
					  <div class="form-group">
					    <label  class="col-lg-3 control-label">密码：</label>
					    <div class="col-lg-9">
					      <input type="password" class="form-control" required="required" name="newUserPwd1">
					    </div>
					  </div>
					  <div class="form-group">
					    <label  class="col-lg-3 control-label">确认密码：</label>
					    <div class="col-lg-9">
					      <input type="password" class="form-control" required="required" name="newUserPwd2">
					    </div>
					  </div>
					  <div class="form-group">
					     <label  class="col-lg-3 control-label"></label>
					    <div class="col-lg-9">
					      <input type="submit" class="btn btn-info" value="注册"/>
					      <input type="reset" class="btn btn-danger" value="取消"/>
					     
					    </div>
					  </div>
					  
					</form>
		       </div>
		    </div>
		    <div class="row">
		       <div style="background-color:grey;height:100px;">
		          <div class="col-lg-12" style="text-align:center;line-height:100px;">
		             &copy;版权所有
		          </div>
		       </div>
		    </div>
		</div>
  <script type="text/javascript" src="static/js/jquery-1.12.3.min.js"></script>
  <script type="text/javascript" src="static/js/bootstrap.min.js"></script>
</body>
</html>