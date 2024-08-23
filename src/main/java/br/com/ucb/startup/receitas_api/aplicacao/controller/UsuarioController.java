package br.com.ucb.startup.receitas_api.aplicacao.controller;

import br.com.ucb.startup.receitas_api.aplicacao.dto.request.UsuarioRequest;
import br.com.ucb.startup.receitas_api.aplicacao.dto.response.UsuarioResponse;
import br.com.ucb.startup.receitas_api.aplicacao.mapper.UsuarioDtoMapper;
import br.com.ucb.startup.receitas_api.dominio.servico.UsuarioServico;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioServico usuarioServico;
    private final UsuarioDtoMapper usuarioMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioResponse criaUsuario(@Valid @RequestBody UsuarioRequest request){
        var usuario = usuarioMapper.toUSuario(request);
        var usuarioCriado = usuarioServico.criaUsuario(usuario);
        return usuarioMapper.toResponse(usuarioCriado);
    }

}
