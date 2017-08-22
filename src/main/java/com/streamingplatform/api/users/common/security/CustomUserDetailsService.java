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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@EnableJpaRepositories
public class CustomUserDetailsService implements UserDetailsService {
    
    @Autowired
    private final UserService userService;
    
    @Autowired
    CustomUserDetailsService(UserService userService) {
        
        this.userService = userService;
    }
    
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        User user = userService.getUserByUsername(username);
        
        if(user == null) {
            
            throw new UsernameNotFoundException(username);
            
        }
        
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        List<String>           permissions        = userService.getPermissions(user.getLogin());
        
        for(String permission : permissions) {
            
            grantedAuthorities.add(new SimpleGrantedAuthority(permission));
            
        }
        
        return new CustomUserDetails(user, grantedAuthorities);
        
    }
    
}
