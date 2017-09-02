package platform.services.api.users;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    public static final String PLATFORM_SERVICES_API                 = "platform.services.api.*";
    public static final String PLATFORM_SERVICES_API_COMMON          = "platform.services.api.common.*";
    public static final String PLATFORM_SERVICES_API_USERS           = "platform.services.api.users.*";
    public static final String PLATFORM_SERVICES_API_USERS_JPA       = "platform.services.api.users.jpa";
    public static final String SELECT_FROM_USER_WHERE_USERNAME       = "select username,password, status from user where username=?";
    public static final String SELECT_FROM_USER_ROLES_WHERE_USERNAME = "select username, role from user_roles where username=?";
    public static final String DATA_SOURCE_PLATFORM_BASE_BEAN_NAME   = "platformBaseDataSource";
    public static final String DATA_SOURCE_PLATFORM_BASE_DRIVER      = "com.mysql.jdbc.Driver";
    public static final String DATA_SOURCE_PLATFORM_BASE_USER        = "root";
    public static final String DATA_SOURCE_PLATFORM_BASE_PASS        = "asdfasdf";

    public static final String DATA_SOURCE_PLATFORM_BASE_URL =
            "jdbc:mysql://localhost:3306/platform_base?useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false";

    public static final String AUTHENTICATION_REALM_NAME = "PlatformAPI";

}
