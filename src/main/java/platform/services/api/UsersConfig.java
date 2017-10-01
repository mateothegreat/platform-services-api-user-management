package platform.services.api;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SuppressWarnings("StringConcatenation")

@Configuration
@ComponentScan(basePackages = {

        UsersConfig.PLATFORM_SERVICES_API_USERS,
        UsersConfig.PLATFORM_SERVICES_API_USERS_AUTHENTICATION,
        UsersConfig.PLATFORM_SERVICES_API_COMMONS

})
public class UsersConfig {

    public static final String PLATFORM_SERVICES_API_COMMONS              = "platform.services.api.commons.*";
    public static final String PLATFORM_SERVICES_API_USERS_AUTHENTICATION = "platform.services.api.users.authentication";
    public static final String PLATFORM_SERVICES_API_USERS                = "platform.services.api.users";
    public static final String PLATFORM_SERVICES_API_STREAMS              = "platform.services.api.streams.streams";

    public static final String REQUEST_PATH                 = "/users";
    public static final String REQUEST_PATH_SETTINGS        = REQUEST_PATH + "/{userId:^[0-9]+$}/settings";
    public static final String REQUEST_PATH_SETTINGS_ENTITY = REQUEST_PATH_SETTINGS + "/{settingId:^[0-9]+$}";

}
