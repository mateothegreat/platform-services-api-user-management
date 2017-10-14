package platform.services.api.monitoring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import platform.services.api.commons.services.GenericService;

@Service
public class MonitoringServicesService extends GenericService<MonitoringServicesRepository, MonitoringService> {

    private final MonitoringServicesRepository repository;

    @Autowired
    public MonitoringServicesService(final MonitoringServicesRepository repository) {

        super(repository);

        this.repository = repository;

    }

}
