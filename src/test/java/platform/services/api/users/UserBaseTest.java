package platform.services.api.users;

import lombok.Getter;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import platform.services.api.commons.enums.Role;
import platform.services.api.commons.enums.Status;
import platform.services.api.commons.jpa.entities.BaseEntity;
import platform.services.api.commons.jpa.repositories.BaseRepository;
import platform.services.api.commons.testing.BaseControllerTest;
import platform.services.api.commons.testing.Randomizers;
import platform.services.api.users.profiles.UserProfile;
import platform.services.api.users.roles.UserRole;

@Getter
public class UserBaseTest extends BaseControllerTest<User> {

    @Autowired
    private UserService userService;

    private User   user;
    private String passwordPlainText;

    public UserBaseTest(final Class<? extends BaseEntity> entityClass, final String pathBase) {

        super(entityClass, pathBase);

    }

    public static User UserFixture() {

        final User fixture = new User();

        fixture.setUsername(Randomizers.username());

        fixture.setPasswordNotEncrypted(Randomizers.password());
        fixture.setPassword(fixture.getPasswordNotEncrypted());

        fixture.setParentId(Randomizers.id());
        fixture.setStatus(Status.ACTIVE_TESTING);
        fixture.setEmail(Randomizers.email());

        fixture.getRoles().add(new UserRole(Role.ROLE_ADMIN));
        fixture.getRoles().add(new UserRole(Role.ROLE_USER));

        fixture.getProfiles().add(new UserProfile(Randomizers.avatar()));
        fixture.getProfiles().add(new UserProfile(Randomizers.avatar()));

        return fixture;

    }

    @BeforeEach
    @Override
    public void beforeEach() {

        user = createUserFixture();

        this.setUsername(user.getUsername());
        this.setPassword(user.getPasswordNotEncrypted());

        super.beforeEach();

    }

    @AfterEach
    public void afterEach() {

        userService.deleteById(user.getId());

        assertThat(userService.existsById(user.getId())).isFalse();

    }

    @Test
    public User createUserFixture() {

        final User fixture = UserFixture();
        final User result  = userService.getById(userService.saveEntity(fixture).getId());

        assertThat(result.getId()).isGreaterThan(0L);
        assertThat(result.getUsername()).isEqualTo(fixture.getUsername());
        assertThat(result.getEmail()).isEqualTo(fixture.getEmail());
        assertThat(result.getStatus()).isEqualTo(fixture.getStatus());
        assertThat(result.getProfiles().isEmpty()).isFalse();
        assertThat(result.getProfiles().size()).isEqualTo(fixture.getProfiles().size());

        result.setPasswordNotEncrypted(fixture.getPasswordNotEncrypted());

        return result;

    }

}
