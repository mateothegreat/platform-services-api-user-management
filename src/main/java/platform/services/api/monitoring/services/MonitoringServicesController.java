package platform.services.api.monitoring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import platform.services.api.commons.controller.BaseController;

@RestController
@RequestMapping(path = "/monitoring/services")
public class MonitoringServicesController extends BaseController<MonitoringServicesService, MonitoringServicesRepository, MonitoringService> {

    public static final String PATH_BASE = "/monitoring/services";
    private final MonitoringServicesService service;

    @Autowired public MonitoringServicesController(final MonitoringServicesService service) {

        super(service);

        this.service = service;

    }

}
