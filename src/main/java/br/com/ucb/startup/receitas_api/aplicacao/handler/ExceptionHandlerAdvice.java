package br.com.ucb.startup.receitas_api.aplicacao.handler;

import br.com.ucb.startup.receitas_api.dominio.exception.UsuarioNaoEncontradoException;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestControllerAdvice
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExceptionHandlerAdvice {

    private static final String METHOD = "method={}";
    private static final String METHOD_MESSAGE = "method={}, message={}";

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleException(Exception e) {
        log.error(METHOD, e.getClass().getSimpleName(), e);
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(UsuarioNaoEncontradoException.class)
    public ErrorResponse handleException(UsuarioNaoEncontradoException e) {
        log.error(METHOD_MESSAGE, e.getClass().getSimpleName(), e.getMessage());
        return new ErrorResponse(HttpStatus.NOT_FOUND, e.getMessage());
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleException(MethodArgumentNotValidException e) {
        log.error(METHOD_MESSAGE, e.getClass().getSimpleName(), e.getMessage());
        List<FieldErrorResponse> errors = new ArrayList<>();
        e.getFieldErrors().forEach(fieldError -> errors.add(
                new FieldErrorResponse(fieldError.getField(), fieldError.getDefaultMessage()
                )
        ));
        return new ErrorResponse(HttpStatus.BAD_REQUEST, "A requisição possuí erro(s) em seu corpo", errors);
    }
}
