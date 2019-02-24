package com.imnu.service;

import com.imnu.dao.Administratordao;

//service中 用户 是否存在,存在返回ture
public class adLoginService {
	
	public boolean getadInfo(String adUsername,String adPassword) {
		
		Administratordao adUserDao = new Administratordao();
		adUserDao.getAdUserInfo(adUsername, adPassword);
		
		return false;
			
	}

}
