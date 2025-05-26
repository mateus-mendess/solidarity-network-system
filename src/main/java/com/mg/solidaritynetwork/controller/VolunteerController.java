package com.mg.solidaritynetwork.controller;

import com.mg.solidaritynetwork.domain.service.*;
import com.mg.solidaritynetwork.dto.request.AuthorRequest;
import com.mg.solidaritynetwork.dto.request.VolunteerRequest;
import com.mg.solidaritynetwork.dto.response.ActionTypeDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.List;

@Controller
public class VolunteerController {

    private final ActionTypeService actionTypeService;
    private final VolunteerRegistrationService volunteerRegistrationService;

    public VolunteerController(ActionTypeService actionTypeService, VolunteerRegistrationService volunteerRegistrationService) {
        this.actionTypeService = actionTypeService;
        this.volunteerRegistrationService = volunteerRegistrationService;
    }

    @GetMapping("/registerVolunteer")
    public ModelAndView getVolunteerForms() throws SQLException {
        List<ActionTypeDTO> actionTypesResponse = actionTypeService.getAllActionTypes();

        ModelAndView modelAndView = new ModelAndView("register_volunteer");
        modelAndView.addObject("volunteerRequest", new VolunteerRequest());
        modelAndView.addObject("actionTypes", actionTypesResponse);

        return modelAndView;
    }

    @PostMapping("/volunteer/register")
    public ResponseEntity<String> registryVolunteer(@ModelAttribute VolunteerRequest volunteerRequest) throws SQLException{
        volunteerRegistrationService.registerVolunteer(volunteerRequest);

        return ResponseEntity.ok().body("Voluntário registrado com sucesso!");
    }
}
