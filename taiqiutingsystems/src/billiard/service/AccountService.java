package billiard.service;

import java.util.List;

import billiard.entity.Account;

public interface AccountService {
	public int addAccount(Account account) throws Exception;
	public int boolIsExist(String cardID) throws Exception;
	public float selectBalance(String cardID) throws Exception;
	public int updateBalanceByCardID(String cardID, String money) throws Exception;
	public int deleteByCardID(String cardID) throws Exception;
	public int updateByPrimaryKeySelective(Account account) throws Exception;
	public Account selectByPrimaryKey(int id) throws Exception;
	public List<Account> selectAll() throws Exception;
	public List<Account> selectAccount(Account account) throws Exception;

}
