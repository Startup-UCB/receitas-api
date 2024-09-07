package br.com.ucb.startup.receitas_api.aplicacao.mapper;

import br.com.ucb.startup.receitas_api.aplicacao.dto.request.LoginRequest;
import br.com.ucb.startup.receitas_api.aplicacao.dto.request.UsuarioRequest;
import br.com.ucb.startup.receitas_api.aplicacao.dto.response.LoginResponse;
import br.com.ucb.startup.receitas_api.aplicacao.dto.response.UsuarioResponse;
import br.com.ucb.startup.receitas_api.dominio.model.AutenticacaoModel;
import br.com.ucb.startup.receitas_api.dominio.model.Token;
import br.com.ucb.startup.receitas_api.dominio.model.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioDtoMapper {

    Usuario toUsuario(UsuarioRequest request);

    Usuario toUsuario(UsuarioRequest request, Long id);

    UsuarioResponse toResponse(Usuario usuario);

    AutenticacaoModel toModel(LoginRequest request);

    LoginResponse toLoginResponse(Token token);

}
