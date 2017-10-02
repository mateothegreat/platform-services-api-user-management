

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

package platform.services.api.users.roles;

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

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import platform.services.api.commons.enums.Role;
import platform.services.api.commons.jpa.entities.BaseEntity;
import platform.services.api.users.User;

@Entity @Getter @Setter
@Table(name = "user_roles")
public class UserRole extends BaseEntity<UserRole> {

//    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "parentId")
    private User user;

    public UserRole setUser(final User user) {

        this.user = user;

        return this;

    }
//    @NotNull
//    @Range(min = 0L, max = 4294967295L)
//    protected Long parentId = 0L;

    public UserRole() {

    }

    public UserRole(final Role role) {

        this.role = role;

    }


    public UserRole setRole(final Role role) {

        this.role = role;

        return this;

    }

    @Override public String toString() {

        return String.format("platform.services.api.users.roles.UserRole{role=%s, user=%s} %s", role, user, super.toString());
    }

    public static UserRole create() {

        final UserRole fixture = new UserRole();

        fixture.setRole(Role.ROLE_USER);

        return fixture;

    }
}

