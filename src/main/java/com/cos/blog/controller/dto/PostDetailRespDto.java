package com.cos.blog.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//콤포지션 하지 말기!!
//사용할때 편하기위해서 필드명들을 다 적음, 콤포지션하면 ... 계속 들어가서
//하지만 간혹 써야할때도 있다.

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDetailRespDto {
	private int id; 
	private String title;
	private String content;
	private String username;
}
