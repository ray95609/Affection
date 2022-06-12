package uuu.Affection.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uuu.Affection.entity.Customer;
import uuu.Affection.exception.AffectionAtaInvalidException;
import uuu.Affection.exception.AffectionException;
import uuu.Affection.service.CustomerService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		request.setCharacterEncoding("utf-8");	
		List<String> errList =new ArrayList<>();
		
		//宣告session 建立邏輯連結(領號)
		HttpSession session =request.getSession();
		
		//1-取得request 的data form
		
		String id =request.getParameter("id");
		String password =request.getParameter("password");
		String confirm_password =request.getParameter("confirm_password");
		String name =request.getParameter("name");
		String email =request.getParameter("email");
		String gender =request.getParameter("gender");
		String birthday =request.getParameter("birthday");
		String phone =request.getParameter("phone");
		String address =request.getParameter("address");
		String subcribe =request.getParameter("subcribe");
		String captcha =request.getParameter("captcha");
		
		
		//TODOtrim確認寫法
		//checkID??
		if(id==null || (id=(id.trim())).length()==0) {
			errList.add("必須輸入帳號");
		}
		
		if(password==null || password.length()==0) {
			errList.add("必須輸入密碼");
		}
				
		if(!confirm_password.equals(password)) {
			errList.add("請確認密碼相符");
		}
		
		if(name==null || (name=(name.trim())).length()==0) {
			errList.add("必須輸入姓名");
		}
		
		if(email==null || (email=(email.trim())).length()==0) {
			errList.add("必須輸入e-mail");
		}
		
		if(gender==null || gender.length()==0) {
			errList.add("必須選擇性別");
		}
		
		if(address!=null ) {
			address=(address.trim());
		}
		
		if(birthday==null || birthday.length()==0) {
			errList.add("必須輸入出生年月日");
		}
		
		if(phone!=null) {phone=(phone.trim());
		}
		
		if(captcha==null || captcha.length()==0) {
			errList.add("必須輸入驗證碼");
		}else {  //驗證碼檢查
			String oldCaptcha =(String)session.getAttribute("captcha");
			if(!captcha.equals(oldCaptcha)) {
				errList.add("驗證錯誤");
				
			}
			
		}
		session.removeAttribute("captcha");
		//2-呼叫商業邏輯
		if(errList.isEmpty()) {
			Customer c1 =new Customer();
					
		
			try {
				c1.setId(id);
				c1.setPassword(password);
				c1.setName(name);
				c1.setEmail(email);
				c1.setBirthday(birthday);
				c1.setGender(gender.charAt(0));
				c1.setPhone(phone);
				c1.setAddress(address);
				c1.setSubscribed(subcribe!=null);
				
				CustomerService cService =new CustomerService();
				
				cService.register(c1);
				//3.1-內部轉交給login_ok.jsp	
				session.setAttribute("member", c1);
				RequestDispatcher dispatcher=request.getRequestDispatcher("/register_ok.jsp") ;
				dispatcher.forward(request, response);
				/*
				response.setContentType("text/html");                
                response.setCharacterEncoding("utf-8");
                try(PrintWriter out = response.getWriter();){                    
                    out.println("<html>");
                    out.println("<head>");    
                    out.println("<title>註冊成功</title>");    
                    out.println("</head>");    
                    out.println("<body>");
                    out.println("<p>註冊成功!" + c1.getName() + ", 你好</p>");
                    out.println("</body>");
                    out.println("</html>");
                }*/
                return;
            }catch(AffectionAtaInvalidException e) {                
            	errList.add(e.getMessage());
            }catch(AffectionException e) {
                this.log(e.getMessage(), e);
                errList.add(e.getMessage());
            }catch(Exception e) {
                this.log("會員註冊發生非預期錯誤"+e.getMessage(), e);
                errList.add("會員註冊失敗:"+e.getMessage());
            }
        }
		request.setAttribute("errList_register", errList);
        //3.2 顯示註冊失敗畫面
		RequestDispatcher dispatcher=request.getRequestDispatcher("/index.jsp") ;
		dispatcher.forward(request, response);
		
        /*response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        try(PrintWriter out = response.getWriter();){
            out.println("<html>");    
            out.println("<head>");    
            out.println("<title>註冊失敗</title>");    
            out.println("</head>");                
            out.println("<body>");
            out.println("<p>" + errList+"</p>");
            out.println("<p>"
                    + "<input type='button' onclick='history.back()' value='回上頁'>"
                    + "</p>");
            out.println("</body>");
            out.println("</html>");
        }*/
    }
}