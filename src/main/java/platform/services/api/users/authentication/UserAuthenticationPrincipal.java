/**
 * ====
 *     Copyright 2017 Pivotal Software, Inc.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 * ====
 *
 * Copyright 2017 Pivotal Software, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package platform.services.api.users.authentication;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Getter @Setter @ToString
public class UserAuthenticationPrincipal implements UserDetails {

    private static final long serialVersionUID = -2303028515734000689L;
    private String                                 username;
    private String                                 password;
    private Collection                             authorities;
//    private Collection<? extends GrantedAuthority> authorities;

//    public UserAuthenticationPrincipal(final @NotEmpty String username, final String encrypted, final Set<UserRole> roles) {
//
//        this.username = username;
//        this.password = encrypted;
//        this.authorities = roles;
//
//    }

    public UserAuthenticationPrincipal(final @NotEmpty String username, final String encrypted, final Collection roles) {

        this.username = username;
        this.password = encrypted;
        this.authorities = roles;

    }

    @Override public boolean isAccountNonExpired() {

        return true;

    }

    @Override public boolean isAccountNonLocked() {

        return true;

    }

    @Override public boolean isCredentialsNonExpired() {

        return true;

    }

    @Override public boolean isEnabled() {

        return true;

    }


    @Override public Collection  getAuthorities() {

        return this.authorities;

    }

//    @Override public String getPassword() {
//
//        return this.user.getPassword();
//
//    }
//
//    @Override public String getUsername() {
//
//        return this.user.getUsername();
//
//    }
//
//    @Override public boolean isAccountNonExpired() {
//
//        return this.user.isAccountNonExpired();
//
//    }
//
//    @Override public boolean isAccountNonLocked() {
//
//        return this.user.isAccountNonLocked();
//
//    }
//
//    @Override public boolean isCredentialsNonExpired() {
//
//        return this.user.isCredentialsNonExpired();
//
//    }
//
//    @Override public boolean isEnabled() {
//
//        return this.user.isEnabled();
//
//    }
//
//    @Override public String getName() {
//
//        return this.user.getUsername();
//
//    }

}
