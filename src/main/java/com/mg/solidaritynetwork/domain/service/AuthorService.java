package com.mg.solidaritynetwork.domain.service;


import com.mg.solidaritynetwork.domain.entity.Author;
import com.mg.solidaritynetwork.domain.repository.AuthorDAO;
import com.mg.solidaritynetwork.dto.request.AuthorRequest;

import com.mg.solidaritynetwork.exception.EmailAlreadyExistsException;
import com.mg.solidaritynetwork.exception.InvalidFormatException;
import com.mg.solidaritynetwork.utils.PasswordEncoder;
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
    private final PasswordEncoder passwordEncoder;
    private final AuthorDAO authorDAO;

    public AuthorService(ModelMapper modelMapper, Validator validator, AuthorDAO authorDAO, PasswordEncoder passwordEncoder) {
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.validator = validator;
        this.authorDAO = authorDAO;
    }

    public Long registry(AuthorRequest authorRequest) throws SQLException {
        this.validateInformation(authorRequest);
        this.ValidateUniqueFields(authorRequest);
        AuthorRequest secureAuthorRequest = this.securePassword(authorRequest);
        Author author = this.toAuthor(secureAuthorRequest);
        return this.save(author);
    }

    private void validateInformation(AuthorRequest authorRequest) {
        Set<ConstraintViolation<AuthorRequest>> validators = validator.validate(authorRequest);

        if (! validators.isEmpty()) {
            for (ConstraintViolation<AuthorRequest> violation : validators) {
                throw new InvalidFormatException(violation.getPropertyPath().toString(), violation.getMessage());
            }
         }
    }

    private void ValidateUniqueFields(AuthorRequest authorRequest) throws SQLException {
        if (authorDAO.existsByEmail(authorRequest.getEmail())) {
            throw new EmailAlreadyExistsException("Email já cadastrado.", "Email");
        }
    }

    private AuthorRequest securePassword(AuthorRequest authorRequest) {
        String hashedPassword = passwordEncoder.encoder(authorRequest.getPassword());
        authorRequest.setPassword(hashedPassword);

        return authorRequest;
    }

    private Author toAuthor(AuthorRequest authorRequest) {
        return modelMapper.map(authorRequest, Author.class);
    }

    private Long save(Author author) throws SQLException {
        return authorDAO.insertAuthor(author);
    }


}
