package com.ufocorp.ufo.biz.manager;

import java.util.List;

import com.ufocorp.ufo.model.db.Weather;
import com.ufocorp.ufo.model.vo.WeatherVo;

/**
 * Weather业务层，接口定义类
 * @author ayis
 * 2015年7月12日
 */
public interface WeatherManager {

	/**
	 * 获取某个城市的天气列表
	 * @param vo
	 * @return
	 */
	List<Weather> getWeatherByCity(WeatherVo vo);
	
	/**
	 * 获取某天的天气列表
	 * @param vo
	 * @return
	 */
	List<Weather> getWeatherByDate(WeatherVo vo);
}
