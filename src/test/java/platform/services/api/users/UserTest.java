package platform.services.api.users;

import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import org.junit.jupiter.api.*;

import platform.services.api.UsersConfig;
import platform.services.api.commons.security.SecurityCryptor;
import platform.services.api.commons.testing.BaseTests;
import platform.services.api.commons.testing.ClassWellFormed;
import platform.services.api.commons.testing.EntityRandomizer;

import static org.assertj.core.api.Assertions.assertThat;

@Profile("testing")
@ContextConfiguration(classes = { UsersConfig.class }, loader = AnnotationConfigContextLoader.class)
public class UserTest extends BaseTests {

    private EntityRandomizer r = new EntityRandomizer();
    private User user;
    private User dirty;

    @BeforeEach public void setUp() {

        user = r.get(User.class);
        dirty = r.get(User.class);

    }

    @Test public void publicClassWithOnePublicConstructorTest() throws ReflectiveOperationException {

        assertThat(ClassWellFormed.classHasOneConstructor(User.class)).isTrue();
        assertThat(ClassWellFormed.classHasPublicConstructor(User.class)).isTrue();

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

        user.setStatus(dirty.getStatus());

        assertThat(user.getStatus()).isEqualTo(dirty.getStatus());

    }

    @Test
    public void getEmail() {

        assertThat(user.getEmail()).isNotEmpty();

    }

    @Test
    public void setEmail() {

        user.setEmail(dirty.getEmail());

        assertThat(user.getEmail()).isEqualTo(dirty.getEmail());

    }

    @Test
    public void getParentId() {

        assertThat(user.getParentId()).isGreaterThanOrEqualTo(0L);

    }

    @Test
    public void setParentId() {

        assertThat(user.getParentId()).isGreaterThanOrEqualTo(0L);

    }

    @Test
    public void getId() {

        assertThat(user.getId()).isGreaterThanOrEqualTo(0L);

    }

    @Test
    public void setId() {

        assertThat(user.getId()).isGreaterThanOrEqualTo(0L);

    }

    @Test
    public void toStringTest() {

        assertThat(user.toString()).isNotBlank();

    }

}
