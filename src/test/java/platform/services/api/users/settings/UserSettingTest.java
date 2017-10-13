package platform.services.api.users.settings;

import org.testng.annotations.BeforeMethod;

import platform.services.api.commons.testing.BaseEntityTest;
import platform.services.api.commons.testing.TestingSpringEntity;

@TestingSpringEntity
public class UserSettingTest extends BaseEntityTest<UserSetting> {

    @BeforeMethod public void beforeEach() {

        baseEntity = UserSettingFixture.create();

    }

}
