package br.com.ucb.startup.receitas_api.aplicacao.controller;

import br.com.ucb.startup.receitas_api.aplicacao.dto.request.LoginRequest;
import br.com.ucb.startup.receitas_api.aplicacao.dto.request.UsuarioRequest;
import br.com.ucb.startup.receitas_api.aplicacao.dto.response.LoginResponse;
import br.com.ucb.startup.receitas_api.aplicacao.dto.response.UsuarioResponse;
import br.com.ucb.startup.receitas_api.aplicacao.mapper.UsuarioDtoMapper;
import br.com.ucb.startup.receitas_api.dominio.servico.AutenticacaoServico;
import br.com.ucb.startup.receitas_api.dominio.servico.UsuarioServico;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/externo")
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final AutenticacaoServico autenticacaoServico;

    private final UsuarioDtoMapper usuarioDtoMapper;

    private final UsuarioServico usuarioServico;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse login(@RequestBody LoginRequest request){

        var usuario = autenticacaoServico.login(usuarioDtoMapper.toModel(request));
        var token = autenticacaoServico.generateToken(usuario);
        return usuarioDtoMapper.toLoginResponse(token);
    }

    @PostMapping("/cadastro")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioResponse criaUsuario(@Valid @RequestBody UsuarioRequest request){
        var usuario = usuarioDtoMapper.toUsuario(request);
        var usuarioCriado = usuarioServico.criaUsuario(usuario);

        return usuarioDtoMapper.toResponse(usuarioCriado);
    }

}
