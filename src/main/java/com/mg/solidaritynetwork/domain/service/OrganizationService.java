package com.mg.solidaritynetwork.domain.service;

import com.mg.solidaritynetwork.domain.entity.Organization;
import com.mg.solidaritynetwork.domain.repository.OrganizationDAO;
import com.mg.solidaritynetwork.dto.request.OrganizationRequest;
import com.mg.solidaritynetwork.exception.CnpjAlreadyExistsException;
import com.mg.solidaritynetwork.exception.InvalidFormatException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OrganizationService {

    private final OrganizationDAO organizationDAO;
    private final Validator validator;
    private final ModelMapper modelMapper;

    public OrganizationService(Validator validator, OrganizationDAO organizationDAO, ModelMapper modelMapper) {
        this.validator = validator;
        this.organizationDAO = organizationDAO;
        this.modelMapper = modelMapper;
    }

    public void register(OrganizationRequest organizationRequest) {
        this.validateInformation(organizationRequest);
        this.validateUniqueFields(organizationRequest);
        Organization organization = this.toOrganization(organizationRequest);
        this.save(organization);
    }

    private void validateInformation(OrganizationRequest organizationRequest) {
        Set<ConstraintViolation<OrganizationRequest>> violations = validator.validate(organizationRequest);

        if (! violations.isEmpty()) {
            for (ConstraintViolation<OrganizationRequest> violation : violations) {
                throw new InvalidFormatException(violation.getPropertyPath().toString(), violation.getMessage());
            }
        }
    }

    private void validateUniqueFields(OrganizationRequest organizationRequest) {
        if (organizationDAO.existsByCnpj(organizationRequest.getCnpj())) {
            throw new CnpjAlreadyExistsException("Cnpj já cadastrado no sistema", "cnpj");
        }
    }

    private Organization toOrganization(OrganizationRequest organizationRequest) {
        return modelMapper.map(organizationRequest, Organization.class);
    }

    private void save(Organization organization) {
        System.out.println(organization.getId());
        System.out.println(organization.getCnpj());
        System.out.println(organization.getCorporateName());
        System.out.println(organization.getProfilePicture().getOriginalFilename());
        System.out.println(organization.getCoverPhoto().getOriginalFilename());
        System.out.println(organization.getAbout());

        organizationDAO.insertOrganization(organization);
    }
}
