<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="uuu.Affection.entity.Product"%>
<%@page import="uuu.Affection.entity.OrderItem"%>
<%@page import="uuu.Affection.service.OrderService"%>
<%@page import="java.util.List"%>
<%@page import="uuu.Affection.entity.Order"%>
<%@page import="uuu.Affection.entity.Customer"%>
<%@ page pageEncoding="UTF-8"%>





<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>History Detail</title>
<link rel="icon" href="favicon.ico" type="image/x-icon">
<link rel="stylesheet"   href="JQ/fancybox3/jquery.fancybox.css"/>
<script type="text/javascript" src="JQ/fancybox3/jquery.fancybox.js"></script> 

<style type="text/css">

.table{
margin:0 auto;
width: 1000px;
background-color: pink;
display: block;
overflow:auto; 
scrollbar-color: #FFAAD5 white;
scrollbar-width: thin;
border-radius: 20px;
opacity:1; 
}

tr{
margin: 0;
}

th{
margin:0;
position:relative;
width:10%;
height:40px; 
background-color:pink;
border-style:dashed;
border-color:white;

}

td{
margin:0;
height:30px;
color:black;
text-align:center;
background-color:white;
border-color:pink;
border-bottom-style:ridge;   

}


h1{
color:pink;
text-shadow:  pink 3px 3px 10px;

}


.face{
position:fixed;
top:51%;
left:25%;
}

.face img{
border-radius:20px;
filter:drop-shadow(3px 3px 7px rgba(0, 0, 0, 0.7))
}

.grateful_word{
position:fixed;
top:48%;
left:40%;
font-size:2em; 
width:30%;
height:15%;
background-color: pink;
border-radius:20px;
box-shadow: black 1px 1px 10px 0px ;
border-style: solid;
border-color: white;
opacity:0.7; 
z-index:10; 
}
.grateful_word p{
margin:30px ;
color:white;
text-shadow:black 1px 1px 5px;  
}



</style>

<script 
src="https://code.jquery.com/jquery-3.0.0.js" 
integrity="sha256-jrPLZ+8vDxt2FnE1zvZXCkCcebI/C8Dt5xyaQBjxQIo=" 
crossorigin="anonymous"></script>   
<!-- <script type="text/javascript" src="jquery.js"> </script> -->


</head>
<body>



	
 



<table class="table">
<tr>
<th>Product</th>
<th>Price</th>
<th>Quantity</th>
</tr>


<%  String orderId=request.getParameter("orderId");
	Customer member=(Customer)session.getAttribute("member");
	Order order=null;
	if(member!=null && orderId!=null){
	OrderService oService=new OrderService();
	order=oService.getOrderHistoryByCustomerIdDetail(orderId,member.getId());
	}%>


<%if(order!=null){ %>
<%for(OrderItem oItem:order.getOrderItemSet()) {
Product p =oItem.getProduct();%>
<tr>
<td><%=p.getName()%></td>
<td><%=oItem.getPrice()%></td>
<td><%=oItem.getQuantity()%></td>
</tr>
<%}%>

<tr>
<th>Recipt name</th>
<th>Recipt address</th>
<th>Recipt phone</th>
</tr>
<tr>
<td><%=order.getOrdername() %></td>
<td><%=order.getOrderaddress() %></td>
<td><%=order.getOrderphone() %></td>
</tr>

</table>


<%}else{%>
	<h1 style="font-size: 3em; margin:20% 0 0 42%; ">查無訂單明細</h1>
<%}%>








</body>
</html>