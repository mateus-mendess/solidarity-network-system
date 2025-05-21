package com.mg.solidaritynetwork.controller;

import com.mg.solidaritynetwork.domain.service.ActionTypeService;
import com.mg.solidaritynetwork.domain.service.AuthorService;
import com.mg.solidaritynetwork.domain.service.VolunteerService;
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
    private final AuthorService authorService;
    private final VolunteerService volunteerService;

    public VolunteerController(ActionTypeService actionTypeService, AuthorService authorService, VolunteerService volunteerService) {
        this.actionTypeService = actionTypeService;
        this.authorService = authorService;
        this.volunteerService = volunteerService;

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
        System.out.println(volunteerRequest.getCpf());
        System.out.println(volunteerRequest.getProfilePicture().getOriginalFilename());
        System.out.println(volunteerRequest.getEmail());
        System.out.println(volunteerRequest.getGender());
        System.out.println(volunteerRequest.getBirthDate());
        System.out.println(volunteerRequest.getPermission());
        System.out.println(volunteerRequest.getPassword());
        System.out.println(volunteerRequest.getLastName());
        System.out.println(volunteerRequest.getName());
        System.out.println(volunteerRequest.getPhone());
        System.out.println(volunteerRequest.getConfirmPassword());
        System.out.println(volunteerRequest.getProfession());

        Long id = authorService.registry(volunteerRequest);
        volunteerRequest.setId(id);
        volunteerService.registry(volunteerRequest);

        return ResponseEntity.ok().body("Voluntário registrado com sucesso!");
    }
}
