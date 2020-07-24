package com.cos.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {

	@GetMapping("/post/saveForm")
	public String saveForm() {
		return "post/saveForm";
	}
}
