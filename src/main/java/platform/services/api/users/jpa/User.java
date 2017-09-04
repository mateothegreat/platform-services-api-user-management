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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import platform.services.api.common.jpa.entities.BaseEntity;
import platform.services.api.common.security.SecurityCryptor;
import platform.services.api.common.utilities.Tracing;

@Entity
@Table(name = "user")
public class User extends BaseEntity {

    private @NotEmpty @Email                     String email;
    private @NotEmpty @Length(min = 4, max = 32) String username;
    private @NotEmpty @Length(min = 8, max = 60) String password;
    private @NotEmpty @Range(min = 0, max = 9)   int    status;

    private static UserDetails getAuthenticationUserDetails() {

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

    /**
     * https://stackoverflow.com/questions/5393803/can-someone-explain-how-bcrypt-verifies-a-hash/10933491#10933491
     * <p>
     * LEFT: User@1f172892[ parent_id=0 username=user1 password=$2a$10$pycCLgy/EJLM2Dkl921dnOdOBL7WGkbShrp7t1bBAiykVTR9IXvNa status=1 email=user1@user1.com
     * id=264 ], RIGHT: User@57a667c8[ parent_id=0 username=user1 password=$2a$10$HqGOkQh20j.xrYTdi4fqCekaImD1s8TA8MIjB/nsJZ7SuGU43sJ8q status=1
     * email=user1@user1.com id= 264 ]
     */
    public String getPassword() {

        Tracing.trace("getPassword: {} - {}", password, SecurityCryptor.encode(password));

        return SecurityCryptor.encode(password);

    }

    public void setPassword(final String password) {

        Tracing.trace("setPassword: {} - {}", password, SecurityCryptor.encode(password));

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

        return String.format("User{email='%s', username='%s', password='%s', status=%d}", email, username, password, status);

    }

}
