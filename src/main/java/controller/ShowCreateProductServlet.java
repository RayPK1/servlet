package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.bo.CreateProductBO;

import java.io.IOException;

import bean.Product;

/**
 * Servlet implementation class ShowCreateProductServlet
 */
public class ShowCreateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCreateProductServlet() {
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
			p.setTenSP(request.getParameter("TenSP"));
			p.setSoLuong(Integer.parseInt(request.getParameter("SoLuong")));
			p.setDonGia(Double.parseDouble(request.getParameter("DonGia")));
			p.setHinhAnh(request.getParameter("HinhAnh"));
			p.setDonViTinh(request.getParameter("DonViTinh"));
			
			CreateProductBO createBO = new CreateProductBO();
			String mess = createBO.createProduct(p);
			RequestDispatcher rd = null;
			if("No error".equals(mess)) {
				rd = request.getRequestDispatcher("ShowProductListServlet?message=2");
			} else if ("Duplicate ID Error".equals(mess)){
				rd = request.getRequestDispatcher("CreateProductServlet?message=1");
			} else if ("Required Fields error".equals(mess)){
				rd = request.getRequestDispatcher("CreateProductServlet?message=2");
			} else if ("Invalid DonGia error".equals(mess)){
				rd = request.getRequestDispatcher("CreateProductServlet?message=3");
			} else if ("Invalid SoLuong error".equals(mess)){
				rd = request.getRequestDispatcher("CreateProductServlet?message=4");
			} else {
				rd = request.getRequestDispatcher("CreateProductServlet?message=5");
			}
			rd.forward(request, response);
		}
	}

}
