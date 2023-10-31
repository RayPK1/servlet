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
 * Servlet implementation class ModifyProductServlet
 */
public class ModifyProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyProductServlet() {
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
			Product p = new Product();
			
			p.setMaSP(request.getParameter("MaSP"));
			p.setTenSP(request.getParameter("TenSP"));
			p.setSoLuong(Integer.parseInt(request.getParameter("SoLuong")));
			p.setDonGia(Double.parseDouble(request.getParameter("DonGia")));
			p.setHinhAnh(request.getParameter("HinhAnh"));
			p.setDonViTinh(request.getParameter("DonViTinh"));
			
			ModifyProductBO modifyP = new ModifyProductBO();
			String message = modifyP.modifyProduct(p); 
			
			RequestDispatcher rd;
			if("No error".equals(message)) {
				rd = request.getRequestDispatcher("ShowProductListServlet?message=3");
				rd.forward(request, response);
			} else if ("Required Fields error".equals(message)) {
				rd = request.getRequestDispatcher("ShowModifyProductServlet?message=1");
				rd.forward(request, response);
			} else if ("Invalid DonGia error".equals(message)) {
				rd = request.getRequestDispatcher("ShowModifyProductServlet?message=2");
				rd.forward(request, response);
			} else if ("Invalid SoLuong error".equals(message)) {
				rd = request.getRequestDispatcher("ShowModifyProductServlet?message=3");
				rd.forward(request, response);
			} else {
				rd = request.getRequestDispatcher("ShowModifyProductServlet?message=4");
				rd.forward(request, response);
			}
		}
	}

}
