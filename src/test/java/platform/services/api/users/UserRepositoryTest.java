package platform.services.api.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.*;

import platform.services.api.commons.jpa.datasources.DataSourceConfig;
import platform.services.api.commons.testing.BaseRepositoryTest;
import platform.services.api.commons.testing.TestingSpringRepository;
import platform.services.api.commons.validation.ValidationError;
import platform.services.api.organizations.Organization;
import platform.services.api.organizations.OrganizationService;

import static org.assertj.core.api.Assertions.assertThat;

@TestingSpringRepository
@SpringBootTest(classes = {

        DataSourceConfig.class,
        OrganizationService.class,
        UserRepository.class

})
public class UserRepositoryTest extends BaseRepositoryTest<UserRepository, User> {

    @Autowired
    private OrganizationService organizationService;

    @Autowired UserRepositoryTest(final UserRepository repository) {

        super(repository, UserCompositeGenerator::userFixture, User.class);

    }

    @BeforeEach
    public void beforeEach() {

        try {

            final Organization organizationFixture = Organization.create();
            final Organization organizationEntity  = organizationService.save(organizationFixture);
            final User         userFixture         = UserCompositeGenerator.userFixture().setOrganization(organizationEntity);
            final User         userEntity          = getBaseRepository().save(userFixture);

            assertThat(userEntity.getOrganization().getId()).isNotZero();

            setFixture(userFixture);

        } catch(final ValidationError error) {

            error.printStackTrace();

        }

    }

}
