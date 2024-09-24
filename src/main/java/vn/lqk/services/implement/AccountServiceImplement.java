package vn.lqk.services.implement;

import vn.lqk.dao.IAccountDao;
import vn.lqk.dao.implement.AccountDaoImplement;
import vn.lqk.models.AccountModel;
import vn.lqk.services.IAccountService;

public class AccountServiceImplement implements IAccountService {

	IAccountDao accountDao = new AccountDaoImplement();

	@Override
	public AccountModel login(String username, String password) {
		AccountModel account = this.findByUsername(username);
		if (account != null && password.equals(account.getPassword())) {
			return account;
		} else {
			return null;
		}
	}

	@Override
	public AccountModel findByUsername(String username) {
		return accountDao.findByUsername(username);
	}

	@Override
	public void insert(AccountModel account) {
		accountDao.insert(account);
		
	}

	@Override
	public boolean register(String password, String username, String fullname) {
		if (accountDao.checkExistUsername(username)) {
			return false;
			}
			accountDao.insert(new AccountModel(username, fullname, password, 2));
			return true;
	}

	@Override
	public boolean checkExistUsername(String username) {
		return accountDao.checkExistUsername(username);
	}
}
