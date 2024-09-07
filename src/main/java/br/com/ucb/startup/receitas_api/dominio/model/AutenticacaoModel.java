package br.com.ucb.startup.receitas_api.dominio.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AutenticacaoModel {
    private String login;
    private String senha;
}
