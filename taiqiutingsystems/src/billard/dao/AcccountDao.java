package billard.dao;

import java.util.List;

import billiard.entity.Account;

public interface AcccountDao {
	//根据证件号删除用户
		int deleteByCardID(String cardid);
		
		//添加新用户
	    int insertAccount(Account record);
	    
	    //获取所有用户信息
	    List<Account> selectAll();
	    
	    //根据部分条件查询用户
	    List<Account> selectAccount(Account record);
	    
	    //根据id获取指定账户信息
	    Account selectByPrimaryKey(Integer id);
	    
	    //判断指定证件号是否存在
	    int boolIsExist(String cardid);
	    
	    //根据证件号获取账户余额
	    String selectBanlanceByCardID(String cardid);

	    //根据id更新账户信息
	    int updateByPrimaryKeySelective(Account record);
	    
	    //根据证件号更新账户余额
	    int updateBalanceByCardID(String cardid, String money);

}
