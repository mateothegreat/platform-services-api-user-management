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

package platform.services.api.users.jpa;

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

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.lang.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.text.MessageFormat;

import platform.services.api.common.jpa.entities.BaseEntity;
import platform.services.api.common.security.SecurityCryptor;

@Entity
@Table(name = "user")
public class User extends BaseEntity {

    @Column(unique = true) private @NotEmpty @Email String email;

    private @NotEmpty @Length(min = 4, max = 32) String username;
    private @NotEmpty @Length(min = 8, max = 60) String password;
    private @NotNull @Range(min = 0, max = 9)    int    status;

//    @JsonCreator
//    public User(@JsonProperty("email") String email,
//                @JsonProperty("username") String username,
//                @JsonProperty("password") String password,
//                @JsonProperty("status") int status) {
//
//        this.email = email;
//        this.username = username;
//        this.password = password;
//        this.status = status;
//    }

    public User() {

    }

    @Nullable
    public static UserDetails getAuthenticationUserDetails() {

        final Authentication authentication = SecurityContextHolder.getContext()
                                                                   .getAuthentication();

        if(authentication == null || !authentication.isAuthenticated()) {

            return null;

        }

        return (UserDetails) authentication.getPrincipal();

    }

    public String getUsername() {

        return username;

    }

    public void setUsername(final String username) {

        this.username = username;
    }

    public String getPassword() {

        return SecurityCryptor.encode(password);

    }

    public void setPassword(final String password) {

        this.password = SecurityCryptor.encode(password);

    }

    public int getStatus() {

        return status;
    }

    public void setStatus(final int status) {

        this.status = status;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(final String email) {

        this.email = email;
    }

    @Override public String toString() {

        return MessageFormat.format("User'{'email=''{0}'', username=''{1}'', password=''{2}'', status={3}, id={4}, parentId={5}'}'",
                email,
                username,
                password,
                status, id,
                parentId);
    }

}
