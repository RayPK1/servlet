package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteProductDAO extends BaseDAO {

	public void DeleteProduct(String maSP) {
		Connection conn = getConnection();
		String sql = "DELETE FROM SANPHAM WHERE MaSP = ?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, maSP);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(conn, pstmt, null);
		}
	}

}
