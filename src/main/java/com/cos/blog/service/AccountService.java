package com.cos.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.dto.SendRequestDto;
import com.cos.blog.dto.WithDrawRequestDto;
import com.cos.blog.model.Account;
import com.cos.blog.repository.AccountRepository;

@Service
public class AccountService {
	
	//DI
	@Autowired
	private AccountRepository accountRepository;

	@Transactional
	public void 송금(SendRequestDto dto) {
		//sender는 Persistence이다.
		Account sender = accountRepository.findByAccountNumber(dto.getSenderAccountNumber());
		sender.setMoney(sender.getMoney() - dto.getMoney());
		accountRepository.update(sender);
		
		Account receiver = accountRepository.findByAccountNumber(dto.getReceiverAccountNumber());
		receiver.setMoney(receiver.getMoney()+dto.getMoney());
		accountRepository.update(receiver);
	}
	
	@Transactional
	public void 인출(WithDrawRequestDto dto) {
		Account user = accountRepository.findByAccountNumber(dto.getAccountNumber());
		user.setMoney(user.getMoney()-dto.getMoney());
		accountRepository.update(user);
	}
	
	@Transactional
	public List<Account> 계좌정보보기(){
		return accountRepository.findAll();
	}
}
