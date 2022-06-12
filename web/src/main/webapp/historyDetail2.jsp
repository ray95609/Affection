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
<link href="Setting.css" rel="stylesheet"></link>
<style type="text/css">

table{
margin:15% auto;
width: 60%;
background-color: pink;
display: block;
overflow:auto; 
scrollbar-color: #FFAAD5 white;
scrollbar-width: thin;
border-radius: 20px;
opacity:0.9; 
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

.tk{
position:absolute;
left:37.5%;
bottom:10%;
font-size:3em; 
text-decoration: underline;
}

.buy_faild{
margin: 10%;
text-align: center;
font-size: 2em;
display:none; 
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
<script src="jq_setting.js"></script>
<script type="text/javascript">







</script>


</head>
<body>
<jsp:include page="/subviews/header.jsp" />

<%  String orderId=request.getParameter("orderId");
	Customer member=(Customer)session.getAttribute("member");
	
	if(member!=null && orderId!=null){
	OrderService oService=new OrderService();
	Order order=oService.getOrderHistoryByCustomerIdDetail(orderId,member.getId());%>
	
 

<div class="main">

<table>
<tr>
<th>Product</th>
<th>Price</th>
<th>Quantity</th>
</tr>

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

<%}%>



</div>

<jsp:include page="/subviews/footer.jsp" />




</body>
</html>