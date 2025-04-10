package enums;

public enum EducationLevel {
    HIGH_SCHOOL("Ensino Médio"),
    TECHNICAL("Técnico"),
    UNDERGRADUATE("Graduação"),
    GRADUATE("Pós-graduação"),
    DOCTORATE("Doutorado");

    private  final String label;

    EducationLevel(String label) {
        this.label = label;
    }
}
