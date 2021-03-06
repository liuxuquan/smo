package com.ufufund.ufo.common.utils;

import java.util.UUID;

public class ThreadLocalUtil {

	private static ThreadLocal<String> proccessId = new ThreadLocal<String>();
	
	/**
	 * 获取线程范围的随机串
	 * @return
	 */
	public static String getProccessId(){
		if(proccessId.get() == null){
			proccessId.set("["+EncryptUtil.md5(UUID.randomUUID().toString())+"] ");
		}
		return proccessId.get();
	}
}
