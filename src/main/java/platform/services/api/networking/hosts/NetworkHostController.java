package platform.services.api.networking.hosts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import platform.services.api.commons.controller.BaseController;
import platform.services.api.commons.exception.ThrowableResponseEntity;

//@RestController
@RepositoryRestController
@RequestMapping(path = "network/hosts", name= "asdf")
//@ExposesResourceFor(NetworkHost.class)
public class NetworkHostController extends BaseController<NetworkHostService, NetworkHostRepository, NetworkHost> {

    public static final String PATH_BASE = "network/hosts";

    private final NetworkHostService service;


    @Autowired
    public NetworkHostController(final NetworkHostService service) {

        super(service);

        this.service = service;

    }

//    @RequestMapping(method = RequestMethod.POST, value = "")
//    public ResponseEntity<NetworkHost> indexPost(@RequestBody final NetworkHost entity) throws ValidationError {
//
////        return new ResponseEntity<Resource<NetworkHost>>(getGenericService().saveAndGetResourceById(entity), HttpStatus.CREATED);
//
//        return new ThrowableResponseEntity<>(getGenericService().saveAndGetById(entity), HttpStatus.CREATED);
//
//    }

    @RequestMapping(

            method = RequestMethod.GET,
            path = "x",
            name = "xxxx"

    )
    public ResponseEntity<NetworkHost> asdf() {

        return new ThrowableResponseEntity<>(service.getById(17L));

    }

}
