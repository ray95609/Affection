<%@page import="uuu.Affection.entity.Product"%>
<%@page import="uuu.Affection.entity.CartItem"%>
<%@page import="uuu.Affection.entity.ShopingCart"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="uuu.Affection.entity.Customer"%>
<%@page import="java.util.List"%>


<!-- header star -->

<link href="Setting.css" rel="stylesheet"></link>
<style type="text/css">


<%Customer member =(Customer) session.getAttribute("member");%>
<%if(member!=null)
{%>
.menber{
left:10%;}

.a_donate img{
left:-12%;
}

<%}%>


.cartJump{
width:300px;
height:80%;
position:fixed;
top:15%;
right:-350px ; 
background-color:pink;
color:white;
z-index:5; 
opacity:1;
display:flex;
flex-direction:column; 
border-radius: 30px 0 0 30px;
overflow:auto; 
opacity:0.9; 
border-style:groove; 
scrollbar-color: #FFAAD5 white;
scrollbar-width: thin;
}

.cartJump_ul{
position:relative;
top:-70px;

}

ul,li{
margin:0px 10px 0 0 ;
list-style:none; 
float: right;
text-shadow: 1px 1px 3px black;
font-size: 1.1em;

}

.cartJump img{
margin-top:10px;
max-width:100px ;
max-height:100px ;
float:left;
margin-left:20px;  
border-radius: 25px;

}


.historylist img{
	float:left;
	position:relative;
	left:18%;
	width:50px;
	height:50px;	
	margin:0.6% 0% 0% 0%;
	opacity:1; 
	transition: all 1s;
}

@keyframes swing_3{
	25%{transform:rotate(10deg)}
	50%{transform:rotate(0deg)}
	75%{transform:rotate(-10deg)}
	100%{transform:translateX(0px);}
	}

.historylist img:hover{
	animation:swing_3 0.05s 2;
	
}


   .buy_succeed{
	position:fixed;
	top:55%;
	right: 21%;
	width:200px;
	height:100px;
	background-color: grey; 
	text-align: center;  
	border-radius: 30px;
	z-index:11;  
	opacity:0.5;
	display:none;  
	}

	.buy_succeed p{
	font-size:2em;
	text-shadow: 3px 3px 5px white; 
	}

</style> 

<script 
src="https://code.jquery.com/jquery-3.0.0.js" 
integrity="sha256-jrPLZ+8vDxt2FnE1zvZXCkCcebI/C8Dt5xyaQBjxQIo=" 
crossorigin="anonymous"></script>
<script src="jq_setting.js">
/*載入JQ共用設定*/



</script>

<script type="text/javascript">
	
/*自動帶入register form輸入項*/
	function repopulateForm(){
		
 <%if("POST".equalsIgnoreCase(request.getMethod())){%>  /*如果是POST請求才啟動*/
	$("input[name='id']").val("${param.id}");		
	$("input[name='name']").val("${param.name}");	
	$("input[name='email']").val("${param.email}");	
	$("input[name='phone']").val("${param.phone}");	
	$("input[name='address']").val("${param.address}");	
	$("input[name='address']").val("${param.address}");
	$("input[name='birthday']").val('${param.birthday}');
	$("input[name='subcribe']").prop('checked', <%= request.getParameter("subcribe")!=null %>);
	$("#male").prop('checked', ${param.gender.charAt(0)==Customer.MALE});
	$("#female").prop('checked', ${param.gender.charAt(0)==Customer.FEMALE});
	$("#secret").prop('checked', ${param.gender.charAt(0)==Customer.SECRET});
	
 <%}%>
 
}

	function  repopulateForm_search(){
	<%if("GET".equalsIgnoreCase(request.getMethod())){%>
	$("input[name='search']").val("${param.search}");
	<%}%>
	}
	
	/*$(".product_donate").click(succeed);
	function succeed() {
		$(".buy_succeed").fadeIn(1000);
		$(".buy_succeed").fadeOut(1000);
	}*/
	
</script>


<script type="text/javascript">
$(document).ready(bg);
function bg() {
	
	/*登入失敗自動彈出登入*/
	ready_jump_login();
}

//TODO  驗證失敗自動彈開登入
	<%List<String> errList = (List<String>)request.getAttribute("errList");
	if(errList!=null&&errList.size()>0){%>
	function ready_jump_login(e) {
		$(".outer").slideDown(800);
	e.stopPropagation();
	}
	<%}%>
</script>


<script type="text/javascript">
$(document).ready(bg_1);
function bg_1() {
	/*如果失敗自動彈出登入註冊*/
	ready_jump();	
	}	
	//TODO  驗證失敗自動彈開註冊
	<%List<String> errList_register = (List<String>)request.getAttribute("errList_register");
	if(errList_register!=null&&errList_register.size()>0){%>
	function ready_jump(e) {
	$(".register").slideDown(800);
	e.stopPropagation();
	}
	<%}%>
	

	
</script>
	
		


<!-- TODO about 志工招募 購物車躍登入會員才看的到-->

<div class="function">

<%if(member!=null){%>
<a href="<%= request.getContextPath() %>/memberCenter.jsp">
<div class="member_icon">
<%=	member!=null?member.getName().charAt(0):""%>
</div>
</a>

<a href="Logout.do">
<div class="logout">
<img src="img/logout.png">
</div>
</a>
<%}%>
<a href="<%= request.getContextPath() %>"><img src="img/logo_ok.png" class="logo"></a>
<div class="menber">
<%if(member==null){%>
<img src="img/login.png" class="Login-button" >

<img src="img/register.png" class="Register-button" >
<%}%>
<a href="<%= request.getContextPath() %>/donate.jsp" class="a_donate"><img src="img/donate.png" class="Donate" ></a>

