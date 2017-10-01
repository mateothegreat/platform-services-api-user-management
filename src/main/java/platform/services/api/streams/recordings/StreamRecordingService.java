package platform.services.api.streams.recordings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import platform.services.api.commons.services.GenericService;
import platform.services.api.streams.recordings.StreamRecording;
import platform.services.api.streams.recordings.StreamRecordingRepository;

@Service
public class StreamRecordingService extends GenericService<StreamRecordingRepository, StreamRecording> {

    private final StreamRecordingRepository repository;

    @Autowired
    public StreamRecordingService(final StreamRecordingRepository repository) {

        super(repository);

        this.repository = repository;

    }

}
