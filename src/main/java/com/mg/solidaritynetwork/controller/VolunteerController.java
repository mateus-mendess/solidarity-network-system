package com.mg.solidaritynetwork.controller;

import com.mg.solidaritynetwork.domain.service.ActionTypeService;
import com.mg.solidaritynetwork.dto.request.VolunteerRequest;
import com.mg.solidaritynetwork.dto.response.ActionTypeDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.List;

@Controller
public class VolunteerController {

    private final ActionTypeService actionTypeService;

    public VolunteerController(ActionTypeService actionTypeService) {
        this.actionTypeService = actionTypeService;
    }

    @GetMapping("/registerVolunteer")
    public ModelAndView getVolunteerForms() throws SQLException {
        List<ActionTypeDTO> actionTypesResponse = actionTypeService.getAllActionTypes();

        ModelAndView modelAndView = new ModelAndView("register_volunteer");
        modelAndView.addObject("volunteerDTO", new VolunteerRequest());
        modelAndView.addObject("actionTypes", actionTypesResponse);

        return modelAndView;
    }
}
