

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
import com.streamingplatform.api.common.controller.*;
import com.streamingplatform.api.users.entities.*;
import com.streamingplatform.api.users.services.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.crossstore.ChangeSetPersister.*;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import platform.api.common.controller.*;
import platform.services.api.users.entities.*;
import platform.services.api.users.services.*;

@RestController
@RequestMapping("/users")
public class UserController extends AbstractRestController {

    @Autowired
    private UserService service;
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> save(@RequestBody User user) {
        
        log.trace("create: {}", user);

        User created = service.save(user);

        return new ResponseEntity<User>(created, HttpStatus.OK);
        
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page> getAll(Pageable pageable) throws NotFoundException {
        
        Page<User> results = service.getAll(pageable);

        return new ResponseEntity<>((Page) results, HttpStatus.OK);
        
    }
    
//    @RequestMapping(params = "username", method = RequestMethod.GET)
//    public ResponseEntity<Object> getByUsername(@RequestParam String username) throws NotFoundException {
//
//        User user = service.getUserByUsername(username);
//
//        if(user == null || user.getId() <= 0) {
//
//            throw new NotFoundException();
//
//        }
//
//        return new ResponseEntity<Object>(user, HttpStatus.OK);
//
//    }
//
//    @RequestMapping(params = "email", method = RequestMethod.GET)
//    public ResponseEntity<Object> getByEmail(@RequestParam String email) throws DataAccessException, NotFoundException {
//
//        User user = service.getUserByEmail(email);
//
//        if(user == null || user.getId() <= 0) {
//
//            throw new NotFoundException();
//
//        }
//
//        return new ResponseEntity<Object>(user, HttpStatus.OK);
//
//    }
    
}
