package br.com.ucb.startup.receitas_api.infraestrutura.persistencia;

import br.com.ucb.startup.receitas_api.infraestrutura.entidades.UsuarioEntidade;
import br.com.ucb.startup.receitas_api.infraestrutura.repositorio.UsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UsuarioPersistencia {

    private final UsuarioRepositorio usuarioRepositorio;

    @Transactional
    public UsuarioEntidade persiste(UsuarioEntidade usuario){
        usuario.getEndereco().setUsuario(usuario);
        return usuarioRepositorio.save(usuario);
    }

    @Transactional(readOnly = true)
    public Optional<UsuarioEntidade> consultaUsuarioPorId(Long id){
        return usuarioRepositorio.consultaUsuarioPorId(id);
    }

    @Transactional(readOnly = true)
    public Optional<UsuarioEntidade> consultarUsuarioPorEmail(String email){
        return usuarioRepositorio.consultaUsuarioPorEmail(email);
    }

    @Transactional(readOnly = true)
    public Optional<UsuarioEntidade> consultarUsuarioPorDocumento(String documento){
        return usuarioRepositorio.consultaUsuarioPorDocumento(documento);
    }
}
