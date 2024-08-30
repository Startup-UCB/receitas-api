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
        var usuario = usuarioMapper.toUsuario(request);
        var usuarioCriado = usuarioServico.criaUsuario(usuario);
        return usuarioMapper.toResponse(usuarioCriado);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizaUsuario(@Valid @RequestBody UsuarioRequest request, @PathVariable("id") Long id){
        var usuario = usuarioMapper.toUsuario(request, id);
        usuarioServico.atualizaUsuario(usuario);
    }

}
