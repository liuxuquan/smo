package com.ufocorp.ufo.biz.manager.impl.helper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.ufocorp.ufo.model.db.Weather;
import com.ufocorp.ufo.model.vo.WeatherVo;

@Service
public class WeatherManagerHelper {

	public Weather toWeather(WeatherVo vo){
		Weather weather = new Weather();
		BeanUtils.copyProperties(vo, weather);
		return weather;
	}
}
