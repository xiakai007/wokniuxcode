<%@page import="com.woniu.entities.Goods"%>
<%@page import="com.woniu.entities.PageBean"%>
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
   <%--点击查询后保留查询字段信息 --%>
   <%
   Goods goods1=(Goods)request.getAttribute("goods1");
   String goods_code="";
   String supp_name="";
   String type_name="";
   if(goods1.getGoods_code()!=null){
	   goods_code=goods1.getGoods_code();
   }
   if(goods1.getSupp_name()!=null){
	   supp_name=goods1.getSupp_name();
   }
   if(goods1.getType_name()!=null){
	   type_name=goods1.getType_name();
   }
   %>
   <div style="width:95%;margin:5px auto;">
     <form action="goodsList.do?oper=gdlist" method="post" name="form1">
       <input type="text" name="goods_code" placeholder="请输入商品编号" value="<%=goods_code%>"/>
       <input type="text" name="supp_name" placeholder="请输入供应商名称" value="<%=supp_name%>"/>
       <input type="text" name="type_name" placeholder="请输入类型名称" value="<%=type_name%>"/>
       <input type="submit" value="查询" class="btn btn-primary"/>
       <input type="hidden" name="currentPage" value="1"/>
     </form>
   </div>
   <div style="width:95%;margin:5px auto;text-align:right;">
     <a href="goodsList.do?oper=addTSid" class="btn btn-success">
                  增加
     </a>
   </div>
   <table class="table table-striped table-bordered table-hover" style="width:95%;margin:5px auto;">
      <thead>
         <tr>
           <th>商品id</th>
           <th>类型id</th>
           <th>类型名称</th>
           <th>供应商id</th>
           <th>供应商名称</th>
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
         PageBean<Goods> pageBean=(PageBean<Goods>)request.getAttribute("pageBean");
         if(pageBean.getData()!=null){  
         for(Goods goods:pageBean.getData()){
         %>
         <tr>
            <td><%=goods.getGoods_id() %></td>
            <td><%=goods.getType_id() %></td>
            <td><%=goods.getType_name() %></td>
            <td><%=goods.getSupp_id() %></td>
            <td><%=goods.getSupp_name() %></td>
            <td><%=goods.getGoods_code() %></td>
            <td><%=goods.getGoods_name() %></td>
            <td><%=goods.getGoods_sum() %></td>
            <td><%=goods.getGoods_price() %></td>
            <td><%=goods.getGoods_photo() %></td>
            <td><%=goods.getGoods_desc() %></td>
            <td>
              <a href="goodsList.do?goods_id=<%=goods.getGoods_id()%>&oper=del" class="btn btn-danger btn-xs">
                                                   删除
              </a>
              <a href="goodsList.do?goods_id=<%=goods.getGoods_id()%>&oper=updGs" class="btn btn-info btn-xs">
                                                   修改
              </a>
            </td>
         </tr>
         <%
           }}
         %>
      </tbody>
   </table>
   <div style="width:95%;margin:0px auto;">
     <ul class="pagination pull-right">
       <li >
         <a href="javascript:goPage(<%=pageBean.getCurrentPage()-1%>)" aria-label="Previous">
           <span aria-hidden="true">&laquo;</span>
         </a>
       </li>
       <%
        for(int i=1;i<=pageBean.getPages();i++){
       %>
       <li 
         <%
          if(i==pageBean.getCurrentPage()){
         %>
         class="active"
         <%
          }
         %>
       ><a href="javascript:goPage(<%=i%>)"><%=i%></a></li>
       <%
        }
       %>
       <li >
         <a href="javascript:goPage(<%=pageBean.getCurrentPage()+1%>)" aria-label="Next">
           <span aria-hidden="true">&raquo;</span>
         </a>
       </li>
     </ul>
   </div>

   <script type="text/javascript" src="static/js/jquery-1.12.3.min.js"></script>
   <script type="text/javascript" src="static/js/bootstrap.min.js"></script>
   <script type="text/javascript">
     function goPage(crpage){
    	 //form1.action="goodsList.do?oper=gdlist&currentPage="+crpage;//查询时提交查询条件和当前页信息方式一
    	 form1.currentPage.value=crpage;//查询时提交查询条件和当前页信息方式二
    	 form1.submit();//js函数表单提交
     }
   </script>
</body>
</html>