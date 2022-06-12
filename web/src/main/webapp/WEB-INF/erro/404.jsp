<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Not-found(404)</title>

<link href="Setting.css" rel="stylesheet"></link>
<style type="text/css">

body{
background-color: white;
}

.main{
background-image: url("img/404.png");
}


.ok{
position:relative;
left:38%; 
font-family:"微軟正黑體" , "Microsoft JhengHei","仿宋_GB2312","FangSong_GB2312, PingFang" ;
}


</style>



<script 
src="https://code.jquery.com/jquery-3.0.0.js" 
integrity="sha256-jrPLZ+8vDxt2FnE1zvZXCkCcebI/C8Dt5xyaQBjxQIo=" 
crossorigin="anonymous"></script>   
<!-- <script type="text/javascript" src="jquery.js"> </script> -->
<script src="jq_setting.js">


</script>



</head>
<body>

<!-- TODO 美化 -->
<div class="function">
<h1 class="ok">NOT FOUND</h1>

</div>


<div class="main">

</div>

<jsp:include page="/subviews/footer.jsp" />
<!--FOOTER -->



</body>
</html>