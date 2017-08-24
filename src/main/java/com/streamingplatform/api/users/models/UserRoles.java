

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

package com.streamingplatform.api.users.models;

import com.streamingplatform.api.common.models.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user_roles")
public class UserRoles extends BaseEntity {
    
    @NotNull
    private String username;
    @NotNull
    private String role;
    
    public UserRoles(final String username, final String role) {
        
        super();
        
        this.username = username;
        this.role = role;
        
    }
    
    public String getUsername() {
        
        return username;
    }
    
    public void setUsername(final String username) {
        
        this.username = username;
    }
    
    public String getRole() {
        
        return role;
    }
    
    public void setRole(final String role) {
        
        this.role = role;
    }
}
