package platform.services.api.users.settings;

import com.github.javafaker.Faker;

import platform.services.api.commons.jpa.entities.BaseEntityFixtureFunction;

public class UserSettingFixture {

    public static UserSetting create() {

        return new UserSetting(new Faker().hacker().noun(), true);

    }

}
