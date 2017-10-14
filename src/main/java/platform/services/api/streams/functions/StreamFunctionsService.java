package platform.services.api.streams.functions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import platform.services.api.commons.services.GenericService;

@Service
public class StreamFunctionsService extends GenericService<StreamFunctionsRepository, StreamFunction> {

    private final StreamFunctionsRepository repository;

    @Autowired
    public StreamFunctionsService(final StreamFunctionsRepository repository) {

        super(repository);

        this.repository = repository;

    }

}
