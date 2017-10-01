package platform.services.api.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import platform.services.api.commons.jpa.datasources.DataSourceConfig;
import platform.services.api.commons.testing.BaseRepositoryTest;
import platform.services.api.commons.testing.TestingSpringRepository;

@TestingSpringRepository
@SpringBootTest(classes = { DataSourceConfig.class, UserRepository.class })
public class UserRepositoryTest extends BaseRepositoryTest<UserRepository, User> {

    @Autowired UserRepositoryTest(final UserRepository repository) {

        super(repository, UserCompositeGenerator::userFixture, User.class);

    }

}
