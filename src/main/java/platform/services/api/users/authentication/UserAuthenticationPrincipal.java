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
    private String     username;
    private String     password;
    private Collection authorities;
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

//
//    @Override public Collection<? extends GrantedAuthority> getAuthorities() {
//
//        return this.user.getAuthorities();
//
//    }
//
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
