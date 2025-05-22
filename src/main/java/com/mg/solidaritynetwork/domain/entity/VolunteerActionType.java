package com.mg.solidaritynetwork.domain.entity;

import java.util.List;

public class VolunteerActionType {

    private Long id;
    private Long idVolunteer;
    private List<Long> idActionTypes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdVolunteer() {
        return idVolunteer;
    }

    public void setIdVolunteer(Long idVolunteer) {
        this.idVolunteer = idVolunteer;
    }

    public List<Long> getIdActionTypes() {
        return idActionTypes;
    }

    public void setIdActionTypes(List<Long> idActionTypes) {
        this.idActionTypes = idActionTypes;
    }
}
