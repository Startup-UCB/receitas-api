package br.com.ucb.startup.receitas_api.dominio.servico;

import br.com.ucb.startup.receitas_api.dominio.model.AutenticacaoModel;
import br.com.ucb.startup.receitas_api.dominio.model.Token;
import br.com.ucb.startup.receitas_api.dominio.model.Usuario;
import br.com.ucb.startup.receitas_api.infraestrutura.autenticacao.JwtService;
import br.com.ucb.startup.receitas_api.infraestrutura.mapper.UsuarioMapper;
import br.com.ucb.startup.receitas_api.infraestrutura.persistencia.UsuarioPersistencia;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AutenticacaoServico {

    private final UsuarioPersistencia usuarioPersistencia;

    private final AuthenticationManager authenticationManager;

    private final UsuarioMapper usuarioMapper;

    private final JwtService jwtService;

    public Usuario login(AutenticacaoModel model) {
        var login = model.getLogin();
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        login,
                        model.getSenha()
                )
        );
        Optional<Usuario> usuario;

        if (login.contains("@")) {
            usuario = usuarioPersistencia.consultarUsuarioPorEmail(login).map(usuarioMapper::toUsuario);
        } else {
            usuario = usuarioPersistencia.consultarUsuarioPorDocumento(login).map(usuarioMapper::toUsuario);
        }
        return usuario.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }

    public Token generateToken(Usuario usuario) {
        var token = jwtService.generateToken(usuarioMapper.toUsuarioEntidade(usuario));
        var tempoExpiracao = jwtService.getExpirationTime();
        return Token.builder().token(token).tempoExpiracao(tempoExpiracao).build();
    }
}
