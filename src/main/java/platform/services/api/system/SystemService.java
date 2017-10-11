package platform.services.api.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import platform.services.api.commons.services.GenericService;

@Service
public class SystemService extends GenericService<SystemRepository, System> {

    private final SystemRepository repository;

    @Autowired
    public SystemService(final SystemRepository repository) {

        super(repository);

        this.repository = repository;

    }

}
