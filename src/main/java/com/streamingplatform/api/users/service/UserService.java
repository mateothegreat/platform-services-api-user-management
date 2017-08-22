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

package com.streamingplatform.api.users.service;

import com.streamingplatform.api.users.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    
    public Page<User> findAll(Pageable pageable);
    
    public User getUserByUsername(String username);
    
    public User getUserByEmail(String email);
    
    public void saveUser(User user);
    
    List<String> getPermissions(String username);
    
    User getCurrentUser();
    
    Boolean isCurrentUserLoggedIn();
    
}
