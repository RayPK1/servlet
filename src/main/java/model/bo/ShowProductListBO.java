package model.bo;

import java.util.ArrayList;

import bean.Product;
import model.dao.ShowProductListDAO;

public class ShowProductListBO {

	ShowProductListDAO showProductListDAO = new ShowProductListDAO();

	public ArrayList<Product> getProductList(int pageNumber) {
		
		return showProductListDAO.getProductList(pageNumber);
	}

	public int getTotalPageNumber() {
		return showProductListDAO.getTotalPageNumber();
	}
			
}
