package br.com.ucb.startup.receitas_api.dominio.exception;

import br.com.ucb.startup.receitas_api.dominio.messages.Messages;

public class UsuarioDiferenteExcepton extends RuntimeException {

    public UsuarioDiferenteExcepton(){
        super(Messages.USUARIO_DIFERENTE);
    }

}
