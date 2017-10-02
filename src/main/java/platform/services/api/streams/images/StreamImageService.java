package platform.services.api.streams.images;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import platform.services.api.commons.services.GenericService;

@Service
public class StreamImageService extends GenericService<StreamImageRepository, StreamImage> {

    private final StreamImageRepository repository;

    @Autowired
    public StreamImageService(final StreamImageRepository repository) {

        super(repository);

        this.repository = repository;

    }

}
