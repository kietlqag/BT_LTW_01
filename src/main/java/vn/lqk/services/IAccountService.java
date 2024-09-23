package vn.lqk.services;

import vn.lqk.models.AccountModel;

public interface IAccountService {

	AccountModel login(String username, String password);
	
	AccountModel findByUsername(String username);
	
}
