package com.mg.solidaritynetwork.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;

    private Long id_ong;

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

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Long getId_ong() {
        return id_ong;
    }

    public void setId_ong(Long id_ong) {
        this.id_ong = id_ong;
    }

    public String getAddress() {
        return street + ", " + neighborhood + ", " + city + ", " + state + ", " + postalCode;
    }

    @Override
    public String toString() {
        return "AddressRequest{" +
                "postalCode='" + postalCode + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", street='" + street + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", id_ong=" + id_ong +
                '}';
    }
}
