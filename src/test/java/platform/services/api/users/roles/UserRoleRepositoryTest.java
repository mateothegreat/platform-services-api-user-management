package platform.services.api.users.roles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import platform.services.api.commons.jpa.datasources.DataSourceConfig;
import platform.services.api.commons.testing.BaseRepositoryTest;
import platform.services.api.commons.testing.TestingSpringRepository;
import platform.services.api.users.UserCompositeGenerator;

@TestingSpringRepository
@SpringBootTest(classes = { DataSourceConfig.class, UserRoleRepository.class })
public class UserRoleRepositoryTest extends BaseRepositoryTest<UserRoleRepository, UserRole> {

    @Autowired UserRoleRepositoryTest(final UserRoleRepository repository) {

        super(repository, UserCompositeGenerator::userRoleFixture, UserRole.class);

    }

}
