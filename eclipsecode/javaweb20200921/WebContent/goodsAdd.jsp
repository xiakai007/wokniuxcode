<%@page import="com.woniu.entities.Goods"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="static/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
</head>
<body>
   <form class="form-horizontal" action="goodsSave.do" method="post" style="width:500px;margin: 20px auto"> 
		<div class="form-group">
			<label class="col-sm-4 control-label">类型id：</label>
			<div class="col-sm-6 ">
				<input type="text" class="form-control"  required="required" name="type_id">
			
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">供应商id：</label>
			<div class="col-sm-6 ">
				<input type="text" class="form-control"  required="required" name="supp_id">
			
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">商品编号：</label>
			<div class="col-sm-6 ">
				<input type="text" class="form-control"  required="required" name="goods_code">
			
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">商品名称：</label>
			<div class="col-sm-6 ">
				<input type="text" class="form-control"  required="required" name="goods_name">
			
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">商品库存：</label>
			<div class="col-sm-6 ">
				<input type="text" class="form-control"  required="required" name="goods_sum">
			
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">商品价格：</label>
			<div class="col-sm-6 ">
				<input type="text" class="form-control"  required="required" name="goods_price">
			
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">商品照片：</label>
			<div class="col-sm-6 ">
				<input type="text" class="form-control"  required="required" name="goods_photo">
			
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">商品描述：</label>
			<div class="col-sm-6 ">
				<input type="text" class="form-control"  required="required" name="goods_desc">
			
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-4 control-label"></label>
			<div class="col-sm-6">
			    
				     	<input type="submit" class="btn btn-info" value="保存"/>
				    	<input type="reset" class="btn btn-info" value="取消"/>
			
			</div> 
		</div>
</form>
   
   <script type="text/javascript" src="static/js/jquery-1.12.3.min.js"></script>
   <script type="text/javascript" src="static/js/bootstrap.min.js"></script>
</body>
</html>