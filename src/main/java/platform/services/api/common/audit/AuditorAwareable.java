package platform.services.api.common.audit;

import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

@Log4j2
public class AuditorAwareable implements AuditorAware<String> {

    public Optional<String> getCurrentAuditor() {
        log.fatal("getCurrentAuditor()");
        return Optional.of("asdf");

//
//        final Authentication authentication = SecurityContextHolder.getContext()
//                                                                   .getAuthentication();
//
//        if(authentication == null || !authentication.isAuthenticated()) {
//
//            return Optional.empty();
//
//        }
//
//        final CustomUserDetails principal = (CustomUserDetails) authentication.getPrincipal();
//
//        final User user = principal.getUser();
//
//        log.error(authentication.toString());


//        return Optional.ofNullable(user);

    }

}
