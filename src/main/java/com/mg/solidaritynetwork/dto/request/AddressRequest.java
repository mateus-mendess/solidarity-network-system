package com.mg.solidaritynetwork.dto.request;

import com.mg.solidaritynetwork.domain.entity.Organization;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class AddressRequest {

    @Pattern(regexp = "^\\d{5}-?\\d{3}$", message = "")
    private String postalCode;

    @NotBlank
    private String neighborhood;

    @NotBlank
    private String street;

    @NotBlank
    private String state;

    @NotBlank
    private String city;
}
