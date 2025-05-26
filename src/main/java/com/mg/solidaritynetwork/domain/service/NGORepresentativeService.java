package com.mg.solidaritynetwork.domain.service;


import com.mg.solidaritynetwork.domain.entity.NGORepresentative;
import com.mg.solidaritynetwork.domain.repository.NGORepresentativeDAO;
import com.mg.solidaritynetwork.dto.request.NGORepresentativeRequest;
import com.mg.solidaritynetwork.exception.InvalidFormatException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class NGORepresentativeService {

    private final NGORepresentativeDAO ngoRepresentativeDAO;
    private final Validator validator;
    private final ModelMapper modelMapper;

    public NGORepresentativeService(Validator validator, ModelMapper modelMapper, NGORepresentativeDAO ngoRepresentativeDAO) {
        this.validator = validator;
        this.modelMapper = modelMapper;
        this.ngoRepresentativeDAO = ngoRepresentativeDAO;
    }

    public void register(NGORepresentativeRequest ngoRepresentativeRequest) {
        this.validateInformation(ngoRepresentativeRequest);
        NGORepresentative representative = toRepresentative(ngoRepresentativeRequest);
        this.save(representative);
    }

    private void validateInformation(NGORepresentativeRequest ngoRepresentativeRequest) {
        Set<ConstraintViolation<NGORepresentativeRequest>> violations = validator.validate(ngoRepresentativeRequest);

        if(! violations.isEmpty()) {
            for (ConstraintViolation<NGORepresentativeRequest> violation : violations) {
                throw new InvalidFormatException(violation.getPropertyPath().toString(), violation.getMessage());
            }
        }
    }

    private NGORepresentative toRepresentative(NGORepresentativeRequest ngoRepresentativeRequest) {
        return modelMapper.map(ngoRepresentativeRequest, NGORepresentative.class);
    }

    private void save(NGORepresentative representative) {
        ngoRepresentativeDAO.insertRepresentative(representative);
    }

}
