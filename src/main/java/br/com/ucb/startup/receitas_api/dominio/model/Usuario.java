package br.com.ucb.startup.receitas_api.dominio.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Usuario {
    private Long id;
    private String nome;
    private String sobrenome;
    private String documento;
    private String email;
    private String senha;
    @Builder.Default
    private Perfil perfil = Perfil.USUARIO;
    private Endereco endereco;
}
