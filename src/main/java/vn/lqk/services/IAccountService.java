package vn.lqk.services;

import vn.lqk.models.AccountModel;

public interface IAccountService {

	AccountModel login(String username, String password);
	
	AccountModel FindByUsername(String username);
	
}
