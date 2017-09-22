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

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

import platform.services.api.commons.jpa.entities.BaseEntity;
import platform.services.api.commons.security.SecurityCryptor;
import platform.services.api.users.profiles.UserProfile;
import platform.services.api.users.roles.UserRole;

@Access(AccessType.FIELD)
@DynamicUpdate
@Entity @Getter @Setter
@Table(name = "user",
       indexes = @Index(name = "idx_login",
                        columnList = "username, password, status"))
public class User extends BaseEntity {

    public static final int USERNAME_LENGTH_MIN = 4;
    public static final int USERNAME_LENGTH_MAX = 32;
    public static final int PASSWORD_LEGNTH_MIN = 8;
    public static final int PASSWORD_LEGNTH_MAX = 60;

    @OneToMany(cascade = javax.persistence.CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "parentId")
    @Column(updatable = false, nullable = false)
    public Set<UserRole> roles = new HashSet<>(0);

    @OneToMany(cascade = javax.persistence.CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "parentId")
    @Column(updatable = false, nullable = false)
    public Set<UserProfile> profiles = new HashSet<>(0);

    private static final long serialVersionUID = -5533099429327139558L;

    @Column(unique = true)
    @Email(message = "validation.email.message")
    private String email;

    @Column(updatable = false, nullable = false)
    @Length(min = USERNAME_LENGTH_MIN, max = USERNAME_LENGTH_MAX, message = "validation.username.length.message")
    private String username;

    @JsonIgnore
    @Basic(fetch = FetchType.LAZY)
    @Column(insertable = true, updatable = false, nullable = false)
    @Length(min = PASSWORD_LEGNTH_MIN, max = PASSWORD_LEGNTH_MAX, message = "validation.password.length.message")
    private String password;

    @JsonIgnore
    @Transient
    private String passwordNotEncrypted;

    /**
     * asdfasdf = $2a$10$3Q3s0j.kgXqr6a7hKQgeHekRdQ3uijJuy0BcFebj4dOcBkA0so/Qi
     *
     * @return String encoded password
     *
     * @author yomateod
     */
    public String getPassword() {

        return SecurityCryptor.encode(password);

    }

    public void setPassword(final String password) {

        this.password = SecurityCryptor.encode(password);

    }

}
