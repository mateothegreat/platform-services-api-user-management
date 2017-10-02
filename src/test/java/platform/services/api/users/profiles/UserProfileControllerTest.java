package platform.services.api.users.profiles;

import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import platform.services.api.commons.testing.BaseControllerTestCase;
import platform.services.api.commons.validation.ConstraintPatterns;
import platform.services.api.users.UserAuthenticationTestSetup;
import platform.services.api.users.UserCompositeGenerator;

@BaseControllerTestCase
public final class UserProfileControllerTest extends UserAuthenticationTestSetup<UserProfile> {

    private static final String PATH_BASE = String.format("/users/%s/profiles", ConstraintPatterns.wrap("parent_uuid", ConstraintPatterns.PATTERN_UUID));

    private final UserCompositeGenerator userCompositeGenerator;

    @Autowired
    public UserProfileControllerTest(final UserCompositeGenerator userCompositeGenerator) {

        super(UserCompositeGenerator::userProfileFixture, UserProfile.class, PATH_BASE, userCompositeGenerator);

        this.setPathBase(uriComponents().getPath());

        this.userCompositeGenerator = userCompositeGenerator;

    }

    public UriComponents uriComponents() {

        return UriComponentsBuilder.fromUriString(PATH_BASE)
                                   .build()
                                   .expand(ImmutableMap.of("parent_uuid", getUserFixture().getUuid().toString()));

    }

}
