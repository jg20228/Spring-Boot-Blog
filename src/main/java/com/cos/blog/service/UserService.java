package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Transactional
	public int 회원가입(User user) {
		String rawPassword = user.getPassword();
		String password = bCryptPasswordEncoder.encode(rawPassword);
		user.setPassword(password);
		
		
		//원래는 Exception Handler를 사용해야한다.
		//try catch를 잡아두면 fail이 아니라 done으로 간다.
		//try catch 안하고 fail 발생시켜도 상관은 없지만 지금은 done으로 가는 방식을 사용.
		//이것을 간단하게 처리할수있는 어노테이션이 있다.->>???
		user.setRole("ROLE_USER");
		try {
			userRepository.save(user);
			return 1;
		} catch (Exception e) {
			e.getMessage();
			return -1;
		}
	}
	//readOnly = true가 필요한 이유
	@Transactional(readOnly = true)
	public User 로그인(User user) {
		String encPassword = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(encPassword);
		User persistUser = userRepository.login(user);
		System.out.println(persistUser);
		System.out.println("1 : "+encPassword);
		System.out.println("2 : "+persistUser.getPassword());
		if(encPassword == persistUser.getPassword()) {
			return persistUser;
		}
		return null;
	}
}
