package com.mg.solidaritynetwork.domain.service;

import com.mg.solidaritynetwork.dto.request.VolunteerRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;


@Service
public class VolunteerRegistrationService {

    private final AuthorService authorService;
    private final VolunteerService volunteerService;
    private final VolunteerActionTypeService volunteerActionTypeService;

    public VolunteerRegistrationService(AuthorService authorService, VolunteerService volunteerService, VolunteerActionTypeService volunteerActionTypeService) {
        this.authorService = authorService;
        this.volunteerService = volunteerService;
        this.volunteerActionTypeService = volunteerActionTypeService;
    }

    public void registerVolunteer(VolunteerRequest volunteerRequest) throws SQLException {
        Long id = authorService.registry(volunteerRequest);
        volunteerRequest.setId(id);
        volunteerService.registry(volunteerRequest);
        volunteerActionTypeService.registry(volunteerRequest);
    }

}
