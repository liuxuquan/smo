package com.ufocorp.ufo.biz.manager.impl.validator;


import org.springframework.stereotype.Service;

import com.ufocorp.ufo.model.vo.Smo_UserInfoVo;
import com.ufufund.ufo.common.exception.UserException;
import com.ufufund.ufo.common.utils.StringUtils;

@Service
public class Smo_UserInfoManagerValidator {

	/**
	 * 城市查询参数校验
	 * @param vo
	 */
	public void validatePhone(Smo_UserInfoVo vo){
		
		if(vo == null || StringUtils.isBlank(vo.getSmo_user_phone())){
			throw new UserException("9901", "电话为空！");
		}
	}
	
	/**
	 * 日期查询参数校验
	 * @param vo
	 */
	public void validateDate(Smo_UserInfoVo vo){
		
		if(vo == null || StringUtils.isBlank(vo.getSmo_user_phone())){
			throw new UserException("9902", "电话为空！");
		}
	}
}
