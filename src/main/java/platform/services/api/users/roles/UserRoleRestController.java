package platform.services.api.users.roles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import platform.services.api.commons.controller.BaseRestController;

@RestController
@RequestMapping("/userrole")
public class UserRoleRestController extends BaseRestController<UserRole> {

    private final UserRoleService service;

    @Autowired public UserRoleRestController(final UserRoleService service) {

        this.service = service;

    }

    public String hello(@AuthenticationPrincipal final UserDetails userDetails) {

        String                                 username    = userDetails.getUsername();
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        authorities
            .forEach(System.out::println);

        return "Hello World";
    }
}
