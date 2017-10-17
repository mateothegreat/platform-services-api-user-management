/**
 * ====
 *     Copyright 2017 Pivotal Software, Inc.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 * ====
 *
 * Copyright 2017 Pivotal Software, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
