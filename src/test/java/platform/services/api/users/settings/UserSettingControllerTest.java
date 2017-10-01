package platform.services.api.users.settings;

import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import platform.services.api.commons.testing.BaseControllerTestCase;
import platform.services.api.commons.validation.ConstraintPatterns;
import platform.services.api.users.UserAuthenticationFixtures;
import platform.services.api.users.UserCompositeGenerator;

@BaseControllerTestCase
public final class UserSettingControllerTest extends UserAuthenticationFixtures<UserSetting> {

    private static final String PATH_BASE = String.format("/users/%s/settings", ConstraintPatterns.wrap("parent_uuid", ConstraintPatterns.PATTERN_UUID));

    private final UserCompositeGenerator userCompositeGenerator;

    @Autowired
    public UserSettingControllerTest(final UserCompositeGenerator userCompositeGenerator) {

        super(UserSettingFixture::create, UserSetting.class, PATH_BASE, userCompositeGenerator);

        this.setPathBase(uriComponents().getPath());

        this.userCompositeGenerator = userCompositeGenerator;

    }

    public UriComponents uriComponents() {

        return UriComponentsBuilder.fromUriString(PATH_BASE)
                                   .build()
                                   .expand(ImmutableMap.of("parent_uuid", getUserFixture().getUuid().toString()));

    }

}
