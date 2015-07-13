package com.ufocorp.ufo.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ufocorp.ufo.model.db.Weather;

/**
 * 持久层dao类
 * @author ayis
 * 2015年7月12日
 */
public interface WeatherMapper {

	public Weather get(@Param("city")String city, @Param("date")String date);
	
	public int add(Weather weather);
	
	public int update(Weather weather);
	
	public int delete(String id);
	
	public List<Weather> getList(Weather weather);
}