</div>
<div class="Search">
<img src="img/search.png"  >
</div>
<%if(member!=null){
%>
<div class="shopcar">
<a class="shopcar" href="ShopCart.jsp"><img src="img/shopcar.png"></a>
</div>
<div class="historylist">
<a href="historyList.jsp"><img src="img/icon/historylist/historylist.png"></a>
</div>
<%}%>
<!--  div class="about" >
<a href="about.jsp"><img src="img/icon/about/about.png"></a>
</div-->

<!-- TODO有時間再做志工招募 -->
<!--div class="volunteer">
<a href="volunteer.jsp"><img img src="img/Volunteer.png"></a>
</div-->

</div>

<!-- 登入 -->
	<div class="outer">
		<div class="login">			<!-- post提出表單(不跨網) get查詢資料(跨網) -->
			<form class="login_1" action="login.do" method="post">
				Account<br> <input type="text" name="login_id" class="id" 
				required placeholder="Please enter the E-mail or ID"> <br> <br>
				Password<br>
				<input type="password" class="password"  name="login_password"
				required placeholder="Please enter the Password">
				 <img src="img/CLOSE.png" class="show" >
				<div class="href_forgotPassword">
					<!-- 連結到忘記密碼網頁 -->
					<a href="忘記密碼">Forgot your password</a>
				</div><br>
				Captcha<br>
				<input type="text"name="login_captcha">
				<img class='captchaImg' src='images/captcha.jpg' title="Click to refresh">
				<div class="submit_login" >
				<div class="login_faild" >
				<%-- <%= %> = out.print() --%>
				<%if(errList!=null&&errList.size()>0)
				{%>
				<ul type="none"><%for(int i=0;i<errList.size();i++){ %>
				<li ><%= errList.get(i) %></li>
				</ul>
				<%} %>
				<% }%>
				</div>
				<div class="login_button">
					<input type="submit" value="Login" >
				</div>	
				</div>

			</form>
		</div>
	</div>


<!-- TODO 服務條款及隱私條款 -->
<!-- 註冊 -->
	<div class="register" id="register" >
		<div class="register_1">
			<form class="register_2" action="register.do" method="post">
				Account<br> 
				<input type="text" id="id" name="id" pattern='[A-Z][1289]\d{8}'
				required placeholder="Please enter the ID"  value="<%= request.getParameter("id")!=null?request.getParameter("id"):""%>"></input> <br>
				Password<br> 
				<input type="password" class="password" name="password"
				maxlength="20" minlength='6'
				required placeholder="Please enter the Password"></input>
				<img src="img/CLOSE.png" class="show" > <br>
				Confirm Password<br>
				<input type="password" class="password" name="confirm_password"
				maxlength="20" minlength='6'
				required placeholder="Please confirm the Password"></input><br>
				Name<br> 
				<input type="text" id="name" name="name"
				minlength='2' maxlength="20"
				required placeholder="Please enter the Name"></input> <br> 
				E-mail<br>
				<input type="email" id="eamil" name="email"
				required placeholder="Please enter the Email"></input> <br> 
				Gender<br>
				<div class="gender" name="gender">
					<input type="radio" name="gender" id="male" value="M">Male</input> 
					<input type="radio" name="gender" id="female" value="F">Female</input>
					<input type="radio" name="gender" id="secret" value="S">Secret</input>
				</div>
				Birthday<br> 
				<input type="date" id="birthday" name="birthday"
				required placeholder="Please enter the Birthday"></input> <br>
				Phone<br> 
				<input type="text" id="phone" name="phone"
				required placeholder="Please enter the Phone"></input> <br>
				Address<br>
				 <input type="text" id="address" name="address"></input> <br>
				<input type="checkbox" id="yes" value="true" name="subcribe"></input>Subscribe 
				<br>
				Captcha<br>
				<input type="text"name="captcha">				<!-- register用驗證碼 function 也要改成兩個-->
																<!-- images/register_captcha.jpg -->
				<img class='captchaImg' src='images/captcha.jpg' title="Click to refresh">
				<div class="register_faild" >
				<%-- <%= %> = out.print() --%>
				<%if(errList_register!=null&&errList_register.size()>0)
				{%>
				<ul type="none"><%for(int i=0;i<errList_register.size();i++){ %>
				<li type="none"><%= errList_register.get(i) %></li>
				</ul>
				<%} %>
				<% }%>
				</div>
				<div class="register_button">
					<input type="submit"  value="Register" >
				</div>
			</form>
		</div>


</div>

	<div class="search_jump">
	<form action="<%=request.getContextPath()%>/donate.jsp" method="GET">
	<input type="search" name="search" class="search_text"
	 style="width:165px; height:20px;border-radius:10px 10px 10px 10px;"
	 required placeholder="Please enter the Keyword">
	<input type=image class="search_img" src=img/search.png onclick="submit()">
	</form>
	</div>
	
	<%ShopingCart scart =(ShopingCart)session.getAttribute("scart");%>
	<%if(scart!=null){ %>
	<div class="cartJump">
	<%for(CartItem item:scart.getCartItemSet()){
	Product p=item.getProduct(); %>
	<img src="<%=p.getPhotoUrl() %>">
	<div class="cartJump_ul">
	<ul>	
	<li><%=p.getName() %></li>
	<br>
	<li><%=scart.getAmount(item) %></li>
	</ul>
	</div>
	<%}%>
	</div>
	<%} %>
	
	<div class="buy_succeed">
	<p>Succeed</p>
	</div>
<!-- header end -->