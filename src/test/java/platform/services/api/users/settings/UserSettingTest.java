package platform.services.api.users.settings;

import org.junit.jupiter.api.*;

import platform.services.api.commons.testing.BaseEntityTest;
import platform.services.api.commons.testing.TestingSpringEntity;

@TestingSpringEntity
public class UserSettingTest extends BaseEntityTest<UserSetting> {

    @BeforeEach public void beforeEach() {

        baseEntity = UserSettingFixture.create();

        super.beforeEach();

    }

}
