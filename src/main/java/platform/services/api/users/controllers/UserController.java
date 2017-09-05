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

package platform.services.api.users.controllers;

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
 * streaming-platform.com
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import platform.services.api.common.controller.BaseRestController;
import platform.services.api.common.exception.RestResponse;
import platform.services.api.common.utilities.Tracing;
import platform.services.api.users.jpa.User;
import platform.services.api.users.services.UserService;

import static org.springframework.http.HttpStatus.PRECONDITION_FAILED;

@RestController
@RequestMapping("/users")
public class UserController extends BaseRestController {

    private final UserService service;

    @Autowired
    public UserController(final UserService service) {

        this.service = service;

    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody final User user) {

        Tracing.trace("create: {}", user);

        user.setParentId(0L);

        try {

            final User created = service.save(user);

            return new ResponseEntity<>(created, HttpStatus.OK);

        } catch(final DataAccessException e) {

            return new ResponseEntity<>(new RestResponse(RestResponse.ENTITY_EXISTS_CODE, RestResponse.ENTITY_EXISTS_MESSAGE, "username", "email address", "asdfasdf"), new HttpHeaders(), PRECONDITION_FAILED);

        }

    }

    @PreAuthorize("hasAuthority('ROLE_USER_ADMIN')")
    @RequestMapping(method = RequestMethod.GET)
//    public ResponseEntity<BaseRepositoryPage<User>> getAll(final Pageable pageable) throws NotFoundException {
//    public ResponseEntity<Page<User>> getAll(final Pageable pageable) throws NotFoundException {
//
//        final Page<User> results = service.getAll(pageable);
//
//        return new ResponseEntity<Page<User>> (results, HttpStatus.OK);
//
//    }

//    public BaseRepositoryPage<BaseEntity> getAll(final Pageable pageable) throws NotFoundException {
     public Page<User> getAll(final Pageable pageable) throws NotFoundException {

//        final BaseRepositoryPage<BaseEntity> results = service.getAll(pageable);

        return service.getAll(pageable);

    }

    @RequestMapping(params = "username", method = RequestMethod.GET)
    public ResponseEntity<User> getByUsername(@RequestParam final String username) throws NotFoundException {

        final User user = service.getUserByUsername(username);

        if(user == null || user.getId() <= 0L) {

            throw new NotFoundException();

        }

        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @RequestMapping(params = "email", method = RequestMethod.GET)
    public ResponseEntity<User> getByEmail(@RequestParam final String email) throws DataAccessException, NotFoundException {

        final User user = service.getUserByEmail(email);

        if(user == null || user.getId() <= 0L) {

            throw new NotFoundException();

        }

        return new ResponseEntity<>(user, HttpStatus.OK);

    }

}
