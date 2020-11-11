package com.axee.cmapp.accounts.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="accounts")
public class AccountEntity {
	
	@Id
	@GeneratedValue
	public int id;
	
	@Column(name="account_no",nullable=false,unique=true, length=100)
	private long accountNumber;
	
	@Column(name="account_type",nullable=false, length=100)
	private String accountType;
	
	@Column(name="status",nullable=false, length=100)
	private String accountStatus;
	
	@Column(name="subscription",nullable=true, length=100)
	private String subscription;
	
	@Column(name="msisdn",nullable=true, length=100)
	private String msisdn;
	
	@Column(name="creation_date",nullable=false, length=100)
	private String creationDate;
	
	@Column(name="update_date",nullable=false, length=100)
	private String updateDate;
	
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	public String getSubscription() {
		return subscription;
	}
	public void setSubscription(String subscription) {
		this.subscription = subscription;
	}
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

}
