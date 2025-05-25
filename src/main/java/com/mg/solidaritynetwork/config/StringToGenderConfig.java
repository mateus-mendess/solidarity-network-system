package com.mg.solidaritynetwork.config;

import com.mg.solidaritynetwork.domain.enums.Gender;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

public class StringToGenderConfig implements Converter<String, Gender> {

    @Override
    public Gender convert(MappingContext<String, Gender> context) {
        return Gender.fromLabel(context.getSource());
    }
}
