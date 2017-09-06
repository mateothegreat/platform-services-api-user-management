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

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
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

@Log4j2
//@Audited
@Entity
@Getter @Setter @ToString
@Table(name = "user")
//public class User extends BaseEntity {
public class User extends BaseEntity<String> {

    public static final int USERNAME_LENGTH_MIN = 4;
    public static final int USERNAME_LENGTH_MAX = 32;
    public static final int PASSWORD_LEGNTH_MIN = 8;
    public static final int PASSWORD_LEGNTH_MAX = 60;

    @Column(unique = true) @NotEmpty @Email
    private String email;

    @NotEmpty @Length(min = USERNAME_LENGTH_MIN, max = USERNAME_LENGTH_MAX)
    private String username;

    @NotEmpty @Length(min = PASSWORD_LEGNTH_MIN, max = PASSWORD_LEGNTH_MAX)
    private String password;

    @NotNull @Range(min = 1L, max = 200L)
//    @NotNull @Range(min = BaseEntity.STATUS_RANGE_MIN, max = BaseEntity.STATUS_RANGE_MAX)
    private Long status;

//    public User() {
//
//    }

//    public User(@NotEmpty @Email final String email, @NotEmpty @Length(min = 4, max = 32) final String username, @NotEmpty @Length(min = 8, max = 60) final String password, @NotNull @Range(min = 0, max = 9) final Long status) {
//
//        this.email = email;
//        this.username = username;
//        this.password = password;
//        this.status = status;
//
//    }

    @Nullable
    public static UserDetails getAuthenticationUserDetails() {

        final Authentication authentication = SecurityContextHolder.getContext()
                                                                   .getAuthentication();

        if(authentication == null || !authentication.isAuthenticated()) {

            return null;

        }

        return (UserDetails) authentication.getPrincipal();

    }

    public String getPassword() {

        return SecurityCryptor.encode(password);

    }

    public void setPassword(final String password) {

        this.password = SecurityCryptor.encode(password);

    }

}
