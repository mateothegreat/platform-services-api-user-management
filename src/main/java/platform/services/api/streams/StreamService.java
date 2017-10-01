package platform.services.api.streams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import platform.services.api.commons.services.GenericService;

@Service
public class StreamService extends GenericService<StreamRepository, Stream> {

    private final StreamRepository repository;

    @Autowired
    public StreamService(final StreamRepository repository) {

        super(repository);

        this.repository = repository;

    }

}
