<%@page import="java.util.List"%>
<%@ page pageEncoding="UTF-8"%>
<%@page import="uuu.Affection.entity.Customer"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1" >

<title>Affection</title>
<link rel="icon" href="favicon.ico" type="image/x-icon">
<link href="Setting.css" rel="stylesheet"></link>
<style type="text/css">
		
		body{
		overflow:hidden; 
		}
		
		#silde_index{
			position:relative;
			width:1800px;/*image width=753 height=357*/
			overflow:hidden;
			margin:auto;
			opacity: 0.95;
		}
		#imgs{
			position:relative;
			width:9000px;/*image width=753x5=3765px*/
			display:flex;
		}
		
		#imgs img{
		width:1800px;
		height:100%; 
		
		}
		
		#prev,#next{
			position:fixed;
			width:30px;
			height:100%;
			color: black;
			cursor:pointer;
			font-size: 5em;
			opacity: 0.5;
		}
		#prev{
			top:50%;
			left:-4px;
		}
		#next{
			top:50%;
			right:24px;
		}
		#prev:hover,#next:hover{
			opacity: 0.9;
		}
		#dots{
			position:fixed;
			width: 30%; /*(16+5x2)x5=130px*/
			margin:0 auto;
			display: flex;
			left:44%;
			bottom:5%; 
		}
		.dot{
			width: 16px;
			height: 16px;
			background-color: gray;
			border-radius: 50%;
			margin: 0px 40px 40px 0px;
		}
		.dot:nth-child(1){
			background-color: white;
		}

@media screen and (max-width: 720px){

#silde_index{
margin:25% 0 0 15.5%;
width:550px;
}

#imgs{
width:2750px;
}

#imgs img{
width:550px;
}

#prev,#next{
font-size: 3em;
}


#prev{
top:45%;
left:10%;
}

#next{
top:45%;
right:2%;
}

#dots{
position:absolute;
left:30%;
bottom:-10%;
width:100% ;
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



</head>
<body>


<jsp:include page="/subviews/header.jsp" />
<!-- 功能列 -->

<!-- 首頁  -->
<div class="main">
<div id="silde_index">
        <div id="imgs">
			<img src="img/baby1.jpg">
			<img src="img/baby2.jpg">
			<img src="img/baby3.jpg">
			<img src="img/baby4.jpg">
			<img src="img/baby5.jpg">
		</div>
		<div class="control">
		<div id="prev" direction="-1">&ltdot;</div>
		<div id="next" direction="1">&gtdot;</div>
		</div>
        <div id="dots">
			<div class="dot" myIndex="0"></div>
			<div class="dot" myIndex="1"></div>
			<div class="dot" myIndex="2"></div>
			<div class="dot" myIndex="3"></div>
			<div class="dot" myIndex="4"></div>
		</div>
    </div>


<jsp:include page="/subviews/footer.jsp" />
<!-- 資訊欄 -->


</body>
</html>