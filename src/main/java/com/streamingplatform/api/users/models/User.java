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

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long    id;
    private Integer parentId;

    private String  username;
    private String  password;
    private Integer status;

    public User() {}

    public User(Integer parentId, String username, String password, Integer status) {

        this.parentId = parentId;
        this.username = username;
        this.password = password;
        this.status = status;

    }

    @Override
    public String toString() {

        return "User{" +
            "id=" + id +
            ", parentId=" + parentId +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", status=" + status +
            '}';
    }

    public Long getId() {

        return id;

    }

    public void setId(Long id) {

        this.id = id;

    }

    public Integer getParentId() {

        return parentId;
    }

    public void setParentId(Integer parentId) {

        this.parentId = parentId;

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

    public Integer getStatus() {

        return status;

    }

    public void setStatus(Integer status) {

        this.status = status;

    }

}
