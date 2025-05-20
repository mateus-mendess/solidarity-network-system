package com.mg.solidaritynetwork.domain.service;


import com.mg.solidaritynetwork.domain.entity.ActionType;
import com.mg.solidaritynetwork.domain.repository.ActionTypeDAO;
import com.mg.solidaritynetwork.dto.response.ActionTypeDTO;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ActionTypeService {

    private final ActionTypeDAO actionTypeDAO;

    public ActionTypeService(ActionTypeDAO actionTypeDAO) {
        this.actionTypeDAO = actionTypeDAO;
    }

    public List<ActionTypeDTO> getAllActionTypes() throws SQLException {
        List<ActionType> actionTypes = this.findAllActionType();
        return this.toActionTypesDTO(actionTypes);
    }

    private List<ActionType> findAllActionType() throws SQLException {
       return actionTypeDAO.findAllActionType();
    }

    private List<ActionTypeDTO> toActionTypesDTO(List<ActionType> actionTypes) {
        List<ActionTypeDTO> actionTypeDTOS = new ArrayList<>();

        for (ActionType actionType : actionTypes) {
            ActionTypeDTO actionTypeDTO = new ActionTypeDTO(actionType.getId(), actionType.getName(), actionType.getColor());

            actionTypeDTOS.add(actionTypeDTO);
        }

        return actionTypeDTOS;
    }
}
