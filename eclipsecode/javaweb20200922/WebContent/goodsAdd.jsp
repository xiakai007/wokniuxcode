<%@page import="com.woniu.entities.Goods"%>
<%@page import="com.woniu.entities.GoodsType"%>
<%@page import="com.woniu.entities.Supplier"%>
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
   <%
   List<GoodsType> listTypes=(List<GoodsType>)request.getAttribute("listTypes");
   List<Supplier> listSuppliers=(List<Supplier>)request.getAttribute("listSuppliers");
   %>
   <form class="form-horizontal" action="goodsList.do?oper=add" method="post" style="width:500px;margin: 20px auto"> 
		<div class="form-group">
			<label class="col-sm-4 control-label">类型名称：</label>
			<div class="col-sm-6 ">
			  <!--<input type="text" class="form-control"  required="required" name="type_id">-->
			    <select name="type_id" class="form-control">
				  <option>请选择类型名称</option>
				  <%
				   for(GoodsType goodsType:listTypes){
				  %>
				  <option value="<%=goodsType.getType_id()%>">
				    <%=goodsType.getType_name()%>
				  </option>
				  <%
				   }
				  %>
				</select>
			
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">供应商名称：</label>
			<div class="col-sm-6 ">
			 <!--<input type="text" class="form-control"  required="required" name="supp_id">-->
				<select name="supp_id" class="form-control">
				  <option>请选择供应商名称</option>
				  <%
				   for(Supplier supplier:listSuppliers){
				  %>
				  <option value="<%=supplier.getSupp_id()%>">
				    <%=supplier.getSupp_name()%>
				  </option>
				  <%
				   }
				  %>
				</select>
			
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