package platform.services.api.organizations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import platform.services.api.commons.controller.BaseController;

@Controller
@RequestMapping("/organizations")
public class OrganizationController extends BaseController<OrganizationService, OrganizationRepository, Organization> {

    public static final String PATH_BASE = "/organizations";

    private final OrganizationService service;

    @Autowired
    public OrganizationController(final OrganizationService service) {

        super(service);

        this.service = service;

    }

}
