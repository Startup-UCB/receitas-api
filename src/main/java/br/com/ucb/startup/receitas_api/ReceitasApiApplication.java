package br.com.ucb.startup.receitas_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class})
public class ReceitasApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReceitasApiApplication.class, args);
	}

}
