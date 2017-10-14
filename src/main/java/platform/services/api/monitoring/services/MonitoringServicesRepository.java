package platform.services.api.monitoring.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import platform.services.api.commons.jpa.repositories.BaseRepository;

@RepositoryRestResource(path = "monitoring/services", collectionResourceRel = "monitoring/services", itemResourceRel = "service")
public interface MonitoringServicesRepository extends BaseRepository<MonitoringService> {

    @RestResource(path = "statuses", rel = "statuses")
    Page<MonitoringService> findAllByServiceStatus(final MonitoredServiceStatus status, final Pageable pageable);


}
