package br.com.ucb.startup.receitas_api.aplicacao.controller;

import br.com.ucb.startup.receitas_api.aplicacao.dto.request.UsuarioRequest;
import br.com.ucb.startup.receitas_api.aplicacao.mapper.UsuarioDtoMapper;
import br.com.ucb.startup.receitas_api.dominio.exception.UsuarioDiferenteExcepton;
import br.com.ucb.startup.receitas_api.dominio.servico.UsuarioServico;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;


@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioServico usuarioServico;
    private final UsuarioDtoMapper usuarioMapper;


    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizaUsuario(@Valid @RequestBody UsuarioRequest request, @PathVariable("id") Long id, Authentication auth){
        var principal = (UserDetails) auth.getPrincipal();

        var usuario = usuarioMapper.toUsuario(request, id);
        usuarioServico.atualizaUsuario(usuario, principal);

        if (!Objects.equals(principal.getUsername(), usuario.getEmail())){
            throw new UsuarioDiferenteExcepton();
        }


    }

}
