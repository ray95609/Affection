<%@page import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@page import="uuu.Affection.entity.Product"%>
<%@page import="java.util.List"%>
<%@page import="uuu.Affection.service.ProductService"%>
<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Donate</title>
<link rel="icon" href="favicon.ico" type="image/x-icon">
<link href="Setting.css" rel="stylesheet"></link>
<link rel="stylesheet"   href="JQ/fancybox3/jquery.fancybox.min.css"/>
<style>

a:hover{color:#8d8d8d;}

.menu{
position:fixed;
margin:10% auto;
right:5%;
width:5%;
height:60%;
background-color: #BEBEBE; 
border-radius: 30px 30px 30px 30px;
opacity:0.7; 
z-index:10; 
}

.menu img{
position:relative;
width:60px;
height:60px; 
margin:45% 0% 0% 5%;
left:10%;
text-align:justify; 
opacity:2; 
}

.menu img:hover{
box-shadow:10px 10px 10px rgb(0,0,0,8);
border-radius: 10px 10px 10px 10px;
opacity:1; 
cursor:pointer; 
}

.sos{
position:fixed;
width:60px;
height:60px; 
right:6%;
top:10%;
}

.sos:hover{
box-shadow:10px 10px 10px rgb(0,0,0,8);
border-radius: 10px 10px 10px 10px;
opacity:1; 
cursor:pointer; 
}

.product{
margin:5% auto;
left:35%;
width:49.7%;
height:30%;
background-color: #8d8d8d; 
border-radius: 150px 30px 30px 150px;
opacity:0.95; 
display: flex;
box-shadow: 6px 6px 10px rgb(0,0,0,8);

}

.product img{
position:relative;
max-width:500px;
max-height:500px;
object-fit:cover; 
border-radius: 140px 0px 0px 140px;
margin: 0;
border-right-style: groove;
}

.product_des{
font-size:1.6em; 
width:30%;
margin:0;
position:relative;
top:-15%; 
text-align:left;
text-shadow:1px 2px #D0D0D0 ;

}

.price{
width:10%;
height:100%;
background-color: #7d7d7d;
border-left-style:groove;
border-color:#8d8d8d;
position:relative;
left:10%;
color:black;   
font-size:1.7em; 
text-align:left; 
word-break:break-all;
text-shadow:1px 2px #D0D0D0 ;
}

.price:hover{
box-shadow:5px 5px 10px rgb(0,0,0,8);
border-radius: 10px 10px 10px 10px;
opacity:1; 

}

.buy{
width:10%;
height:100%;
background-color: #7d7d7d;
border-left-style:groove;
border-right-style: groove;
border-color:#8d8d8d;
position:relative;
left:10%;

}

.buy_link img{
position:relative;
top:35%;
left:0%;
border-radius:50%;
max-height:80px ;
max-width:80px ;
border-style: none;
}

.buy:hover{
box-shadow:5px 5px 10px rgb(0,0,0,8);
border-radius: 10px 10px 10px 10px;
opacity:1; 
}

.percentage{
width:10%;
height:100%;
position:relative;
left:10%;
background-color: #5d5d5d;
border-radius: 0px 30px 30px 0px;
color:white;   
font-size:1.5em; 
text-align:center; 
}

.percentage:hover{
box-shadow:5px 5px 10px rgb(0,0,0,8);
border-radius: 0px 30px 30px 0px;
opacity:1; 
}

.percentage_1{
width:90%;
max-height:95%;    
position:relative;
margin:7% 5% 5% 5%;
background-color: #D0D0D0; 
border-radius: 0px 30px 30px 0px;
display:none; 
/*達到100%背景或有其他特效*/

}

.select_faild{
margin: 10%;
text-align: center;
font-size: 2em;
display:none; 
}


.newpage{
width:100%;
height:100%;
position:fixed;
top:0%;
left:0%;  
z-index:-1; 
}




/*TODO  手機模式排版*/

@media screen and (max-width: 720px){
.menu{
position:fixed;
margin:0% auto;
left:10%;
width:80%;
height:10%;
background-color: #6g6g6g; 
border-radius: 30px 30px 30px 30px;
opacity:0.7; 

}

.menu img{
position:relative;
width:50px;
height:50px; 
margin:3% 5% 0% 0%;
left:15%;
opacity:2; 
}


.product {
margin:20% auto;
left:40%;
width:75%;
height:30%;


}

.product img{
position:relative;
max-width:70%;
max-height:100%;

}

.product_des{
width:60vh;
height:20vh;
font-size:1.3em; 
margin:0% auto;
position:relative;
top:0%; 
text-align:left;

}

.buy{
width:50% ;
height:100% ;
}

.buy img{
position:relative;
left:15%;
width:50px ;
height:50px ;

}

.price{
width:50% ;
height:100% ;
font-size:1.5em; 
}

.percentage{
font-size:1em; 

}



</style>

<script 
src="https://code.jquery.com/jquery-3.0.0.js" 
integrity="sha256-jrPLZ+8vDxt2FnE1zvZXCkCcebI/C8Dt5xyaQBjxQIo=" 
crossorigin="anonymous"></script>
<!-- <script type="text/javascript" src="jquery.js">  從本機載入JQ</script> -->
<script src="jq_setting.js"></script>
<script type="text/javascript" src="JQ/fancybox3/jquery.fancybox.min.js"></script>
<script>

function getProduct(pid){  
	//同步請求
	location.href="product.jsp?productId="+pid;
	//非同步請求Ajax  {}=jason 預設method為get
	/*$.ajax({
			url:"product.jsp?productId="+pid,
			method:"GET",
			}).done(getProductDoneHandler);*/
	}
	
	function getProductDoneHandler(response,status,xhr){
			//代換原來BODY內容
			//$("body").html(response);
			
			//部分更新:fancybox燈箱效果
		$(".newpage").html(response);
		$.fancybox.open({
		src  : ".newpage",
		type : "inline",
		opts : {
		afterShow : function( instance, current ) {
			console.info( 'done!' );
				}
			}
		});
	}
	
	
	function newIndex() {
		$(".newpage").css("z-index", 9);
	}
	


	
</script>



</head>
<body>
<jsp:include page="/subviews/header.jsp" />
<!-- 功能列 -->

<!-- 排序跟抓資料庫用 -->
<%String search=request.getParameter("search");
  String type=request.getParameter("type");	
  String sos=request.getParameter("sos");	
  
  ProductService pService =new ProductService();
  List<Product> list =null;
  if(sos==null){
   if(search!=null && search.length()>0){
	  list=pService.getProductByKeyword(search);
  }else if(type!=null && type.length()>0){
	  list=pService.getProductByType(type);
  }else{
	  list = pService.getAllProduct();
  }
  }else{
	  list = pService.getProductSos(sos);
	  }%>


	

<!-- TODO  改志工成捐款、單筆與定期定額	 -->


<div class="main">
<div class="menu">
<form action="?<%=request.getQueryString()!=null?request.getQueryString():""%>" method="post" name="formSOS" id="formSOS">
<%
if(request.getQueryString()!=null &&request.getQueryString().length()<16){
String qs =request.getQueryString();
String key="";
if(qs.length()<16){
 key=qs.substring(5);
}else{key="";}
%>
<p id="sosp" style="position:fixed; top:6%; right:5.8%; color:red; text-shadow: 1px 1px 3px grey; ">Shortage</p>
<input type="submit" class="sos" title="Shortage" name="sos" value="<%=key%>" src=img/icon/sos/sos.png 
style="border-radius: 50%" >
</form>
<%} %>
<form action="<%=request.getContextPath()%>/donate.jsp" method="GET">
<a href="?type=Food"><img src="img/food.png" title="Food"></a>
<a href="?type=Clothes"><img src="img/clothes.png" title="Clothes"></a>
<a href="?type=Electrical"><img src="img/tv.png" title="Electrical appliances"></a>
<a href="?type=Toy"><img src="img/toy.png" title="Toy"> </a>
<a href="?type=Cash"><img src="img/icon/money/money.png" title="Volunteer"></a>
</form>
</div>


<% if(list!=null && list.size()>0){%>

<%for(int i=0;i<list.size();i++){ 
	Product p =list.get(i);
	double need=p.getNeed();
	if(need==0){need=1;}
	double stock=p.getStock();
	double percentage = (stock/need);
	if(percentage>1){percentage=1;}
	%>
	
<div class="product" name="food" id="<%=p.getType()%>"><!-- 讓href可以連過去 -->
<img src="<%= p.getPhotoUrl() %>">
<div class="product_des">
<h1><%= p.getType() %></h1>
<h2><%= p.getName() %></h2>
<span><%= p.getDescription() %>
</span>
</div>
<div class="price">
<span><br><br><br><br>$<%=((int)p.getPrice())%></span>
</div>
<div class="buy">
<!-- 呼叫js方法 -->				
<a href="javascript:getProduct(<%= p.getId()%>)" class="buy_link"><img src="img/donation.png"></a>
</div> 
<div class="percentage">
<div class="percentage_1" style="height:<%=percentage*100%>%; <%if(percentage>=1){%>background-color:pink;<%}%>"><!-- 100%效果 -->
<span <%if(percentage>=1){%>style="color:white;"<%}%>><br><br><br><br><%= Math.round(percentage*100)%>%</span>
</div>
</div>
</div>
<%}%>


<%}else{%>
<div class="select_faild" ><h1>Oops!<br>查無商品資料</h1></div>
<%}%>

<div class="newpage">
</div>

</div>

<jsp:include page="/subviews/footer.jsp" />
<!-- 資訊欄 -->



</body>
</html>