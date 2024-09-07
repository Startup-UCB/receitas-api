package br.com.ucb.startup.receitas_api.infraestrutura.config;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidatorConfig {

    @Bean
    public CPFValidator cpfValidator(){
        var cpfValidator = new CPFValidator();
        cpfValidator.initialize(null);
        return cpfValidator;
    }

    @Bean
    public CNPJValidator cnpjValidator(){
        var cnpjValidator = new CNPJValidator();
        cnpjValidator.initialize(null);
        return cnpjValidator;
    }
}
