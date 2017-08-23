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
import com.streamingplatform.api.users.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    
    private static final Logger log = LogManager.getLogger(CustomUserDetailsService.class);
    
    @Autowired
    private final UserService UserService;
    
    @Autowired
    CustomUserDetailsService(UserService UserService) {
        
        log.trace("CustomUserDetailsService");
        
        this.UserService = UserService;
    }
    
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        log.trace("loadUserByUsername: {}", username);
        
        User user = UserService.getUserByUsername(username);
        
        if(user == null) {
            
            throw new UsernameNotFoundException(username);
            
        }
        
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        List<String>           permissions        = UserService.getPermissions(user.getUsername());
        
        for(String permission : permissions) {
            
            log.trace("loadUserByUsername->grantedAuthorities.add: {}", permission);
            
            grantedAuthorities.add(new SimpleGrantedAuthority(permission));
            
        }
        
        return new CustomUserDetails(user, grantedAuthorities);
        
    }
    
}
