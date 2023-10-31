package model.bo;

import model.dao.CheckLoginDAO;

public class CheckLoginB0 {

	
	public boolean isValidAccount(String user, String pass) {
		CheckLoginDAO checkLogin = new CheckLoginDAO();
		return checkLogin.isValidAccount(user, pass);
	}

	public int getAccountRole(String user) {
		// TODO Auto-generated method stub
		return 0;
	}

}
