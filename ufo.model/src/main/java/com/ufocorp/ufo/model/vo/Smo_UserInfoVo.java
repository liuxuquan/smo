package com.ufocorp.ufo.model.vo;

import lombok.Data;
import lombok.ToString;

import com.ufocorp.ufo.model.db.Smo_UserInfo;

/**
 * 视图对象，在持久化对象基础上，增加属性便于程序操作逻辑
 * @author ayis
 * 2015年7月12日
 */
@Data
@ToString(callSuper=true)
public class Smo_UserInfoVo extends Smo_UserInfo{

	private String actionType;
	
	
}
