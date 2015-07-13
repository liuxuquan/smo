package com.ufocorp.ufo.web.controller;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ufocorp.ufo.biz.manager.WeatherManager;
import com.ufocorp.ufo.model.db.Weather;
import com.ufocorp.ufo.model.vo.WeatherVo;
import com.ufufund.ufo.common.exception.UserException;

@Controller
@Slf4j
public class WeatherController {
	
	private static final String INDEX = "weather/index.htm";
	
	@Autowired
	private WeatherManager weatherManager;

	@RequestMapping(value="weather/index", method=RequestMethod.GET)
	public String index(WeatherVo vo, Model model){
		
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
			model.addAttribute("result", list);
		}catch(UserException ue){
			log.warn(ue.getMessage(), ue);
			model.addAttribute("code", ue.getCode());
			model.addAttribute("message", ue.getMessage());
			model.addAttribute("returnUrl" , INDEX);
			return "error/user_error";
		}
		return "weather/index";
	} 
	
	
}
