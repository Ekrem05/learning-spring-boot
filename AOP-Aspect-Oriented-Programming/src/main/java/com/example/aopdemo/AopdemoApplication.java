package com.example.aopdemo;

import com.example.aopdemo.dao.AccountDAO;
import com.example.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner cmdRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {

		return x->{
			findAccount(accountDAO);
		};
	}

	private void findAccount(AccountDAO accountDAO) {
		accountDAO.findAccount("Ivan");
	}


}
