package com.ufocorp.ufo.web.util;

import org.apache.commons.lang.StringUtils;

import com.ufocorp.ufo.web.filter.ServletHolder;
import com.ufufund.ufo.common.exception.UserException;

/**
 * 图形验证码工具类
 * 
 * @author ayis 2015-03-14
 */
public class VerifyCodeUtils {

	/**
	 * 图形验证码校验
	 * @param veriCode
	 * @return 校验失败，直接提示业务类异常；否则，成功
	 */
	public static boolean validate(String veriCode) {
		String value = (String) ServletHolder.getSession().getAttribute("VERIFYCODE");
		if (StringUtils.isBlank(veriCode)) {
			throw new UserException("您输入的验证码为空！");
		} else if (StringUtils.isBlank(value)) {
			throw new UserException("您输入的验证码已失效！");
		} else if (!veriCode.equalsIgnoreCase(value)) {
			throw new UserException("您输入的验证码不匹配！");
		}
		ServletHolder.getSession().removeAttribute("VERIFYCODE");
		return true;
	}
}
