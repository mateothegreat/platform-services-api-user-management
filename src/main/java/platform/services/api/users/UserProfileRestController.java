package platform.services.api.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import platform.services.api.commons.controller.BaseRestController;

@RestController
@RequestMapping("/profile")
public class UserProfileRestController extends BaseRestController<UserProfile> {

    private final UserProfileService service;

    @Autowired public UserProfileRestController(final UserProfileService service) {

        super(service);

        this.service = service;

    }





}
