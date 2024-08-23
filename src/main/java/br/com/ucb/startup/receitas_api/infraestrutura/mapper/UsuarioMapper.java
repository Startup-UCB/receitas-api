package br.com.ucb.startup.receitas_api.infraestrutura.mapper;

import br.com.ucb.startup.receitas_api.dominio.model.Usuario;
import br.com.ucb.startup.receitas_api.infraestrutura.entidades.UsuarioEntidade;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioEntidade toUsuarioEntidade(Usuario usuario);

    Usuario toUsuario(UsuarioEntidade entidade);
}
