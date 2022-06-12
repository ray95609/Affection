<%@ page pageEncoding="UTF-8"%>
<%@page import="uuu.Affection.entity.Product"%>
<%@page import="java.util.List"%>
<%@page import="uuu.Affection.service.ProductService"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Donation</title>
<link rel="icon" href="favicon.ico" type="image/x-icon">
<link href="Setting.css" rel="stylesheet"></link>
<link rel="stylesheet"   href="JQ/fancybox3/jquery.fancybox.min.css"/>
<style type="text/css">

body{
overflow:hidden; 
}

.content input{
width:200px ;
height:20px ;
border-radius: 30px 30px 30px 30px;
}



.content{
width:60%;
height:60%;
position:absolute;
margin:10% auto; 
left:20%;
border-radius: 30px 30px 30px 30px;
background-color: white;
box-shadow:10px 10px 10px rgb(0,0,0,8);
}

.content img{
float:left;
max-height:500px ;
max-width:500px ;
border-radius: 30px 30px 30px 30px;
margin: 3% 0 0 1% ;
}

.describe{
float:right;
position:absolute;
margin:5%;
left:40%; 
font-size:1.6em; 
text-shadow: 5px 10px 15px  #8E8E8E;
}

.describe span{
max-width:30%;
font-size:1.6em; 

}

.stock_need{
width:20% ;
height:100% ;
background-color:white ;
color:white ;
float:right;
border-radius: 0px 30px 30px 0px;
text-shadow: 5px 10px 15px  #8E8E8E;
 
}

.need{
float:right;
position:relative;
left:-1%;
top:-100%;
width:49% ;
height:100% ;
background-color:white ;
color:black;
border-radius: 0px 30px 30px 0px;
text-align:center;
font-size:1.7em;  
border-left-style: groove;
word-break:break-all;
text-shadow: 5px 10px 15px  #8E8E8E;
}

.need:hover{
box-shadow:10px 10px 10px  rgb(0,0,0,8);
border-radius: 0px 30px 30px 0px;
opacity:1; 
background-color:#E0E0E0; 
}

.stock{
position:relative;
width:49% ;
height:100% ;
text-align:center;
font-size:1.7em;  
background-color:white ;
color:black;
border-left-style: groove;
word-break:break-all;
}

.stock:hover{
box-shadow:10px 10px 10px rgb(0,0,0,8);
border-radius: 10px 10px 10px 10px;
opacity:1; 
background-color:#E0E0E0; 
}

.product_fiald{
margin: 10%;
text-align: center;
font-size: 2em;
display:none;
opacity: 0.9;
}

@keyframes swing_1{
	0%{transform:scale(1.2,1.2)}
	25%{transform:scale(1.5,1.5)}
	50%{transform:scale(1.2,1.2)}
	75%{transform:scale(1.5,1.5)}
	100%{transform:translateX(0px);}
}
.product_donate{
filter:drop-shadow(3px 3px 7px rgba(0, 0, 0, 0.7));

}

.product_donate:hover{
animation:swing_1 1s 2;
}




/*TODO  手機模式排版*/
@media screen and (max-width: 720px){

.content input{
width:100px ;
height:20px ;
border-radius: 30px 30px 30px 30px;
}


.content{
top:20%;
height:30%;
width:78% ;
}

.content img{
max-height:200px ;
max-width:200px ;
}

.describe{
left:40%;
top:-10%;
font-size:1em ;

}

.stock{
font-size:0.9em; 
width:60%;
text-align:left; 
}

.need{
font-size:0.9em;
width:45%;
text-align:left; 
}


}



</style>


<script 
src="https://code.jquery.com/jquery-3.0.0.js" 
integrity="sha256-jrPLZ+8vDxt2FnE1zvZXCkCcebI/C8Dt5xyaQBjxQIo=" 
crossorigin="anonymous"></script>   
<!-- <script type="text/javascript" src="jquery.js">  從本機載入JQ</script> -->
<script src="jq_setting.js"></script>
<script type="text/javascript" src="JQ/fancybox3/jquery.fancybox.min.js"></script>
<script type="text/javascript">

$(document).on("submit","#DONATE",addToCart)
function addToCart(e) {
	
	//2-送出ajax請求
	$.ajax({
		url: $("#DONATE").attr("action"),
		method: $("#DONATE").attr("method"),
		data: $("#DONATE").serialize()
	}).done(addToCartHandle);
	//1-停止submit 之同步請求
	e.preventDefault();		
}

function addToCartHandle(response, status, xhr){
	console.log(response); //for test
	$(".buy_succeed").fadeIn(1000);
	$(".buy_succeed").fadeOut(1000);
	//部分更新
	//$(".cartNumber").text(response);
}





</script>


</head>
<body>
<jsp:include page="/subviews/header.jsp" />
<!-- 功能列 -->

<%String productId=request.getParameter("productId");
Product p =null;
ProductService pService= new ProductService();
if(productId!=null && productId.length()>0){
p = pService.getProductId(productId);
}%>



<%if(p!=null){%>
<div class="main">
<div class="content">
<img src="<%=p.getPhotoUrl()%>" name="photoUrl">
<div class="describe" name="id">
<h1 name="name" style="font-size: 1.8em;"><%=p.getName()%></h1>
<span >Price&emsp;</span><span name="price">$<%=p.getPrice()%></span>
<h2 name="description" style="font-size:1.2em;max-width:70%; "><%=p.getDescription()%></h2>


<form id="DONATE" action="add_To_Cart.do" method="POST">

<input type="hidden" name="productId" value="<%=p.getId()%>">
<input type="number" name="quantity" min='1' max="<%=p.getNeed()%>" required><span style="font-size: 1em"></span>
<br>														
<input type=submit class="product_donate"  value="Donate"
title="Donate" style="width: 50px;height: 50px; position:relative; margin:5% 0 0 20%;   ">
</form>
</div>
<div class="stock_need">
<div class="stock" name="stock">
<span><br><br><br><br><br><br><br>STOCK<br><%=p.getStock()%></span>
</div>
<div class="need" name="stock">
<span><br><br><br><br><br><br><br>NEED<br><%=p.getNeed()%></span>
</div>
</div>
</div>

</div>
<%}else{%>

<div class="product_fiald">
<h1>Oops!<br>無此商品</h1>
</div>


<%}%>




<jsp:include page="/subviews/footer.jsp" />
<!-- 資訊欄 -->



</body>
</html>