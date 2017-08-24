

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

import org.springframework.http.HttpStatus;

public class RestException extends Exception {
    
    private static final long serialVersionUID = 1L;
    
    private String errorMessage;
    private int    errorCode;
    
    public RestException(HttpStatus httpStatus) {
        
        super(httpStatus.value() + ": " + httpStatus.getReasonPhrase());
        
        this.errorMessage = httpStatus.getReasonPhrase();
        this.errorCode = httpStatus.value();
        
    }
    
    public RestException(String errorMessage) {
        
        super(errorMessage);
        
        this.errorMessage = errorMessage;
        
    }
    
    public RestException(int errorCode, String errorMessage) {
        
        super(errorCode + ": " + errorMessage);
        
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        
    }
    
    public RestException() {
        
        super();
        
    }
    
    public String getErrorMessage() {
        
        return errorMessage;
        
    }
    
    public int getErrorCode() {
        
        return errorCode;
        
    }
    
}
