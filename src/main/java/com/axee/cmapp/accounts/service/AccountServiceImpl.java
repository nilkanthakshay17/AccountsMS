package com.axee.cmapp.accounts.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axee.cmapp.accounts.dtos.AccountDTO;
import com.axee.cmapp.accounts.entities.AccountEntity;
import com.axee.cmapp.accounts.repository.AccountsRepository;

@Service
public class AccountServiceImpl implements AccountsServiceInt {
	
	SimpleDateFormat sdf;
	Date date;
	
	AccountsRepository accountsRepository;

	@Autowired
	public AccountServiceImpl(AccountsRepository accountsRepository) {
		this.accountsRepository=accountsRepository;
	}
	
	@Override
	public AccountDTO createAccount(AccountDTO accountDTO) {
		ModelMapper  modelMapper=new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		date=new Date();
		sdf=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		Long account_no=accountsRepository.getMaxAccountValue();
		
		if(account_no==null) {
			accountDTO.setAccountNumber(1);
		}
		else {
			accountDTO.setAccountNumber(account_no+1);
		}
		
		accountDTO.setAccountStatus("available".toUpperCase());
		
		accountDTO.setCreationDate(sdf.format(date));
		accountDTO.setUpdateDate(sdf.format(date));
		
		AccountEntity entity=modelMapper.map(accountDTO, AccountEntity.class);
		
		AccountEntity savedEntity=accountsRepository.save(entity);
		
		AccountDTO returnValue=modelMapper.map(savedEntity, AccountDTO.class); 
		
		return returnValue;
	}

}
