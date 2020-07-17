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

	// DI
	@Autowired
	private AccountRepository accountRepository;


	//스프링이 들고 있는 트랜잭션
	//밑에 둘중에 하나가 실패하면 rollback, 둘다 성공하면 commit
	//다음에 만들때는 콤포지션으로 dto로 만들어서 하나로만 주고 받는게 맞다.
	@Transactional
	public void 송금(SendRequestDto dto) {
		//송금하는 사람의 계좌번호
		//송금받는 사람의 계좌번호
		//얼마를 보낼걸지를 정해야한다.
		
		// 홍길동 업데이트 +
		Account 홍길동 = accountRepository.findByAccountNumber(dto.getSenderAccountNumber());
		홍길동.setMoney(홍길동.getMoney() - dto.getMoney());
		accountRepository.update(홍길동);
		// 장보고 업데이트 - 
		Account 장보고 = accountRepository.findByAccountNumber(dto.getReceiverAccountNumber());
		장보고.setMoney(장보고.getMoney()+ dto.getMoney());
		accountRepository.update(장보고);
	}

	@Transactional
	public void 인출(WithDrawRequestDto dto) {
		//인출하는 사람의 계좌번호
		//얼마를 인출할지
		
		Account 홍길동 = accountRepository.findByAccountNumber(dto.getAccountNumber());
		홍길동.setMoney(홍길동.getMoney()-dto.getMoney());
		accountRepository.update(홍길동);
	}
	
	//트랜잭션을 타게하는 이유 : isolation 고립성 때문이다.
	@Transactional(readOnly = true) 
	public List<Account> 계좌정보보기() {
		return accountRepository.findAll();
	}
}
