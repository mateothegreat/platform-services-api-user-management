package platform.services.api.users;

import io.github.benas.randombeans.randomizers.text.StringRandomizer;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import platform.services.api.UsersConfig;
import platform.services.api.commons.jpa.enums.Status;
import platform.services.api.commons.security.SecurityCryptor;
import platform.services.api.commons.testing.BaseTests;
import platform.services.api.commons.testing.ClassWellFormed;
import platform.services.api.commons.testing.EntityRandomizer;

@Profile("testing")
@ContextConfiguration(classes = { UsersConfig.class }, loader = AnnotationConfigContextLoader.class)
public class UserTest extends BaseTests {

    private User user;

    private User dirty;

    @BeforeEach public void setUp() {

        user = (User) EntityRandomizer.get(User.class);
        dirty = (User) EntityRandomizer.get(User.class);

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

//    @Test
//    void setProfile() {
//
//
//        final String avatar = StringRandomizer.aNewStringRandomizer(32).getRandomValue();
//
//        final UserProfile profile = new UserProfile(avatar);
//
//        user.setProfile(profile);
//
//        assertThat(user.getProfile().getAvatar()).isEqualToIgnoringCase(avatar);
//
//    }

}
