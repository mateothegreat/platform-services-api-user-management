package platform.services.api.streams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import platform.services.api.commons.controller.BaseController;
import platform.services.api.commons.exception.ThrowableResponseEntity;
import platform.services.api.commons.validation.ValidationError;

@RestController
@RequestMapping("/streams")
public class StreamController extends BaseController<StreamService, StreamRepository, Stream> {

    public static final String PATH_BASE = "streams";
    @Autowired
    public StreamController(final StreamService service) {

        super(service);

    }


    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ResponseEntity<Stream> indexPost(@RequestBody final Stream entity) throws ValidationError {

        return new ThrowableResponseEntity<>(getGenericService().save(entity), HttpStatus.CREATED);

    }

}
