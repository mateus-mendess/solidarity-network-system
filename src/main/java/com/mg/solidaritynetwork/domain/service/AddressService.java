package com.mg.solidaritynetwork.domain.service;

import com.mg.solidaritynetwork.domain.entity.Address;
import com.mg.solidaritynetwork.domain.repository.AddressDAO;
import com.mg.solidaritynetwork.dto.request.AddressRequest;
import com.mg.solidaritynetwork.dto.response.ViaCepResponse;
import com.mg.solidaritynetwork.exception.InvalidFormatException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

@Service
public class AddressService {

    private final ModelMapper modelMapper;
    private final Validator validator;
    private final AddressDAO addressDAO;
    private final GeocodingService geocodingService;

    public AddressService(ModelMapper modelMapper, Validator validator, AddressDAO addressDAO, GeocodingService geocodingService) {
        this.modelMapper = modelMapper;
        this.validator = validator;
        this.addressDAO = addressDAO;
        this.geocodingService = geocodingService;
    }

    public void register(AddressRequest addressRequest ) throws SQLException {
        List<Double> coordinates = geocodingService.getCoordinates(addressRequest);
        addressRequest.setLatitude(coordinates.get(0));
        addressRequest.setLongitude(coordinates.get(1));
        this.validateInformation(addressRequest);
        Address address = this.toAddress(addressRequest);
        this.save(address);
    }

    public ViaCepResponse fetchAddressFromViaCep(String postalCode) {
        this.validatePostalCode(postalCode);
        return this.getAddressFromViaCep(postalCode);
    }

    private void validatePostalCode(String postalCode) {
        if (! postalCode.matches("^\\d{5}-?\\d{3}$")) {
            throw new InvalidFormatException("Cep", "CEP inválido. Verifique se o número informado contém 8 dígitos e está no formato correto (ex: 12345-678).");
        }
    }

    private ViaCepResponse getAddressFromViaCep(String postalCode) {
        String url = "https://viacep.com.br/ws/"+postalCode+"/json/";

        RestTemplate template = new RestTemplate();
        ResponseEntity<ViaCepResponse> response = template.getForEntity(url, ViaCepResponse.class);

        return response.getBody();
    }

    private void validateInformation(AddressRequest addressRequest) {
        Set<ConstraintViolation<AddressRequest>> violations = validator.validate(addressRequest);

        for (ConstraintViolation<AddressRequest> violation : violations) {
            throw new InvalidFormatException(violation.getPropertyPath().toString(), violation.getMessage());
        }
    }

    private Address toAddress(AddressRequest addressRequest) {
        return modelMapper.map(addressRequest, Address.class);
    }

    private void save(Address address) throws SQLException {
        addressDAO.insertAddress(address);
    }
}
