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

package com.streamingplatform.api.users.common.domain;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class AbstractDomainClass implements DomainObject {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Version
    private int version;
    
    private Date dateCreated;
    private Date lastUpdated;
    
    @Override
    public int getId() {
        
        return this.id;
        
    }
    
    @Override
    public void setId(int id) {
        
        this.id = id;
        
    }
    
    public Integer getVersion() {
        
        return version;
        
    }
    
    public void setVersion(Integer version) {
        
        this.version = version;
        
    }
    
    public Date getDateCreated() {
        
        return dateCreated;
        
    }
    
    public Date getLastUpdated() {
        
        return lastUpdated;
        
    }
    
    @PreUpdate
    @PrePersist
    public void updateTimeStamps() {
        
        lastUpdated = new Date();
        
        if(dateCreated == null) {
            
            dateCreated = new Date();
            
        }
        
    }
    
}
