package com.ufocorp.ufo.biz.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufocorp.ufo.biz.manager.Smo_UserInfoManager;
import com.ufocorp.ufo.biz.manager.impl.helper.Smo_UserInfoManagerHelper;
import com.ufocorp.ufo.biz.manager.impl.validator.Smo_UserInfoManagerValidator;
import com.ufocorp.ufo.dao.Smo_UserInfoMapper;
import com.ufocorp.ufo.model.db.Smo_UserInfo;
import com.ufocorp.ufo.model.vo.Smo_UserInfoVo;

/**
 * Weather业务层，实现类
 * @author ayis
 * 2015年7月12日
 */
@Service
public class Smo_UserInfoManagerImpl implements Smo_UserInfoManager{

	@Autowired
	private Smo_UserInfoMapper smo_userinfoMapper;
	
	@Autowired
	private Smo_UserInfoManagerValidator validator;
	
	@Autowired
	private Smo_UserInfoManagerHelper helper;
	
	@Override
	public List<Smo_UserInfo> getUserInfoByPhone(Smo_UserInfoVo vo){
		// 验证输入参数
		validator.validatePhone(vo);
		// 参数处理
		Smo_UserInfo smo_userinfo = helper.toSmo_UserInfo(vo);
		// 执行返回结果
		return smo_userinfoMapper.getList(smo_userinfo);
	}
	
	@Override
	public List<Smo_UserInfo> getUserInfoById(Smo_UserInfoVo vo){
		// 验证输入参数
		validator.validateDate(vo);
		// 参数处理
		Smo_UserInfo smo_userinfo = helper.toSmo_UserInfo(vo);
		// 执行返回结果
		return smo_userinfoMapper.getList(smo_userinfo);
	}
}
