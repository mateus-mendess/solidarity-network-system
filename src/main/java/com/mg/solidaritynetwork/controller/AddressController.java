package com.mg.solidaritynetwork.controller;


import com.mg.solidaritynetwork.domain.service.AddressService;
import com.mg.solidaritynetwork.dto.response.ViaCepResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/search-cep")
    @ResponseBody
    public ViaCepResponse fetchAddressByZipCode(@RequestParam("postalCode") String postalCode) {
        return addressService.fetchAddressFromViaCep(postalCode);
    }

}
