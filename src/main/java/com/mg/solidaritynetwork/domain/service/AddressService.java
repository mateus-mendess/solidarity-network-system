package com.mg.solidaritynetwork.domain.service;

import com.mg.solidaritynetwork.domain.repository.AddressDAO;
import com.mg.solidaritynetwork.dto.request.AddressRequest;
import com.mg.solidaritynetwork.dto.response.ViaCepResponse;
import com.mg.solidaritynetwork.exception.InvalidFormatException;
import jakarta.validation.Validator;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AddressService {

    private final ModelMapper modelMapper;
    private final Validator validator;
    private final AddressDAO addressDAO;

    public AddressService(ModelMapper modelMapper, Validator validator, AddressDAO addressDAO) {
        this.modelMapper = modelMapper;
        this.validator = validator;
        this.addressDAO = addressDAO;
    }

    public void register(AddressRequest addressRequest) {

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
}
