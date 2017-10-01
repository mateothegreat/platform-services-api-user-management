package platform.services.api.users;

import org.springframework.beans.factory.annotation.Autowired;

import org.junit.jupiter.api.*;

import javax.transaction.Transactional;

import platform.services.api.commons.testing.BaseControllerTestCase;
import platform.services.api.organizations.Organization;
import platform.services.api.streams.Stream;

@Transactional
@BaseControllerTestCase
public class UserControllerTest extends UserAuthenticationFixtures<User> {

    private static final String PATH_BASE         = "/users";

    private final UserCompositeGenerator userCompositeGenerator;

    @Autowired
    public UserControllerTest(final UserCompositeGenerator userCompositeGenerator) {

        super(UserCompositeGenerator::userFixture, User.class, PATH_BASE, userCompositeGenerator);

        this.userCompositeGenerator = userCompositeGenerator;

    }

    @BeforeEach
    public void beforeEach() {

        final Organization organizationFixture = Organization.create();
        final Organization organizationEntity = create_custom_expecting_201_CREATED("/organizations", organizationFixture, Organization.class);

        generateFixture();

        fixture.setOrganization(organizationEntity);

        setEntity(create_expecting_201_CREATED(getFixture()));

    }

}
