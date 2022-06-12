<%@page import="java.util.List"%>
<%@page import="uuu.Affection.entity.ReceiptType"%>
<%@page import="uuu.Affection.entity.PaymentType"%>
<%@page import="uuu.Affection.entity.Product"%>
<%@page import="uuu.Affection.entity.CartItem"%>
<%@page import="uuu.Affection.entity.ShopingCart"%>
<%@page import="uuu.Affection.entity.Customer"%>
<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Checkout</title>
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
margin-top:2%; 
margin-left:15%;
top:150px;
background-color:pink; 
color:black; 
border-style:groove; 
border-radius:20px;
box-shadow: black 1px 1px 10px 0px inset; 
z-index:4; 
opacity:0.9; 

}

.single span{
position:relative;
margin:5%; 
font-size: 1.5em;
left:10%; 
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
text-shadow: 1px 1px 3px black;
}

.buy_function{
float:left;
width:60%;
height:20%;
position:fixed;
top:17%; 
left:28%; 
z-index:6; 
}


.buy_function input{
width:50px;
height:50px;
margin: 0%  10% 0% 10%;
filter:drop-shadow(3px 3px 7px rgba(0, 0, 0, 0.7))
}


.buy_faild{
margin: 10%;
text-align: center;
font-size: 2em;
display:none; 
}

.Shopcart_Donate{
width:55px;
height:50px;
margin: 70%  10% 0% 10%;
filter:drop-shadow(3px 3px 7px rgba(0, 0, 0, 0.7))
}

@keyframes swing_2{
	0%{transform:scale(1.2,1.2)}
	25%{transform:scale(1.5,1.5)}
	50%{transform:scale(1.2,1.2)}
	75%{transform:scale(1.5,1.5)}
	100%{transform:translateX(0px);}
}

.Shopcart_Donate:hover {
	animation:swing_2 1s 2;
}

.More_Donation{
 transition:all 1s;
}

.More_Donation:hover{
	transform:rotateY(180deg);
	transition:all 1s;
}

.fill{
	width:50px;
	height:50px;
	transition:all 1s;
	margin:0 0 0 15%;
	filter:drop-shadow(3px 3px 7px rgba(0, 0, 0, 0.7));
	cursor:pointer;
	display:none; 
}

@keyframes swing_3{
	25%{transform:rotate(10deg)}
	50%{transform:rotate(0deg)}
	75%{transform:rotate(-10deg)}
	100%{transform:translateX(0px);}
	}
	
	
.fill:hover {
	animation:swing_3 0.05s 2;
}


.Quantity{
position: relative;
margin:2.5% 0 0 0 ;
right:20%; 
width:100px; 
float:right;
border-radius: 30px;
font-size: 1.2em;
text-align: center;
}

