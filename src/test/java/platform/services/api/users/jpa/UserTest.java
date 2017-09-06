package platform.services.api.users.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import org.junit.*;
import org.junit.runner.*;

import platform.platform.api.common.BaseTests;
import platform.services.api.users.UserConfig;
import platform.services.api.common.security.SecurityCryptor;

import static org.assertj.core.api.Assertions.assertThat;

@Profile("test")
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = UserConfig.class, loader = AnnotationConfigContextLoader.class)

public class UserTest extends BaseTests {

    private User user;

    @Test
    public void getAuthenticationUserDetails() throws Exception {

        assertThat(User.getAuthenticationUserDetails()).isNull();

    }

    @Before public void setUp() {

        SecurityCryptor.setTrace(false);

        user = UserConfig.buildUser();

    }

    @Test public void getUsername() {

        assertThat(user.getUsername()).isEqualTo(UserConfig.USER_VALID_USERNAME);

    }

    @Test
    public void setUsername() {

        assertThat(user.getUsername()).isEqualTo(UserConfig.USER_VALID_USERNAME);

    }

    @Test
    public void getPassword() {

        assertThat(SecurityCryptor.matches(UserConfig.USER_VALID_PASSWORD, user.getPassword()));

    }

    @Test
    public void setPassword() {

        assertThat(SecurityCryptor.matches(UserConfig.USER_VALID_PASSWORD, user.getPassword()));

    }

    @Test
    public void getStatus() {

        assertThat(user.getStatus()).isEqualTo(UserConfig.USER_VALID_STATUS);

    }

    @Test
    public void setStatus() {

        assertThat(user.getStatus()).isEqualTo(UserConfig.USER_VALID_STATUS);

    }

    @Test
    public void getEmail() {

        assertThat(user.getEmail()).isEqualTo(UserConfig.USER_VALID_EMAIL);

    }

    @Test
    public void setEmail() {

        assertThat(user.getEmail()).isEqualTo(UserConfig.USER_VALID_EMAIL);

    }

    @Test
    public void toStringTest() {

        assertThat(user.toString()).isNotBlank();

    }

    @Test
    public void getParentId() {

        assertThat(user.getParentId()).isEqualTo(UserConfig.USER_VALID_PARENT_ID);

    }

    @Test
    public void setParentId() {

        assertThat(user.getParentId()).isEqualTo(UserConfig.USER_VALID_PARENT_ID);

    }

    @Test
    public void getId() {

        assertThat(user.getParentId()).isEqualTo(UserConfig.USER_VALID_ID);

    }

    @Test
    public void setId() {

        assertThat(user.getParentId()).isEqualTo(UserConfig.USER_VALID_ID);

    }

}
