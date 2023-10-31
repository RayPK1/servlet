package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Product;

public class ShowProductListDAO extends BaseDAO {

	public ArrayList<Product> getProductList(int pageNumber) {
		ArrayList<Product> list = new ArrayList<Product>();
		
		Connection conn = getConnection();
		String sql = "SELECT * FROM (SELECT RowNum = ROW_NUMBER() OVER (ORDER BY MaSP), * FROM SANPHAM) AS tempTable WHERE RowNum > (? * (? - 1)) AND RowNum <= (? * (? - 1)) + ? ORDER BY MaSP";
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Product p;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "20");
			pstmt.setString(2, String.valueOf(pageNumber));
			pstmt.setString(3, "20");
			pstmt.setString(4, String.valueOf(pageNumber));
			pstmt.setString(5, "20");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				p = new Product();
				p.setMaSP(rs.getString("MaSP"));
				p.setTenSP(rs.getString("TenSP"));
				p.setSoLuong(rs.getInt("SoLuong"));
				p.setDonGia(rs.getDouble("DonGia"));
				p.setHinhAnh(rs.getString("HinhAnh"));
				p.setDonViTinh(rs.getString("DonViTinh"));
				
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(conn, pstmt, rs);
		}
		return list;
	}

	public int getTotalPageNumber() {
		Connection conn = getConnection();
		String sql = "SELECT count(MaSP) as totalRow FROM SANPHAM";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int totalPageNumber = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				totalPageNumber = rs.getInt("totalRow");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(conn, pstmt, rs);
		}
		return (int) Math.ceil(totalPageNumber / 20.0);
	}
}
