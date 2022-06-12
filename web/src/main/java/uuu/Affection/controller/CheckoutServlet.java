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

import org.apache.jasper.tagplugins.jstl.core.Remove;

import uuu.Affection.entity.Customer;
import uuu.Affection.entity.Order;
import uuu.Affection.entity.PaymentType;
import uuu.Affection.entity.ReceiptType;
import uuu.Affection.entity.ShopingCart;
import uuu.Affection.exception.AffectionAtaInvalidException;
import uuu.Affection.exception.AffectionException;
import uuu.Affection.exception.AffectionOverException;
import uuu.Affection.service.MailService;
import uuu.Affection.service.OrderService;

/**
 * Servlet implementation class Checkout
 */
@WebServlet("/checkout.do")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckoutServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//建立所需物件與錯誤清單
		HttpSession session =request.getSession();
		List<String> errlist=new ArrayList<>();
		Customer member =(Customer)session.getAttribute("member");
		ShopingCart scart =(ShopingCart)session.getAttribute("scart");
		
		

		//取得Form的內容
		String order_name=request.getParameter("order_name");
		String order_phone=request.getParameter("order_phone");
		String order_address=request.getParameter("order_address");
		String order_email=request.getParameter("order_email");
		String order_payment=request.getParameter("order_payment");
		String order_receipt=request.getParameter("order_receipt");
		
		
		if(member==null) {
			errlist.add("必須先登入才能購物!");			
		}
		
		if(scart==null) {
			errlist.add("捐贈品為空,無法建立!");			
		}
		
		if(order_payment==null) {
			errlist.add("未選擇付款方式!");
		} 
		
		if(order_receipt==null) {
			errlist.add("未選擇發票方式!");
		} 
		
		if(order_name==null) {
			errlist.add("請輸入捐贈大名!");
		} 
		
		if(order_phone==null) {
			errlist.add("請輸入捐贈聯絡方式!");
		} 
		
		if(order_address==null) {
			errlist.add("請輸入發票寄送地址!");
		} 
		
		//呼叫商業邏輯
		if(errlist.isEmpty()) {
			Order order =new Order();
			PaymentType pType=PaymentType.valueOf(order_payment);
			ReceiptType rType=ReceiptType.valueOf(order_receipt);
			
			try {
			//set order內容
			order.setMember(member);
			order.add(scart);
			
			order.setPaymentType(pType);
			order.setReceiptType(rType);
			order.setOrdername(order_name);
			order.setOrderemail(order_email);
			order.setOrderphone(order_phone);
			order.setOrderaddress(order_address);
			
			//寫入資料庫
			OrderService oService=new OrderService();
			oService.checkout(order);
			
			session.removeAttribute("scart");
			
			
						
			String to =order_email;
			
			if(to!=null) {
				MailService.sendHelloMailWithLogo(to);
				
			}

						
			//外部轉交
			response.sendRedirect("historyList.jsp");
			return;
			
			
			}catch (AffectionOverException e) {
				errlist.add(e.toString());
				this.log(e.getMessage(), e);
			}catch (AffectionException e) {
				errlist.add(e.getMessage());
				this.log(e.getMessage(), e);
			}catch (AffectionAtaInvalidException e) {
				errlist.add(e.getMessage());
			}catch (Exception e) {
				errlist.add("結帳發生非預期錯誤: "+e.getMessage());
				this.log("結帳發生非預期錯誤", e);
			}
			
		}
		
		//3.2 error則forward回check_out.jsp
				request.setAttribute("check_errlist", errlist);
				RequestDispatcher dispatcher = request.getRequestDispatcher("checkout.jsp");
				dispatcher.forward(request, response);
		
		
		
		
		
		
		
		
	}

}
