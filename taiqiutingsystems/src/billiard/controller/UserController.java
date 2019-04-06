package billiard.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import billiard.common.ResultMessage;
import billiard.entity.Account;
import billiard.service.AccountService;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/user/")
public class UserController {
	@Autowired
	private AccountService accountService;
	
	/**
	 * 添加用户
	 * @param account
	 * @return
	 */
	@RequestMapping("add")
	@ResponseBody
	public ResultMessage addAccount(Account account) {
		try {
			int isExist = accountService.boolIsExist(account.getCardid());
			if(isExist > 0) {
				return ResultMessage.error("用户已存在！");
			}
			int data = accountService.addAccount(account);
			if(data == 0) {
				return ResultMessage.error("添加失败！");
			}else {
				return ResultMessage.okNotData("添加成功！");
			}
		}catch (Exception e) {
			e.printStackTrace();
			return ResultMessage.error("系统错误！");
		}
	}
	
	/**
	 * 删除用户
	 * @param cardid
	 * @return
	 */
	@RequestMapping("delete")
	@ResponseBody
	public ResultMessage deleteAccount(String cardid) {
		try {
			int data = accountService.deleteByCardID(cardid);
			if(data == 0) {
				return ResultMessage.error("删除失败！");
			}else {
				return ResultMessage.okNotData("删除成功！");
			}
		}catch (Exception e) {
			e.printStackTrace();
			return ResultMessage.error("系统错误！");
		}
	}
	
	/**
	 * 修改用户信息
	 * @param account
	 * @return
	 */
	@RequestMapping("modify")
	@ResponseBody
	public ResultMessage modifyAccount(Account account) {
		try {
			int data = accountService.updateByPrimaryKeySelective(account);
			if(data == 0) {
				return ResultMessage.error("修改失败！");
			}else {
				return ResultMessage.okNotData("修改成功！");
			}
		}catch (Exception e) {
			e.printStackTrace();
			return ResultMessage.error("系统错误！");
		}
	}
	
	/**
	 * 获取所有用户
	 * @return
	 */
	@RequestMapping("all")
	@ResponseBody
	public ResultMessage getAllAccount() {
		try {
			List<Account> dataList = accountService.selectAll();
			if(dataList.isEmpty()) {
				return ResultMessage.error("无用户信息！");
			}
			return ResultMessage.okHaveData(dataList);
		}catch (Exception e) {
			e.printStackTrace();
			return ResultMessage.error("系统错误！");
		}
	}
	
	/**
	 * 查询用户
	 * @param account
	 * @return
	 */
	@RequestMapping("search")
	@ResponseBody
	public ResultMessage selectAccount(Account account) {
		try {
			List<Account> dataList = accountService.selectAccount(account);
			if(dataList.isEmpty()) {
				return ResultMessage.error("无用户信息！");
			}
			return ResultMessage.okHaveData(dataList);
		}catch (Exception e) {
			e.printStackTrace();
			return ResultMessage.error("系统错误！");
		}
	}
	
	/**
	 * 充值
	 * @param cardid 用户证件号
	 * @param money	充值金额
	 * @return
	 */
	@RequestMapping("recharge")
	@ResponseBody
	public ResultMessage recharge(String cardid, String money) {
		try {
			int isExist = accountService.boolIsExist(cardid);
			if(isExist == 0) {
				return ResultMessage.error("用户不存在！");	//查询不到用户，返回
			}
			
			float balance = accountService.selectBalance(cardid); //查询当前账户余额
			
			float sum = 0;
			
			try {
				sum = Float.parseFloat(money);
			}catch (Exception e) {
				return ResultMessage.error("充值金额格式错误！");
			}
			
			sum = balance + sum;
			int cnt = accountService.updateBalanceByCardID(cardid, String.valueOf(sum));
			if(cnt <= 0) {
				return ResultMessage.error("充值失败！");
			}else {
				return ResultMessage.okNotData("充值成功！");
			}
		}catch (Exception e) {
			e.printStackTrace();
			return ResultMessage.error("系统错误！");
		}
	}
	
	/**
	 * 扣费
	 * @param cardid 用户证件号
	 * @param money 消费金额
	 * @return
	 */
	@RequestMapping("pay")
	@ResponseBody
	public ResultMessage pay(String cardid, String money) {
		try {
			int isExist = accountService.boolIsExist(cardid);
			if(isExist == 0) {
				return ResultMessage.error("用户不存在！");	//查询不到用户，返回
			}
			
			float balance = accountService.selectBalance(cardid); //查询当前账户余额
			
			float sum = 0;
			
			try {
				sum = Float.parseFloat(money);
			}catch (Exception e) {
				return ResultMessage.error("金额格式错误！");
			}
			
			if(balance < sum) { //判断余额是否小于消费金额
				int cnt = accountService.updateBalanceByCardID(cardid, "0");
				if(cnt <= 0) {
					return ResultMessage.error("扣款失败！");
				}else {
					return ResultMessage.okNotData("余额不足，扣费"+balance+"元，仍需缴纳"+(sum-balance)+"元！");
				}	
			}else {
				sum = balance - sum;
				int cnt = accountService.updateBalanceByCardID(cardid, String.valueOf(sum));
				if(cnt <= 0) {
					return ResultMessage.error("扣款失败！");
				}else {
					return ResultMessage.okNotData("扣款成功，账户剩余"+sum+"元！");
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			return ResultMessage.error("系统错误！");
		}
	}
	
}