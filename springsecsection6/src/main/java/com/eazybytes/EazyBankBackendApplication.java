package com.eazybytes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*   Completely optional
@EntityScan("com.eazybytes.model")
@EnableJpaRepositories("com.eazybytes.repository")*/
//@ComponentScan("com.eazybytes.springsecsection1.controller")
public class EazyBankBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EazyBankBackendApplication.class, args);
	}

}
