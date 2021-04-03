<%@page import="com.woniu.entities.GoodsType"%>
<%@page import="com.woniu.entities.PageType"%>
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
   <!-- 客能显示 --><%--客不能显示 --%>
   <%
   GoodsType gdstype=(GoodsType)request.getAttribute("goodsType");
   String type_code="";
   String type_name="";
   if(gdstype.getType_code()!=null){
	   type_code=gdstype.getType_code();
   }
   if(gdstype.getType_name()!=null){
	   type_name=gdstype.getType_name();
   }
   %>
   <div style="width:70%;margin:20px auto;">
     <form action="goodsType.do?oper=typelist" method="post" name="form1">
       <input type="text" name="type_code" placeholder="请输入类型编号" value="<%=type_code%>"/>
       <input type="text" name="type_name" placeholder="请输入类型名称" value="<%=type_name%>"/>
       <input type="submit" value="查询" class="btn btn-info"/>
       <input type="hidden" name="currentPage" value="1"/>
     </form>
   </div>
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
         PageType<GoodsType> pageType=(PageType<GoodsType>)request.getAttribute("pageType");
         if(pageType.getPagaData()!=null){  
         for(GoodsType goodsType:pageType.getPagaData()){
         %>
         <tr>
            <td><%=goodsType.getType_id() %></td>
            <td><%=goodsType.getType_code() %></td>
            <td><%=goodsType.getType_name() %></td>
            <td >
              <a href="goodsType.do?type_id=<%=goodsType.getType_id()%>&oper=del" class="btn btn-danger btn-xs">
                                                   删除
              </a>
              <a href="goodsType.do?type_id=<%=goodsType.getType_id()%>&oper=updUI" class="btn btn-primary btn-xs">
                                                   修改
              </a>
            </td>
         </tr>
         <%
           }}
         %>
      </tbody>
   </table>
   <div style="width:70%;margin:10px auto;">
     <ul class="pagination pull-right">
       <li>
         <a href="javascript:goPage(<%=pageType.getCurrentPage()-1%>)" aria-label="Previous">
           <span aria-hidden="true">&laquo;</span>
         </a>
       </li>
       <%
         for(int i=1;i<=pageType.getPages();i++){
       %>
       <li
       <%
         if(i==pageType.getCurrentPage()){
       %>
         class="active"
       <%
         }
       %>
       >
         <a href="javascript:goPage(<%=i%>)">
           <%=i%>
         </a>
       </li>
       <%
         }
       %>
       <li>
         <a href="javascript:goPage(<%=pageType.getCurrentPage()+1%>)" aria-label="Next">
           <span aria-hidden="true">&raquo;</span>
         </a>
       </li>
     </ul>
   </div>
   <script type="text/javascript" src="static/js/jquery-1.12.3.min.js"></script>
   <script type="text/javascript" src="static/js/bootstrap.min.js"></script>
   <script type="text/javascript">
     function goPage(ctpage){
    	 form1.currentPage.value=ctpage;
    	 form1.submit();
     }
   </script>
</body>
</html>