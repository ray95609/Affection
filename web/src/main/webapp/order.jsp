<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Order</title>

<thnk href="Setting.css" rel="stylesheet"></thnk>

<style type="text/css">

table{
margin:5% auto;
width: 60%;
height:5%;
background-color: pink;

}


th{
position:relative;
height:20px; 
background-color:pink;
border-style:dashed;
border-color:white;

}

td{
color:black;
text-align:center;
background-color:white;
border-color:pink;
border-bottom-style:ridge;   

}

.table{
margin: -5% auto;
}


h1{
color:pink;
text-shadow:  pink 3px 3px 10px;

}

.tk{
position:absolute;
left:37.5%;
bottom:10%;
font-size:3em; 
text-decoration: underline;
}


.water{
position:absolute;
width: 150%;
height:150%;
background:linear-gradient(180deg, #AAAAFF 50%, #0000C6 100%);
}

</style>

<script 
src="https://code.jquery.com/jquery-3.0.0.js" 
integrity="sha256-jrPLZ+8vDxt2FnE1zvZXCkCcebI/C8Dt5xyaQBjxQIo=" 
crossorigin="anonymous"></script>   
<!-- <script type="text/javascript" src="jquery.js">  -->
<script src="jq_setting.js"></script>
<script type="text/javascript">

$(".water").animate();



</script>




</head>
<body>
<jsp:include page="/subviews/header.jsp" />


<div class="main">


<table class="table2">
<caption><h1>Order List</h1> </caption>
<tr>
<th>Donate</th>
<th>Price</th>
</tr>
<%for(int i=0;i<5;i++){ %>
<tr>
<td>Milk<%=i %></td>
<td>100<%=i %></td>
</tr>
<%}%>
</table>

<table class="table">

<tr class="title">
<th>Number</th>
<th>Payment</th>
<th>Transaction date</th>
<th>State</th>
</tr>
<tr>
<td>00011</td>
<td>2021-10-05<br></td>
<td>Credit</td>
<td>Unpaid</td>
</tr>
</table>


<h1 class="tk" >Thank You For Donation</h1>




</div>

<div class="water">

</div>

<jsp:include page="/subviews/footer.jsp" />




</body>
</html>