package br.com.ucb.startup.receitas_api.dominio.servico;

import br.com.ucb.startup.receitas_api.dominio.exception.PessoaSemSobrenomeException;
import br.com.ucb.startup.receitas_api.dominio.exception.UsuarioDiferenteExcepton;
import br.com.ucb.startup.receitas_api.dominio.model.Usuario;
import br.com.ucb.startup.receitas_api.infraestrutura.adaptador.UsuarioAdaptador;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UsuarioServico {

    private final UsuarioAdaptador usuarioAdaptador;
    private final PasswordEncoder passwordEncoder;

    public Usuario criaUsuario(Usuario usuario) {
        validaSobrenome(usuario);
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return usuarioAdaptador.salvaUsuario(usuario);
    }

    public Usuario atualizaUsuario(Usuario usuario, UserDetails usuarioLogado) {
        validaSobrenome(usuario);
        var usuarioSalvo = usuarioAdaptador.consultaUsuario(usuario.getId());

        if(!Objects.equals(usuarioSalvo.getEmail(), usuarioLogado.getUsername())){
            throw new UsuarioDiferenteExcepton();
        }

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
