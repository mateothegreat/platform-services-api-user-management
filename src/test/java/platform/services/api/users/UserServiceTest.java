package platform.services.api.users;

import lombok.extern.log4j.Log4j2;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import platform.services.api.commons.testing.BaseRepositoryTest;
import platform.services.api.commons.testing.BaseServiceTest;
import platform.services.api.commons.testing.TestingSpringService;
import platform.services.api.users.authentication.Authenticate;

@Log4j2
@TestingSpringService
public class UserServiceTest extends BaseServiceTest<UserRepository, User, Long> {

    private final UserService userService;
    private       User        user;

    @Autowired
    public UserServiceTest(final UserService userService) {

        super(userService, User.class);

        this.userService = userService;

    }

    @BeforeEach
    public void beforeEach() {

        log.trace("beforeEach: Authenticate.SUDO_INTEGRATION(): {}", Authenticate.SUDO_INTEGRATION());

        user = createFixtureViaService();

        this.setBaseEntityFixture(user);

    }

    @AfterEach
    public void afterEach() {

        userService.deleteById(this.getBaseEntityFixture().getId());

        assertThat(userService.existsById(this.getBaseEntityFixture().getId())).isFalse();

    }

    @Test
    public void getById() {

        final User result = this.userService.findById(user.getId());

        assertThat(result.getId()).isNotZero();

    }

    public User createFixtureViaService() {

        return userService.getByUuid(userService.save(UserBaseTest.UserFixture()).getUuid());

    }

}
