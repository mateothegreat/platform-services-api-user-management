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

package com.streamingplatform.api.users.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.data.rest.core.RepositoryConstraintViolationException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.persistence.NonUniqueResultException;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.PRECONDITION_FAILED;

@ControllerAdvice
@RestControllerAdvice
public class GlobalRestExceptionHandlers {
    
    private final Logger logger = LoggerFactory.getLogger(
        com.streamingplatform.api.users.controllers.UserController.class);
    
    @ExceptionHandler(value = {UnsatisfiedServletRequestParameterException.class})
    public ResponseEntity<RestErrorResponse> handleUnsatisfiedServletRequestParameterException(
        UnsatisfiedServletRequestParameterException e) {
        
        logger.trace("handleUnsatisfiedServletRequestParameterException");
        logger.trace("handleUnsatisfiedServletRequestParameterException");
        logger.trace("handleUnsatisfiedServletRequestParameterException");
        logger.trace("handleUnsatisfiedServletRequestParameterException");
        logger.trace("handleUnsatisfiedServletRequestParameterException");
        logger.trace("handleUnsatisfiedServletRequestParameterException");
        logger.trace("handleUnsatisfiedServletRequestParameterException");
        logger.trace("handleUnsatisfiedServletRequestParameterException");
        logger.trace(e.getMessage());
        
        return new ResponseEntity<>(PRECONDITION_FAILED);
        
    }
    
    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<RestErrorResponse> handleResourceNotFoundException(ResourceNotFoundException e) {
        
        logger.trace("handleResourceNotFoundException");
        
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
    }
    
    @ExceptionHandler(value = {NonUniqueResultException.class})
    public ResponseEntity<RestErrorResponse> handleNonUniqueResultException(NonUniqueResultException e) {
        
        logger.trace("NonUniqueResultException");
        
        return new ResponseEntity<>(HttpStatus.CONFLICT);
        
    }
    
    @ExceptionHandler(value = {IncorrectResultSizeDataAccessException.class})
    public ResponseEntity<RestErrorResponse> handleIncorrectResultSizeDataAccessException(
        IncorrectResultSizeDataAccessException e) {
        
        logger.trace("IncorrectResultSizeDataAccessException");
        
        return new ResponseEntity<>(HttpStatus.CONFLICT);
        
    }
    
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<RestErrorResponse> exceptionHandler(Exception ex) {
        
        //        RestErrorResponse error = new RestErrorResponse();
        //
        //        error.setErrorCode(HttpStatus.BAD_REQUEST.value());
        //        error.setMessage("The request could not be understood by the server due to malformed syntax.");
        
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        
    }
    
    @ExceptionHandler(value = {RepositoryConstraintViolationException.class})
    public ResponseEntity<Object> handleAccessDeniedException(Exception ex, WebRequest request) {
        
        RepositoryConstraintViolationException nevEx = (RepositoryConstraintViolationException) ex;
        
        String errors = nevEx.getErrors()
                             .getAllErrors()
                             .stream()
                             .map(ObjectError::toString)
                             .collect(Collectors.joining("\n"));
        
        return new ResponseEntity<>(errors, new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);
        
    }
    
}
