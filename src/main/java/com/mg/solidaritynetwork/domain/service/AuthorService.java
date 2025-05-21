package com.mg.solidaritynetwork.domain.service;


import com.mg.solidaritynetwork.domain.entity.Author;
import com.mg.solidaritynetwork.domain.repository.AuthorDAO;
import com.mg.solidaritynetwork.dto.request.AuthorRequest;
import com.mg.solidaritynetwork.dto.request.VolunteerRequest;

import com.mg.solidaritynetwork.exception.FormatErrorException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Set;

@Service
public class AuthorService {

    private final ModelMapper modelMapper;
    private final Validator validator;
    private final AuthorDAO authorDAO;

    public AuthorService(ModelMapper modelMapper, Validator validator, AuthorDAO authorDAO) {
        this.modelMapper = modelMapper;
        this.validator = validator;
        this.authorDAO = authorDAO;
    }

    public Long registry(AuthorRequest authorRequest) throws SQLException {
        this.validateInformation(authorRequest);
        Author author = this.toAuthor(authorRequest);
        return this.save(author);
    }

    private void validateInformation(AuthorRequest authorRequest) {
        Set<ConstraintViolation<AuthorRequest>> validators = validator.validate(authorRequest);

        if (! validators.isEmpty()) {
            for (ConstraintViolation<AuthorRequest> violation : validators) {
                throw new FormatErrorException(violation.getPropertyPath().toString(), violation.getMessage());
            }
         }
    }

    private Author toAuthor(AuthorRequest authorRequest) {
        return modelMapper.map(authorRequest, Author.class);
    }

    private Long save(Author author) throws SQLException {
        return authorDAO.insertAuthor(author);
    }


}
