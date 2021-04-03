<%@page import="java.util.List"%>
<%@page import="com.woniu.entities.Users"%>
<%@page import="com.woniu.entities.Goods"%>
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
     List<Users> listUsers=(List<Users>)request.getAttribute("listUsers");
     List<Goods> listGoods=(List<Goods>)request.getAttribute("listGoods");
     %>
	 <form class="form-horizontal" action="instockList.do?oper=add" method="post" style="width:600px;margin:5px auto;">
	  <div class="form-group">
	    <label class="col-sm-3 control-label">入库人：</label>
	    <div class="col-sm-7">
	      <select name="user_id" class="form-control">
	        <option>请选择入库人</option>
	        <%
	          for(Users user:listUsers){
	        %>
	        <option value="<%=user.getUser_id()%>">
	          <%=user.getUser_name()%>
	        </option>
	         <%
	          }
	        %>
	      </select>
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="col-sm-3 control-label">商品名称：</label>
	    <div class="col-sm-7">
	      <select name="goods_id" class=form-control>
	        <option>请选择商品</option>
	        <%
	          for(Goods goods:listGoods){
	        %>
	        <option value="<%=goods.getGoods_id()%>">
	          <%=goods.getGoods_name()%>
	        </option>
	        <%
	          }
	        %>
	      </select>
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="col-sm-3 control-label">入库编号：</label>
	    <div class="col-sm-7">
	      <input type="text" class="form-control" required="required" name="instock_code">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="col-sm-3 control-label">入库时间：</label>
	    <div class="col-sm-7">
	      <input type="text" class="form-control" required="required" name="instock_time">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="col-sm-3 control-label">入库状态：</label>
	    <div class="col-sm-7">
	      <input type="text" class="form-control" required="required" name="instock_status">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="col-sm-3 control-label">备注：</label>
	    <div class="col-sm-7">
	      <input type="text" class="form-control" required="required" name="instock_rms">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="col-sm-3 control-label">入库数量：</label>
	    <div class="col-sm-7">
	      <input type="text" class="form-control" required="required" name="instock_count">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="col-sm-3 control-label"></label>
	    <div class="col-sm-7">
	      <input type="submit" class="btn btn-primary" value="保存">
	      <input type="reset" class="btn"  value="取消">
	    </div>
	  </div>
	</form>
   <script type="text/javascript" src="static/js/jquery-1.12.3.min.js"></script>
   <script type="text/javascript" src="static/js/bootstrap.min.js"></script>
</body>
</html>