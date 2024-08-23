package br.com.ucb.startup.receitas_api.dominio.exception;

public class PessoaSemSobrenomeException extends RuntimeException{

    public PessoaSemSobrenomeException(){
        super("Uma pessoa física deve possuir sobrenome");
    }

}
