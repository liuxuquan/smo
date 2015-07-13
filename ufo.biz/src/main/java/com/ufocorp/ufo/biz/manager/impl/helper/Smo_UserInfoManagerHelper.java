package com.ufocorp.ufo.biz.manager.impl.helper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.ufocorp.ufo.model.db.Smo_UserInfo;
import com.ufocorp.ufo.model.vo.Smo_UserInfoVo;

@Service
public class Smo_UserInfoManagerHelper {

	public Smo_UserInfo toSmo_UserInfo(Smo_UserInfoVo vo){
		Smo_UserInfo smo_userinfo = new Smo_UserInfo();
		BeanUtils.copyProperties(vo, smo_userinfo);
		return smo_userinfo;
	}
}
