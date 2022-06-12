<%@ page pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="uuu.Affection.entity.Customer"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1" >
<title>Login_Successful</title>
<link href="Setting.css" rel="stylesheet"></link>

<style type="text/css">

.ok{
position:relative;
left:42%; 
}


.function{
opacity: 1;
}


.content{
position:relative;
top:5%;
left:43%; 
}


@media screen and (max-width: 720px){


	.ok{
	position:relative;
	left:0%; 
	top:-4%;
	}

	.function {
	width:99.87%;
	height:80px;
	float: right;
	background-color: #9D9D9D;
	opacity: 1;
	position: fixed;
	top:0%;
	left:0%;
	color:black;
	font-size:2em; 
	transition: all 2s;
	margin:0%;
	background: linear-gradient(180deg, #9D9D9D 0%, #E0E0E0 100%);
	box-shadow:8px 8px 10px #999;
	z-index:2;
	border-radius: 0 0 50% 50%;
	}
	
	.content{
	position:relative;
	top:10%;
	left:10%; 
	}
}


</style> 

</head>

<body>

<!-- 功能列 -->
<div class="function">
<h1 class="ok">登入失敗</h1>

</div>
</div>


<!-- 首頁  -->
<div class="main">
<div class="content">
<h1>
<% List<String> errList = (List<String>)request.getAttribute("errList"); %>
<% out.print(errList!=null?errList:"");%>
</h1>				
<h1>5秒後自動回<a href="/Affection">首頁</a></h1>
</div>
</div>				
<!-- 資訊欄 -->
<div class="information">
<div class="information_head">Imformation</div>
<div>
<span>連絡電話:02-25149191</span><span> 地址:台北市松山區復興北路99號</span><br> 
<span>勸募字號:台內團字第0000000000號</span><span> 立案字號:衛部救字第0000000000號</span><br>
<span>Copyright ©2021 Affection</span>
</div>
</div>


</body>
</html>