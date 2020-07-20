package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

//싱글톤 패턴으로 IoC하는 것, Controller는 특이하게 요청시마다 메모리(디스패쳐서블릿이 해준다)에 뜸
//Controller, Repository, Configuration, Service, Component
//RestController, Bean

//Controller는 ViewResolver가 관리해서 html만 return 하려고함
//RestController는 4.0부터 나온것인데 특징은 데이터를 리턴함

//Repository mapper가 대신 띄워주어서 생략가능함

//Configuration 설정파일

//Service 붙이면 IoC가 되니까 메모리에 뜨는데 누군가가 Service 호출하는순간 트랜잭션 시작

//Bean 클래스에 못걸고 메소드에만 건다.

@Service // IoC
public class UserService {

	@Autowired
	private UserRepository userRepository; // DI
	
	@Transactional
	public void 회원가입(User user) {
		userRepository.save(user);
	}

}
