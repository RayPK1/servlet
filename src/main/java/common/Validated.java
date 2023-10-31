package common;

import bean.Product;

public class Validated {

	public static String ValidatedProduct(Product p) {
		String MessBO = "No error";
		
		if("".equals(p.getTenSP())||"".equals(p.getDonViTinh())||"0".equals(Integer.toString(p.getSoLuong()))||"0.0".equals(Double.toString(p.getDonGia()))) {
			MessBO = "Required Fields error";
			return MessBO;
		}
		
		if(!(Double.toString(p.getDonGia()).matches("[0-9]{4,15}\\.[0-9]+"))){
			System.out.println("Đơn giá = "+p.getDonGia());
			return MessBO = "Invalid DonGia error";
		}
		if(!(Integer.toString(p.getSoLuong()).matches("[0-9]*"))){
			System.out.println("Số lượng = "+p.getSoLuong());
			return MessBO = "Invalid SoLuong error";
		}
		return MessBO;
	}
}
