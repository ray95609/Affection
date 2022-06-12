package uuu.Affection.controller;

import java.io.IOException;
import java.net.http.HttpRequest;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uuu.Affection.entity.Customer;

/**
 * Servlet Filter implementation class LoginCheckServlet
 */
@WebFilter(urlPatterns= {"/memberCenter.jsp","/memberUpdate_ok.jsp","/memberUpdate_ok.jsp","/checkout.jsp","/historyList.jsp","/historyDetail.jsp","/ShopCart.jsp","/transfer.jsp"})
public class LoginCheckFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginCheckFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest)request;
		HttpServletResponse httpRes = (HttpServletResponse)response;	
		
		HttpSession session = httpReq.getSession();
		Customer member = (Customer)session.getAttribute("member");
		
		if(member==null) { //尚未登入
			session.setAttribute("previous.uri", httpReq.getRequestURI());
			session.setAttribute("previous.querystring", httpReq.getQueryString());
			httpRes.sendRedirect(httpReq.getContextPath());
			return;
		}else {
			chain.doFilter(request, response); //交給下一棒
		}
	}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
