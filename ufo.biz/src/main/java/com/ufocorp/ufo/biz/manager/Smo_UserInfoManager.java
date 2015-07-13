package com.ufocorp.ufo.biz.manager;

import java.util.List;

import com.ufocorp.ufo.model.db.Smo_UserInfo;
import com.ufocorp.ufo.model.vo.Smo_UserInfoVo;

/**
 * Weather业务层，接口定义类
 * @author ayis
 * 2015年7月12日
 */
public interface Smo_UserInfoManager {

	/**
	 * 获取某个城市的天气列表
	 * @param vo
	 * @return
	 */
	List<Smo_UserInfo> getUserInfoByPhone(Smo_UserInfoVo vo);
	
	/**
	 * 获取某天的天气列表
	 * @param vo
	 * @return
	 */
	List<Smo_UserInfo> getUserInfoById(Smo_UserInfoVo vo);
}
