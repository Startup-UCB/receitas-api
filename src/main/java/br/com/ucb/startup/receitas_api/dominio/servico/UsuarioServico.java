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

    public Usuario criaUsuario(Usuario usuario) {
        validaSobrenome(usuario);
        return usuarioAdaptador.salvaUsuario(usuario);
    }

    public Usuario atualizaUsuario(Usuario usuario) {
        validaSobrenome(usuario);
        var usuarioSalvo = usuarioAdaptador.consultaUsuario(usuario.getId());
        var enderecoId = usuarioSalvo.getEndereco().getId();
        usuario.getEndereco().setId(enderecoId);
        return usuarioAdaptador.salvaUsuario(usuario);
    }

    private void validaSobrenome(Usuario usuario){
        if (usuario.getDocumento().length() == 11 && !StringUtils.hasText(usuario.getSobrenome())) {
            throw new PessoaSemSobrenomeException();
        }
    }

}
