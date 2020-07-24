package com.cos.blog.config.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cos.blog.model.User;

// 인증 관리
public class RoleIntercepter extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		
		User principal = (User) session.getAttribute("principal");
		if(principal == null) {
			//들어 왔을때 return이 아니라 Exception을 던지면 자바자체에서 낚아챔
			//그러면 이 밑으로 진행해야할지 말아야할지 정해야하는데
			
			//JVM이 낚아채는게 아니라 내가 낚아 챌것이다.
			System.out.println("RoleIntercepter : 인증이 안됨");
			
			throw new Exception();
		}else {
			if(!principal.getRole().equals("ROLE_ADMIN")) {
				System.out.println("RoleIntercepter : 권한이 없음");

				throw new Exception();
			}
		}
		
		System.out.println("인증과 권한을 체크해야함");
		return true;
	}
}
