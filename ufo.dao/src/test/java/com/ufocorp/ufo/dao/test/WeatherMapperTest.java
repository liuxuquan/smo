package com.ufocorp.ufo.dao.test;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ufocorp.ufo.dao.WeatherMapper;
import com.ufocorp.ufo.model.db.Weather;
import com.ufufund.ufo.common.utils.SequenceUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-ufo-dao.xml"})
@Slf4j
public class WeatherMapperTest {

	@Autowired
	private WeatherMapper weatherMapper;
	
//	@Test
	public void add(){
		
		Weather weather = new Weather();
		weather.setId(SequenceUtil.getSerial());
		weather.setCity("深圳");
		weather.setDate("20150712");
		weather.setTemperature(30);
		
		int n = weatherMapper.add(weather);
		Assert.assertEquals(1, n);
	}
	
//	@Test
	public void get(){
		
		String city = "上海";
		String date = "20150712";
		Weather weather =weatherMapper.get(city, date);
		
		Assert.assertNotNull(weather);
		log.debug(weather.toString());
	}
	
//	@Test
	public void update(){
		
		Weather weather = new Weather();
		weather.setId("396855A1EE0D0001");
		weather.setTemperature(15);
		
		int n = weatherMapper.update(weather);
		Assert.assertEquals(1, n);
	}
	
//	@Test
	public void delete(){
		
		String id = "397455A1EE1F0001";
		
		int n = weatherMapper.delete(id);
		Assert.assertEquals(1, n);
	}
	
	@Test
	public void getList(){
		
		Weather weather = new Weather();
		weather.setDate("20150712");
		
		List<Weather> list = weatherMapper.getList(weather);
		log.debug(list.toString());
	}
	
}
