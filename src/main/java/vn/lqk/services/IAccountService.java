package vn.lqk.services;

import vn.lqk.models.AccountModel;

public interface IAccountService {

	AccountModel login(String username, String password);
	
	AccountModel findByUsername(String username);
	
	void insert(AccountModel account);
	
	boolean register(String password, String username, String fullname);
	
	boolean checkExistUsername(String username);
}
