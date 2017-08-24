

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

public class RestErrorResponse {
    
    private int    errorCode;
    private String message;
    
    public RestErrorResponse(int errorCode, String message) {
        
        this.errorCode = errorCode;
        this.message = message;
        
        //        return new ResponseEntity<RestErrorResponse>(new RestErrorResponse(HttpStatus.NOT_FOUND);
    }
    
    public int getErrorCode() {
        
        return errorCode;
    }
    
    void setErrorCode(int errorCode) {
        
        this.errorCode = errorCode;
    }
    
    public String getMessage() {
        
        return message;
    }
    
    void setMessage(String message) {
        
        this.message = message;
    }
}
