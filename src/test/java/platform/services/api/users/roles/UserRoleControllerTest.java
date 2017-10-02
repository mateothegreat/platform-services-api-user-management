package platform.services.api.users.roles;

import org.springframework.beans.factory.annotation.Autowired;

import org.junit.jupiter.api.*;

import platform.services.api.commons.testing.BaseControllerTestCase;
import platform.services.api.commons.validation.ConstraintPatterns;
import platform.services.api.organizations.Organization;
import platform.services.api.users.User;
import platform.services.api.users.UserAuthenticationTestSetup;
import platform.services.api.users.UserCompositeGenerator;

import static org.assertj.core.api.Assertions.assertThat;

@BaseControllerTestCase
public final class UserRoleControllerTest extends UserAuthenticationTestSetup<UserRole> {

    private static final String PATH_BASE = String.format("/users/%s/roles", ConstraintPatterns.wrap("parent_uuid", ConstraintPatterns.PATTERN_UUID));

    @Autowired
    public UserRoleControllerTest(final UserCompositeGenerator userCompositeGenerator) {

        super(UserCompositeGenerator::userRoleFixture, UserRole.class, PATH_BASE, userCompositeGenerator);

    }

    @BeforeEach
    public void beforeEach() {

        final Organization organizationFixture = Organization.create();
        final Organization organizationEntity  = create_custom_expecting_201_CREATED("/organizations", organizationFixture, Organization.class);
        final User         userFixture         = UserCompositeGenerator.userFixture().setOrganization(organizationEntity);
        final User         userEntity          = create_custom_expecting_201_CREATED("/users", userFixture, User.class);

        assertThat(userEntity.getOrganization().getId()).isNotZero();

        setPathBase(String.format("/users/%s/roles", userEntity.getUuid()));

        generateFixture();

        setEntity(create_expecting_201_CREATED(getFixture()));

    }

//    @Override public void generateFixture() {
//
//        setFixture(getFn().create());
//
//    }

//    @Test
//    void httpGetAndhasRoleAdmin() {
//
//        RestAssuredFactory.request(PATH_BASE).get(Role.ROLE_ADMIN.name()).then().statusCode(HttpStatus.OK.value());
//
//    }
//
//    @Test
//    void httpGetAndhasRoleUser() {
//
//        RestAssuredFactory.request(PATH_BASE).get(Role.ROLE_USER.name()).then().statusCode(HttpStatus.OK.value());
//
//    }
//
//    @Test
//    void httpGetAndhasRoleEmpty() {
//
//        RestAssuredFactory.request(PATH_BASE).get(Role.ROLE_EMPTY.name()).then().statusCode(HttpStatus.FORBIDDEN.value());
//
//    }

}
