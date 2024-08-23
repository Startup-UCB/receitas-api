package br.com.ucb.startup.receitas_api.dominio.servico;

import br.com.ucb.startup.receitas_api.dominio.exception.PessoaSemSobrenomeException;
import br.com.ucb.startup.receitas_api.dominio.model.Usuario;
import br.com.ucb.startup.receitas_api.infraestrutura.adaptador.UsuarioAdaptador;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class UsuarioServico {

    private final UsuarioAdaptador usuarioAdaptador;

    public Usuario criaUsuario(Usuario usuario){
        if (usuario.getDocumento().length() == 11 && !StringUtils.hasText(usuario.getDocumento())){
            throw new PessoaSemSobrenomeException();
        }
        return usuarioAdaptador.salvaUsuario(usuario);
    }

}
