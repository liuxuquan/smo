package com.ufocorp.ufo.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ufocorp.ufo.model.db.Smo_UserInfo;

/**
 * 持久层dao类
 * @author ayis
 * 2015年7月12日
 */
public interface Smo_UserInfoMapper {

	public Smo_UserInfo get(@Param("smo_user_phone")String smo_user_phone);
	
	public int add(Smo_UserInfo userinfo);
	
	public int update(Smo_UserInfo userinfo);
	
	public int delete(String userinfo_phone);
	
	public List<Smo_UserInfo> getList(Smo_UserInfo userinfo);
}
