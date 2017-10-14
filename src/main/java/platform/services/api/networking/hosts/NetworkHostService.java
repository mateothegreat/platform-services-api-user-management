package platform.services.api.networking.hosts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import platform.services.api.commons.services.GenericService;
@Transactional

@Service
public class NetworkHostService extends GenericService<NetworkHostRepository, NetworkHost> {

    private final NetworkHostRepository repository;

    @Autowired
    public NetworkHostService(final NetworkHostRepository repository) {

        super(repository);

        this.repository = repository;

    }

}
