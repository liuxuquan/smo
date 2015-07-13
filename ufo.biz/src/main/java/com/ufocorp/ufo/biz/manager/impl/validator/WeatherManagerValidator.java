package com.ufocorp.ufo.biz.manager.impl.validator;


import org.springframework.stereotype.Service;

import com.ufocorp.ufo.model.vo.WeatherVo;
import com.ufufund.ufo.common.exception.UserException;
import com.ufufund.ufo.common.utils.StringUtils;

@Service
public class WeatherManagerValidator {

	/**
	 * 城市查询参数校验
	 * @param vo
	 */
	public void validateCity(WeatherVo vo){
		
		if(vo == null || StringUtils.isBlank(vo.getCity())){
			throw new UserException("9901", "城市参数为空！");
		}
	}
	
	/**
	 * 日期查询参数校验
	 * @param vo
	 */
	public void validateDate(WeatherVo vo){
		
		if(vo == null || StringUtils.isBlank(vo.getDate())){
			throw new UserException("9902", "日期参数为空！");
		}
	}
}
