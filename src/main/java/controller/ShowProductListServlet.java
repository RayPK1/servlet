package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.bo.ShowProductListBO;

import java.io.IOException;
import java.util.ArrayList;

import bean.Product;

/**
 * Servlet implementation class ShowProductListServlet
 */
public class ShowProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowProductListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		HttpSession session = request.getSession();
		session.removeAttribute("searchTextProduct");
		if (session.getAttribute("UserName") == null) {
			response.sendRedirect("login.jsp?error=1");
		} else {
			ShowProductListBO showProductListBO = new ShowProductListBO();
			String page = (String)request.getParameter("page");
			
			int pageNumber = 1; //Mặc định trang web ở trang 1
			
			if(page!=null && !"".equals(page)) {
				pageNumber=Integer.parseInt(page);
			}
			ArrayList<Product> list = showProductListBO.getProductList(pageNumber);
			
			int totalPageNumber = showProductListBO.getTotalPageNumber();
			
			request.setAttribute("list", list);
			request.setAttribute("totalPageNumber", totalPageNumber);
			System.out.println(totalPageNumber);
			request.setAttribute("pageNumber", pageNumber);
			
			RequestDispatcher rd = request.getRequestDispatcher("shop.jsp");
			rd.forward(request, response);
		}
	}
}
