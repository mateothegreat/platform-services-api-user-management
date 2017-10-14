package platform.services.api.monitoring.services;

import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Table;

import platform.services.api.commons.jpa.entities.BaseEntity;

@Entity @Accessors(fluent = true)

@Table(name = "monitoring_services")
public class MonitoringService extends BaseEntity<MonitoringService> {
    private String name;
    private String description;

    private MonitoredServiceStatus serviceStatus;

    public static MonitoringService create() {

        final MonitoringService fixture = new MonitoringService();

        fixture.name = new Faker().app().name();
        fixture.description = new Faker().company().catchPhrase();
        fixture.serviceStatus = MonitoredServiceStatus.ONLINE_IN_ALARM;

        return fixture;

    }

}
