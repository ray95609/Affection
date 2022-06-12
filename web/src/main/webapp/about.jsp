<%@ page pageEncoding="UTF-8"%>

<%@page import="uuu.Affection.entity.Product"%>
<%@page import="java.util.List"%>
<%@page import="uuu.Affection.service.ProductService"%>
<%@page import="uuu.Affection.entity.Customer"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>About</title>

<link href="Setting.css" rel="stylesheet"></link>

<style type="text/css">

.introduce{
vertical-align:middle; 
text-align: center;
}


.introduce img{
max-width: 600px;
max-height: 600px;
margin: 8%;
border-radius: 50%;

}

.introduce p{
margin:8%;

}


</style>

<script 
src="https://code.jquery.com/jquery-3.0.0.js" 
integrity="sha256-jrPLZ+8vDxt2FnE1zvZXCkCcebI/C8Dt5xyaQBjxQIo=" 
crossorigin="anonymous"></script>   
<!-- <script type="text/javascript" src="jquery.js">  從本機載入JQ</script> -->
<script src="jq_setting.js">

</script>



</head>
<body>
<jsp:include page="/subviews/header.jsp" />
<!-- 功能列 -->

<div class="main">

<div class="introduce">
<img src="img/introduce/baby.jpg" style="float:left;">
<p style="float:right;">

</p>
<img src="img/introduce/child.jpg" style="float:right;">
<p style="float:left ;">

</p>


</div>

</div>

<jsp:include page="/subviews/footer.jsp" />
<!-- 資訊欄 -->



</body>
</html>