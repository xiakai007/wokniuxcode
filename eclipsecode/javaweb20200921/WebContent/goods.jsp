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
   <div style="width:70%;margin:20px auto;text-align:right;">
     <a href="goodsAdd.jsp" class="btn btn-success">增加</a>
   </div>
   <table class="table table-striped table-bordered table-hover" style="width:70%;margin:20px auto;">
      <thead>
         <tr>
           <th>商品id</th>
           <th>类型id</th>
           <th>供应商id</th>
           <th>商品编号</th>
           <th>商品名称</th>
           <th>商品库存</th>
           <th>商品价格</th>
           <th>商品照片</th>
           <th>商品描述</th>
           <th>操作</th>
         </tr>
      </thead>
      <tbody>
         <%
           List<Goods> listGoods=(List<Goods>)request.getAttribute("list3");
         if(listGoods!=null){  
         for(Goods goods:listGoods){
         %>
         <tr>
            <td><%=goods.getGoods_id() %></td>
            <td><%=goods.getType_id() %></td>
            <td><%=goods.getSupp_id() %></td>
            <td><%=goods.getGoods_code() %></td>
            <td><%=goods.getGoods_name() %></td>
            <td><%=goods.getGoods_sum() %></td>
            <td><%=goods.getGoods_price() %></td>
            <td><%=goods.getGoods_photo() %></td>
            <td><%=goods.getGoods_desc() %></td>
            <td>
              <a href="goodsDel.do?goods_id=<%=goods.getGoods_id()%>" class="btn btn-danger btn-xs">
                                                   删除
              </a>
            </td>
         </tr>
         <%
           }}
         %>
      </tbody>
   </table>

   <script type="text/javascript" src="static/js/jquery-1.12.3.min.js"></script>
   <script type="text/javascript" src="static/js/bootstrap.min.js"></script>
</body>
</html>