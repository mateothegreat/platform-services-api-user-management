package platform.services.api.monitoring.services;

public enum MonitoredServiceStatus {

    ONLINE_HEALTHY("ONLINE_HEALTHY"),
    ONLINE_IN_ALARM("ONLINE_IN_ALARM"),

    UNREACHABLE("UNREACHABLE"),

    NOT_MONITORED("NOT_MONITORED"),
    PENDING_FIRST_CHECK("PENDING_FIRST_CHECK");

    private String status;

    MonitoredServiceStatus(final String status) {

        this.status = status;

    }

}
