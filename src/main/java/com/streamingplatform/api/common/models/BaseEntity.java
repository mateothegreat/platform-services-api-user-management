

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

package com.streamingplatform.api.common.models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BaseEntity implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    public BaseEntity() {
    
    }
    
    public BaseEntity(Long id) {
        
        this.id = id;
        
    }
    
    public Long getId() {
        
        return id;
    }
    
    public void setId(Long id) {
        
        this.id = id;
    }
    
    // @Column(name = "createdByUser", nullable = false)
    // @CreatedBy
    // private String createdByUser;
    //
    // @Column(name = "creationTime", nullable = false)
    // @CreatedDate
    // private ZonedDateTime creationTime;
    //
    // @Column(name = "modifiedByUser", nullable = false)
    // @LastModifiedBy
    // private String modifiedByUser;
    //
    // @Column(name = "modificationTime", nullable = false)
    // @LastModifiedDate
    // private ZonedDateTime modificationTime;
    
    private String getUsernameOfAuthenticatedUser() {
        
        Authentication authentication = SecurityContextHolder.getContext()
                                                             .getAuthentication();
        
        if(authentication == null || !authentication.isAuthenticated()) {
            
            return null;
            
        }
        
        return ((User) authentication.getPrincipal()).getUsername();
        
    }
    
}
