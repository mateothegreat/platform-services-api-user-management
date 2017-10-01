package platform.services.api.streams.recordings.sequences;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import platform.services.api.commons.controller.BaseController;
import platform.services.api.commons.exception.ThrowableResponseEntity;
import platform.services.api.commons.validation.ConstraintPatterns;
import platform.services.api.commons.validation.ValidationError;
import platform.services.api.streams.Stream;
import platform.services.api.streams.StreamService;
import platform.services.api.streams.recordings.StreamRecording;
import platform.services.api.streams.recordings.StreamRecordingService;

@RestController
@RequestMapping("/streams/{root_uuid:^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$}/recordings/{uuid:^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$}/sequences")
public class StreamRecordingSequenceController extends BaseController<StreamRecordingSequenceService, StreamRecordingSequenceRepository, StreamRecordingSequence> {

    private final StreamService                  streamService;
    private final StreamRecordingService         streamRecordingService;
    private final StreamRecordingSequenceService service;

    @Autowired
    public StreamRecordingSequenceController(final StreamService streamService, final StreamRecordingSequenceService service, final StreamRecordingService streamRecordingService) {

        super(service);

        this.service = service;
        this.streamService = streamService;
        this.streamRecordingService = streamRecordingService;

    }

    @RequestMapping(

            method = RequestMethod.POST,
            value = ""

    )
    public ResponseEntity<StreamRecordingSequence> indexPost(@PathVariable final UUID root_uuid, @PathVariable final UUID uuid, @RequestBody final StreamRecordingSequence entity) throws ValidationError {

        final Stream          stream          = streamService.getByUuid(root_uuid);
        final StreamRecording streamRecording = streamRecordingService.getByUuid(uuid);

        if(streamRecording == null) {

            return new ThrowableResponseEntity<>(entity, HttpStatus.NOT_ACCEPTABLE);

        }

        entity.setRecording(streamRecording);

        final StreamRecordingSequence result = service.save(entity);

        if(result == null) {

            return new ThrowableResponseEntity<>(entity, HttpStatus.NOT_ACCEPTABLE);

        }

        return new ThrowableResponseEntity<>(result, HttpStatus.CREATED);

    }

//    @RequestMapping(
//
//            method = RequestMethod.DELETE,
//            value = ConstraintPatterns.CONSTRAINT_UUID_PATTERN
//
//    )
//    public ResponseEntity<Void> delete(@PathVariable final UUID uuid) {
//
//        return new ResponseEntity<>((service.deleteByUuid(uuid)) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST);
//
//    }

}
