package platform.services.api.users.roles;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import platform.services.api.commons.testing.BaseRepositoryTest;
import platform.services.api.users.UserFactory;
import platform.services.api.users.UserFactorySetup;
import platform.services.api.users.UserService;

@UserFactorySetup
public class UserRoleRepositoryTest extends BaseRepositoryTest<UserRoleRepository, UserRole> {

    @Autowired private UserRoleRepository repository;
    @Autowired private UserService        parentService;
    @Autowired private UserFactory        userFactory;

    @BeforeClass public void beforeClass() {

        setFn(UserRole::create);
        setBaseRepository(repository);

    }
    @BeforeMethod @Test public void beforeMethod() {

        persistFixture(UserRole.create()
                               .setUser(userFactory.persistNewUser()));

    }

}
