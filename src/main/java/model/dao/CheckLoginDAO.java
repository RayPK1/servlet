package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckLoginDAO extends BaseDAO {

	public boolean isValidAccount(String user, String pass) {
		Connection conn = getConnection();
		String sql = "SELECT * FROM NGUOIDUNG WHERE TaiKhoan = ? AND MatKhau = ?";
		ResultSet rs = null;
		PreparedStatement pstmt = null; 
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(conn, pstmt, rs);
		}
		
		return false;
	}

}
