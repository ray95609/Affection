package uuu.Affection.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uuu.Affection.entity.Customer;
import uuu.Affection.exception.AffectionException;
import uuu.Affection.service.OrderService;

/**
 * Servlet implementation class ATMTransferedServlet
 */
@WebServlet("/ATMTransfered.do")
public class ATMTransferedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ATMTransferedServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session =request.getSession();
		Customer member=(Customer) session.getAttribute("member");
		
		if(member==null) {
			response.sendRedirect(request.getContextPath());
			return;
		}
		
		 //1.讀取request中form的輸入項:bank,orderId,trans_account,trans_amount,trans_date,trans_time
		
		String bank=request.getParameter("bank");
		String orderId=request.getParameter("orderId");
		String trans_account=request.getParameter("trans_account");
		String trans_amount=request.getParameter("trans_amount");
		String trans_date=request.getParameter("trans_date");
		String trans_time=request.getParameter("trans_time");
		
		List<String> errmsg = new ArrayList<>();
		
		if(bank==null) {
			errmsg.add("請輸入付款銀行");
		}
		
		if(orderId==null) {
			errmsg.add("查無此訂單");
		}
		
		if(trans_account==null) {
			errmsg.add("請輸入付款帳號後五碼");
		}
		
		if(trans_amount==null) {
			errmsg.add("請輸入付款金額");
		}
		
		if(trans_date==null) {
			errmsg.add("請輸入付款日期");
		}
		
		if(trans_time==null) {
			errmsg.add("請輸入付款時間");
		}
		
		if(errmsg.isEmpty()) {
			OrderService oService =new OrderService();
			try {
				oService.updateStatusToTransfered(member.getId() ,orderId ,bank ,trans_account ,
						Double.parseDouble(trans_amount) ,LocalDateTime.parse(trans_date+"T"+trans_time) );
				        
				response.sendRedirect("historyList.jsp");
				 return;
			} catch (NumberFormatException e) {
				 errmsg.add("轉帳金額格式不正確" + trans_amount);
			} catch (DateTimeParseException e) {
		           errmsg.add("transDate不正確" + trans_date);
			} catch (AffectionException e) {
				 this.log("通知轉帳失敗:" + e.getMessage(), e);
		           errmsg.add(e.getMessage());
			}catch(Exception e) {
		           this.log("通知轉帳發生錯誤:" + e.getMessage(), e);
		           errmsg.add("通知轉帳發生錯誤:"+e);
		       }
		}
		
		 System.out.println(errmsg);      
			
		 /*TODO 問老師為何註解調反而能跑*/
		  //3.2
		    request.setAttribute("errors", errmsg);
		    request.getRequestDispatcher("transfer.jsp").forward(request, response);
		    
	}

	
	
	
	
	
	
	
}
