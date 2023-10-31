package model.bo;

import bean.Product;
import model.dao.ModifyProductDAO;

public class ModifyProductBO {

	ModifyProductDAO modifyDAO = new ModifyProductDAO();
	public String modifyProduct(Product p) {
		String tempVal=null;
		tempVal = common.Validated.ValidatedProduct(p);
		if(!"No error".equals(tempVal)) {
			return tempVal;
		}
		return modifyDAO.modifyProduct (p);
	}

	public Product getProductInfoBO(String MaSP) {
	return modifyDAO.getProductInfoDAO(MaSP);
	}

}
