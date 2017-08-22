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

package com.streamingplatform.api.users.controllers;

import com.streamingplatform.api.users.models.User;
import com.streamingplatform.api.users.repository.UserRepository;
import com.streamingplatform.api.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;

import static org.springframework.http.ResponseEntity.ok;

@EnableJpaRepositories
@Component
@RestController
@RequestMapping("/users")
public class UserController {
    
    private final UserService userService;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    public UserController(UserRepository userRepository, UserService userService) {
        
        this.userService = userService;
    }
    
    // @RequestMapping(method = RequestMethod.GET)
    // public ResponseEntity<Page<User>> findAll(Pageable pageable) throws NotFoundException {
    //
    //     // Page<User> page = userRepository.findAll(pageable);
    //
    //     // return new ResponseEntity<Page<User>>(page, HttpStatus.OK);
    //
    // }
    
    @RequestMapping(params = "username", method = RequestMethod.GET)
    public ResponseEntity<Object> getByUsername(@RequestParam String username) throws NotFoundException {
        
        User user = userService.getUserByUsername(username);
        
        if(user == null || user.getId() <= 0) {
            
            throw new NotFoundException();
            
        }
        
        return new ResponseEntity<Object>(user, HttpStatus.OK);
        
    }
    
    @RequestMapping(params = "email", method = RequestMethod.GET)
    public ResponseEntity<Object> getByEmail(@RequestParam String email) throws NotFoundException {
        
        User user = userService.getUserByEmail(email);
        
        if(user == null || user.getId() <= 0) {
            
            throw new NotFoundException();
            
        }
        
        return new ResponseEntity<Object>(user, HttpStatus.OK);
        
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @PermitAll
    ResponseEntity<Boolean> isCurrentUserLoggedIn() {
        
        return new ResponseEntity<>(userService.isCurrentUserLoggedIn(), HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<User> getCurrentUser() {
        
        return ok(userService.getCurrentUser());
    }
    
}
