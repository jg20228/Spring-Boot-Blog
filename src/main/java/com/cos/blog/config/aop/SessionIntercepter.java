package com.cos.blog.config.aop;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cos.blog.model.User;

// 인증 관리
//내가 new 할거라서 메모리에 띄울 필요가없다.
//어댑터로 안해도 강제성이 default로 되어있어서 ???
public class SessionIntercepter extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//인증관리의 인터셉터!
		//return 값이 true면 통과 false면 
		HttpSession session = request.getSession();
		
		User principal = (User) session.getAttribute("principal");
		if(principal == null) {
			//브라우저에게 알려줘야한다.
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('로그인이 필요합니다.');");
			out.print("location.href='/auth/loginForm';");
			out.print("</script>");
			return false; //더이상 진입 안됨 바로 response 됨.
		}
		//잘되어 있으면 true!
		return true;
	}
}
