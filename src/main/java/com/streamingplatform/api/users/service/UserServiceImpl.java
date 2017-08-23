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
import com.streamingplatform.api.users.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public Page<User> findAll(Pageable pageable) {
        
        return userRepository.findAll(pageable);
        
    }
    
    @Override
    public User getUserByUsername(String username) {
        
        return userRepository.getUserByUsername(username);
        
    }
    
    @Override
    public User getUserByEmail(String email) {
        
        User user = userRepository.getUserByEmail(email);
        return user;
        
    }
    
    @Override
    public void saveUser(User user) {
        
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        
        //        Role userRole = roleRepository.findByRole("ADMIN");
        //        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        
        userRepository.save(user);
        
    }
    
    @Override
    public List<String> getPermissions(String username) {
        
        return new ArrayList<>();
    }
    
}
