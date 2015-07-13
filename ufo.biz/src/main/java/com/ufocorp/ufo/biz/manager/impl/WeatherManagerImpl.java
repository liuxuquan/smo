package com.ufocorp.ufo.biz.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufocorp.ufo.biz.manager.WeatherManager;
import com.ufocorp.ufo.biz.manager.impl.helper.WeatherManagerHelper;
import com.ufocorp.ufo.biz.manager.impl.validator.WeatherManagerValidator;
import com.ufocorp.ufo.dao.WeatherMapper;
import com.ufocorp.ufo.model.db.Weather;
import com.ufocorp.ufo.model.vo.WeatherVo;

/**
 * Weather业务层，实现类
 * @author ayis
 * 2015年7月12日
 */
@Service
public class WeatherManagerImpl implements WeatherManager{

	@Autowired
	private WeatherMapper weatherMapper;
	
	@Autowired
	private WeatherManagerValidator validator;
	
	@Autowired
	private WeatherManagerHelper helper;
	
	@Override
	public List<Weather> getWeatherByCity(WeatherVo vo){
		// 验证输入参数
		validator.validateCity(vo);
		// 参数处理
		Weather weather = helper.toWeather(vo);
		// 执行返回结果
		return weatherMapper.getList(weather);
	}
	
	@Override
	public List<Weather> getWeatherByDate(WeatherVo vo){
		// 验证输入参数
		validator.validateDate(vo);
		// 参数处理
		Weather weather = helper.toWeather(vo);
		// 执行返回结果
		return weatherMapper.getList(weather);
	}
}
