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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class LoggedInChecker {
    
    public User getLoggedInUser() {
        
        User user = null;
        
        Authentication authentication = SecurityContextHolder.getContext()
                                                             .getAuthentication();
        
        if(authentication != null) {
            
            Object principal = authentication.getPrincipal();
            
            // principal can be "anonymousUser" (String)
            if(principal instanceof CustomUserDetails) {
                
                CustomUserDetails userDetails = (CustomUserDetails) principal;
                
                user = userDetails.getUser();
                
            }
            
        }
        
        return user;
        
    }
    
}
