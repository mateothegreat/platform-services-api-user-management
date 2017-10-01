package platform.services.api.users;

import platform.services.api.commons.enums.Status;
import platform.services.api.commons.jpa.entities.BaseEntity;
import platform.services.api.commons.testing.Randomizers;

public class UserFixtureFactory {

    public static BaseEntity<User> createFixture() {

        return new User().setUsername(Randomizers.username())
                         .setPasswordNotEncrypted(Randomizers.password())
                         .setEmail(Randomizers.email())
//                         .setParentId(Randomizers.id())
                         .setStatus(Status.ACTIVE_TESTING);
//
//        fixture.addRole(new UserRole(Role.ROLE_ADMIN));
//        fixture.addRole(new UserRole(Role.ROLE_USER));
//
//        fixture.addProfile(new UserProfile(Randomizers.avatar()));
//        fixture.addProfile(new UserProfile(Randomizers.avatar()));

    }
}
