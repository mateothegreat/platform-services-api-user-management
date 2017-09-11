package platform.services.api.commons.audit;

import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

import org.springframework.security.core.userdetails.User;


@Log4j2
public class AuditorAwareable implements AuditorAware<String> {

    public Optional<String> getCurrentAuditor() {

        final Authentication authentication = SecurityContextHolder.getContext()
                                                                   .getAuthentication();

        if(authentication == null || !authentication.isAuthenticated()) {

            return Optional.empty();

        }

        final String username = ((User) authentication.getPrincipal()).getUsername();

//        final User user = principal.getUser();

        log.trace("getCurrentAuditor(): {}", username);;

        return Optional.ofNullable(username);

    }

}
