package com.cos.blog.dto;

import lombok.Builder;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WithDrawRequestDto {
	private String accountNumber;
	private int money;
}
