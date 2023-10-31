package model.bo;

import bean.Product;
import model.dao.CreateProductDAO;

public class CreateProductBO {
	
	CreateProductDAO createDAO = new CreateProductDAO();

	public String createProduct(Product p) {
		String MessBO= null;
		String tempVal = null;
		//Check validated
		tempVal = common.Validated.ValidatedProduct(p);
		if(!"No error".equals(tempVal)) {
			return tempVal;
		}
		
		for (int i = 1; i <= 10; i++) {//Lặp 10 lần
			//lấy mã sản phẩm mới nhất
			String lastestMaSP = createDAO.getLastestMaHH();
			System.out.println("lastestMaSP = " + lastestMaSP + " " + i );
			//Kiểm tra mã hàng hóa có nuull không
			if(lastestMaSP == null || "".equals(lastestMaSP)) {
				lastestMaSP = "SP001";
			} else {
				// tăng mã hàng hóa lên một đơn vị
				long numSP = Long.parseLong(lastestMaSP.substring(2));
				lastestMaSP = "SP" + common.Process.riseString(numSP, 3);
			}
			//Gán vào sản phẩm
			p.setMaSP(lastestMaSP);
			System.out.println("Mã sản phẩm = "+p.getMaSP());
			//Tạo sản phẩm
			String messenger=createDAO.createProduct(p);
			//Kiểm tra tạo sản phẩm thành công chưa
			if("Duplicate ID Error".equals(messenger)) {
				MessBO = "Duplicate ID Error";
				continue;
			} else if ("No error".equals(messenger)) {
				MessBO = "No error";
				break;
			}
		}
		
	return MessBO;
	}
	
	
}
