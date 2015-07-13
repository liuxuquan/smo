package com.ufocorp.ufo.model.db;

import lombok.Data;

/**
 * 持久化对象，与数据库表对应
 * @author ayis
 * 2015年7月12日
 */
@Data
public class Smo_UserInfo{
	
	private int smo_user_id;
	private String smo_user_name;
	private String smo_user_phone;
	private String smo_user_identify;
	private String smo_user_imageurl;
	
	private int smo_user_age;
	private boolean smo_user_sex;
	private boolean smo_user_valid;
	private String smo_user_email;
	private String smo_user_pwd;
	
	private String smo_user_regiesttime;
	private int smo_user_logintype;
}
