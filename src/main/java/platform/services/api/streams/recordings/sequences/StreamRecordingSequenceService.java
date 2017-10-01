package platform.services.api.streams.recordings.sequences;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

import platform.services.api.commons.exception.ThrowableResponseEntity;
import platform.services.api.commons.services.GenericService;
import platform.services.api.commons.validation.ValidationError;
import platform.services.api.streams.recordings.StreamRecording;
import platform.services.api.streams.recordings.StreamRecordingService;

@Service
public class StreamRecordingSequenceService extends GenericService<StreamRecordingSequenceRepository, StreamRecordingSequence> {

    private final StreamRecordingSequenceRepository repository;
    private final StreamRecordingService            streamRecordingService;

    @Autowired
    public StreamRecordingSequenceService(final StreamRecordingSequenceRepository repository, final StreamRecordingService streamRecordingService) {

        super(repository);

        this.repository = repository;
        this.streamRecordingService = streamRecordingService;

    }

//    public Page<StreamRecordingSequence> getAllByRecordingId(final Long recordingId) {
//
//        return getAllByRecordingId(recordingId, new PageRequest(0, 5));
//
//    }
//
//    public Page<StreamRecordingSequence> getAllByRecordingId(final Long recordingId, final Pageable pageable) {
//
//        return repository.getAllByRecordingId(recordingId, pageable);
//
//    }

//    @Override
    public StreamRecordingSequence save(final UUID recording_uuid, final StreamRecordingSequence entity) throws ValidationError {

        final StreamRecording streamRecording = streamRecordingService.getByUuid(recording_uuid);


        entity.setRecording(streamRecording);

        return save(entity);

    }

}
