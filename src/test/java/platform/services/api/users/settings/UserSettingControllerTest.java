package platform.services.api.users.settings;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;

import platform.services.api.commons.testing.BaseControllerTestCase;
import platform.services.api.commons.validation.ConstraintPatterns;
import platform.services.api.organizations.Organization;
import platform.services.api.users.User;
import platform.services.api.users.UserAuthenticationTestSetup;
import platform.services.api.users.UserCompositeGenerator;

import static org.assertj.core.api.Assertions.assertThat;

@BaseControllerTestCase
public final class UserSettingControllerTest extends UserAuthenticationTestSetup<UserSetting> {

    private static final String PATH_BASE = String.format("/users/%s/settings", ConstraintPatterns.wrap("parent_uuid", ConstraintPatterns.PATTERN_UUID));

    private final UserCompositeGenerator userCompositeGenerator;

    @Autowired
    public UserSettingControllerTest(final UserCompositeGenerator userCompositeGenerator) {

        super(UserSettingFixture::create, UserSetting.class, PATH_BASE, userCompositeGenerator);

        this.userCompositeGenerator = userCompositeGenerator;

    }

    @BeforeMethod
    public void beforeEach() {

        final Organization organizationFixture = Organization.create();
        final Organization organizationEntity  = create_custom_expecting_201_CREATED("/organizations", organizationFixture, Organization.class);
        final User         userFixture         = UserCompositeGenerator.userFixture().setOrganization(organizationEntity);
        final User         userEntity          = create_custom_expecting_201_CREATED("/users", userFixture, User.class);

        assertThat(userEntity.getOrganization().getId()).isNotZero();

        setPathBase(String.format("/users/%s/settings", userEntity.getUuid()));

        generateFixture();

        setEntity(create_expecting_201_CREATED(getFixture()));

    }

}
