package br.com.ucb.startup.receitas_api.dominio.exception;

import br.com.ucb.startup.receitas_api.dominio.messages.Messages;

public class UsuarioNaoEncontradoException extends RuntimeException {

    public UsuarioNaoEncontradoException(Long id){
        super(String.format(Messages.USUARIO_NAO_ENCONTRADO, id));
    }
}
