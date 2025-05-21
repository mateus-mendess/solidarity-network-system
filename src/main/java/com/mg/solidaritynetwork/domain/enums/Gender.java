package com.mg.solidaritynetwork.domain.enums;

import com.mg.solidaritynetwork.exception.FormatErrorException;

public enum Gender {
    MALE("Masculino"),
    FEMALE("Feminino"),
    NON_BINARY("Não-binário"),
    BIGENDER("Bigênero"),
    TRANSGENDER("Transgênero"),
    OTHER("Outro");

    private final String label;

    private Gender(String label) {
        this.label = label;
    }

    public static Gender fromLabel(String label) {
        for (Gender gender : Gender.values()) {
            if (gender.label.equalsIgnoreCase(label)) {
                return gender;
            }
        }
        throw new FormatErrorException("Gênero", "Gênero inválido!");
    }

    public String getLabel() {
        return label;
    }
}
