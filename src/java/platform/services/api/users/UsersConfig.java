package platform.services.api.users;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import platform.services.api.commons.CommonsConfig;

@ComponentScan(basePackages = { CommonsConfig.PLATFORM_SERVICES_API, CommonsConfig.PLATFORM_SERVICES_API_COMMONS })
@Configuration
public class UsersConfig {

    public static final String PLATFORM_SERVICES_API_USERS         = "platform.services.api.users.*";
    public static final String PLATFORM_SERVICES_API_USERS_JPA     = "platform.services.api.users.jpa";
    public static final String PLATFORM_SERVICES_API_STREAMS       = "platform.services.api.streams.*";
    public static final String PLATFORM_SERVICES_API_STREAMS_JPA   = "platform.services.api.streams.jpa";
    public static final String DATA_SOURCE_PLATFORM_BASE_BEAN_NAME = "platformBaseDataSource";
    public static final String DATA_SOURCE_PLATFORM_BASE_DRIVER    = "com.mysql.jdbc.Driver";
    public static final String DATA_SOURCE_PLATFORM_BASE_USER      = "root";
    public static final String DATA_SOURCE_PLATFORM_BASE_PASS      = "asdfasdf";

    public static final String DATA_SOURCE_PLATFORM_BASE_URL =
            "jdbc:mysql://localhost:3306/platform_base?useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false";

    public static final String AUTHENTICATION_REALM_NAME = "PlatformAPI";

}
