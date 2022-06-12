package uuu.Affection.controller;

import java.io.IOException;
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
import uuu.Affection.exception.AffectionException;
import uuu.Affection.service.CustomerService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")  //http://localhost:8080/Affection/login.do
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<String> errList =new ArrayList<>();
		
		//宣告session 建立邏輯連結(領號)
		HttpSession session =request.getSession();
		
		//1-取得request 的data form
		String login_id =request.getParameter("login_id");
		String login_password =request.getParameter("login_password");
		String login_captcha =request.getParameter("login_captcha");
		
		//TODOtrim確認寫法
		if(login_id==null || login_id.trim().length()==0) {
			errList.add("必須輸入帳號");
			
		}
		
		if(login_password==null || login_password.trim().length()==0) {
			errList.add("必須輸入密碼");
			
		}
		
		if(login_captcha==null || login_captcha.length()==0) {
			errList.add("必須輸入驗證碼");
			
		}else {  //驗證碼檢查
			String oldCaptcha =(String)session.getAttribute("captcha");
			if(!login_captcha.equals(oldCaptcha)) {
				errList.add("驗證錯誤");
				
			}
			
		}
		session.removeAttribute("captcha");
		//2-呼叫商業邏輯
		if(errList.isEmpty()) {
			CustomerService cService =new CustomerService();
			
			
			try {
				Customer c =cService.login(login_id, login_password);
			
			//3.1-內部轉交給login_ok.jsp	
				session.setAttribute("member", c);
				RequestDispatcher dispatcher=request.getRequestDispatcher("/login_ok.jsp") ;
				dispatcher.forward(request, response);
				
			//forward 	
				return;
				
			  } catch (AffectionException e) {
				  	errList.add(e.getMessage());//給user看
				    this.log("登入失敗",e);//給admin/developer看
				   }catch(Exception e) {
					errList.add("登入失敗:" + e.getMessage());//給user看
				    this.log("登入發生非預期錯誤",e);//給admin/developer看
				   }
				  }
		
		request.setAttribute("errList", errList);
		  //3.2 失敗 內部轉交(forward)給login.jsp
		/*TODO 重新整理當前頁面*/
		RequestDispatcher dispatcher=request.getRequestDispatcher("/index.jsp") ;
		dispatcher.forward(request, response);
		
			
		
		
		/*response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");//設定文字編碼(繁體中文的痛)
				
		PrintWriter out=response.getWriter();
		out.println("<!DOCUMENT html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title=>Affection-登入失敗</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>Faild Login:"+errList+"</h2>");
		out.println("<input type='button' value='Restart' onClick='history.back()';>");
		out.println("</body>");
		out.println("</html>");*/
		
		
	}

}
