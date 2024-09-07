package br.com.ucb.startup.receitas_api.infraestrutura.adaptador;

import br.com.ucb.startup.receitas_api.dominio.exception.UsuarioNaoEncontradoException;
import br.com.ucb.startup.receitas_api.dominio.model.Usuario;
import br.com.ucb.startup.receitas_api.infraestrutura.mapper.UsuarioMapper;
import br.com.ucb.startup.receitas_api.infraestrutura.persistencia.UsuarioPersistencia;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsuarioAdaptador {

    private final UsuarioPersistencia usuarioPersistencia;
    private final UsuarioMapper usuarioMapper;

    public Usuario salvaUsuario(Usuario usuario) {
        var entidade = usuarioMapper.toUsuarioEntidade(usuario);
        var usuarioSalvo = usuarioPersistencia.persiste(entidade);
        return usuarioMapper.toUsuario(usuarioSalvo);
    }

    public Usuario consultaUsuario(Long id) {
        var entidade = usuarioPersistencia.consultaUsuarioPorId(id);
        return entidade.map(usuarioMapper::toUsuario).orElseThrow(() -> new UsuarioNaoEncontradoException(id));
    }
}