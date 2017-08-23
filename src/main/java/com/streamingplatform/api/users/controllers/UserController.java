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

import com.streamingplatform.api.users.common.controller.AbstractRestController;
import com.streamingplatform.api.users.models.User;
import com.streamingplatform.api.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController extends AbstractRestController {
    
    @Autowired
    private UserService UserService;
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> create(@RequestBody User user) {
        
        log.trace("create: {}", user);
        
        return new ResponseEntity<User>(user, HttpStatus.OK);
        
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<User>> findAll(Pageable pageable) throws NotFoundException {
        
        Page<User> page = UserService.findAll(pageable);
        
        return new ResponseEntity<Page<User>>(page, HttpStatus.OK);
        
    }
    
    @RequestMapping(params = "username", method = RequestMethod.GET)
    public ResponseEntity<Object> getByUsername(@RequestParam String username) throws NotFoundException {
        
        User user = UserService.getUserByUsername(username);
        
        if(user == null || user.getId() <= 0) {
            
            throw new NotFoundException();
            
        }
        
        return new ResponseEntity<Object>(user, HttpStatus.OK);
        
    }
    
    @RequestMapping(params = "email", method = RequestMethod.GET)
    public ResponseEntity<Object> getByEmail(@RequestParam String email) throws DataAccessException, NotFoundException {
        
        User user = UserService.getUserByEmail(email);
        
        if(user == null || user.getId() <= 0) {
            
            throw new NotFoundException();
            
        }
        
        return new ResponseEntity<Object>(user, HttpStatus.OK);
        
    }
    
}
