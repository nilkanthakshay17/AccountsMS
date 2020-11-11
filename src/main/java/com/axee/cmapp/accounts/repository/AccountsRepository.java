package com.axee.cmapp.accounts.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.axee.cmapp.accounts.entities.AccountEntity;

public interface AccountsRepository extends CrudRepository<AccountEntity,Integer>{

	@Query(value="select max(a.account_no) from accounts a",nativeQuery = true)
	Long getMaxAccountValue();
}
