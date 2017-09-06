package platform.services.api.common.authentication;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.Assert;

import platform.services.api.users.jpa.User;

@Log4j2
public class Authenticated {

    public static void runAs(final String username, final String password, final String... roles) {

        Assert.notNull(username, "Username must not be null!");
        Assert.notNull(password, "Password must not be null!");

        log.trace("runAs(String username, String password, String... roles): {}, {}, {}", username, password, roles);

        SecurityContextHolder.getContext()
                             .setAuthentication(
                                     new UsernamePasswordAuthenticationToken(username, password,
                                             AuthorityUtils.createAuthorityList(roles)));

    }

    public static User getPrincipal() {

        User user = null;

        final Authentication authentication = SecurityContextHolder.getContext()
                                                                   .getAuthentication();

        if(authentication != null) {

            final Object principal = authentication.getPrincipal();

            // principal can be "anonymousUser" (String)
//            if(principal instanceof CustomUserDetails) {

                final CustomUserDetails userDetails = (CustomUserDetails) principal;

                user = userDetails.getUser();

//            }

        }

        log.trace("getPrincipal(): {}", user.toString());

        return user;

    }

}
