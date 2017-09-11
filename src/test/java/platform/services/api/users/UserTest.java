package platform.services.api.users;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import org.junit.jupiter.api.*;
import org.junit.runner.*;

import platform.services.api.commons.BaseTests;
import platform.services.api.commons.security.SecurityCryptor;

import static org.assertj.core.api.Assertions.assertThat;

//@Profile("test")
//@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {

    UserService.class,
    UsersConfig.class

}, loader = AnnotationConfigContextLoader.class)
@Log4j2
public class UserTest extends BaseTests {

    private User user;

    @Test
    @Disabled
    // TODO: Implement
    public void getAuthenticationUserDetails() throws Exception {
log.trace(User.getAuthenticationUserDetails());
        assertThat(User.getAuthenticationUserDetails()).isNull();

    }

    @BeforeEach public void setUp() {

        SecurityCryptor.setTrace(false);

        user = UsersConfig.buildUser();

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
