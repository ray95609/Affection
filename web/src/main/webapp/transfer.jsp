<%@page import="uuu.Affection.entity.Customer"%>
<%@page import="uuu.Affection.service.OrderService"%>
<%@page import="uuu.Affection.entity.Order"%>
<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Transfer</title>
<link rel="icon" href="favicon.ico" type="image/x-icon">
<link rel="stylesheet"   href="JQ/fancybox3/jquery.fancybox.css"/>


<style type="text/css">

.table_trans{
width:400px;
height:750px;
position:fixed;
top:5%;
left:-40%;
border-style: groove;
border-color: pink;
border-radius:30px;
display: flex;
flex-direction: column;
background-color: pink;
color:white; 
font-size:2em;
text-shadow: 3px 3px 5px grey;
box-shadow: 5px 5px 10px grey ;

}

.table_trans div{
margin-bottom:20px;
border-bottom-color: pink;
border-bottom-style: groove;

}

.table_trans input{
border-radius: 5px;
}


.notify{
width:50px;
height:50px;
margin: 0 auto; 
filter:drop-shadow(3px 3px 7px rgba(0, 0, 0, 0.7));

}

@keyframes swing_3{
	25%{transform:rotate(10deg)}
	50%{transform:rotate(0deg)}
	75%{transform:rotate(-10deg)}
	100%{transform:translateX(0px);}
	}
	
	
.notify:hover {
	animation:swing_3 0.05s 16;
}



</style>




<script 
src="https://code.jquery.com/jquery-3.0.0.js" 
integrity="sha256-jrPLZ+8vDxt2FnE1zvZXCkCcebI/C8Dt5xyaQBjxQIo=" 
crossorigin="anonymous"></script>   
<!-- <script type="text/javascript" src="jquery.js">  </script> -->
<script type="text/javascript" src="JQ/fancybox3/jquery.fancybox.js"></script> 
<script type="text/javascript">

transferJump();

function transferJump() {
	$(".table_trans").animate({left:"39.5%"},1000);
}




</script>



</head>
<body>



<%String orderId=request.getParameter("orderId");
  Customer member = (Customer)session.getAttribute("member");
  OrderService oService = new OrderService();	
  Order order = null;
  if(member!=null && orderId!=null){
  order = oService.getOrderHistoryByCustomerIdDetail(orderId,member.getId());
  }%>
<%if (order!=null){%>
<form class="transferForm" action="ATMTransfered.do" method="POST">
<div class="table_trans">
<div>Order ID<%=member.getName() %></div>
<div ><input readonly name="orderId" value="<%= order.getId() %>" required></div>
<div>Bank</div>
<div><input type="text" name="bank" required></input></div>
<div>Account Last 5 digits </div>
<div><input type="text" name="trans_account" required ></input></div>
<div>Amount</div>
<div><input readonly type="number" min="1"  name="trans_amount" required value="<%=order.getTotalAmount()%>"></input></div>
<div>Transfer time</div>
<div><input type="date" name="trans_date" required></input>
  	 <input type="time" name="trans_time" required></input>
</div>
<p>${requestScope.errors}</p>
<input type="image" src=img/icon/notify/notify.png class="notify"  onclick="submit()">
</div>

</form>

<%} %>










</body>
</html>