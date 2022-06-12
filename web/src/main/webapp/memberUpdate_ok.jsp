<%@ page pageEncoding="UTF-8"%>
<%@page import="uuu.Affection.entity.Customer"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1" >
<meta http-equiv='refresh' content='5; url=<%=request.getContextPath() %>'><!-- TODO history.back() -->
<title>Login_Successful</title>
<link rel="icon" href="favicon.ico" type="image/x-icon">
<link href="Setting.css" rel="stylesheet"></link>

<style type="text/css">

.ok{
position:relative;
left:43%; 
font-family:"微軟正黑體" , "Microsoft JhengHei","仿宋_GB2312","FangSong_GB2312, PingFang" ;
}

.function{
opacity: 1;
}

.content_ok{
text-align:center;
position:relative;
top:10%;
left:0; 
display:none; 

}


.bar{
width:300px;
height:30px;
background-color: black;
margin:25% 0 0 42%;
border-radius: 20px 
}

.loading
{
position:relative;
width:0px;
height:20px;
background-color:white;
opacity:0.8;
border-radius: 20px; 
top:5px;
bottom:5px;
left:10px;
right:10px;
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
	
	.content_ok{
	text-align:center;
	position:relative;
	top:10%;
	left:0%; 
	}
	
	.bar{
	position:absolute;
	top:50%;
	left:-13%; 
	}
}


</style> 

<script 
src="https://code.jquery.com/jquery-3.0.0.js" 
integrity="sha256-jrPLZ+8vDxt2FnE1zvZXCkCcebI/C8Dt5xyaQBjxQIo=" 
crossorigin="anonymous"></script>   
<!-- <script type="text/javascript" src="JQ/jquery.js">  從本機載入JQ</script> -->
<script src="jq_setting.js">
/*載入JQ共用設定*/
</script>

<script type="text/javascript">
$(document).ready(bg);
function bg() {
	back();	
}

/*login ok返回上一頁*/
	/*function back() {
	setTimeout("window.self.location=document.referrer", 5000);
	}*/


</script>

</head>
<body>

<!-- 功能列 -->
<div class="function">
<h1 class="ok">會員修改成功</h1>

</div>
</div>


<!-- 首頁  -->
<div class="main">
<div class="content_ok" >
				<% Customer c=(Customer)session.getAttribute("member");
				int gender=c.getGender();
				String g="";
				if( gender==77){
					g="先生"	;
				}
				if(gender==70){
					g="小姐";
				}
				if(gender==83){
					g="貴賓";
				}%>
				
				
				<h1 style="font-size:3.5em">Welcome<%= c!=null?c.getName()+g:"XXXXX" %></h1>
				
				<h1>5秒後自動回上一頁</h1>				
				
</div>			
<div class="bar">
<div class="loading">
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