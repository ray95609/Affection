<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Slide show</title>
	<script type="text/javascript" src="JQ/jquery.js"></script>
	<script type="text/javascript">
		var myInterval, index=0;
		$(document).ready(function init(){
				$(".dot,#next,#prev").click(moveHandler);//run the same function
				myInterval = setTimeout(moveHandler, 3000);//initial timer
		});
		function moveHandler(e){
			clearInterval(myInterval);//reset timer
			myInterval = setTimeout(moveHandler, 3000);//set timeer
			$(".dot:eq("+index+")").css("backgroundColor","gray");//reset dot color
			if(this==window){	index++;//setInterval
			}else if($(this).attr("myIndex")){	index=Number($(this).attr("myIndex"));//.dot
			}else{	index+=Number($(this).attr("direction"));}// $#prev / #next
			if (index>4) index=0;//last image
			if (index<0) index=4;//first image
			$(".dot:eq("+index+")").css("backgroundColor","white");//set dot color
			$("#imgs").stop().animate({"marginLeft":-index*1300+"px"},1000);//image width=735px
			$("#outer").stop().animate({"backgroundPositionX":-index*200+"px"},1000);//map width=1000px/5=200px
		}
	</script>
	<style>
		body{
			background:#333;
		}
		#outer{
			position:relative;
			width:1300px;/*image width=753 height=357*/
			overflow:hidden;
			background-image:url(map.png);
			background-color:#666;
			margin:auto;
		}
		#imgs{
			position:relative;
			width:6500px;/*image width=753x5=3765px*/
			display:flex;
		}
		
		a img{
		max-width:100%;
		height:100%; 
		
		}
		
		#prev,#next{
			position:absolute;
			width:30px;
			height:40px;
			color: white;
			cursor:pointer;
			font-size: 3em;
			top: 150px;
			opacity: 0.5;
		}
		#prev{
			top:50%;
			left:0px;
		}
		#next{
			top:50%;
			right:0px;
		}
		#prev:hover,#next:hover{
			opacity: 0.9;
		}
		#dots{
			width: 130px; /*(16+5x2)x5=130px*/
			margin: auto;
			display: flex;
		}
		.dot{
			width: 16px;
			height: 16px;
			background-color: gray;
			border-radius: 50%;
			margin: 5px;
		}
		.dot:nth-child(1){
			background-color: white;
		}
	</style>
</head>
<body>
    <div id="outer">
        <div id="imgs">
			<a href=""><img src="img/baby1.jpg"></a>
			<a href=""><img src="img/baby2.jpg"></a>
			<a href=""><img src="img/baby3.jpg"></a>
			<a href=""><img src="img/baby4.jpg"></a>
			<a href=""><img src="img/baby5.jpg"></a>
		</div>
        <div id="prev" direction="-1">&ltdot;</div>
		<div id="next" direction="1">&gtdot;</div>
		<div id="dots">
			<div class="dot" myIndex="0"></div>
			<div class="dot" myIndex="1"></div>
			<div class="dot" myIndex="2"></div>
			<div class="dot" myIndex="3"></div>
			<div class="dot" myIndex="4"></div>
		</div>
    </div>
</body>
</html>