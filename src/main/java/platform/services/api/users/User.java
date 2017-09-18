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

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.Set;

import platform.services.api.commons.jpa.entities.BaseEntity;
import platform.services.api.commons.security.SecurityCryptor;

@Entity @Getter @Setter
@Table(name = "user")
public class User extends BaseEntity {

    public static final int USERNAME_LENGTH_MIN = 4;
    public static final int USERNAME_LENGTH_MAX = 32;
    public static final int PASSWORD_LEGNTH_MIN = 8;
    public static final int PASSWORD_LEGNTH_MAX = 60;

    //    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    @ElementCollection(fetch = FetchType.EAGER)
//    @OneToMany(mappedBy = "userRole", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @OneToMany(mappedBy = "id")
//    @OneToMany
//    @JoinColumn(name = "USER_ROLE_ID", referencedColumnName = "id")
    @OneToMany(cascade = javax.persistence.CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "parentId")
    public Set<UserRole> roles;

    @OneToMany(cascade = javax.persistence.CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "parentId")
    public Set<UserProfile> profiles;


    //    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//    @JoinColumn(name = "parentId", referencedColumnName = "parentId")
//    @JoinColumn(name = "pId", referencedColumnName = "parentId", insertable = false, updatable = false)
//    @RestResource(path = "userProfile", rel="profile")
//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
//    @OneToOne(cascade = CascadeType.ALL)
//    @OneToOne
//    @JoinColumn(name = "PROFILE_ID")
//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//    @OneToOne
//    @JoinColumn(name = "profileId")
//    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
//    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//    @JoinColumn(name = "parentId")
//    @OneToOne(optional=false, mappedBy="user",cascade = CascadeType.ALL)
//    @JoinColumn(name = "parentId", insertable = false, updatable = false)
//    @OneToOne(cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn(name="OWNER_ID", referencedColumnName="id")
//    @JoinColumn(name = "parentId", insertable = false, updatable = false, referencedColumnName = "id")
//    @OneToOne
////    @PrimaryKeyJoinColumn
//    @JoinColumn(name = "parentId", insertable = false, updatable = false, referencedColumnName = "id")
//    @Cascade({ CascadeType.ALL, CascadeType.DELETE_ORPHAN })
//    @OneToOne(cascade={javax.persistence.CascadeType.ALL})
//    @JoinColumn(name = "id", insertable = false, updatable = false)
//    @OneToOne(cascade={javax.persistence.CascadeType.ALL}, optional = false)
//    @OneToOne(mappedBy = "user", cascade = javax.persistence.CascadeType.ALL, optional = false, orphanRemoval = true, fetch = FetchType.LAZY)
//    @OneToOne @MapsId
//    @OneToOne(
//        mappedBy = "user",
//        cascade = javax.persistence.CascadeType.ALL,
//        orphanRemoval = true,
//        fetch = FetchType.EAGER
//    )
//    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user")
////    @OneToOne(cascade={javax.persistence.CascadeType.ALL})
//    @JoinColumn(name = "userId")
//    private UserProfile profile;

    private static final long serialVersionUID = -5533099429327139558L;

    @Column(unique = true) @NotEmpty @Email
    private String email;

    @NotEmpty @Length(min = USERNAME_LENGTH_MIN, max = USERNAME_LENGTH_MAX)
    private String username;

    @NotEmpty @Length(min = PASSWORD_LEGNTH_MIN, max = PASSWORD_LEGNTH_MAX)
    private String password;

    public String getPassword() {

        return SecurityCryptor.encode(password);

    }

    public void setPassword(final String password) {

        this.password = SecurityCryptor.encode(password);

    }

}
