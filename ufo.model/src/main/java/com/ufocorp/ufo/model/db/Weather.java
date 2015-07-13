package com.ufocorp.ufo.model.db;

import lombok.Data;

/**
 * 持久化对象，与数据库表对应
 * @author ayis
 * 2015年7月12日
 */
@Data
public class Weather {
	
	private String id;
	private String city;
	private String date;
	private int temperature;
	private String updatetime;
}
