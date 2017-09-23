package platform.services.api.users.roles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import platform.services.api.commons.controller.BaseController;
import platform.services.api.commons.enums.Role;
import platform.services.api.users.authentication.AuthenticatedUser;
import platform.services.api.users.profiles.UserProfile;
import platform.services.api.users.profiles.UserProfileRepository;

@RestController
@RequestMapping("/users/roles")
public class UserRoleController extends BaseController<UserRoleRepository, UserRole, Long> {

    private final UserRoleService service;

    @Autowired
    private AuthenticatedUser authenticatedUser;

    @Autowired public UserRoleController(final UserRoleService service) {

        super(service, "role");

        this.service = service;

    }

    @RequestMapping(value = "/check/{role:ROLE_USER}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<?> httpGetAndhasRoleUser(@PathVariable final Role role) {

        return new ResponseEntity<>(authenticatedUser.getUser(), HttpStatus.OK);

    }

    @RequestMapping(value = "/check/{role:ROLE_ADMIN}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> httpGethasRoleAdmin(@PathVariable final Role role) {

        return new ResponseEntity<>(authenticatedUser.getUser(), HttpStatus.OK);

    }

    @RequestMapping(value = "/check/{role:ROLE_EMPTY}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_EMPTY')")
    public ResponseEntity<?> httpGethasRoleEmpty(@PathVariable final Role role) {

        return new ResponseEntity<>(authenticatedUser.getUser(), HttpStatus.OK);

    }

}
