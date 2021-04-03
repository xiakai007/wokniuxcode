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
<script type="text/javascript">
var xmlHttp;
function createXMLHttpRequest(){
	  if(window.ActiveXObject){
		  xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }else{
		  xmlHttp= new XMLHttpRequest();
	  }
}
//向服务器发送请求
function sendData(){
	  createXMLHttpRequest();
	  //设置xmlHttp对象
	  xmlHttp.open("post","isProper.do",true);
	  //设置请求头
	  xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	  //设置xmlHttp对象的状态改变时要执行的函数
	  xmlHttp.onreadystatechange=getData;
	  xmlHttp.send("checkName="+myform.newUserName.value);
}
//xmlHttp.readyState状态改变时调用此函数
function getData(){
	  if(xmlHttp.readyState==4&&xmlHttp.status==200){
		  var res=xmlHttp.responseText;
		  if(res=="true"){
			  document.getElementById("sp1").innerHTML="该用户名已被注册：不可用！";
		  }else{
			  document.getElementById("sp1").innerHTML="用户名可用";
		  }
	  }
}
  function checkData(){
	  if(myform.newUserPwd1.value==myform.newUserPwd2.value){
		  return true;
	  }else{
		  alert("两次密码必须一致");
		  return false;
	  }
  }
</script>
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
					<form class="form-horizontal" action="#" method="post" id="form1" onsubmit="return checkData()" name="myform">
					  <div class="form-group">
					   <label  class="col-lg-3 control-label">新用户名：</label>
					   <div class="col-lg-9">
					      <input type="text" class="form-control" required="required" name="newUserName"
					       onblur="sendData();">
					      <span id="sp1"></span>
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