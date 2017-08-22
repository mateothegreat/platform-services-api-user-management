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

package com.streamingplatform.api.users.common.security;

import com.streamingplatform.api.users.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {
    
    private User                   user;
    private List<GrantedAuthority> authorities;
    
    public CustomUserDetails(User user, List<GrantedAuthority> authorities) {
        
        this.user = user;
        this.authorities = authorities;
    }
    
    public User getUser() {
        
        return user;
    }
    
    public void setUser(User user) {
        
        this.user = user;
    }
    
    @Override
    public String getPassword() {
        
        return user.getPassword();
    }
    
    @Override
    public String getUsername() {
        
        return user.getLogin();
    }
    
    @Override
    public boolean isAccountNonExpired() {
        
        return true;
    }
    
    @Override
    public boolean isAccountNonLocked() {
        
        return true;
    }
    
    @Override
    public boolean isCredentialsNonExpired() {
        
        return true;
    }
    
    @Override
    public boolean isEnabled() {
        
        return true;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        
        return authorities;
        
    }
    
}
