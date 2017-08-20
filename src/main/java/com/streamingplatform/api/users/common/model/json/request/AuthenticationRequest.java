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

package com.streamingplatform.api.users.common.model.json.request;

import org.springframework.stereotype.Component;

@Component
public class AuthenticationRequest {
    
    private static final long serialVersionUID = 6624726180748515507L;
    private String username;
    private String password;
    
    public AuthenticationRequest() {
        
        super();
    }
    
    public AuthenticationRequest(String username, String password) {
        
        this.setUsername(username);
        this.setPassword(password);
    }
    
    public String getUsername() {
        
        return this.username;
    }
    
    public void setUsername(String username) {
        
        this.username = username;
    }
    
    public String getPassword() {
        
        return this.password;
    }
    
    public void setPassword(String password) {
        
        this.password = password;
    }
    
}
