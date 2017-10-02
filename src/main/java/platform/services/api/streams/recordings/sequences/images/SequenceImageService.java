package platform.services.api.streams.recordings.sequences.images;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import platform.services.api.commons.services.GenericService;

@Service
public class SequenceImageService extends GenericService<SequenceImageRepository, SequenceImage> {

    private final SequenceImageRepository repository;

    @Autowired
    public SequenceImageService(final SequenceImageRepository repository) {

        super(repository);

        this.repository = repository;

    }

}
