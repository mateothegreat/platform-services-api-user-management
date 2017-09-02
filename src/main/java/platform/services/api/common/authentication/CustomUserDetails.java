

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

package platform.services.api.common.authentication;

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
 * streaming-platform.com
 */
import platform.services.api.users.jpa.User;
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
    
    public Collection<? extends GrantedAuthority> getAuthorities() {
        
        return authorities;
        
    }
    
    @Override
    public String getPassword() {
        
        return user.getPassword();
    }
    
    @Override
    public String getUsername() {
        
        return user.getUsername();
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
    
    public void setAuthorities(final List<GrantedAuthority> authorities) {
        
        this.authorities = authorities;
    }
    
}
