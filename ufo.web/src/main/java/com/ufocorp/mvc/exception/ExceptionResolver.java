package com.ufocorp.mvc.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class ExceptionResolver extends SimpleMappingExceptionResolver {
	private static Logger log = LoggerFactory.getLogger(ExceptionResolver.class);
	
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response,
			Object handler, Exception ex) {
		log.error("spring mvc error:", ex);
		return super.doResolveException(request, response, handler, ex);
	}
}
