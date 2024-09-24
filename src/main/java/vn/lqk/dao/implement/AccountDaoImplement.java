package vn.lqk.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import vn.lqk.configs.DBConnectMySQL;
import vn.lqk.dao.IAccountDao;
import vn.lqk.models.AccountModel;

public class AccountDaoImplement extends DBConnectMySQL implements IAccountDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public List<AccountModel> findAll() {
		String sql = "SELECT * FROM account";

		List<AccountModel> list = new ArrayList<>();

		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new AccountModel(rs.getString("username"), rs.getString("password"), rs.getString("fullname"),
						rs.getInt("roleid")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public AccountModel findByUsername(String username) {
		String sql = "SELECT * FROM account WHERE username = ?";
		AccountModel account = null;
		try {
			conn = super.getDatabaseConnection();

			ps = conn.prepareStatement(sql);

			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				account = new AccountModel();
				account.setUsername(rs.getString("username"));
				account.setPassword(rs.getString("password"));
				account.setFullname(rs.getString("fullname"));
				account.setRoleid(rs.getInt("roleid"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return account;
	}

	@Override
	public void insert(AccountModel account) {
		String sql = "INSERT INTO account(username, password, tennguoidung) VALUES(?, ?, ?)";

		try {
			conn = super.getDatabaseConnection();

			ps = conn.prepareStatement(sql);

			ps.setString(1, account.getUsername());
			ps.setString(2, account.getPassword());
			ps.setString(3, account.getFullname());

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean checkExistUsername(String username) {
		boolean duplicate = false;
		String query = "SELECT * FROM [account] where username = ?";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}

}
