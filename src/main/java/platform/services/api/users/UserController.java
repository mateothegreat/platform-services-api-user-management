/*
 * Copyright (C) 2017 Matthew Davis <matthew@appsoa.io>
 *
 * This library is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Library General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library.  If not, see
 * <http://www.gnu.org/licenses/>.
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
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import static org.springframework.http.HttpStatus.PRECONDITION_FAILED;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import platform.services.api.commons.controller.BaseRestController;
import platform.services.api.commons.exception.RestResponse;
import platform.services.api.commons.utilities.Tracing;
import platform.services.api.users.authentication.AuthenticatedRunAsRole;

@RestController
@RequestMapping("/users")
public class UserController extends BaseRestController<User> {

    private UserService service;

    public UserController(@Autowired final UserService service) {

        super(service);

//        this.genericService = service;

    }

    @RequestMapping(method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER_ADMIN') OR #user.username == authentication.name")
    public ResponseEntity<?> save(@RequestBody final User user) {

        Tracing.trace("create: {}", user);

        user.setParentId(0L);

        try {

            final User created = service.saveEntity(user);

            return new ResponseEntity<>(created, HttpStatus.OK);

        } catch(final DataAccessException e) {

            return new ResponseEntity<>(
                new RestResponse(RestResponse.ENTITY_EXISTS_CODE, RestResponse.ENTITY_EXISTS_MESSAGE, "username", "email address",
                                 "asdfasdf"), new HttpHeaders(), PRECONDITION_FAILED);

        }

    }

    @RequestMapping(params = "username", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER_ADMIN') OR #user.username == authentication.name")
    public ResponseEntity<User> getByUsername(@RequestParam final String username) throws NotFoundException {

        final Optional<User> result = service.findByUserUsername(username);

        return result.map(user -> new ResponseEntity<>(user, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @RequestMapping(params = "email", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER_ADMIN') OR #user.username == authentication.name")
    public ResponseEntity<User> getByEmail(@RequestParam final String email) throws DataAccessException, NotFoundException {

        final Optional<User> result = service.findByEmail(email);

        return result.map(user -> new ResponseEntity<>(user, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @AuthenticatedRunAsRole("ROLE_SUPERA") //Authority added by RunAsManager
    @PreAuthorize("hasRole('ROLE_SUPER')")
    @RequestMapping(method = RequestMethod.GET, path = "/escalate")
    public String escalateRole() {

        Authentication auth = SecurityContextHolder.getContext()
                                                   .getAuthentication();

        return "Current User Authorities inside this RunAS method only " +
            auth.getAuthorities()
                .toString();

    }

}
