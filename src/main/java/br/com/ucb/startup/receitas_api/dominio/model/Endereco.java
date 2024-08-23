package br.com.ucb.startup.receitas_api.dominio.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Endereco {
    private Long id;
    private String cep;
    private String logradouro;
    private String numero;
    private String bairro;
    private String complemento;
    private String pais;
    private String cidade;
    private String estado;
}
