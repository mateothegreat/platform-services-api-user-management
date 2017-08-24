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

package com.streamingplatform.api.common.exception;

import com.streamingplatform.api.users.controllers.UserController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import javax.persistence.NonUniqueResultException;
import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpStatus.PRECONDITION_FAILED;

@ControllerAdvice
@RestControllerAdvice
public class GlobalRestExceptionHandlers {
    
    private static final Logger logger = LogManager.getLogger(UserController.class);
    
    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<RestErrorResponse> handleNotFoundException(NotFoundException notFoundException) {
        
        logger.trace("handleNotFoundException");
        
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
    }
    
    @ExceptionHandler(value = {DataAccessException.class})
    public ResponseEntity<RestErrorResponse> handleDataAccessException(DataAccessException dataAccessEx) {
        
        logger.trace("handleDataAccessException");
        logger.trace(dataAccessEx.getMessage());
        logger.trace(dataAccessEx.toString());
        
        return new ResponseEntity<>(PRECONDITION_FAILED);
        
    }
    
    @ExceptionHandler(value = {InsufficientAuthenticationException.class})
    public ResponseEntity<RestErrorResponse> handleInsufficientAuthenticationException(
        InsufficientAuthenticationException e) {
        
        logger.trace("handleInsufficientAuthenticationException");
        logger.trace(e.getMessage());
        logger.trace(e.toString());
        
        e.printStackTrace();
        
        return new ResponseEntity<>(PRECONDITION_FAILED);
        
    }
    
    @ExceptionHandler(value = {UnsatisfiedServletRequestParameterException.class})
    public ResponseEntity<RestErrorResponse> handleUnsatisfiedServletRequestParameterException(
        UnsatisfiedServletRequestParameterException e) {
        
        logger.trace("handleUnsatisfiedServletRequestParameterException");
        logger.trace("handleUnsatisfiedServletRequestParameterException");
        logger.trace("handleUnsatisfiedServletRequestParameterException");
        logger.trace("handleUnsatisfiedServletRequestParameterException");
        logger.trace("handleUnsatisfiedServletRequestParameterException");
        logger.trace("handleUnsatisfiedServletRequestParameterException");
        logger.trace(e.getMessage());
        
        return new ResponseEntity<>(PRECONDITION_FAILED);
        
    }
    
    @ExceptionHandler(value = {HttpClientErrorException.class})
    public ResponseEntity<?> handleHttpClientErrorException(HttpServletRequest request, Throwable e) {
        
        HttpStatus status = getStatus(request);
        logger.trace(status.toString());
        logger.trace(status.toString());
        logger.trace(status.toString());
        logger.trace(status.toString());
        logger.trace(status.toString());
        logger.trace(status.toString());
        logger.trace("HttpClientErrorException");
        logger.trace("HttpClientErrorException");
        logger.trace("HttpClientErrorException");
        logger.trace("HttpClientErrorException");
        logger.trace("HttpClientErrorException");
        logger.trace("HttpClientErrorException");
        logger.trace("HttpClientErrorException");
        logger.trace(e.getMessage());
        logger.error(e.getStackTrace());
        e.printStackTrace();
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
    }
    
    private HttpStatus getStatus(HttpServletRequest request) {
        
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if(statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
    
    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<RestErrorResponse> handleResourceNotFoundException(ResourceNotFoundException e) {
        
        logger.trace("handleResourceNotFoundException");
        logger.trace(e.getMessage());
        logger.error(e.getStackTrace());
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
    }
    
    @ExceptionHandler(value = {NonUniqueResultException.class})
    public ResponseEntity<RestErrorResponse> handleNonUniqueResultException(NonUniqueResultException e) {
        
        logger.trace("NonUniqueResultException");
        logger.trace(e.getMessage());
        logger.error(e.getStackTrace());
        return new ResponseEntity<>(HttpStatus.CONFLICT);
        
    }
    
    @ExceptionHandler(value = {IncorrectResultSizeDataAccessException.class})
    public ResponseEntity<RestErrorResponse> handleIncorrectResultSizeDataAccessException(
        IncorrectResultSizeDataAccessException e) {
        
        logger.trace("IncorrectResultSizeDataAccessException");
        logger.trace(e.getMessage());
        logger.error(e.getStackTrace());
        return new ResponseEntity<>(HttpStatus.CONFLICT);
        
    }
    
    // @ExceptionHandler(value = {Exception.class})
    // public ResponseEntity<RestErrorResponse> exceptionHandler(Exception e) {
    //
    //     //        RestErrorResponse error = new RestErrorResponse();
    //     //
    //     //        error.setErrorCode(HttpStatus.BAD_REQUEST.value());
    //     //        error.setMessage("The request could not be understood by the server due to malformed syntax.");
    //     logger.trace("exceptionHandler");
    //     logger.trace("exceptionHandler");
    //     logger.trace("exceptionHandler");
    //     logger.trace("exceptionHandler");
    //     logger.trace("exceptionHandler");
    //     logger.trace("exceptionHandler");
    //     logger.trace("exceptionHandler");
    //     logger.trace("exceptionHandler");
    //     logger.trace("exceptionHandler");
    //     logger.trace("exceptionHandler");
    //     logger.trace("exceptionHandler");
    //     logger.trace("exceptionHandler");
    //
    //     logger.trace(e.getMessage());
    //     logger.trace(e.toString());
    //     logger.error(e.getStackTrace());
    //     e.printStackTrace();
    //     return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    //
    // }
    // @ExceptionHandler(value = {RepositoryConstraintViolationException.class})
    // public ResponseEntity<Object> handleAccessDeniedException(Exception ex, WebRequest request) {
    //
    //     RepositoryConstraintViolationException nevEx = (RepositoryConstraintViolationException) ex;
    //
    //     String errors = nevEx.getErrors()
    //                          .getAllErrors()
    //                          .stream()
    //                          .map(ObjectError::toString)
    //                          .collect(Collectors.joining("\n"));
    //
    //     return new ResponseEntity<>(errors, new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);
    //
    // }
    
}
