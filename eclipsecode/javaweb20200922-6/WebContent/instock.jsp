<%@page import="com.woniu.entities.Instock"%>
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
   List<Instock> listInstock =(List<Instock>)request.getAttribute("listInstock");
   
   %>
   <div style="width:95%;margin:5px auto;text-align:right">
     <a href="instockList.do?oper=addUGid" class="btn btn-success btn-sm">
                     增加
     </a>
   </div>
   <table class="table table-striped table-bordered table-hover" style="width:95%;margin:10px auto">
     <thead>
      <tr>
       <th>入库id</th>
       <th>入库人id</th>
       <th>商品id</th>
       <th>入库编号</th>
       <th>入库时间</th>
       <th>入库状态</th>
       <th>备注</th>
       <th>入库数量</th>
       <th>操作</th>
       </tr>
     </thead>
     <tbody>
      <%
        for(Instock instock:listInstock){
      %>
      <tr>
       <td><%=instock.getInstock_id()%></td>
       <td><%=instock.getUser_id()%></td>
       <td><%=instock.getGoods_id()%></td>
       <td><%=instock.getInstock_code()%></td>
       <td><%=instock.getInstock_time()%></td>
       <td><%=instock.getInstock_status()%></td>
       <td><%=instock.getInstock_rms()%></td>
       <td><%=instock.getInstock_count()%></td>
       <td>
         <a href="instockList.do?instock_id=<%=instock.getInstock_id()%>&oper=del" class="btn btn-danger btn-sm">
                              删除
         </a>
         <a href="instockList.do?instock_id=<%=instock.getInstock_id()%>&oper=updIns" class="btn btn-primary btn-sm">
                              修改
         </a>
       </td>
       </tr>
      <%
        }
      %>
     </tbody>
   </table>
   <script type="text/javascript" src="static/js/jquery-1.12.3.min.js"></script>
   <script type="text/javascript" src="static/js/bootstrap.min.js"></script>
</body>
</html>