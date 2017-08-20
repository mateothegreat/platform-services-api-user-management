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

import com.streamingplatform.api.users.common.exception.RestException;
import com.streamingplatform.api.users.models.User;
import com.streamingplatform.api.users.repository.UserRepository;
import com.streamingplatform.api.users.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    
    private final Logger LOG = LoggerFactory.getLogger(UserController.class);
    
    private final UserRepository userRepository;
    private final UserService    userService;
    
    @Autowired
    public UserController(UserRepository userRepository, UserService userService) {
        
        this.userRepository = userRepository;
        this.userService = userService;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<User>> findAll(Pageable pageable) throws RestException {
        
        Page<User> page = userRepository.findAll(pageable);
        
        return new ResponseEntity<Page<User>>(page, HttpStatus.OK);
        
    }
    
    @RequestMapping(params = "username", method = RequestMethod.GET)
    public ResponseEntity<Object> getByUsername(@RequestParam String username) throws RestException {
        
        User user = userService.getUserByUsername(username);
        
        if (user == null || user.getId() <= 0) {
            
            throw new ResourceNotFoundException();
            
        }
        
        return new ResponseEntity<Object>(user, HttpStatus.OK);
        
    }
    
    
    @RequestMapping(params = "email", method = RequestMethod.GET)
    public ResponseEntity<Object> getByEmail(@RequestParam String email) {
        
        User user = userService.getUserByEmail(email);
        
        if (user == null || user.getId() <= 0) {
            
            throw new ResourceNotFoundException();
            
        }
        
        return new ResponseEntity<Object>(user, HttpStatus.OK);
        
    }
    
}
