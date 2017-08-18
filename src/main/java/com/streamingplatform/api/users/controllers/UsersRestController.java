///*
// * Copyright (C) 2017 Matthew Davis <matthew@appsoa.io>
// *
// * This library is free software: you can redistribute it and/or
// * modify it under the terms of the GNU Lesser General Public
// * License as published by the Free Software Foundation; either
// * version 3 of the License, or (at your option) any later version.
// *
// * This library is distributed in the hope that it will be useful,
// * but WITHOUT ANY WARRANTY; without even the implied warranty of
// * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// * Library General Public License for more details.
// *
// * You should have received a copy of the GNU Lesser General Public
// * License along with this library.  If not, see
// * <http://www.gnu.org/licenses/>.
// */
//
//package com.streamingplatform.api.users.controllers;
//
//import com.streamingplatform.api.users.exception.handlers.ErrorResponse;
//import com.streamingplatform.api.users.exception.handlers.UserException;
//import com.streamingplatform.api.users.models.User;
//import com.streamingplatform.api.users.repositories.UsersRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/users")
//public class UsersRestController {
//
//    @Autowired
//    private UsersRepository userRepository;
//
//    @RequestMapping(path = "/create", method = RequestMethod.POST)
//    public @ResponseBody
//    String create(@RequestParam String username, @RequestParam String password) {
//
//        User user = new User();
//
//        user.setUsername(username);
//        user.setPassword(password);
//
//        userRepository.save(user);
//
//        return "Saved";
//
//    }
//
//    @RequestMapping(method = RequestMethod.GET)
//    public @ResponseBody
//    Iterable<User> getAll() {
//
//        return userRepository.findAll();
//
//    }
//
//    private void validate(User user) throws UserException {
//
//        String username = user.getUsername();
//
//        userRepository.findByUsername(username).orElseThrow(() -> new UserException("Could not locate " + username));
//
//    }
//
//    @ExceptionHandler(UserException.class)
//    public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
//
//        ErrorResponse errorResponse = new ErrorResponse();
//
//        errorResponse.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
//        errorResponse.setMessage(ex.getMessage());
//
//        return new ResponseEntity<>(errorResponse, HttpStatus.OK);
//
//    }
//
//}
