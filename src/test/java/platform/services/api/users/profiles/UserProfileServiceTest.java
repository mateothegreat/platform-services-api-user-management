package platform.services.api.users.profiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;

import platform.services.api.commons.testing.BaseServiceTest;
import platform.services.api.commons.testing.TestingSpringService;
import platform.services.api.users.UserCompositeGenerator;
import platform.services.api.users.authentication.Authenticate;

@TestingSpringService
public class UserProfileServiceTest extends BaseServiceTest<UserProfileService, UserProfileRepository, UserProfile> {

    private final UserProfileService service;

    @Autowired
    public UserProfileServiceTest(final UserProfileService service) {

        super(service, UserCompositeGenerator::userProfileFixture, UserProfile.class);

        this.service = service;

    }

    @BeforeMethod
    public void beforeEach() {

        Authenticate.SUDO_INTEGRATION();

        super.beforeEach();

    }

}
