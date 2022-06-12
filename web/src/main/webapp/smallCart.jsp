<%@page import="uuu.Affection.entity.ShopingCart"%>
<%@page import="uuu.Affection.entity.CartItem"%>
<%@page import="uuu.Affection.entity.Product"%>
<%@page pageEncoding="UTF-8" contentType="text/plain"%>


${sessionScope.cart.getTotalQuantity()}


<!--  DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>MemberCenter</title>
<style type="text/css">


.cartJump{
width:300px;
height:80%;
position:fixed;
top:15%;
right:-350px ; 
background-color:pink;
color:white;
z-index:5; 
opacity:1;
display:flex;
flex-direction:column; 
border-radius: 30px 0 0 30px;
overflow:auto; 
opacity:0.9; 
border-style:groove; 
scrollbar-color: #FFAAD5 white;
scrollbar-width: thin;
}

.cartJump_ul{
position:relative;
top:-70px;

}

ul,li{
margin:0px 10px 0 0 ;
list-style:none; 
float: right;
text-shadow: 1px 1px 3px black;
font-size: 1.1em;

}

.cartJump img{
margin-top:10px;
max-width:100px ;
max-height:100px ;
float:left;
margin-left:20px;  
border-radius: 25px;

}


.historylist img{
	float:left;
	position:relative;
	left:18%;
	width:50px;
	height:50px;	
	margin:0.6% 0% 0% 0%;
	opacity:1; 
	transition: all 1s;
}

@keyframes swing_3{
	25%{transform:rotate(10deg)}
	50%{transform:rotate(0deg)}
	75%{transform:rotate(-10deg)}
	100%{transform:translateX(0px);}
	}

.historylist img:hover{
	animation:swing_3 0.05s 2;
	
}



</style>

</head>
<body>



<%--ShopingCart scart =(ShopingCart)session.getAttribute("scart");%>
	<%if(scart!=null){ %>
	<div class="cartJump">
	<%for(CartItem item:scart.getCartItemSet()){
	Product p=item.getProduct(); %>
	<img src="<%=p.getPhotoUrl() %>">
	<div class="cartJump_ul">
	<ul>	
	<li><%=p.getName() %></li>
	<br>
	<li><%=p.getPrice() %></li>
	</ul>
	</div>
	<%}%>
	</div>
	<%} --%>






</body>
</html-->