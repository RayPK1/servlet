package model.bo;

import model.dao.DeleteProductDAO;

public class DeleteProductBO {

	DeleteProductDAO deleteDAO = new DeleteProductDAO();

	public void DeleteProduct(String maSP) {
		deleteDAO.DeleteProduct(maSP);
	} 
}
