package platform.services.api.users;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import platform.services.api.UsersConfig;
import platform.services.api.commons.enums.Status;
import platform.services.api.commons.security.SecurityCryptor;
import platform.services.api.commons.testing.BaseTests;
import platform.services.api.commons.testing.classes.ClassWellFormed;
import platform.services.api.commons.testing.EntityRandomizer;
import platform.services.api.commons.testing.TestingSpringEntity;

@TestingSpringEntity
public class UserTest extends BaseTests<User> {

    protected EntityRandomizer<User> r;
    private   User                   user;
    private   User                   dirty;

    public UserTest() {

        this.r = new EntityRandomizer<>();

    }

    @BeforeEach
    public void setUp() {

        user = r.get(User.class);
        dirty = r.get(User.class);

    }

    @Test public void publicClassWithOnePublicConstructorTest() throws ReflectiveOperationException {

        assertThat(ClassWellFormed.classHasOneConstructor(User.class)).isTrue();
        assertThat(ClassWellFormed.classHasPublicConstructor(User.class)).isTrue();

    }

    @Test public void getUsername() {

        user.setUsername(UsersConfig.USER_VALID_USERNAME);

        assertThat(user.getUsername()).isEqualTo(UsersConfig.USER_VALID_USERNAME);

    }

    @Test
    public void setUsername() {

        user.setUsername(UsersConfig.USER_VALID_USERNAME);

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

        user.setStatus(Status.ACTIVE);

        assertThat(user.getStatus()).isEqualTo(Status.ACTIVE);

    }

    @Test
    public void setStatus() {

        user.setStatus(Status.ACTIVE);

        assertThat(user.getStatus()).isEqualTo(Status.ACTIVE);

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

        user.setId(1L);

        assertThat(user.getId()).isGreaterThanOrEqualTo(0L);

    }

    @Test
    public void toStringTest() {

        assertThat(user.toString()).isNotBlank();

    }

}
