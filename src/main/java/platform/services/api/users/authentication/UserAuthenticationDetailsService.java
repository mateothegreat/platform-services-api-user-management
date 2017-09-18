package platform.services.api.users.authentication;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import platform.services.api.users.User;
import platform.services.api.users.UserRestRepository;

@Log4j2
@Service
public class UserAuthenticationDetailsService implements UserDetailsService {

    @Autowired
    private UserRestRepository userRepository;

//    private final User                   user;
//    private final List<GrantedAuthority> authorities;

//    public UserAuthenticationDetailsService(final User user, final List<GrantedAuthority> authorities) {
//
//        this.user = user;
//        this.authorities = authorities;
//    }

    @Override
    public UserDetails loadUserByUsername(final String username) {

        log.fatal("loadUserByUsername: {}", username);
        final Optional<User> result = userRepository.findByUsername(username);
log.fatal(result.get());
        if(!result.isPresent()) {

            throw new UsernameNotFoundException(username);

        }

        final User user = result.get();


        return new UserAuthenticationPrincipal(user);

    }

}
