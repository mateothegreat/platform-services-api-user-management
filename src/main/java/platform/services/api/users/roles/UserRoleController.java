package platform.services.api.users.roles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import platform.services.api.commons.controller.BaseController;
import platform.services.api.users.authentication.UserAuthenticationPrincipal;

@RestController
@RepositoryRestController
@RequestMapping("/users/roles")
public class UserRoleController extends BaseController<UserRoleRepository, UserRole> {

    private final UserRoleService<UserRoleRepository, UserRole> service;

    @Autowired public UserRoleController(final UserRoleService<UserRoleRepository, UserRole> service) {

        super(service, "role");

        this.service = service;

    }


}
