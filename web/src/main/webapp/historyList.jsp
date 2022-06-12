<%@page import="uuu.Affection.entity.OrderItem"%>
<%@page import="uuu.Affection.entity.Product"%>
<%@page import="uuu.Affection.service.OrderService"%>
<%@page import="uuu.Affection.entity.Order"%>
<%@page import="uuu.Affection.entity.Customer"%>
<%@page import="uuu.Affection.entity.PaymentType"%>
<%@page import="java.util.List"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Order History</title>
<link rel="stylesheet"   href="JQ/fancybox3/jquery.fancybox.css"/>
<link rel="icon" href="favicon.ico" type="image/x-icon">
<link href="Setting.css" rel="stylesheet"></link>

<style type="text/css">

body{
overflow:hidden; 
}

.table2{
margin:5% auto;
width: 60%;
height:350px;
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
height:20px; 
background-color:pink;
border-style:dashed;
border-color:white;

}

td{
margin:0;
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

.Detail{
width:1200px;
border-radius: 30px;

}

.transfer_detail{
width:500px;
height:800px;
border-radius: 30px;
}

</style>

<script 
src="https://code.jquery.com/jquery-3.0.0.js" 
integrity="sha256-jrPLZ+8vDxt2FnE1zvZXCkCcebI/C8Dt5xyaQBjxQIo=" 
crossorigin="anonymous"></script>
<script type="text/javascript" src="JQ/fancybox3/jquery.fancybox.js"></script>   
<!-- <script type="text/javascript" src="jquery.js">  </script> -->
<script src="jq_setting.js"></script>

<script>
function getDtail(oid){
	
	//同步請求
	//location.href="historyDetail.jsp?orderId="+oid;
	//非同步請求Ajax  {}=jason 預設method為get
	$.ajax({
			url:"historyDetail.jsp?orderId="+oid,
			method:"GET",
			}).done(getDtailDoneHandler).fail(getDtailFailHandler);
	}
function getDtailDoneHandler(response,status,xhr){
	//代換原來BODY內容
	//$(".Detail").html(response);
	
	//部分更新:fancybox燈箱效果
	$(".Detail").html(response);
	$.fancybox.open({
	src  : ".Detail",
	type : "inline",
	opts : {
	afterShow : function( instance, current ) {
	console.info( 'done!' );
				}
			}
		});	
	}
	
	
function getDtailFailHandler(xhr, status, error){
	alert("查詢明細失敗: " + status + "," + error);
}
	
	
function getTransfer(oid) {
	//同步請求
	//location.href="transfer.jsp?orderId="+oid;
	$.ajax({
		url:"transfer.jsp?orderId="+oid,
		method:"GET",
		}).done(getTransferHandler).fail(getTransferFailHandler);
}	
	
function getTransferHandler(response,status,xhr){
	//代換原來BODY內容
	//$(".transfer_detail").html(response);
	
	//部分更新:fancybox燈箱效果
	$(".transfer_detail").html(response);
	$.fancybox.open({
	src  : ".transfer_detail",
	type : "inline",
	opts : {
	afterShow : function( instance, current ) {
	console.info( 'done!' );
				}
			}
		});	
	}	
	
	
function getTransferFailHandler(xhr, status, error){
	alert("查詢交易狀態: " + status + "," + error);
}




</script>



</head>
<body>
<jsp:include page="/subviews/header.jsp" />

<%  Customer member=(Customer)session.getAttribute("member");
	Order o =(Order)session.getAttribute("o");
	List<Order> list=null;
	if(member!=null){
	  OrderService oService=new OrderService();
	  list=oService.getOrderHistoryByCustomerId(member.getId());
	  }%>
<div class="main">

<% if(list!=null && list.size()>0){%>
<table class="table2">
<caption><h1 style="color:white;">Order List</h1> </caption>
<tr>
<th>Number</th>
<th>Order</th>
<th>Payment</th>
<th>Transaction date</th>
<th>Status</th>
<th>Amount</th>
<th class="ppxx">Detail</th>
</tr>


<%for(Order order:list){ %>
<tr>
<td><%=order.getId() %></td>
<td><%=member.getName() %></td>
<td><%=order.getPaymentType()%></td>
<td><%=order.getOrderDate()%></td>
<td><% if(order.getPaymentType() == PaymentType.ATM && order.getStatus()==0){%><a href="javascript:getTransfer(<%= order.getId()%>)">通知已轉帳</a><%}else{ %><%=order.getStatusString() %><%} %></td>
<td><%=order.getTotalAmount() %>元</td>
<td><a data-fancybox="gallery" href="javascript:getDtail(<%= order.getId()%>)" > + </a></td>
</tr>
<%}%>
<!-- 購物清單用div彈出 or 在下方展開購物清單 捐贈品與數量與價格  maybe DAO要改變查詢方式? join 其他表單 -->
</table>
<%}else{%>
<div class="buy_faild">
<h1>Oops!查無歷史紀錄</h1>
</div>	
<%}%>


<h1 class="tk" >Thank You For Donation</h1>

<%if(member!=null){ %>
<%int i =(int)(Math.random()*10); %>
<div class="face">
<img src="img/face/face<%=i%>.png" class="faceImg" >
</div>
<div class="grateful_word">
<p>
Thank you for your donation<br>
Let me grow up healthy and happy.
</p>
</div>
<%} %>

<div class="Detail">
</div>

<div class="transfer_detail" >
</div>

</div>



<jsp:include page="/subviews/footer.jsp" />




</body>
</html>