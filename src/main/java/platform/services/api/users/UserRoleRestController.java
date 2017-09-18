package platform.services.api.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import platform.services.api.commons.controller.BaseRestController;

@RestController
@RequestMapping("/userrole")
public class UserRoleRestController extends BaseRestController<UserRole> {

    private final UserRoleService service;

    @Autowired public UserRoleRestController(final UserRoleService service) {

        this.service = service;

    }

}
