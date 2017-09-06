package platform.services.api.common.audit;

import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Log4j2
public class UsernameAuditorAware implements AuditorAware<String> {

    protected static final String ANONYMOUS_USERNAME = "anonymous";
    protected static final String TESTGUY_USERNAME   = "testguy";

    @Override
    public Optional<String> getCurrentAuditor() {

        log.debug("Getting the username of authenticated user.");

        Authentication authentication = SecurityContextHolder.getContext()
                                                             .getAuthentication();

        if(authentication == null) {

            // in testing mode, return admin
            return Optional.ofNullable(TESTGUY_USERNAME);

        }

        if(authentication.getPrincipal()
                         .equals("anonymousUser")) {

            log.debug("Current user is anonymous.");

            return Optional.ofNullable(ANONYMOUS_USERNAME);

        }

        String username = ((CurrentUser) authentication.getPrincipal()).getUsername();

        log.debug("Returning username: {}", username);

        return Optional.ofNullable(username);

    }

}
