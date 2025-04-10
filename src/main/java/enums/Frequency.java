package enums;

public enum Frequency {
    OCCASIONAL("Eventual"),
    WEEKLY("Semanal"),
    MONTHLY("Mensal");

    private final String label;

    Frequency(String label) {
        this.label = label;
    }
}
