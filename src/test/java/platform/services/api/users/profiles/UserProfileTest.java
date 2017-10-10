package platform.services.api.users.profiles;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import platform.services.api.commons.testing.BaseEntityTest;
import platform.services.api.commons.testing.TestingSpringEntity;
import platform.services.api.commons.utilities.Randomizers;

import static org.assertj.core.api.Assertions.assertThat;

@TestingSpringEntity public class UserProfileTest extends BaseEntityTest<UserProfile> {

    @BeforeMethod public void beforeEach() {

        baseEntity = new UserProfile();

        super.beforeEach();

        setAvatar();

    }

    @Test
    public void setAvatar() {

        baseEntity.setAvatar(Randomizers.avatar());

    }

    @Test
    public void getAvatar() {

        assertThat(baseEntity.getAvatar()).isNotEmpty();

    }

}
