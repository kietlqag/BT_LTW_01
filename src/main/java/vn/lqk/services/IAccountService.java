package vn.lqk.services;

import vn.lqk.models.AccountModel;

public interface IAccountService {

	AccountModel login(String username, String password);
	
	AccountModel findByUsername(String username);
	
	boolean register(String username, String fullname, String password);
	
	boolean checkExistUsername(String username);
	
	boolean resetpass(String username, String password);
}
