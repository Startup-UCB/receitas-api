package br.com.ucb.startup.receitas_api.aplicacao.handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FieldErrorResponse {
    private String field;
    private String message;
}
