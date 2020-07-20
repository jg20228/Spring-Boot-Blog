package com.cos.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.blog.model.User;

@Controller
public class UserController {
	@PostMapping("/auth/joinProc")
	public @ResponseBody User joinProc(@RequestBody User user) {
		//ResponseBody는 응답을 html아니라 data로 하기 위해서
		//RequestBody를 붙여야 JSON data로 받을 수 있다. 안붙이면 x-www-form-urlencoded만 받을 수 있음
		//Spring에서는 web.xml에서 필터링을 해야하는데 스프링 필터를 등록(기본적으로 필터링해야될것)해두면
		//스프링필터에 ip 등등 많은데 MessageConverter가 있다 key=value만 파싱하려고 대기하고 있는데 
		//@RequestBody를 걸면 컨텍트 타입을 확인하고 JSON을 보면 MessageConverter로 change함 (ex : 오브젝트 맵퍼=jackson) 자바오브젝트로 변경해줌
		
		return user;
	}
}
