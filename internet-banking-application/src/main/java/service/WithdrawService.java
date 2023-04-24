package service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dto.Acknowledge;
import dto.WithdrawRequest;
import entity.Account;
import entity.Customer;
import entity.PaymentInfo;
import exception.InsufficientAmountException;
import repository.AccountRepository;
import repository.CustomerRepository;
import utility.PaymentUtils;

@Service
public class WithdrawService {

	

	private CustomerRepository customerRepository;

	private AccountRepository accountRepository;
	
	@Transactional
	public Acknowledge withdrawAmount(WithdrawRequest request) throws InsufficientAmountException {
		
		Acknowledge acknowledge = new Acknowledge();
		
		System.out.println(request.toString());
	    
	    Account account = request.getAccount();
	    account = accountRepository.save(account);
	    
		Customer customer = request.getCustomer();
	    customer = customerRepository.save(customer);

	    
	    acknowledge.setStatus("Success..");
	    
		return acknowledge;

	} 
	
}
