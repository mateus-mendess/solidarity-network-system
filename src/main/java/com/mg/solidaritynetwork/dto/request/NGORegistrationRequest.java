package com.mg.solidaritynetwork.dto.request;

public class NGORegistrationRequest {
    private OrganizationRequest organizationRequest;
    private AddressRequest addressRequest;
    private NGORepresentativeRequest ngoRepresentativeRequest;

    public OrganizationRequest getOrganizationRequest() {
        return organizationRequest;
    }

    public void setOrganizationRequest(OrganizationRequest organizationRequest) {
        this.organizationRequest = organizationRequest;
    }

    public AddressRequest getAddressRequest() {
        return addressRequest;
    }

    public void setAddressRequest(AddressRequest addressRequest) {
        this.addressRequest = addressRequest;
    }

    public NGORepresentativeRequest getNgoRepresentativeRequest() {
        return ngoRepresentativeRequest;
    }

    public void setNgoRepresentativeRequest(NGORepresentativeRequest ngoRepresentativeRequest) {
        this.ngoRepresentativeRequest = ngoRepresentativeRequest;
    }
}
