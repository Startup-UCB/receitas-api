package br.com.ucb.startup.receitas_api.aplicacao.handler;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;
    private String codigo;
    private String erro;
    private String mensagemErro;

    private List<FieldErrorResponse> errors = Collections.emptyList();

    /**
     * Construtor apenas com a mensagem de erro.
     *
     * @param httpStatus   status http
     * @param mensagemErro mensagem de erro
     */
    public ErrorResponse(HttpStatus httpStatus, String mensagemErro) {
        this.timestamp = LocalDateTime.now();
        this.codigo = httpStatus.toString();
        this.erro = httpStatus.getReasonPhrase();
        this.mensagemErro = mensagemErro;
    }

    /**
     * Construtor com os campos de erro.
     *
     * @param codigo   codigo http
     * @param erro   nome do erro
     * @param mensagemErro mensagem de erro
     */
    public ErrorResponse(String codigo, String erro, String mensagemErro) {
        this.timestamp = LocalDateTime.now();
        this.codigo = codigo;
        this.erro = erro;
        this.mensagemErro = mensagemErro;
    }

    /**
     * Construtor contendo todos os campos.
     *
     * @param httpStatus   codigo http
     * @param mensagemErro mensagem de erro
     * @param erros       uma lista com cada erro lançado
     */
    public ErrorResponse(HttpStatus httpStatus, String mensagemErro, List<FieldErrorResponse> erros) {
        this(httpStatus, mensagemErro);
        this.errors = erros;
    }
}
