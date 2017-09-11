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

package platform.services.api.commons.exception;

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

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.config.ResourceNotFoundException;
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

@Log4j2
@ControllerAdvice
@RestControllerAdvice
public class GlobalRestExceptionHandlers {

    @ExceptionHandler(value = { NotFoundException.class })
    public ResponseEntity<RestErrorResponse> handleNotFoundException(NotFoundException notFoundException) {

        log.trace("handleNotFoundException");

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

//    @ExceptionHandler(value = { DataAccessException.class })
//    public ResponseEntity<Object> handleDataAccessException(final DataAccessException dataAccessEx) {
//
//        log.trace("handleDataAccessException");
//        log.trace(dataAccessEx.getMessage());
//        log.trace(dataAccessEx.toString());
//
////        RestErrorResponse restErrorResponse = new RestErrorResponse(444, "There is a {} that already exists");
//
////        return new RestErrorResponse(444, "There is a {} that already exists");
//        ;
////        return new ResponseEntity<RestErrorResponse>(new RestErrorResponse("There is a {} that already exists", 444));
//
////        String msg = RestResponse.format(RestResponse.ENTITY_EXISTS_MESSAGE, "username", "email address", "asdfasdf");
////        String msg = RestResponse.format(RestResponse.ENTITY_EXISTS_MESSAGE, "username", "email address", "asdfasdf");
//
////        final RestResponse restResponse = new RestResponse(RestResponse.ENTITY_EXISTS_CODE, RestResponse.ENTITY_EXISTS_MESSAGE, "username", "email address", "asdfasdf");
//
////        final RestResponse restResponse = new RestResponse(RestResponse.ENTITY_EXISTS_CODE, RestResponse.ENTITY_EXISTS_MESSAGE);
//
//        return new ResponseEntity<>(new RestResponse(RestResponse.ENTITY_EXISTS_CODE, RestResponse.ENTITY_EXISTS_MESSAGE, "asdusername", "email address", "asdfasdf"), new HttpHeaders(), PRECONDITION_FAILED);
////        return new ResponseEntity<>(, new HttpHeaders(), PRECONDITION_FAILED);
//
//    }

    @ExceptionHandler(value = { InsufficientAuthenticationException.class })
    public ResponseEntity<RestErrorResponse> handleInsufficientAuthenticationException(
            InsufficientAuthenticationException e) {

        log.trace("handleInsufficientAuthenticationException");
        log.trace(e.getMessage());
        log.trace(e.toString());

        e.printStackTrace();

        return new ResponseEntity<>(PRECONDITION_FAILED);

    }

    @ExceptionHandler(value = { UnsatisfiedServletRequestParameterException.class })
    public ResponseEntity<RestErrorResponse> handleUnsatisfiedServletRequestParameterException(
            UnsatisfiedServletRequestParameterException e) {

        log.trace("handleUnsatisfiedServletRequestParameterException");
        log.trace("handleUnsatisfiedServletRequestParameterException");
        log.trace("handleUnsatisfiedServletRequestParameterException");
        log.trace("handleUnsatisfiedServletRequestParameterException");
        log.trace("handleUnsatisfiedServletRequestParameterException");
        log.trace("handleUnsatisfiedServletRequestParameterException");
        log.trace(e.getMessage());

        return new ResponseEntity<>(PRECONDITION_FAILED);

    }

    @ExceptionHandler(value = { HttpClientErrorException.class })
    public ResponseEntity<?> handleHttpClientErrorException(HttpServletRequest request, Throwable e) {

        HttpStatus status = getStatus(request);
        log.trace(status.toString());
        log.trace(status.toString());
        log.trace(status.toString());
        log.trace(status.toString());
        log.trace(status.toString());
        log.trace(status.toString());
        log.trace("HttpClientErrorException");
        log.trace("HttpClientErrorException");
        log.trace("HttpClientErrorException");
        log.trace("HttpClientErrorException");
        log.trace("HttpClientErrorException");
        log.trace("HttpClientErrorException");
        log.trace("HttpClientErrorException");
        log.trace(e.getMessage());
        log.error(e.getStackTrace());
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

    @ExceptionHandler(value = { ResourceNotFoundException.class })
    public ResponseEntity<RestErrorResponse> handleResourceNotFoundException(ResourceNotFoundException e) {

        log.trace("handleResourceNotFoundException");
        log.trace(e.getMessage());
        log.error(e.getStackTrace());
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(value = { NonUniqueResultException.class })
    public ResponseEntity<RestErrorResponse> handleNonUniqueResultException(NonUniqueResultException e) {

        log.trace("NonUniqueResultException");
        log.trace(e.getMessage());
        log.error(e.getStackTrace());
        return new ResponseEntity<>(HttpStatus.CONFLICT);

    }

    @ExceptionHandler(value = { IncorrectResultSizeDataAccessException.class })
    public ResponseEntity<RestErrorResponse> handleIncorrectResultSizeDataAccessException(
            IncorrectResultSizeDataAccessException e) {

        log.trace("IncorrectResultSizeDataAccessException");
        log.trace(e.getMessage());
        log.error(e.getStackTrace());
        return new ResponseEntity<>(HttpStatus.CONFLICT);

    }

    // @ExceptionHandler(value = {Exception.class})
    // public ResponseEntity<RestErrorResponse> exceptionHandler(Exception e) {
    //
    //     //        RestErrorResponse error = new RestErrorResponse();
    //     //
    //     //        error.setErrorCode(HttpStatus.BAD_REQUEST.value());
    //     //        error.setMessage("The request could not be understood by the server due to malformed syntax.");
    //     log.trace("exceptionHandler");
    //     log.trace("exceptionHandler");
    //     log.trace("exceptionHandler");
    //     log.trace("exceptionHandler");
    //     log.trace("exceptionHandler");
    //     log.trace("exceptionHandler");
    //     log.trace("exceptionHandler");
    //     log.trace("exceptionHandler");
    //     log.trace("exceptionHandler");
    //     log.trace("exceptionHandler");
    //     log.trace("exceptionHandler");
    //     log.trace("exceptionHandler");
    //
    //     log.trace(e.getMessage());
    //     log.trace(e.toString());
    //     log.error(e.getStackTrace());
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
