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

package platform.services.api.users.entities;

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

import com.streamingplatform.api.common.entities.*;
import com.streamingplatform.api.common.utils.logging.*;
import com.streamingplatform.api.security.*;
import org.hibernate.validator.constraints.*;
import org.springframework.security.core.*;
import org.springframework.security.core.context.*;
import platform.api.common.entities.*;
import platform.api.common.utils.logging.*;
import platform.api.security.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "user")
public class User extends BaseEntity {

    @Digits(fraction = 0, integer = 10)
    private int parent_id;

    @NotEmpty
    @Length(min = 4, max = 32)
    private String username;

    @NotEmpty
    @Length(min = 8, max = 60)
    private String password;

    @NotEmpty
    @Digits(fraction = 0, integer = 1)
    private int status;

    @NotEmpty
    @Email
    private String email;

    public int getParent_id() {

        return parent_id;
    }

    public void setParent_id(int parent_id) {

        this.parent_id = parent_id;

    }

    public String getUsername() {

        return username;

    }

    public void setUsername(String username) {

        this.username = username;
    }

    /*
     * https://stackoverflow.com/questions/5393803/can-someone-explain-how-bcrypt-verifies-a-hash/10933491#10933491
     */
    public String getPassword() {

        Tracing.trace("getPassword: {} - {}", password, BCryptor.encode(password));

        return BCryptor.encode(password);

    }
//LEFT: User@1f172892[
//parent_id=0
//username=user1
//password=$2a$10$pycCLgy/EJLM2Dkl921dnOdOBL7WGkbShrp7t1bBAiykVTR9IXvNa
//status=1
//email=user1@user1.com
//        id=264
//], RIGHT: User@57a667c8[
//parent_id=0
//username=user1
//password=$2a$10$HqGOkQh20j.xrYTdi4fqCekaImD1s8TA8MIjB/nsJZ7SuGU43sJ8q
//status=1
//email=user1@user1.com
//        id= 264
//]
//    public void setPas
//username=user1
//password=$2a$10$HqGOkQh20j.xrYTdi4fqCekaImD1s8TA8MIjB/nsJZ7SuGU43sJ8q
//status=1

    public void setPassword(String password) {

        Tracing.trace("setPassword: {} - {}", password, BCryptor.encode(password));

        this.password = BCryptor.encode(password);

    }

    public int getStatus() {

        return status;
    }

    public void setStatus(int status) {

        this.status = status;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    private String getUsernameOfAuthenticatedUser() {

        Authentication authentication = SecurityContextHolder.getContext()
                                                             .getAuthentication();

        if(authentication == null || !authentication.isAuthenticated()) {

            return null;

        }

        return ((org.springframework.security.core.userdetails.User) authentication.getPrincipal()).getUsername();

    }

    @Override
    public String toString() {

        return "User{" +
                "id=" + id +
                ", parent_id=" + parent_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", email='" + email + '\'' +
                '}';
    }
}
