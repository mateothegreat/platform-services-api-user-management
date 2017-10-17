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
package platform.services.api.users;

/*-
 * $$SoftwareLicense
 * Streaming Platform Users API
 * %%
 * Copyright (C) 2017 streamnvr
 * %%
 * __
 *       /\ \__
 *   ____\ \ ,_\  _ __    __     __      ___ ___     ___   __  __   _ __
 *  /',__\\ \ \/ /\`'__\/'__`\ /'__`\  /' __` __`\ /' _ `\/\ \/\ \ /\`'__\
 * /\__, `\\ \ \_\ \ \//\  __//\ \L\.\_/\ \/\ \/\ \/\ \/\ \ \ \_/ |\ \ \/
 * \/\____/ \ \__\\ \_\\ \____\ \__/.\_\ \_\ \_\ \_\ \_\ \_\ \___/  \ \_\
 *  \/___/   \/__/ \/_/ \/____/\/__/\/_/\/_/\/_/\/_/\/_/\/_/\/__/    \/_/
 *
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * streaming-main.platform.com
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import platform.services.api.commons.controller.BaseController;
import platform.services.api.commons.exception.ThrowableResponseEntity;
import platform.services.api.commons.validation.ValidationError;
import platform.services.api.users.authentication.AuthenticatedRunAsRole;
import platform.services.api.users.authentication.UserAuthenticationPrincipal;

@RestController
@RequestMapping("/users")
public class UserController extends BaseController<UserService, UserRepository, User> {

    private final UserService service;

    public UserController(@Autowired final UserService service) {

        super(service);

        this.service = service;

    }

//    @RequestMapping (method = RequestMethod.POST)
////    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER_ADMIN')")
//////    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER_ADMIN') OR #username == authentication.name")
//////    @PostAuthorize("returnObject.username == authentication.name")
//    public ResponseEntity<User> save(@RequestBody final User user) {
//
//        return new ResponseEntity<>(service.save(user), HttpStatus.OK);
//
//    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    @ResponseBody public ResponseEntity<User> postIndex(@RequestBody final User entity) throws ValidationError {

        return new ThrowableResponseEntity<>(service.save(entity), HttpStatus.CREATED);

    }


    @GetMapping(params = "username")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER_ADMIN')")

//    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER_ADMIN') OR #username == authentication.name")
//    @PostAuthorize("returnObject.username == authentication.name")
    public ThrowableResponseEntity<User> getByUsername(@RequestParam final String username) {

        return new ThrowableResponseEntity<>(service.getByUsername(username));

    }

    @RequestMapping(params = "email", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER_ADMIN')")
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER_ADMIN') OR #username == authentication.name")
//    @PostAuthorize("returnObject.username == authentication.name")
    public ResponseEntity<User> getByEmail(@RequestParam final String email) throws DataAccessException, NotFoundException {

        return new ThrowableResponseEntity<>(service.getByUsername(email));

    }

    @AuthenticatedRunAsRole("ROLE_SUPERA") //Authority added by RunAsManager
    @PreAuthorize("hasRole('ROLE_SUPER')")
    @RequestMapping(method = RequestMethod.GET, path = "/escalate")
    public String escalateRole() {

        final Authentication auth = SecurityContextHolder.getContext()
                                                         .getAuthentication();

        return String.format("Current User Authorities inside this RunAS method only %s", auth.getAuthorities());

    }

    @RequestMapping(value = "/_current/principal", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ROLE_USER')")
    public ResponseEntity<UserAuthenticationPrincipal> getAuthenticationPrincipal(@AuthenticationPrincipal final UserAuthenticationPrincipal principal) {

        return new ResponseEntity<>(principal, HttpStatus.OK);

    }

}
