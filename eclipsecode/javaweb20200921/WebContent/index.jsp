<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link href="static/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
</head>
<body>
   <div class="container-fluid">
	  <div class="row" style="background-color:black;color:white;height:80px;">
		   <div class="col-lg-12" style="text-align:center;line-height:80px;">
		       <h1 align="center">后台管理系统</h1>
		   </div>
	  </div>
	  <div class="row" style="height:450px;">
	    <div class="col-lg-2">
	      <div class="panel-group" id="accordion">
	       <!-- 第一组折叠 -->
		   <div class="panel panel-default">
		    <div class="panel-heading" role="tab" id="headingOne">
		      <h4 class="panel-title">
		        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
		                                         系统管理
		        </a>
		      </h4>
		    </div>
		    <div id="collapseOne" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
		      <div class="panel-body">
		        <ul>
		          <li>
		            <a href="#">用户管理</a>
		          </li>
		          <li>
		            <a href="#">修改密码</a>
		          </li>
		        </ul>
		      </div>
		    </div>
		  </div>
		  <!-- 第二组折叠 -->
		   <div class="panel panel-default">
		    <div class="panel-heading" role="tab" id="headingTwo">
		      <h4 class="panel-title">
		        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
		                                         基础数据管理
		        </a>
		      </h4>
		    </div>
		    <div id="collapseTwo" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingTwo">
		      <div class="panel-body">
		        <ul>
		          <li>
		            <a href="goodsTypeList.do" target="frame1">商品类型管理</a>
		          </li>
		          <li>
		            <a href="supplierList.do" target="frame1">商品供应商管理</a>
		          </li>
		          <li>
		            <a href="goodsList.do" target="frame1">商品管理</a>
		          </li>
		        </ul>
		      </div>
		    </div>
		  </div>
		  <!-- 第三组折叠 -->
		   <div class="panel panel-default">
		    <div class="panel-heading" role="tab" id="headingThree">
		      <h4 class="panel-title">
		        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="true" aria-controls="collapseThree">
		                                         仓库管理
		        </a>
		      </h4>
		    </div>
		    <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
		      <div class="panel-body">
		        <ul>
		          <li>
		            <a href="#">入库管理</a>
		          </li>
		          <li>
		            <a href="#">出库管理</a>
		          </li>
		          <li>
		            <a href="#">商品管理</a>
		          </li>
		        </ul>
		      </div>
		    </div>
		  </div>
		  
		</div>
	    </div>
		<div class="col-lg-10">
		  <iframe name="frame1" width="100%" height="450px" frameborder="0"></iframe>
		</div>
	  </div>
	  <div class="row">
		       <div style="background-color:grey;height:80px;">
		          <div class="col-lg-12" style="text-align:center;line-height:80px;">
		             &copy;版权所有
		          </div>
		       </div>
	  </div>
   </div>
   <script type="text/javascript" src="static/js/jquery-1.12.3.min.js"></script>
   <script type="text/javascript" src="static/js/bootstrap.min.js"></script>
</body>
</html>