.amount{
position:relative;
float:right; 
top:40%;
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

.select select{
margin:3% 0 0 0;
border-radius: 20px 20px 20px 20px;
width: 90%;
text-align:center;
}

.remind{
position:fixed;
top:15%;
right:29%;   
display:none; 
}

.check_err{
position: fixed;
top:10%;
left:-40%; 
width:30%;
height:8%;
background-color:pink; 
color:white; 
border-style:groove; 
box-shadow: black 1px 1px 10px 0px inset; 
border-radius:20px;
  
}

.check_err ul{
position:relative;
list-style:none; 
margin-left: 0;
margin-top:30px; 
}

.check_err li{
position:relative;
list-style:none; 
margin-left: 0;
}

</style>



<script 
src="https://code.jquery.com/jquery-3.0.0.js" 
integrity="sha256-jrPLZ+8vDxt2FnE1zvZXCkCcebI/C8Dt5xyaQBjxQIo=" 
crossorigin="anonymous"></script>   
<!-- <script type="text/javascript" src="jquery.js"> </script> -->
<script src="jq_setting.js"></script>
<script type="text/javascript">

$(document).ready(init_check);
function init_check()
{	
	singleIn();//Order表單
	
	remind();//提醒跳動
	
	function remind(){
		$(".remind").animate({"top":"14%"},300)
			        .animate({"top":"15%"},300,remind);}
	
	TPsize();//總價放大
	
	function TPsize(){
		$(".TP").animate({"left":"42%","width":"300px","height":"60px"},500)
				.animate({"font-size":"2.2em"},500)	;}
				
	spanSize();//敘述放大
	function spanSize(){
		$(".single").animate({"font-size":"1.5em"},500)
					.animate({"borderWidth":"0px"},100)
					.delay(500);}
	
	fillIn();//fillin
	function fillIn() {
		$(".fill").show(500);
		$(".remind").show(500);
	}
	
	
function singleIn(){
	time=setTimeout(singleIn, 500);
	$(".single").fadeIn(1000);
}

function gotoCheckout(){
	location.href='checkout.jsp';
	
}

$(".close_button").click(outCheckout);
function outCheckout(){
	$(".checkout").animate({"left":"-35%"},500);
}
$(".fill").click(inCheckout);
function inCheckout(){
	$(".checkout").animate({"left":"0px"},500);
}

checkErrJump();
function checkErrJump(){
	$(".check_err").animate({"left":"0%"},500);
	
}

}
</script>



</head>
<body>
<jsp:include page="/subviews/header.jsp" />
<!-- header -->

<%ShopingCart scart =(ShopingCart)session.getAttribute("scart");%>


<div class="main">

<%if(scart!=null&& scart.size()>0) {%>

<%for(CartItem item:scart.getCartItemSet()){
	Product p=item.getProduct();%>
<form action="checkout.do" method="POST">
<!-- div class="car"-->
	
<div class="single" >
<img src="<%=p.getPhotoUrl()%>">
<span name="price">$<%=p.getPrice()%></span>
<span name="Product"><%=p.getName() %></span>
<div class="Quantity">
<span name="Quantity<%=item.hashCode() %>"><%=scart.getQuantity(item)%></span>
</div>				 								      
<div class="amount" style="margin:-0.75% 0 0 0; ">
<span>$<%=scart.getAmount(item)%></span>
</div>
</div>

<!--/div-->

<div class="TP">
<p>$<%=scart.getTotalAmount() %></p>
</div>
<%}%>
<div class="checkout">
<img src="img/icon/close/close.png" class="close_button" >
<h2>Thank You For Your Donation</h2>
<%Customer member =(Customer) session.getAttribute("member");%>
<div>Order</div> 
<div><input type="text" name="order_name" value="<%=member!=null?member.getName():"Please login first"%>" required  <%if(member==null){%>readonly<%}%> ></div>
<div>Phone</div>
<div><input type="text" name="order_phone" value="<%=member!=null?member.getPhone():""%>" required <%if(member==null){%>readonly<%}%>></div>
<div>Address</div>
<div><input type="text" name="order_address" value="<%=member!=null?member.getAddress():""%>" required <%if(member==null){%>readonly<%}%>></div>
<div>Email</div>
<div><input type="text" name="order_email" value="<%=member!=null?member.getEmail():""%>" required <%if(member==null){%>readonly<%}%>></div>
<div>Payment</div>
<div class="select">
<select name="order_payment"  required >
<option value="">Please Select...</option>
<% for(PaymentType pType:PaymentType.values()){%>
<option value="<%= pType.name()%>" >
<%=pType%>
</option>
<%}%>
</select>
</div>

<div>Receipt</div>
<div class="select">
<select name="order_receipt"  required>
<option value="">Please Select...</option>
<% for(ReceiptType rType:ReceiptType.values()){%>
<option value="<%= rType.name()%>">
<%=rType%>
</option>
<%}%>
</select>
</div>
</div>



<div class="buy_function">													<!--TODO href shopcart -->
<input type="image" class="More_Donation" src=img/icon/continue/continue.png onclick="history.go(-1)">
<input type="image" class="Shopcart_Donate" src=img/donate2.png onclick="submit()">
<img class="fill" src=img/icon/order/order.png >


</form>

</div>
<%}else{%>
	<div class="buy_faild">
	<h1>Oops!<br>無選擇任何項目</h1>
	</div>
<%}%>

<!-- TODO 製作四個邊角 做出鎖住的效果 -->

</div>
<div class="remind">
Fill out the form
</div>
<%List<String> check_errlist = (List<String>)request.getAttribute("check_errlist");
	if(check_errlist!=null&&check_errlist.size()>0){%>
<div class="check_err">
<ul>
<%for(int i=0;i<check_errlist.size();i++){%>
<li>
<%= check_errlist.get(i) %>
</li>
<%}%>
</ul>
</div>
<%}%>

<jsp:include page="/subviews/footer.jsp" />



</body>
</html>