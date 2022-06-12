/**
 * JQ Setting
 */
	var myInterval, index=0;
	
	var w= $(window).width();
	
	var preUrl = document.referrer;
	
	if(w>720){
	w=1800;	
	} else{w=550;}
	
	
$(document).ready(init);
	function init() {
		
		/*登入註冊彈出視窗*/
		$(".Login-button").click(inHandler);
		$(".Register-button").click(outHandler);
		$(".main").click(allHandler);
		/*顯示密碼*/
		$(".show").mousedown(downHandler);  
		$(".show").mouseup(upHandler);
		$("div").mouseleave(upHandler);
		/*更新驗證碼*/
		$(".captchaImg").click(refresh);
		/*hover information*/
		$(".information_head").click(pullout);
		$(document).click(pushin);
		$(".main").click(pushin);
		/*logout hover */
		$(".member_icon").hover(logout_show);
		$(document).click(logout_hide);
		$(".main").click(logout_hide);
		/*search jump*/
		$(".Search").click(search_jump);
		//$(document).click(search_out);
		$(".main").click(search_out);
				
		/*首頁滑動投影片*/
		$(".dot,#next,#prev").click(moveHandler);//run the same function
		myInterval = setTimeout(moveHandler, 3000);//initial timer
						
		/*登入註冊成功slide*/
		$(".content_ok").fadeIn(2000);
		
		/*login ok 進度條*/
		$(".loading").animate({"width":"280px","opacity":0.9},5000);
		
		/*自動帶入register form輸入項*/
		repopulateForm();	
		
		/*自動帶入search*/
		repopulateForm_search();
						
		/*查詢商品失敗*/
		$(".select_faild").fadeIn(2000);
		
		/*產品連結失敗*/
		$(".product_fiald").fadeIn(2000);
					
		/*產品%數動畫*/
		$(".percentage_1").slideDown(1000);
		
		/*購物車失敗*/
		$(".buy_faild").fadeIn(2000);
		
		/*購物車Hover*/	
		$(".shopcar").hover(cartJump);
		$(".main").click(cartJumpOut);
		
		/*燈箱z-index*/
		$(".buy_link").click(newIndex);
		
		

	}		
	
	function inHandler(e) {
		$(".register").fadeOut();
		$(".outer").slideDown(800);
		e.stopPropagation();
	}
	function outHandler(e) {
		$(".outer").fadeOut();
		$(".register").slideDown(800);
		e.stopPropagation();
	}
	
	function allHandler(e) {
		$(".outer").fadeOut(800);
		$(".register").fadeOut(800);
		e.stopPropagation();
	}
	
	function search_jump(e){
		$(".search_jump").slideDown()
		e.stopPropagation();
		}
		
	function search_out(e){
		$(".search_jump").slideUp()
		e.stopPropagation();
		}	
	
	function downHandler() {
		$(".password").attr("type", "text");
		$(".show").attr("src", "img/EYE.png");
	}
	function upHandler() {
		$(".password").attr("type", "password");
		$(".show").attr("src", "img/CLOSE.png");
	}

	function refresh() {
		$(".captchaImg").attr("src", "images/captcha.jpg?"+new Date().getTime());
		
		//var captcha = document.getElementsByClassName("captchaImg");
		//captcha[0].src = "images/captcha.jpg?abc=" + new Date().getTime();
	}
	
	function pullout(e){
		$(".information").animate({"height":"15%","opacity":0.9},1000);
		e.stopPropagation();
	}
	function pushin(e){
		$(".information").animate({"height":"4.5%","opacity":1},1000);
		e.stopPropagation();
	}
	
	function logout_show(e){
		$(".logout img").show(1000);
		e.stopPropagation();
	}
	
	function logout_hide(e){
		$(".logout").hide(1000);
		e.stopPropagation();
	}
	
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
		$("#imgs").stop().animate({"marginLeft":-index*w+"px"},1000);//image width=735px
		}
	
	
		function cartJump(e){
		$(".cartJump").animate({"right":"0%"},1000);
		e.stopPropagation();
		}
	
		function cartJumpOut(e){
		$(".cartJump").animate({"right":"-350px"},1000);
		e.stopPropagation();
		}
		
		
		