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
<title>MemberCenter</title>
<link rel="icon" href="favicon.ico" type="image/x-icon">
<link href="Setting.css" rel="stylesheet"></link>

<style type="text/css">

body{
overflow:auto; 
}

input{
width:300px;
height:20px; 
font-size:0.6em; 
}

h1{
font-family: 'Gluten', cursive;
font-size: 2.5em;
text-transform: uppercase;
text-shadow:1px 2px white ;
text-align: center;
margin: 5% 0 0 0 ;
}

.register_member{
width:35%;
height:90%;
background: linear-gradient(180deg, #5B5B5B 0%, #E0E0E0 100%);
margin:-1% auto;
border-radius: 5% 20% 5% 20%;
line-height:35px; 
font-family: 'Gluten', cursive;
box-shadow:10px 15px 10px #7D7D7D inset;
opacity:0.9;
transition:all 3s; 

}

.register_member_1{
position:relative;
left:20%; 
top:1%;
font-size: 1.3em;
text-transform: uppercase;
text-shadow:1px 2px #D0D0D0 ;
}


.member_register_button{
position: absolute;
left:20%;
bottom:-2% ; 

}
.member_register_button input{
width: 100px;
height: 30px;
font-size: 20px;

}

/*TODO  720 media screen*/


</style>

<script 
src="https://code.jquery.com/jquery-3.0.0.js" 
integrity="sha256-jrPLZ+8vDxt2FnE1zvZXCkCcebI/C8Dt5xyaQBjxQIo=" 
crossorigin="anonymous"></script>   
<!-- <script type="text/javascript" src="jquery.js">  從本機載入JQ</script> -->
<script src="jq_setting.js"></script>
<script type="text/javascript">
<%Customer member =(Customer)session.getAttribute("member");%>
function repopulateForm(){
	 <%if("POST".equalsIgnoreCase(request.getMethod())){%>  /*如果是POST請求才啟動*/
		$("input[name='id']").val("${param.id}");		
		$("input[name='name']").val("${param.name}");	
		$("input[name='email']").val("${param.email}");	
		$("input[name='phone']").val("${param.phone}");	
		$("input[name='address']").val("${param.address}");	
		$("input[name='birthday']").val('${param.birthday}');
		$("input[name='subcribe']").prop('checked', <%= request.getParameter("subcribe")!=null %>);
		$("#male").prop('checked', ${param.gender.charAt(0)==Customer.MALE});
		$("#female").prop('checked', ${param.gender.charAt(0)==Customer.FEMALE});
		$("#secret").prop('checked', ${param.gender.charAt(0)==Customer.SECRET});
	<% }else if("GET".equalsIgnoreCase(request.getMethod())){  
			 /*TODO 問老師*/
			 /*Customer member =(Customer)session.getAttribute("member");*/
		  	 if(member!=null){%>
		  	alert(1)
		  	$("input[name='id']").val('<%= member.getId() %>');
		 	$("input[name='name']").val("<%=member.getName()%>");	
			$("input[name='email']").val("<%=member.getEmail()%>");	
			$("input[name='phone']").val("<%=member.getPhone()%>");	
			$("input[name='address']").val("<%=member.getAddress()%>");	
			$("input[name='birthday']").val("<%=member.getBirthday()%>");
			$("input[name='subcribe']").prop('checked', ${sessionScope.member.subscribed});
			$("#male").prop('checked',${sessionScope.member.gender==Customer.MALE});
			$("#female").prop('checked', ${sessionScope.member.gender==Customer.FEMALE});
			$("#secret").prop('checked', ${sessionScope.member.gender==Customer.SECRET});
	<%}else{%>
			alert("請先登入會員");
			location.href="<%=request.getContextPath()%>"; 
			 			 
		 <%}%>
	 		 
	 <%}%>
	
	 
	
	 
	}

</script>



</head>
<body>
<jsp:include page="/subviews/header.jsp" />
<!-- 功能列 -->


<div class="main">
<h1 style="text-shadow:5px 5px 15px #5B5B5B ">Revise your member data</h1>
<div class="register_member" id="register_member" >
		<div class="register_member_1">
			<form class="register_2" action="MemberUpdata.do" method="post">
				Account 
				<br>
				<input type="text" id="id" name="id" pattern='[A-Z][1289]\d{8}' readonly="readonly"
				value="<%=member!=null?member.getId():""%>"></input>
				<br>Password
				<br>
				<input type="password" class="password" name="password"
				maxlength="20" minlength='6'
				required placeholder="Please enter the Password"></input>
				<img src="img/CLOSE.png" class="show" >
				 <br>
				Confirm Password<br>
				<input type="password" class="password" name="confirm_password"
				maxlength="20" minlength='6'
				required placeholder="Please confirm the Password"></input>
				<br>
				Name<br> 
				<input type="text" id="name" name="name"
				minlength='2' maxlength="20"
				value="<%=member!=null?member.getName():""%>"
				required placeholder="Please enter the Name" ></input> 
				<br> 
				E-mail<br>
				<input type="email" id="eamil" name="email"
				value="<%=member!=null?member.getEmail():""%>"
				required placeholder="Please enter the Email"></input>
				<br> 
				Gender<br>
				<div class="gender" name="gender">
					<input type="radio" name="gender" id="male" value="M"
					style="width:20px;height:20px ;">Male</input> 
					<input type="radio" name="gender" id="female" value="F"
					style="width:20px;height:20px ;">Female</input>
					<input type="radio" name="gender" id="secret" value="S"
					style="width:20px;height:20px ;">Secret</input>
				</div>
				
				Birthday<br> 
				<input type="date" id="birthday" name="birthday"
				value="<%=member!=null?member.getBirthday():""%>"
				required placeholder="Please enter the Birthday"></input> <br>
				Phone<br> 
				<input type="text" id="phone" name="phone"
				value="<%=member!=null?member.getPhone():""%>"
				required placeholder="Please enter the Phone"></input> <br>
				Address<br>
				 <input type="text" id="address" name="address"
				 value="<%=member!=null?member.getAddress():""%>"></input>
				<input type="checkbox" id="yes" value="true" name="subcribe"
				style="width:20px;height:20px ;"></input>Subscribe<br>
				
				Captcha<br>
				<input type="text"name="captcha">				<!-- register用驗證碼 function 也要改成兩個-->
																<!-- images/register_captcha.jpg -->
				<img class='captchaImg' src='images/captcha.jpg' title="Click to refresh">
				<div class="register_faild" style="text-align:center; ">
				
				<%List<String> errList_Update = (List<String>)request.getAttribute("errList_Update");
				if(errList_Update!=null&&errList_Update.size()>0)
				{%>
				<ul type="none"><%for(int i=0;i<errList_Update.size();i++){ %>
				<li type="none"><%= errList_Update.get(i) %></li>
				</ul>
				<%} %>
				<% }%>
				</div>
				<div class="member_register_button">
					<input type="submit"  value="Revise" >
				</div>
			</form>
		</div>

</div>

<jsp:include page="/subviews/footer.jsp" />
<!-- 資訊欄 -->



</body>
</html>