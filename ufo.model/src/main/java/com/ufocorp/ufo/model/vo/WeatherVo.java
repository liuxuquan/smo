package com.ufocorp.ufo.model.vo;

import lombok.Data;
import lombok.ToString;

import com.ufocorp.ufo.model.db.Weather;

/**
 * 视图对象，在持久化对象基础上，增加属性便于程序操作逻辑
 * @author ayis
 * 2015年7月12日
 */
@Data
@ToString(callSuper=true)
public class WeatherVo extends Weather{

	private String actionType;
	
	
}
