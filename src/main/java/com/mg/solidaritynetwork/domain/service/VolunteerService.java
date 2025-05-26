package com.mg.solidaritynetwork.domain.service;

import com.mg.solidaritynetwork.domain.entity.Volunteer;
import com.mg.solidaritynetwork.domain.repository.VolunteerDAO;
import com.mg.solidaritynetwork.dto.request.VolunteerRequest;
import com.mg.solidaritynetwork.exception.CpfAlreadyExistsException;
import com.mg.solidaritynetwork.exception.InvalidFormatException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Set;

@Service
public class VolunteerService {

    private final ModelMapper modelMapper;
    private final Validator validator;
    private final VolunteerDAO volunteerDAO;

    public VolunteerService(ModelMapper modelMapper, Validator validator, VolunteerDAO volunteerDAO) {
        this.modelMapper = modelMapper;
        this.validator = validator;
        this.volunteerDAO = volunteerDAO;
    }

    public void registry(VolunteerRequest volunteerRequest) throws SQLException{
        this.validateInformation(volunteerRequest);
        this.validateUniqueFields(volunteerRequest);
        Volunteer volunteer = this.toVolunteer(volunteerRequest);
        this.save(volunteer);
    }

    private void validateInformation(VolunteerRequest volunteerRequest) {
        Set<ConstraintViolation<VolunteerRequest>> violations = validator.validate(volunteerRequest);

        if (! violations.isEmpty()) {
            for (ConstraintViolation<VolunteerRequest> violation: violations) {
                throw new InvalidFormatException(violation.getPropertyPath().toString(), violation.getMessage());
            }
        }
    }

    private void validateUniqueFields(VolunteerRequest volunteerRequest) {
        if (volunteerDAO.existsByCpf(volunteerRequest.getCpf())) {
            throw new CpfAlreadyExistsException("CPF já cadastrado", "cpf");
        }
    }

    private Volunteer toVolunteer(VolunteerRequest volunteerRequest) {
        return modelMapper.map(volunteerRequest, Volunteer.class);
    }

    private void save(Volunteer volunteer) throws SQLException {
        volunteerDAO.insertVolunteer(volunteer);
    }

}
