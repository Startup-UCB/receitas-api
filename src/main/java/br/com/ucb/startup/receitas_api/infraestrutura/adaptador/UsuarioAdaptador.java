package br.com.ucb.startup.receitas_api.infraestrutura.adaptador;

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

    public Usuario salvaUsuario(Usuario usuario){
        var entidade = usuarioMapper.toUsuarioEntidade(usuario);
        var usuarioSalvo = usuarioPersistencia.persiste(entidade);
        return usuarioMapper.toUsuario(usuarioSalvo);
    }


}
