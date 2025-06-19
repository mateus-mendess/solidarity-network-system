package com.mg.solidaritynetwork.domain.service;


import com.mg.solidaritynetwork.dto.request.NGORegistrationRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
public class OrganizationRegistrationService {

    private final AuthorService authorService;
    private final OrganizationService organizationService;
    private final AddressService addressService;
    private final NGORepresentativeService ngoRepresentativeService;

    public OrganizationRegistrationService(AuthorService authorService, OrganizationService organizationService, AddressService addressService, NGORepresentativeService ngoRepresentativeService) {
        this.authorService = authorService;
        this.organizationService = organizationService;
        this.addressService = addressService;
        this.ngoRepresentativeService = ngoRepresentativeService;
    }

    @Transactional
    public void registerOrganization(NGORegistrationRequest ngoRegistrationRequest) throws SQLException {
        Long id = authorService.registry(ngoRegistrationRequest.getOrganizationRequest());
        ngoRegistrationRequest.getOrganizationRequest().setId(id);
        organizationService.register(ngoRegistrationRequest.getOrganizationRequest());
        ngoRegistrationRequest.getAddressRequest().setId_ong(id);
        addressService.register(ngoRegistrationRequest.getAddressRequest());
        ngoRepresentativeService.register(ngoRegistrationRequest.getNgoRepresentativeRequest());
    }
}
