package com.ufocorp.ufo.web.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ufocorp.ufo.web.filter.ServletHolder;
import com.ufufund.ufo.common.exception.UserException;
import com.ufufund.ufo.common.utils.ThreadLocalUtil;

/**
 * 短信动态码工具类
 * 
 * @author ayis 2015-03-14
 */
public class MsgCodeUtils {
	private static final Logger LOG = LoggerFactory
			.getLogger(MsgCodeUtils.class);

	// 时间段内最大发送次数
	private static final int MAX_COUNT = 5;
	// 次数控制时间段，单位：分钟
	private static final int MINUTES = 10;
	// 每两次发送时间间隔，单位：秒
	private static final int SECONDS = 60;
	// 用户短信动态码有效时间，单位：分钟
	private static final int ACTIVE_TIME = 5;

	/**
	 * 发送短信动态码<br/>
	 * 控制规则： 1.每两次发送时间间隔控制：<code>SECONDS</code> 2.时间段内发送次数控制：在
	 * <code>MINUTES</code>内，最多<code>MAX_COUNT</code>次
	 * 
	 * @param template
	 *            短信模版
	 */
	
	public static void sendMsg(String template, String mobileNo) {

		long now = System.currentTimeMillis();

		MsgCode msgCode = (MsgCode) ServletHolder.getSession()
				.getAttribute("MSGCODE");
		if (msgCode != null) {
			// session中已存在
			List<Long> timeList = msgCode.getTimeList();
			/** 判断与上次发送的时间间隔 **/
			long last = timeList.get(timeList.size() - 1).longValue();
			
			if (now - last <= SECONDS * 1000) {
				long t = SECONDS - ((now-last)/1000);
				throw new UserException(SECONDS + "秒之内只能发送一次，请稍后[" + t + "秒]再试！");
			}
			/** 判断时间段内，发送次数 **/
			for (int i = 0; i < timeList.size();) {
				if (now - timeList.get(i).longValue() > MINUTES * 60 * 1000) {
					timeList.remove(i);
				} else {
					i++;
				}
			}
			if (timeList.size() >= MAX_COUNT) {
				throw new UserException(MINUTES + "分钟之内只能发送" + MAX_COUNT + "次，请稍后再试！");
			}
		} else {
			// session中不存在
			msgCode = new MsgCode();
		}

		// 设置或者重新设置短信码
		int n = new Random().nextInt(1000000);
		if (n < 100000) {
			n += 100000;
		}
		
		msgCode.setMobileNo(mobileNo);
		msgCode.setMsgCode(String.valueOf(n));
		msgCode.getTimeList().add(now);
		ServletHolder.getSession().setAttribute("MSGCODE", msgCode);

		LOG.debug("MsgCode=" + msgCode.getMsgCode() + ", timeList="
				+ msgCode.getTimeList());

		// 调用短信接口，发送短信
		// code after the message interface was provided.

	}

	/**
	 * 检验短信验证码：严格一次检验有效
	 * @param compare
	 * @param mobileNo
	 * @exception 校验失败，直接提示业务类异常
	 */
	public static void validate(String compare, String mobileNo) {
		validate(compare, mobileNo, true);
	}
	
	/**
	 * 检验短信验证码
	 * @param compare 比较码
	 * @param mobileNo 手机号
	 * @param strictly 是否严格一次检验有效
	 * @exception 校验失败，直接提示业务类异常
	 */
	public static void validate(String compare, String mobileNo, boolean strictly){
		
		MsgCode msgCode = (MsgCode) ServletHolder.getSession().getAttribute("MSGCODE");
		if (null == compare || StringUtils.isBlank(compare)) {
			throw new UserException("您输入的手机验证码为空！");
		} else if (null == msgCode || StringUtils.isBlank(msgCode.getMsgCode())) {
			throw new UserException("您的手机验证码已失效，请重新发送！");
		} else if (!msgCode.getMsgCode().equals(compare) || !msgCode.getMobileNo().equals(mobileNo) ) {
			throw new UserException("您输入的手机验证码不匹配，请重新发送！");
		} else {
			long now = System.currentTimeMillis();
			if (now
					- msgCode.getTimeList().get(
							msgCode.getTimeList().size() - 1) > ACTIVE_TIME * 60 * 1000) {
				throw new UserException("您的手机验证码已失效，请重新发送！");
			}
		}
		if(strictly){
			ServletHolder.getSession().removeAttribute("MSGCODE");
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public static String getMsgCode(){
		MsgCode msgCode = (MsgCode) ServletHolder.getSession().getAttribute("MSGCODE");
		return msgCode.getMsgCode();
	}
	

	private static class MsgCode {
		private String mobileNo;
		// 短信码
		private String msgCode;
		// 发送时间列表
		private List<Long> timeList = new ArrayList<Long>();
		
		public String getMobileNo() {
			return mobileNo;
		}

		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}

		public String getMsgCode() {
			return msgCode;
		}

		public void setMsgCode(String msgCode) {
			this.msgCode = msgCode;
		}

		public List<Long> getTimeList() {
			return timeList;
		}
	}
}
