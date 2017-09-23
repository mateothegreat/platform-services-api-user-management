package platform.services.api.users.authentication;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import platform.services.api.commons.exception.ThrowableResponseEntity;
import platform.services.api.users.User;
import platform.services.api.users.UserRepository;

@Log4j2
@Service
public class UserAuthenticationDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserAuthenticationPrincipal loadUserByUsername(final String username) {

        final User user = new ThrowableResponseEntity<>(userRepository.getByUsername(username), HttpStatus.INTERNAL_SERVER_ERROR).getBody();

        return new UserAuthenticationPrincipal(user.getUsername(), user.getPasswordNotEncrypted(), user.getRoles());

    }

}
