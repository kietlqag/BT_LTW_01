package vn.lqk.dao;

import java.util.List;

import vn.lqk.models.AccountModel;

public interface IAccountDao {

	List<AccountModel> findAll();
	
	AccountModel findByUsername(String username);
	
	void insert(AccountModel account);
	
	boolean checkExistUsername(String username);
	
	void update(String username, String password);
}
