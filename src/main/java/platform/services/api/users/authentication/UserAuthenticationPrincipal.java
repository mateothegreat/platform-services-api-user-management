package platform.services.api.users.authentication;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

import platform.services.api.users.User;

public class UserAuthenticationPrincipal implements UserDetails {

    private static final long serialVersionUID = -2303028515734000689L;

    private final User user;

    public UserAuthenticationPrincipal(final User user) {

        this.user = user;

    }

    @Override public Collection<? extends GrantedAuthority> getAuthorities() {

        return this.user.getAuthorities();

    }

    @Override public String getPassword() {

        return this.user.getPassword();

    }

    @Override public String getUsername() {

        return this.user.getUsername();

    }

    @Override public boolean isAccountNonExpired() {

        return this.user.isAccountNonExpired();

    }

    @Override public boolean isAccountNonLocked() {

        return this.user.isAccountNonLocked();

    }

    @Override public boolean isCredentialsNonExpired() {

        return this.user.isCredentialsNonExpired();

    }

    @Override public boolean isEnabled() {

        return this.user.isEnabled();

    }

    @Override public String getName() {

        return this.user.getName();

    }

}
