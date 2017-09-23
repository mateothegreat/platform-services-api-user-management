package platform.services.api.users.profiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import platform.services.api.commons.controller.BaseController;

@RestController
@RequestMapping("/profiles")
public class UserProfileController extends BaseController<UserProfileRepository, UserProfile, Long> {

    private final UserProfileService service;

    @Autowired public UserProfileController(final UserProfileService service) {

        super(service, "profile");

        this.service = service;

    }

}
