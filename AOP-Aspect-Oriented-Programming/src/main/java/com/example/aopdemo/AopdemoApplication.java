package com.example.aopdemo;

import com.example.aopdemo.dao.AccountDAO;
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
	public CommandLineRunner cmdRunner(AccountDAO accountDAO) {

		return x->{
			addAccount(accountDAO);
		};
	}

	private void addAccount(AccountDAO accountDAO) {
		accountDAO.addAccount();
	}

}
