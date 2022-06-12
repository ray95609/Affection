package uuu.Affection.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uuu.Affection.entity.Product;
import uuu.Affection.entity.ShopingCart;
import uuu.Affection.exception.AffectionException;
import uuu.Affection.service.ProductService;

/**
 * Servlet implementation class aadToCartServlet
 */
@WebServlet("/add_To_Cart.do")
public class addToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addToCartServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> errList =new ArrayList<>();
		
		HttpSession session =request.getSession();
		
		//1.取得request中的form data
		String productId =request.getParameter("productId");
		String quantity=request.getParameter("quantity");
		
		//2.檢查productId
		if(productId!=null) {
			ProductService pService= new ProductService();
			try {
				Product p=pService.getProductId(productId);
				if(p!=null) {
					if(quantity!=null && quantity.matches("\\d+")) {
						ShopingCart scart =(ShopingCart)session.getAttribute("scart");
						if(scart==null) {
							scart=new ShopingCart();
							session.setAttribute("scart", scart);
						}
						scart.add(p, Integer.parseInt(quantity));
					}else {
						errList.add("加入購物車失敗,產品數量須為正整數");
					}
					
				}else {
					errList.add("加入購物車失敗,查無此產品,產品編號:"+productId);
					
				}
			} catch (AffectionException e) {
				this.log("加入購物車失敗",e);
			}
			
		}else errList.add("購物車清單productId不得空白");
					
		this.log(errList.toString());
		
		//3.1-內部轉交給ShopCart.jsp
		//request.getRequestDispatcher("ShopCart.jsp").forward(request, response);//內部轉交 不可使用
		//2-外部轉交
		response.sendRedirect(request.getContextPath()+"/ShopCart.jsp");
		//3-非同步請求時外部轉交
		//response.sendRedirect(request.getContextPath() + "/smallCart.jsp");
		}

}
