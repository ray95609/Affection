package uuu.Affection.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uuu.Affection.entity.CartItem;
import uuu.Affection.entity.ShopingCart;

/**
 * Servlet implementation class UpdateCartServlet
 */
@WebServlet("/update_cart.do")
public class UpdateCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCartServlet() {
        super();
        }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ShopingCart scart = (ShopingCart)session.getAttribute("scart");
		
		//1.讀取request中的Form Data
		if(scart!=null && scart.size()>0) {
			for(CartItem item:scart.getCartItemSet()) {
				String qty=request.getParameter("Quantity" + item.hashCode());
				String delete=request.getParameter("delete" + item.hashCode());
				
				//2. 判斷要修改或刪除
				if(delete==null) { //只要修改數量
					if(qty!=null && qty.matches("\\d+")) {
						scart.update(item, Integer.parseInt(qty));
					}
				}else {//要刪除該筆
					scart.remove(item);
				}
			}
		}
		
		//3. 外部轉交給/member/cart.jsp
		response.sendRedirect(request.getContextPath()+"/ShopCart.jsp");

	}

}