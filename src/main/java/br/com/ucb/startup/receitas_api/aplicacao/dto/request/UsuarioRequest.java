package br.com.ucb.startup.receitas_api.aplicacao.dto.request;

import br.com.ucb.startup.receitas_api.aplicacao.validator.Document;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UsuarioRequest {

    @NotBlank
    private String nome;

    private String sobrenome;

    @NotBlank
    @Document
    private String documento;

    @NotBlank
    private String email;

    @NotBlank
    private String senha;

    @Valid
    @NotNull
    @JsonProperty("endereco")
    private EnderecoRequest endereco;
}
