package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.bo.ModifyProductBO;

import java.io.IOException;

import bean.Product;

/**
 * Servlet implementation class ShowModifyProductServlet
 */
public class ShowModifyProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowModifyProductServlet() {
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
		if (session.getAttribute("UserName") == null) {
			response.sendRedirect("login.jsp?error=1");
		} else {
			ModifyProductBO modifyProductBO = new ModifyProductBO();
			Product p = new Product();
			p = modifyProductBO.getProductInfoBO(request.getParameter("MaSP"));
			request.setAttribute("p", p);
			RequestDispatcher rd;
			if(p!=null) {
				rd = request.getRequestDispatcher("modifyProduct.jsp");
				rd.forward(request, response);
			} else {
				rd = request.getRequestDispatcher("ShowProductListServlet");
				rd.forward(request, response);
			}
		}
	}

}
