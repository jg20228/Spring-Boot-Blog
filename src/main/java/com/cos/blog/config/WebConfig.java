package com.cos.blog.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 필터링
@Configuration //스프링컨텍스트에 IoC 되는것
public class WebConfig implements WebMvcConfigurer{
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new HandlerInterceptor() {
			//HandlerInterceptor는 인터페이스이다.
			//default라고 인터페이스인데 내부가 구현되어있음
			
			@Override
			public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
					throws Exception {
				//함수 진입 직전을 컨트롤 할 수 있다.
				return true;
			}
			//이렇게 만들면 하나의 역할밖에 못한다.
			//user,admin 쪽으로 들어오는 모든것은 인증이 필요함
		}).addPathPatterns("/user/**").addPathPatterns("/admin/**");
	}
}
