package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Product;

public class CreateProductDAO extends BaseDAO {

	public String createProduct(Product p) {
		Connection conn = getConnection();
		
		String sql = "INSERT INTO SANPHAM (MaSP, TenSP, SoLuong, DonGia, HinhAnh, DonViTinh) VALUES(?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getMaSP());
			pstmt.setString(2, p.getTenSP());
			pstmt.setInt(3, p.getSoLuong());
			pstmt.setDouble(4, p.getDonGia());
			pstmt.setString(5, p.getHinhAnh());
			pstmt.setString(6, p.getDonViTinh());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			String errorMessage = e.getMessage();
			
			if(errorMessage!=null && errorMessage.contains("The duplicate key value is")) {
				System.out.println("error Message = "+ errorMessage);
				return "Duplicate ID Error";
			}
		} finally {
			closeConnection(conn, pstmt, null);
		}
		return "No error";
	}
	
	public String getLastestMaHH() {
		Connection conn = getConnection();
		String lastestMaSP = null;
		String sql = "SELECT TOP 1 MaSP FROM SANPHAM ORDER BY MaSP DESC";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				lastestMaSP = rs.getString("MaSP");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(conn, pstmt, rs);
		}
		return lastestMaSP;
	}

}
