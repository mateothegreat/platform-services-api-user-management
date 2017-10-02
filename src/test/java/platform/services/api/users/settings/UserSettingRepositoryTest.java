package platform.services.api.users.settings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import platform.services.api.commons.jpa.datasources.DataSourceConfig;
import platform.services.api.commons.testing.TestingSpringRepository;

@TestingSpringRepository
@SpringBootTest(classes = { DataSourceConfig.class, UserSettingRepository.class })
public class UserSettingRepositoryTest extends BaseRepositoryTest<UserSettingRepository, UserSetting> {

    @Autowired UserSettingRepositoryTest(final UserSettingRepository repository) {

        super(repository, UserSettingFixture::create, UserSetting.class);

    }

}
