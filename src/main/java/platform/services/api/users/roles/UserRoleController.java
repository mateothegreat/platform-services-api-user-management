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
package platform.services.api.users.roles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import platform.services.api.commons.controller.BaseController;
import platform.services.api.commons.enums.Role;
import platform.services.api.commons.exception.ThrowableResponseEntity;
import platform.services.api.commons.validation.ValidationError;
import platform.services.api.users.authentication.AuthenticatedUser;

@RestController
@RequestMapping("/users/{root_uuid:^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$}/roles")
public class UserRoleController extends BaseController<UserRoleService, UserRoleRepository, UserRole> {

    private final UserRoleService service;

    @Autowired
    private AuthenticatedUser authenticatedUser;

    @Autowired public UserRoleController(final UserRoleService service) {

        super(service);

        this.service = service;

    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    public ResponseEntity<UserRole> postIndex(@PathVariable final UUID root_uuid, @RequestBody final UserRole entity) throws ValidationError {

        return new ThrowableResponseEntity<>(service.save(root_uuid, entity), HttpStatus.CREATED);

    }


    @RequestMapping(value = "/check/{role:ROLE_USER}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<?> httpGetAndhasRoleUser(@PathVariable final Role role) {

        return new ResponseEntity<>(authenticatedUser.getUser(), HttpStatus.OK);

    }

    @RequestMapping(value = "/check/{role:ROLE_ADMIN}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> httpGethasRoleAdmin(@PathVariable final Role role) {

        return new ResponseEntity<>(authenticatedUser.getUser(), HttpStatus.OK);

    }

    @RequestMapping(value = "/check/{role:ROLE_EMPTY}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_EMPTY')")
    public ResponseEntity<?> httpGethasRoleEmpty(@PathVariable final Role role) {

        return new ResponseEntity<>(authenticatedUser.getUser(), HttpStatus.OK);

    }

}
