package platform.services.api.users.settings;

import org.springframework.beans.factory.annotation.Autowired;

import platform.services.api.commons.testing.BaseServiceTest;
import platform.services.api.commons.testing.TestingSpringService;

@TestingSpringService
public class UserSettingServiceTest extends BaseServiceTest<UserSettingService, UserSettingRepository, UserSetting> {

    private final UserSettingService service;

    @Autowired
    public UserSettingServiceTest(final UserSettingService service) {

        super(service, UserSettingFixture::create, UserSetting.class);

        this.service = service;

    }

}
