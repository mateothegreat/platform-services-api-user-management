package platform.services.api.networking.hosts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
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
@RequestMapping("/network/hosts")
@ExposesResourceFor(NetworkHost.class)
public class NetworkHostController extends BaseController<NetworkHostService, NetworkHostRepository, NetworkHost> {

    public static final String PATH_BASE = "network/hosts";

    private final NetworkHostService service;


    @Autowired
    public NetworkHostController(final NetworkHostService service) {

        super(service);

        this.service = service;

    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    public ResponseEntity<NetworkHost> indexPost(@RequestBody final NetworkHost entity) throws ValidationError {

//        return new ResponseEntity<Resource<NetworkHost>>(getGenericService().saveAndGetResourceById(entity), HttpStatus.CREATED);

        return new ThrowableResponseEntity<>(getGenericService().saveAndGetById(entity), HttpStatus.CREATED);

    }

}
