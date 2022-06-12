<!DOCTYPE html>
<html>
    <head>
        <title> Affection Card </title>
        <meta charset="UTF-8">
        <style>
        
        .main{
        width:600px;
        height:600px;
        
        background-color: 	#FFECF5;
        background-size: contain;
        background-repeat: no-repeat;
        background-position: center;
       	border-radius: 30px;
       	text-shadow: 1px 1px 5px black;
       	font-family:Arial,"微軟正黑體" , "Microsoft JhengHei","仿宋_GB2312","FangSong_GB2312, PingFang" ;
       	box-shadow: 10px 10px 20px grey;
       	border-style: inset;
       	border-color: pink;
       	
        }
        
        .tk{
        text-align: center;
        z-index:5;
        }
		
		
		.last{
		margin:450px 0 0 350px;
		z-index:5; 
		}
		
		
		.logo{
		position:absolute;
		top:14px;
		left: 110px; 
		z-index:1;
		filter:drop-shadow(2px 2px 7px rgba(0, 0, 0, 0.7));
		}
        
        @keyframes swing_2{
		10%{transform:rotate(0deg)}
		100%{transform:rotateY(360deg);}
		}
        
        .logo:hover {
		animation:swing_2 6s 4;
		}
		
		
		@keyframes swing_3{
		10%{transform:rotate(0deg)}
		100%{transform:translateX(-300px);}
		}
		
        
        .left{
        width:300px;
        height:600px;
        position:absolute;
        left: 10px;
        top: 10px;
        z-index:1;
        background: linear-gradient(90deg, white 0%, pink 100%);    
        border-radius:30px 0 0 30px; 
        opacity:0.9; 
        
        }
        
        .left:hover{
        animation:swing_3 3s 1;
        }
        
         
        .right{
        width:300px;
        height:600px;
        position:absolute;
        left: 310px;
        top: 10px;
        z-index:1;
         background: linear-gradient(90deg, pink 0%, white 100%);      
        border-radius:0px 30px 30px 0px; 
        opacity:0.9;
        
        }
       
       @keyframes swing_4{
		10%{transform:rotate(0deg)}
		100%{transform:translateX(300px);}
		}
       
        .right:hover{
        animation:swing_4 3s 1;
        }
        
        </style>
        

        
    </head>
    
    
    
    
    <body>
    <div class="main">
    <!-- div class="left"></div-->
    <!-- div class="right"></div-->
    <div class="tk"><h1 >感謝您的捐贈</h1></div>
    <img src="cid:image" class="logo">
    <div class="tk"><h2 class="tk">有您的祝福與關懷，讓我們能快樂且健康的成長</h2></div>
    <h2 class="last">Affection全體敬上</h2>

    </div>
    </body>
    
</html>