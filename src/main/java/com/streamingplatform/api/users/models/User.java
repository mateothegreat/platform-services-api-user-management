

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

@Entity
@Table(name = "user")
public class User extends BaseEntity {
    
    private int parent_id;
    
    private String username;
    private String password;
    
    private int status;
    
    private String email;
    
    public int getParent_id() {
        
        return parent_id;
    }
    
    public void setParent_id(int parent_id) {
        
        this.parent_id = parent_id;
    }
    
    public String getUsername() {
        
        return username;
    }
    
    public void setUsername(String username) {
        
        this.username = username;
    }
    
    public String getPassword() {
        
        return password;
    }
    
    public void setPassword(String password) {
        
        this.password = password;
    }
    
    public int getStatus() {
        
        return status;
    }
    
    public void setStatus(int status) {
        
        this.status = status;
    }
    
    public String getEmail() {
        
        return email;
    }
    
    public void setEmail(String email) {
        
        this.email = email;
    }
    
}
