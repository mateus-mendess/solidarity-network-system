package com.mg.solidaritynetwork.validation.constraints;

import com.mg.solidaritynetwork.dto.request.AuthorRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, AuthorRequest> {

    @Override
    public boolean isValid(AuthorRequest authorRequest, ConstraintValidatorContext context) {
        if (authorRequest.getPassword() == null || authorRequest.getConfirmPassword() == null) {
            return false;
        }

        return authorRequest.getPassword().equals(authorRequest.getConfirmPassword());
    }
}
