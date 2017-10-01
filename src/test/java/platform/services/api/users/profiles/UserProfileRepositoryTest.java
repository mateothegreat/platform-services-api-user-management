package platform.services.api.users.profiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import platform.services.api.commons.jpa.datasources.DataSourceConfig;
import platform.services.api.commons.testing.BaseRepositoryTest;
import platform.services.api.commons.testing.TestingSpringRepository;
import platform.services.api.users.UserCompositeGenerator;

@TestingSpringRepository
@SpringBootTest(classes = { DataSourceConfig.class, UserProfileRepository.class })
class UserProfileRepositoryTest extends BaseRepositoryTest<UserProfileRepository, UserProfile> {

    UserProfileRepositoryTest(@Autowired final UserProfileRepository repository) {

        super(repository, UserCompositeGenerator::userProfileFixture, UserProfile.class);

    }

}
