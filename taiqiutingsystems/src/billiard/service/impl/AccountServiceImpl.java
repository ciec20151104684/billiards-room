package billiard.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import billiard.dao.AccountDao;
import billiard.entity.Account;
import billiard.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	@Resource
	private AccountDao accountDao;
	
	//添加新用户
	public int addAccount(Account account) throws Exception{
		return accountDao.insertAccount(account);
	}
	
	//判断指定证件号是否存在
	public int boolIsExist(String cardID) throws Exception{
		return accountDao.boolIsExist(cardID);
	}
	
	//根据证件号获取账户余额
	public float selectBalance(String cardID) throws Exception{
		return Float.parseFloat(accountDao.selectBanlanceByCardID(cardID));
	}
	
	//根据证件号更新账户余额
	public int updateBalanceByCardID(String cardID, String money) throws Exception{
		return accountDao.updateBalanceByCardID(cardID, money);
	}
	
	//根据证件号删除用户
	public int deleteByCardID(String cardID) throws Exception{
		return accountDao.deleteByCardID(cardID);
	}
	
	//根据id更新账户信息
	public int updateByPrimaryKeySelective(Account account) throws Exception{
		return accountDao.updateByPrimaryKeySelective(account);
	}
	
	//根据id获取指定账户信息
	public Account selectByPrimaryKey(int id) throws Exception{
		return accountDao.selectByPrimaryKey(id);
	}
	
	//获取所有用户信息
	public List<Account> selectAll() throws Exception{
		return accountDao.selectAll();
	}
	
	//根据部分条件查询用户
	public List<Account> selectAccount(Account account) throws Exception{
		return accountDao.selectAccount(account);
	}
}

