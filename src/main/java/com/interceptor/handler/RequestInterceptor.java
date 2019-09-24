package com.interceptor.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.interceptor.constants.InterceptorConstants;

import net.logstash.logback.encoder.org.apache.commons.lang.StringUtils;

@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {

	private static final Logger LOGGER = LoggerFactory.getLogger(RequestInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		boolean redirect = true;
		try {
			LOGGER.info("Inside preHandler method");
			if (StringUtils.isNotEmpty(request.getServletPath()) && InterceptorConstants.API_KEY_PATH.containsKey(request.getServletPath())) {
				
			}
		} catch (Exception e) {
			LOGGER.error("Exception while {} ", e);
		}

		return redirect;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// post handler logic
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// after completion handler logic
	}
}
