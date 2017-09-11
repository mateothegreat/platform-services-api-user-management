package platform.services.api.commons.audit;

public enum AuditableAction {

    INSERTED("INSERTED"),
    UPDATED("UPDATED"),
    DELETED("DELETED");

    private final String name;

    AuditableAction(final String value) {

        this.name = value;

    }

    public String value() {

        return this.name;

    }

    @Override
    public String toString() {

        return name;

    }

}
