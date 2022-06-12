<%@page import="uuu.Affection.service.ProductService"%>
<%@page import="uuu.Affection.service.OrderService"%>
<%@page import="uuu.Affection.entity.Product"%>
<%@page import="uuu.Affection.entity.CartItem"%>
<%@page import="uuu.Affection.entity.ShopingCart"%>
<%@page import="uuu.Affection.entity.Customer"%>
<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>ShopCar</title>
<link rel="icon" href="favicon.ico" type="image/x-icon">
<link href="Setting.css" rel="stylesheet"></link>
<style type="text/css">


/*.car{
width:70%;
height:70%;
position:fixed;
margin:10% auto; 
left:15%;
background-color:grey; 
color:white;
opacity:0.7; 
border-radius: 20px 20px 20px 20px;
box-shadow: black 3px 3px 15px 0px ; 
overflow:auto;
scrollbar-color: pink #e0e0e0;

}*/

.single{
position:relative;
width:70%;
height:120px;
float:left;
margin:2% 0 0 15%; 
top:150px;
background-color:pink; 
color:black; 
border-style:groove; 
border-radius:20px;
box-shadow: black 1px 1px 10px 0px inset; 
z-index:2; 
opacity:0.9; 
display:none; 
}

.single span{
position:relative;
margin:5%; 
font-size: 1.5em;
left:5%; 
top:30%;
color:white;
text-shadow: 1px 1px 5px black;
}

.single img{
position:relative;
max-width: 100px;
max-height: 100px;
margin:0.8%; 
float:left; 
border-radius:20px;
box-shadow: black 1px 1px 10px 0px ;
}

.single input{
position: relative;
width:30px;
height:30px;
left: 10%;
top: 35%; 
 }

.TP{
position:fixed;
width:200px;
height:40px;
background-color:pink;
color: white;
text-align:center;
left:45%;
top:11.5%;
opacity:1; 
border-radius:20px;
font-size: 1.5em;
box-shadow: black 1px 1px 5px 0px inset; 
z-index:6; 

}
.TP p{
margin: 3%;

}

.buy_function{
position:fixed;
width:60%;
height:5%;
top:17%; 
left:65%; 
z-index:6; 
}


.buy_function input{
width:50px;
height:50px;
filter:drop-shadow(3px 3px 7px rgba(0, 0, 0, 0.7))
}


.buy_faild{
margin: 10%;
text-align: center;
font-size: 2em;
display:none; 
}

@keyframes swing_2{
	0%{transform:scale(1.2,1.2)}
	25%{transform:scale(1.5,1.5)}
	50%{transform:scale(1.2,1.2)}
	75%{transform:scale(1.5,1.5)}
	100%{transform:translateX(0px);}
}

.Shopcart_Donate{
position:fixed;
width:55px;
height:50px;
top:17%;
left:49%;
cursor:pointer;
filter:drop-shadow(3px 3px 7px rgba(0, 0, 0, 0.7))
}


.Shopcart_Donate:hover {
	animation:swing_2 1s 2;
}

.More_Donation{
position:fixed;
width:55px;
height:50px;
top:17%;
left:34%;
filter:drop-shadow(3px 3px 7px rgba(0, 0, 0, 0.7));
cursor:pointer;
transition:all 1s;
}

.More_Donation:hover{
	transform:rotateY(180deg);
	transition:all 1s;
}

.Shopcart_Delete{
	transition:all 1s;
}

@keyframes swing_3{
	25%{transform:rotate(10deg)}
	50%{transform:rotate(0deg)}
	75%{transform:rotate(-10deg)}
	100%{transform:translateX(0px);}
	}
	
	
.Shopcart_Delete:hover {
	animation:swing_3 0.05s 2;
}


.Quantity input{
position: relative;
left:-20%; 
width:100px; 
float:right;
border-radius: 30px;
font-size: 1.5em;
text-align: center;
}

.amount{
position:relative;
float:right; 
top:6%;
}

.checkout{
position:fixed;
width:20%;
height:60%;
background-color: pink; 
color:white;
z-index:7; 
top:15%;
display:flex;
flex-direction: column;
left: -35%; 
border-radius: 0% 20% 20% 0%;
border-style:groove;
box-shadow: black 5px 5px 25px ; 
opacity: 0.9;
}

.checkout h2{
position:relative;
margin:-5% 0 0 5% ; 
text-shadow: 1px 1px 3px black;
}


.checkout div:nth-child(odd){
margin:5% 0 0% 15%; 
width: 60%;
height: 5%;
background-color:;
text-align: center;
border-bottom-style:dashed; 
border-radius: 20px 20px 0px 0px;
box-shadow: black 1px 1px 3px inset;
text-shadow: 1px 1px 3px black;

}

.checkout div:nth-child(even){
margin:0 0 0 15%; 
width: 60%;
height: 10%;
background-color:;
text-align: center;
border-radius: 0px 0px 20px 20px;
box-shadow: black 1px 1px 3px inset;
text-shadow: 1px 1px 3px black;

}

