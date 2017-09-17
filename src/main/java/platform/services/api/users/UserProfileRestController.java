package platform.services.api.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import platform.services.api.commons.controller.BaseRestController;

@RestController
@RequestMapping("/userprofile")
public class UserProfileRestController extends BaseRestController<UserProfile> {

    private final UserProfileService service;

    @Autowired public UserProfileRestController(final UserProfileService service) {

        this.service = service;

    }

}
