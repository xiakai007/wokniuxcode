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
   <div style="width:70%;margin:20px auto;text-align:right;">
     <a href="supplierAdd.jsp" class="btn btn-success">增加</a>
   </div>
   <table class="table table-striped table-bordered table-hover" style="width:70%;margin:20px auto;">
      <thead>
         <tr>
           <th>供应商id</th>
           <th>供应商编号</th>
           <th>供应商名称</th>
           <th>供应商手机号</th>
           <th>操作</th>
         </tr>
      </thead>
      <tbody>
         <%
           List<Supplier> listSuppliers=(List<Supplier>)request.getAttribute("list2");
         if(listSuppliers!=null){  
         for(Supplier supplier:listSuppliers){
         %>
         <tr>
            <td><%=supplier.getSupp_id() %></td>
            <td><%=supplier.getSupp_code() %></td>
            <td><%=supplier.getSupp_name() %></td>
            <td><%=supplier.getSupp_phone() %></td>
            <td>
              <a href="supplierDel.do?supp_id=<%=supplier.getSupp_id()%>" class="btn btn-danger btn-xs">
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