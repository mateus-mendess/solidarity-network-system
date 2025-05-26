package com.mg.solidaritynetwork.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Pattern;

public class ViaCepResponse {
    @Pattern(regexp = "^\\d{5}-?\\d{3}$", message = "CEP inválido. Verifique se o número informado contém 8 dígitos e está no formato correto (ex: 12345-678).")
    @JsonProperty("cep")
    private String postalCode;

    @JsonProperty("bairro")
    private String neighborhood;

    @JsonProperty("logradouro")
    private String street;

    @JsonProperty("estado")
    private String state;

    @JsonProperty("localidade")
    private String city;

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
