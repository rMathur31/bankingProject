package com.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dto.Acknowledge;
import dto.WithdrawRequest;
import exception.InsufficientAmountException;
import service.WithdrawService;

@SpringBootApplication(scanBasePackages={
"dto", "entity","exception","repository","service","utility"})
@RestController
@EnableTransactionManagement
public class InternetBankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(InternetBankingApplication.class, args);
	}

	@Autowired
	private WithdrawService withdrawService;


	@PostMapping("/withdraw")
	public Acknowledge withdrawAmt(@RequestBody WithdrawRequest request) throws InsufficientAmountException{
		return withdrawService.withdrawAmount(request);
	}
}
