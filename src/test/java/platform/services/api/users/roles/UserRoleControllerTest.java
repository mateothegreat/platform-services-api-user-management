package platform.services.api.users.roles;

import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import platform.services.api.commons.testing.BaseControllerTestCase;
import platform.services.api.commons.validation.ConstraintPatterns;
import platform.services.api.users.UserAuthenticationFixtures;
import platform.services.api.users.UserCompositeGenerator;

@BaseControllerTestCase
public final class UserRoleControllerTest extends UserAuthenticationFixtures<UserRole> {

    private static final String PATH_BASE = String.format("/users/%s/roles", ConstraintPatterns.wrap("parent_uuid", ConstraintPatterns.PATTERN_UUID));

    private final UserCompositeGenerator userCompositeGenerator;

    @Autowired
    public UserRoleControllerTest(final UserCompositeGenerator userCompositeGenerator) {

        super(UserCompositeGenerator::userRoleFixture, UserRole.class, PATH_BASE, userCompositeGenerator);

        this.setPathBase(uriComponents().getPath());

        this.userCompositeGenerator = userCompositeGenerator;

    }

    public UriComponents uriComponents() {

        return UriComponentsBuilder.fromUriString(PATH_BASE)
                                   .build()
                                   .expand(ImmutableMap.of("parent_uuid", getUserFixture().getUuid().toString()));

    }

    @Override public void generateFixture() {

        setFixture(getFn().create());

    }

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
