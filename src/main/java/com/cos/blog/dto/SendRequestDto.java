package com.cos.blog.dto;

import lombok.Builder;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SendRequestDto {
	private String senderAccountNumber;
	private String receiverAccountNumber;
	private int money;
}