.checkout input:first-child{
margin:3% 0 0 0;
border-radius: 20px 20px 20px 20px;
width: 90%;
text-align:center;
}

.checkout selection{
margin:6% 0 0 0;
border-radius: 20px 20px 20px 20px;
width: 90%;
}

.checkout_button{
position:relative;
width:50px;
height:50px;
margin:5% 0 0 40%; 
}

.checkout_button:hover {
	animation:swing_2 1s 2;
}

.checkout img{
max-width:50px;
max-height:50px;
position:relative;
margin:0% 0 5% 75%;
cursor:pointer; 
}

.select{
margin:3% 0 0 0;
border-radius: 20px 20px 20px 20px;
width: 90%;
text-align:center;
}

</style>


<script 
src="https://code.jquery.com/jquery-3.0.0.js" 
integrity="sha256-jrPLZ+8vDxt2FnE1zvZXCkCcebI/C8Dt5xyaQBjxQIo=" 
crossorigin="anonymous"></script>   
<!-- <script type="text/javascript" src="jquery.js">  JJQ</script> -->
<script src="jq_setting.js"></script>
<script type="text/javascript">
$(document).ready(init_shopcart);
function init_shopcart()
{
	singleIn();
	
	$(".close_button").click(outCheckout);
	
	$(".Shopcart_Donate").click(deleteout);
	}
	
	
function singleIn(){
	time=setTimeout(singleIn, 500);
	$(".single").fadeIn(1000);
}

function gotoCheckout(){
	location.href='checkout.jsp';
	
}


function outCheckout(){
	$(".checkout").animate({"left":"-35%"},500);
}

function inCheckout(){
	$(".checkout").animate({"left":"0px"},500);
}

function backToDonate(){
	location.href='donate.jsp';
	
}


</script>


</head>
<body>
<jsp:include page="/subviews/header.jsp" />

<%ShopingCart scart =(ShopingCart)session.getAttribute("scart");%>

<!-- TODO 滑下來上下晃動(慣性) -->
<!-- TODO 購物車一直爆掉 -->
<div class="main">

<%if(scart!=null&& scart.size()>0) {
ProductService pService =new ProductService();%>

<%for(CartItem item:scart.getCartItemSet()){
	Product p=item.getProduct();%>
<form action="update_cart.do" method="POST">
<!-- div class="car"-->
	
<div class="single" >
<img src="<%=p.getPhotoUrl()%>">
<input type="checkbox" name="delete<%=item.hashCode()%>" >
<span name="need">Need(<%=pService.selectNeed(item) %>) </span>
<span name="price">$<%=p.getPrice()%></span>
<span name="Product"><%=p.getName() %></span>
<div class="Quantity">
<input type="number" value="<%=scart.getQuantity(item)%>" required
name="Quantity<%=item.hashCode() %>" min="1" max="<%=pService.selectNeed(item)%>">
</div>				 								      
<div class="amount">
<span>$<%=scart.getAmount(item)%></span>
</div>
</div>

<!--/div-->

<div class="TP">
<p>$<%=scart.getTotalAmount() %></p>
</div>
<%}%>
<!-- 按鈕一直衝突 -->
<div class="buy_function">														<!--TODO href donate -->
<img class="More_Donation" src=img/icon/continue/continue.png onclick="backToDonate()">
<img class="Shopcart_Donate" src=img/donate2.png onclick="gotoCheckout()">
<input type="image" class="Shopcart_Delete" src=img/icon/delete/edit.png onclick="submit()">
</form>


</div>
<%}else{%>
	<div class="buy_faild">
	<h1>Oops!<br>無選擇任何項目</h1>
	</div>
<%}%>

<div class="checkout">
<img src="img/icon/close/close.png" class="close_button">
<h2>Thank You For Your Donation</h2>
<form>
<%Customer member =(Customer) session.getAttribute("member");%>
<!-- TODO input的value需要跟購物車相同-->
<!--input type="hidden" name="price" value="<--%=p.getPrice()%>"-->

<div>Orderer</div> 
<div><input type="text" name="order_name" value="<%=member!=null?member.getName():""%>"></div>
<div>Phone</div>
<div><input type="text" name="order_phone" value="<%=member!=null?member.getPhone():""%>"></div>
<div>Address</div>
<div><input type="text" name="order_address" value="<%=member!=null?member.getAddress():""%>"></div>
<div>Payment</div>
<div>
<select name="order_payment" class="select">
<option>Cash</option>
<option>Transfer</option>
<option>Credit card</option>
</select>
</div>
<div>Receipt</div>
<div>
<select name="order_receipt" class="select">
<option>Electronic receipt</option>
<option>Paper receipt</option>
<option>Donation</option>
</select>
</div>
<input type="image" class="checkout_button" src=img/donate2.png onclick="">

</form>

</div>




<jsp:include page="/subviews/footer.jsp" />



</body>
</html>