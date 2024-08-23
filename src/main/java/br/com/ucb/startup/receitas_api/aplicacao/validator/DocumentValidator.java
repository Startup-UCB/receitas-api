package br.com.ucb.startup.receitas_api.aplicacao.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@RequiredArgsConstructor
public class DocumentValidator implements ConstraintValidator<Document, String> {

    private final CPFValidator cpfValidator;
    private final CNPJValidator cnpjValidator;

    @Override
    public boolean isValid(String field, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.hasText(field) && (cpfValidator.isValid(field, constraintValidatorContext) || cnpjValidator.isValid(field, constraintValidatorContext));
    }
}
