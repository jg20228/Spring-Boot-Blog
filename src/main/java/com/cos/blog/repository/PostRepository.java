package com.cos.blog.repository;

import com.cos.blog.model.Post;


//mapper 스캔이 안되면 어노테이션을 붙여야함
public interface PostRepository {
	//퍼시스턴스를 만들어줌
	public void save(Post post);
	//내부적으로 구현되어있다.
}
