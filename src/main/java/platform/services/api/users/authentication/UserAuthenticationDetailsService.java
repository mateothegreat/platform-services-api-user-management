package platform.services.api.users.authentication;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

import platform.services.api.commons.exception.ServiceResultCode;
import platform.services.api.commons.exception.ServiceResultException;
import platform.services.api.users.User;
import platform.services.api.users.UserRepository;

@Log4j2
@Service
public class UserAuthenticationDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserAuthenticationPrincipal loadUserByUsername(final String username) {

        final Optional<User> result = userRepository.findByUsername(username);

        if(!result.isPresent()) {

            throw new ServiceResultException(HttpStatus.INTERNAL_SERVER_ERROR, ServiceResultCode.INTERNAL_ERROR_AUTHENTICATION_AUTHORITIES_FAILURE);

        }

        final User user = result.get();

        log.trace("loadUserByUsername: {}, {}", username, user.toString());

        return new UserAuthenticationPrincipal(user.getUsername(), user.getPasswordNotEncrypted(), user.getRoles());

    }

}
