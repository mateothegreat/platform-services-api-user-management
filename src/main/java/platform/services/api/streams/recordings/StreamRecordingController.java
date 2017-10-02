package platform.services.api.streams.recordings;

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
import platform.services.api.commons.validation.ValidationError;

@RestController
@RequestMapping("/streams/{root_uuid:^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$}/recordings")
public class StreamRecordingController extends BaseController<StreamRecordingService, StreamRecordingRepository, StreamRecording> {

    private final StreamRecordingService service;

    @Autowired public StreamRecordingController(final StreamRecordingService service) {

        super(service);

        this.service = service;

    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    public ResponseEntity<StreamRecording> indexPost(@PathVariable final UUID root_uuid, @RequestBody final StreamRecording entity) throws ValidationError {

        return new ThrowableResponseEntity<>(service.save(root_uuid, entity), HttpStatus.CREATED);

    }

}
