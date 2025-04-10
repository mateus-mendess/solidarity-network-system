package enums;

public enum AvailabilityPeriod {
    MORNING("Manhã"),
    AFTERNOON("Tarde"),
    EVENING("Noite");

    private final String label;

    AvailabilityPeriod(String label) {
        this.label = label;
    }
}
