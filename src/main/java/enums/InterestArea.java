package enums;

public enum InterestArea {
    HOMELESS_SUPPORT("Apoio a pessoas em situação de rua"),

    EDUCATION("Educação"),

    HEALTH("Saúde"),

    ANIMAL_WELFARE("Bem-estar animal"),

    ENVIRONMENT("Meio ambiente"),

    CULTURE("Cultura"),

    SPORTS("Esportes"),

    ELDERLY_CARE("Cuidado com idosos"),

    CHILDREN_ASSISTANCE("Assistência a crianças"),

    SOCIAL_INCLUSIO("Inclusão social");

    private final String label;

    InterestArea(String label) {
        this.label = label;
    }
}
