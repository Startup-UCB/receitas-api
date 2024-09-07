package br.com.ucb.startup.receitas_api.dominio.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Token {
    private String token;
    private long tempoExpiracao;
}
