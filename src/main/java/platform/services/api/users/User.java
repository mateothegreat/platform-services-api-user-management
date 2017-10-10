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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.util.HashSet;
import java.util.Set;

import platform.services.api.commons.enums.Status;
import platform.services.api.commons.jpa.entities.BaseEntity;
import platform.services.api.commons.security.SecurityCryptor;
import platform.services.api.commons.utilities.Randomizers;
import platform.services.api.commons.validation.ConstraintPatterns;
import platform.services.api.organizations.Organization;
import platform.services.api.users.profiles.UserProfile;
import platform.services.api.users.roles.UserRole;
import platform.services.api.users.settings.UserSetting;

//@Access(AccessType.FIELD)
//@DynamicUpdate
@Entity @Getter @Setter

@Table(name = "user",
       indexes = @Index(name = "idx_login",
                        columnList = "username, password, status"))
@Transactional
public class User extends BaseEntity<User> {

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JsonBackReference @JsonIgnore
    private Organization organization;

    @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private Set<UserRole> roles = new HashSet<>(0);

    @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private Set<UserProfile> profiles = new HashSet<>(0);

    @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private Set<UserSetting> settings = new HashSet<>(0);

    @Column(unique = true) @Email(message = "validation.email.message")
    private String email;

    @Column(unique = true, updatable = false, nullable = false)
    @Length(min = ConstraintPatterns.CONSTRAINT_USERNAME_LENGTH_MIN, max = ConstraintPatterns.CONSTRAINT_USERNAME_LENGTH_MAX, message = "validation.username.length.message")
    private String username;

    //    @JsonIgnore
//    @Basic(fetch = FetchType.LAZY)
    @Column(insertable = true, updatable = false, nullable = false)
//    @Length(min = ConstraintPatterns.CONSTRAINT_PASSWORD_LEGNTH_MIN, max = ConstraintPatterns.CONSTRAINT_PASSWORD_LEGNTH_MAX, message = "validation.password.length.message")
    private String password;

    @JsonIgnore
    @Transient
    private String passwordNotEncrypted;

    public User() {

    }
    public static User create() {

        return new User().setUsername(Randomizers.username())
                         .setPasswordNotEncrypted(Randomizers.password())
                         .setEmail(Randomizers.email())
                         .setStatus(Status.ACTIVE_TESTING);

    }

    public User setEmail(final String email) {

        this.email = email;

        return this;

    }
    public User setPasswordNotEncrypted(final String passwordNotEncrypted) {

        setPassword(passwordNotEncrypted);

        this.passwordNotEncrypted = passwordNotEncrypted;

        return this;

    }
    public User setUsername(final String username) {

        this.username = username;

        return this;

    }
    public String getPassword() {
        /*
         * asdfasdf = $2a$10$3Q3s0j.kgXqr6a7hKQgeHekRdQ3uijJuy0BcFebj4dOcBkA0so/Qi
         *
         * @return String encoded password
         *
         * @author yomateod
         */

        return SecurityCryptor.encode(password);

    }
    public User setPassword(final String password) {

        this.password = SecurityCryptor.encode(password);

        return this;

    }
    public User addRole(final UserRole role) {

//        role.setParentId(this.getId());

        this.roles.add(role);

        return this;

    }
    public User addProfile(final UserProfile profile) {

//        profile.setParentId(this.getId());

        this.profiles.add(profile);

        return this;

    }
    public User setRoles(final Set<UserRole> roles) {

        this.roles = roles;

        return this;

    }
    public User setProfiles(final Set<UserProfile> profiles) {

        this.profiles = profiles;

        return this;

    }
    public User setOrganization(final Organization organization) {

        this.organization = organization;

        return this;

    }

}
