package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Product;

public class ModifyProductDAO extends BaseDAO {

	public String modifyProduct(Product p) {
		Connection conn = getConnection();
		String sql = "UPDATE SANPHAM SET TenSP = ?, DonGia = ?, SoLuong = ?, DonViTinh = ?, HinhAnh = ? WHERE MaSP = ?";
		PreparedStatement pstmt = null;
		
		try {
			System.out.println("MaSP = "+p.getMaSP()+ " TenSP = " + p.getTenSP()+ " DonGia = "+ p.getDonGia()+" SoLuong = "+ p.getSoLuong()+ " DonViTinh = "+p.getDonViTinh()+" HinhAnh = "+p.getHinhAnh());
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getTenSP());
			pstmt.setDouble(2, p.getDonGia());
			pstmt.setInt(3, p.getSoLuong());
			pstmt.setString(4, p.getDonViTinh());
			pstmt.setString(5, p.getHinhAnh());
			pstmt.setString(6, p.getMaSP());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(conn, pstmt, null);
		}
		
		return "No error";
	}

	public Product getProductInfoDAO(String MaSP) {
		Connection conn = getConnection();
		String sql = "SELECT * FROM SANPHAM WHERE MaSP = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Product p = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, MaSP);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				p = new Product();
				p.setMaSP(rs.getString("MaSP"));
				p.setTenSP(rs.getString("TenSP"));
				p.setSoLuong(Integer.parseInt(rs.getString("SoLuong")));
				p.setDonGia(Double.parseDouble(rs.getString("DonGia")));
				p.setHinhAnh(rs.getString("HinhAnh"));
				p.setDonViTinh(rs.getString("DonViTinh"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(conn, pstmt, rs);
		}
		System.out.println("Product = " + p);
		return p;
	}

}
