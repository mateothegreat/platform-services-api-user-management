package platform.services.api.streams.recordings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

import platform.services.api.commons.services.GenericService;
import platform.services.api.commons.validation.ValidationError;
import platform.services.api.streams.Stream;
import platform.services.api.streams.StreamService;

@Service
public class StreamRecordingService extends GenericService<StreamRecordingRepository, StreamRecording> {

    private final StreamRecordingRepository repository;

    @Autowired
    private StreamService streamService;

    @Autowired
    public StreamRecordingService(final StreamRecordingRepository repository) {

        super(repository);

        this.repository = repository;

    }

    public StreamRecording save(final UUID uuid, final StreamRecording entity) throws ValidationError {

        final Stream parent = streamService.getByUuid(uuid);

        if(parent == null) {

            throw new ValidationError("Invalid stream");

        }

        entity.setStream(parent);

        return repository.save(entity);

    }
}
