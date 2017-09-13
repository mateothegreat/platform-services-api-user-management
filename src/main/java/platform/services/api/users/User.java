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

package platform.services.api.users;

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
 * streaming-main.platform.com
 */

import lombok.ToString;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import platform.services.api.commons.jpa.BaseEntity;
import platform.services.api.commons.security.SecurityCryptor;

@ToString
@Entity
@Table(name = "user")
public class User extends BaseEntity {

    public static final int USERNAME_LENGTH_MIN = 4;
    public static final int USERNAME_LENGTH_MAX = 32;
    public static final int PASSWORD_LEGNTH_MIN = 8;
    public static final int PASSWORD_LEGNTH_MAX = 60;

    @Column(unique = true) @NotEmpty @Email
    private String email;

    @NotEmpty @Length(min = USERNAME_LENGTH_MIN, max = USERNAME_LENGTH_MAX)
    private String username;

    //    @NotEmpty @Length(min = PASSWORD_LEGNTH_MIN, max = PASSWORD_LEGNTH_MAX)
    private String password;

    @NotNull @Range(min = 1L, max = 200L)
//    @NotNull @Range(min = BaseEntity.STATUS_RANGE_MIN, max = BaseEntity.STATUS_RANGE_MAX)
    private Long status;

    public String getEmail() {

        return email;
    }

    public void setEmail(final String email) {

        this.email = email;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(final String username) {

        this.username = username;
    }

    public Long getStatus() {

        return status;
    }

    public void setStatus(final Long status) {

        this.status = status;
    }

    public String getPassword() {

        return SecurityCryptor.encode(password);

    }

    public void setPassword(final String password) {

        this.password = SecurityCryptor.encode(password);

    }

}
