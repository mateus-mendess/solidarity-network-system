package enums;

public enum SpecificSkill {
    FIRST_AID("Primeiros Socorros"),
    COOKING("Culinária"),
    TEACHING("Ensino"),
    DRIVING("Direção"),
    COMPUTING("Informática"),
    CARPENTRY("Carpintaria"),
    TRANSLATION("Tradução"),
    MEDICAL_ASSISTANCE("Assistência Médica");

    private final String label;

    SpecificSkill(String label) {
        this.label = label;
    }
}
