package platform.services.api.users.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import platform.services.api.users.User;
import platform.services.api.users.UserService;

@Service
public class AuthenticatedUser {

    @Autowired
    private UserAuthenticationDetailsService detailsService;

    @Autowired
    UserService userService;

    public UserAuthenticationPrincipal getUserDetails() {

        return detailsService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

    }

    public User getUser() {

        return userService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

    }

}
