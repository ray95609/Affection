package uuu.Affection.controller;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class CharSetFliter
 */
@WebFilter(
		dispatcherTypes = {DispatcherType.REQUEST ,DispatcherType.ERROR}
					, 
		urlPatterns = { 
				"*.do", 
				"*.jsp"
		})
public class CharSetFliter implements Filter {

    /**
     * Default constructor. 
     */
    public CharSetFliter() {
      
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		/*統一設定編碼*/
		request.setCharacterEncoding("UTF-8");
		request.getParameterNames();			//鎖定request編碼
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter();					//鎖定response編碼
		
		
		chain.doFilter(request, response);//關鍵元件  沒有這一段 所有城市都會被卡住  出不去也進不來
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
