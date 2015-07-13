package com.ufocorp.ufo.web.controller.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ufocorp.ufo.biz.manager.WeatherManager;
import com.ufocorp.ufo.model.db.Weather;
import com.ufocorp.ufo.model.vo.WeatherVo;
import com.ufufund.ufo.common.exception.UserException;

@Controller
@Slf4j
public class AjaxWeatherController {
	
	@Autowired
	private WeatherManager weatherManager;

	@RequestMapping(value="weather/get", method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> index(WeatherVo vo){
		
		log.debug(vo.toString());
		
		Map<String,Object> result = new HashMap<String,Object>();
		try{
			List<Weather> list = null;
			if("1".equals(vo.getActionType())){
				// 根据城市查询天气列表
				list = weatherManager.getWeatherByCity(vo);
			}else if("2".equals(vo.getActionType())){
				// 根据日期查询天气列表
				list = weatherManager.getWeatherByDate(vo);
			}else{
				throw new UserException("请求类型错误！");
			}
			result.put("result", list);
			result.put("code", "0000");
			result.put("message", "交易成功");
		}catch(UserException ue){
			log.warn(ue.getMessage(), ue);
			result.put("result", null);
			result.put("code", ue.getCode());
			result.put("message", ue.getMessage());
		}catch(Exception e){
			log.error(e.getMessage(), e);
			result.put("result", null);
			result.put("code", "9999");
			result.put("message", "系统执行异常！");
		}
		log.info(result.toString());
		return result;
	} 
	
	
}
