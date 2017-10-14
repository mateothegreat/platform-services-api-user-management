package platform.services.api.networking.hosts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import platform.services.api.commons.controller.BaseController;

@RestController
//@RepositoryRestController
//@RestController

@RequestMapping("/hosts")
//@ExposesResourceFor(NetworkHost.class)
public class NetworkHostController extends BaseController<NetworkHostService, NetworkHostRepository, NetworkHost> {

    public static final String PATH_BASE = "/hosts";

    private final NetworkHostService service;
    private final EntityLinks        entityLinks;

    @Autowired private NetworkHostRepository repository;

    @Autowired
    public NetworkHostController(final NetworkHostService service, final EntityLinks links) {

        super(service);

        this.service = service;

        entityLinks = links;
    }

//    @RequestMapping(method = RequestMethod.POST, value = "")
//    public ResponseEntity<NetworkHost> indexPost(@RequestBody final NetworkHost entity) throws ValidationError {
//
////        return new ResponseEntity<Resource<NetworkHost>>(getGenericService().saveAndGetResourceById(entity), HttpStatus.CREATED);
//
//        return new ThrowableResponseEntity<>(getGenericService().saveAndGetById(entity), HttpStatus.CREATED);
//
//    }

//    @RequestMapping(
//
//            method = RequestMethod.GET,
//            path = ""
//
//    )
//    @ResponseBody
//    public Page<NetworkHost> getAll(Pageable pageable) {
//
//        return service.findAll(pageable);
//
//        //
////        resources.add(linkTo(NetworkHostController.class).withSelfRel());
////        resources.add(entityLinks.linkToCollectionResource(NetworkHost.class));
//
//
//    }

}
