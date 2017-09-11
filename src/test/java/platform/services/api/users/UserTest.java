package platform.services.api.users;

import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import org.junit.*;

import platform.services.api.UsersConfig;
import platform.services.api.commons.security.SecurityCryptor;
import platform.services.api.commons.testing.BaseTests;
import platform.services.api.commons.testing.EntityRandomizer;

import static org.assertj.core.api.Assertions.assertThat;

@Profile("testing")
@ContextConfiguration(classes = { UsersConfig.class }, loader = AnnotationConfigContextLoader.class)
public class UserTest extends BaseTests {

    private User user;

    @Before public void setUp() {

        SecurityCryptor.setTrace(false);

        user = UsersConfig.buildUser();

    }

    @Test public void userConstructorWithArgs() {

        EntityRandomizer r = new EntityRandomizer();

        final User user = r.get(User.class);

        assertThat(user.getUsername()).isNotEmpty();
        assertThat(user.getStatus()).isNotNull();

    }

    @Test public void getUsername() {

        assertThat(user.getUsername()).isEqualTo(UsersConfig.USER_VALID_USERNAME);

    }

    @Test
    public void setUsername() {

        assertThat(user.getUsername()).isEqualTo(UsersConfig.USER_VALID_USERNAME);

    }

    @Test
    public void getPassword() {

        assertThat(SecurityCryptor.matches(UsersConfig.USER_VALID_PASSWORD, user.getPassword()));

    }

    @Test
    public void setPassword() {

        assertThat(SecurityCryptor.matches(UsersConfig.USER_VALID_PASSWORD, user.getPassword()));

    }

    @Test
    public void getStatus() {

        assertThat(user.getStatus()).isEqualTo(UsersConfig.USER_VALID_STATUS);

    }

    @Test
    public void setStatus() {

        assertThat(user.getStatus()).isEqualTo(UsersConfig.USER_VALID_STATUS);

    }

    @Test
    public void getEmail() {

        assertThat(user.getEmail()).isEqualTo(UsersConfig.USER_VALID_EMAIL);

    }

    @Test
    public void setEmail() {

        assertThat(user.getEmail()).isEqualTo(UsersConfig.USER_VALID_EMAIL);

    }

    @Test
    public void toStringTest() {

        assertThat(user.toString()).isNotBlank();

    }

    @Test
    public void getParentId() {

        assertThat(user.getParentId()).isEqualTo(UsersConfig.USER_VALID_PARENT_ID);

    }

    @Test
    public void setParentId() {

        assertThat(user.getParentId()).isEqualTo(UsersConfig.USER_VALID_PARENT_ID);

    }

    @Test
    public void getId() {

        assertThat(user.getId()).isEqualTo(UsersConfig.USER_VALID_ID);

    }

    @Test
    public void setId() {

        assertThat(user.getId()).isEqualTo(UsersConfig.USER_VALID_ID);

    }

}
