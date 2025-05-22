package com.mg.solidaritynetwork.domain.service;


import com.mg.solidaritynetwork.domain.entity.VolunteerActionType;
import com.mg.solidaritynetwork.domain.repository.VolunteerActionTypeDAO;
import com.mg.solidaritynetwork.dto.request.VolunteerRequest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class VolunteerActionTypeService {

    private final ModelMapper modelMapper;
    private final VolunteerActionTypeDAO volunteerActionTypeDAO;


    public VolunteerActionTypeService(VolunteerActionTypeDAO volunteerActionTypeDAO, ModelMapper modelMapper) {
        this.volunteerActionTypeDAO = volunteerActionTypeDAO;
        this.modelMapper = modelMapper;
    }

    public void registry(VolunteerRequest volunteerRequest) {
        VolunteerActionType volunteerActionType = this.toVolunteerActionType(volunteerRequest);
        this.save(volunteerActionType);
    }

    private VolunteerActionType toVolunteerActionType(VolunteerRequest volunteerRequest) {
        return modelMapper.map(volunteerRequest, VolunteerActionType.class);
    }

    private void save(VolunteerActionType volunteerActionType) {
        volunteerActionTypeDAO.insertVolunteerActionType(volunteerActionType);
    }
}
