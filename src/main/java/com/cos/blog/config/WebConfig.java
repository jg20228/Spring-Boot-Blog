package com.cos.blog.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cos.blog.config.aop.RoleIntercepter;
import com.cos.blog.config.aop.SessionIntercepter;

// 필터링
@Configuration //스프링컨텍스트에 IoC 되는것
public class WebConfig implements WebMvcConfigurer{//WebMvnConfigurer는 버전 업데이트되면 이름이 바뀔수도있다.
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		
		//aop에 있는 인터셉터 등록 끝
		registry.addInterceptor(new SessionIntercepter())
		.addPathPatterns("/user/**")
		.addPathPatterns("/post/**")
		.addPathPatterns("/post**");
		
		registry.addInterceptor(new RoleIntercepter())
		.addPathPatterns("/admin/**");
		
		
		
	}
}
