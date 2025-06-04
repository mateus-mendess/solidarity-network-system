package com.mg.solidaritynetwork.controller;

import com.mg.solidaritynetwork.domain.service.OrganizationRegistrationService;
import com.mg.solidaritynetwork.dto.request.NGORegistrationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.rmi.MarshalledObject;
import java.sql.SQLException;

@Controller
public class OrganizationController {

    private final OrganizationRegistrationService organizationRegistrationService;

    public OrganizationController(OrganizationRegistrationService organizationRegistrationService) {
        this.organizationRegistrationService = organizationRegistrationService;
    }

    @GetMapping("/register-organization")
    public ModelAndView getOrganizationRegistrationView() {
        ModelAndView modelAndView = new ModelAndView("register_organization");
        modelAndView.addObject("organizationRegistrationRequest", new NGORegistrationRequest());

        return modelAndView;
    }

    @PostMapping("/organizations")
    public ResponseEntity<String> registryOrganization(@ModelAttribute NGORegistrationRequest ngoRegistrationRequest) throws SQLException {
        organizationRegistrationService.registerOrganization(ngoRegistrationRequest);

        return ResponseEntity.ok().body("Organização cadastrada com sucesso.");
    }
}
