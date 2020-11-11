package com.axee.cmapp.accounts.ui.controller;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axee.cmapp.accounts.dtos.AccountDTO;
import com.axee.cmapp.accounts.exception.CMAccountsException;
import com.axee.cmapp.accounts.service.AccountsServiceInt;
import com.axee.cmapp.accounts.ui.model.AccountRequestModel;
import com.axee.cmapp.accounts.ui.model.AccountResponseModel;
import com.axee.cmapp.accounts.utils.AccountsContants;

@RestController
@RequestMapping("/accounts")
public class AccountsController {

	AccountsServiceInt accountsServiceInt;
	
	@Autowired
	public AccountsController(AccountsServiceInt accountsServiceInt) {
		this.accountsServiceInt=accountsServiceInt;
	}
	
	@GetMapping("/status/check")
	public String checkStatus() {
		return "Working...";
	}
	
	@PostMapping
	public ResponseEntity<AccountResponseModel> createAccount(@RequestBody AccountRequestModel inputAccount){
		ModelMapper  modelMapper=new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		
		System.out.println(inputAccount.getAccountType());
		System.out.println(inputAccount.getAccountType().toString().equals(AccountsContants.PRE_STATUS));
		
		if(! inputAccount.getAccountType().toUpperCase().equals(AccountsContants.PRE_STATUS) && ! inputAccount.getAccountType().toUpperCase().equals(AccountsContants.POST_STATUS)) 
			throw new CMAccountsException("Account Type can not be other than POST or PRE");

			
		inputAccount.setAccountType(inputAccount.getAccountType().toUpperCase());
		
		AccountDTO accountDTO=modelMapper.map(inputAccount, AccountDTO.class);
		
		AccountDTO receivedDto=accountsServiceInt.createAccount(accountDTO);
		
		AccountResponseModel returnValue=modelMapper.map(receivedDto, AccountResponseModel.class);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
	}
}
