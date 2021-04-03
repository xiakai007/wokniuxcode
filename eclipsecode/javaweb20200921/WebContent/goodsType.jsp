<%@page import="com.woniu.entities.GoodsType"%>
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
   <!-- 客能 --><%--客不能 --%>
   <div style="width:70%;margin:20px auto;text-align:right;">
     <a href="goodsTypeAdd.jsp" class="btn btn-success">增加</a>
   </div>
   <table class="table table-striped table-bordered table-hover" style="width:70%;margin:20px auto;">
      <thead>
         <tr>
           <th>类型id</th>
           <th>类型编号</th>
           <th>类型名称</th>
           <th>操作</th>
         </tr>
      </thead>
      <tbody>
         <%
           List<GoodsType> listTypes=(List<GoodsType>)request.getAttribute("list");
         if(listTypes!=null){  
         for(GoodsType goodsType:listTypes){
         %>
         <tr>
            <td><%=goodsType.getType_id() %></td>
            <td><%=goodsType.getType_code() %></td>
            <td><%=goodsType.getType_name() %></td>
            <td >
              <a href="goodsTypeDel.do?type_id=<%=goodsType.getType_id()%>" class="btn btn-danger btn-xs">
                                                   删除
              </a>
              <a href="goods.do?type_id=<%=goodsType.getType_id()%>&oper=updUI" class="btn btn-primary btn-xs">
                                                   修改
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