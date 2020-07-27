package com.cos.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.controller.dto.PostDetailRespDto;
import com.cos.blog.model.Post;
import com.cos.blog.model.User;
import com.cos.blog.repository.PostRepository;

@Service // IoC
public class PostService {
	//서비스의 함수 이름은 가독성 때문에 매우 중요하다.
	@Autowired
	private PostRepository postRepository; // DI
	
	@Transactional
	public void 글쓰기(Post post) {
		postRepository.save(post);
	}
	
	@Transactional(readOnly = true)
	public List<Post> 목록보기() {
		return postRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public PostDetailRespDto 상세보기(int id) {
		return postRepository.findById(id);
	}
	
	@Transactional
	public void 삭제하기(int id) {
		postRepository.deleteById(id);
	}
	
}