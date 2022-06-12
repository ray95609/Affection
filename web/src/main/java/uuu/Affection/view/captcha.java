package uuu.Affection.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CaptchaServlet
 */
//@WebServlet("/images/captcha.jpg")

public class captcha extends HttpServlet {
	private int len = 6,  width = 16 * 2 + 12 * len,  height = 20;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public captcha() {
        super();
        // TODO Auto-generated constructor stub
    }
    /*兩個驗證碼-連結到web.xml撈資料用
    public void init(){
    	String len = this.getInitParameter("len");
    	if(len!=null && len.matches("\\d+")) {
    		this.len = Integer.parseInt(len);
    		this.width = 16 * 2 + 12 * this.len;
    	}
    }*/
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.不須取得request中的FormData       
        //2.用亂數產生len個英(大寫)數字的字元
        String captcha = "";
        Random random = new Random(); //import java.util.Random;
        for(int i=0;i<len;i++) {
            int data = random.nextInt(36);
            char ch = (char)(data<10?(data+'0'):(data-10+'A'));
            captcha+=ch;
        }
        //System.out.println("captcha:" + captcha);
		
        HttpSession session = request.getSession();//建立session 物件
        session.setAttribute("captcha", captcha);//將驗證碼字串存入session中名為captcha的attribute		
		
        //繪製圖片(Draw image)		
        BufferedImage image = generateImage(captcha, width, height);
		
        //3.讓圖片透過response的位元串流輸出到前端
        response.setContentType("image/jpeg");
        try (ServletOutputStream outStream = response.getOutputStream();){      //將影像輸出到前端
            ImageIO.write(image, "JPEG", outStream);
        } 
	}

	private BufferedImage generateImage(String rand, int width, int height) {
        //開始建立圖片
        BufferedImage image =
                new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();   //取得影像繪圖區
 
        //畫出背景方塊
        g.setColor(getRandomColor(200, 250)); //設定繪圖區背景色
        g.fillRect(0, 0, width, height);    //在繪圖區畫個長方型

        //畫干擾線讓背景雜亂
        Random random = new Random();
        g.setColor(getRandomColor(170, 210));
        for (int i = 0; i<155; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }

        //畫出認證文字
        g.setFont(new Font("Arial", Font.PLAIN, 18));//設定字體
        g.setColor(getRandomColor(20, 140));
        //將認證文字畫到image中
        g.drawString(rand, 16, 16);
        g.dispose();
        return image;
    } 

    private Color getRandomColor(int fc, int bc) {
        //在參數設定的範圍內，隨機產生顏色
        Random random = new Random();
        if (fc > 255) fc = 255;
        if (bc > 255) bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }
}
