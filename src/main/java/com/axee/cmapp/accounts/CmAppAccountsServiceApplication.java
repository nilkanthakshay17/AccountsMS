package com.axee.cmapp.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CmAppAccountsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CmAppAccountsServiceApplication.class, args);
		System.out.println("Accounts Service Started");
	}

}
