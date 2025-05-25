package com.mg.solidaritynetwork.config;


import com.mg.solidaritynetwork.domain.entity.VolunteerActionType;
import com.mg.solidaritynetwork.dto.request.VolunteerRequest;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addConverter(new StringToGenderConfig());

        TypeMap<VolunteerRequest, VolunteerActionType> typeMap = modelMapper.createTypeMap(VolunteerRequest.class, VolunteerActionType.class)
                .addMappings(mapper -> {mapper.map(VolunteerRequest::getId, VolunteerActionType::setIdVolunteer);
                    mapper.map(VolunteerRequest::getIdActionTypes, VolunteerActionType::setIdActionTypes);
                    mapper.skip(VolunteerActionType::setId);});

        return modelMapper;
    }
}
