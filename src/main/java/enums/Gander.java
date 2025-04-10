package enums;

public enum Gander {
    MASCULINO("Masculino"),
    FEMININO("Feminino"),
    OUTRO("Outro");

    private final String label;

    Gander(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

}
