package platform.services.api.users.profiles;

import org.junit.jupiter.api.*;

import platform.services.api.commons.testing.BaseEntityTest;
import platform.services.api.commons.testing.TestingSpringEntity;
import platform.services.api.commons.utilities.Randomizers;

@TestingSpringEntity public class UserProfileTest extends BaseEntityTest<UserProfile> {

    @BeforeEach public void beforeEach() {

        baseEntity = new UserProfile();

        super.beforeEach();

        setAvatar();

    }

    @Test
    public void setAvatar() {

        baseEntity.setAvatar(Randomizers.avatar());

//        getParentId();

    }

    @Test
    public void getAvatar() {

        assertThat(baseEntity.getAvatar()).isNotEmpty();

    }

}
