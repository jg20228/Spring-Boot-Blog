package com.cos.blog.config.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// 인증 관리
//내가 new 할거라서 메모리에 띄울 필요가없다.
//어댑터로 안해도 강제성이 default로 되어있어서 ???
public class SessionIntercepter extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//인증관리의 인터셉터!
		
		return true;
	}
}
