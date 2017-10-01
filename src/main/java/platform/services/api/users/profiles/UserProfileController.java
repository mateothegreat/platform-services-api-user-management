package platform.services.api.users.profiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

import platform.services.api.commons.controller.BaseController;
import platform.services.api.commons.exception.ThrowableResponseEntity;
import platform.services.api.commons.validation.ValidationError;

@RestController
@Transactional
@RequestMapping("/users/{root_uuid:^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$}/profiles")
public class UserProfileController extends BaseController<UserProfileService, UserProfileRepository, UserProfile> {

    private final UserProfileService service;

    @Autowired public UserProfileController(final UserProfileService service) {

        super(service);

        this.service = service;

    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    public ResponseEntity<UserProfile> postIndex(@RequestBody final UserProfile entity) throws ValidationError {

        return new ThrowableResponseEntity<>(service.save(entity), HttpStatus.CREATED);

    }


}
