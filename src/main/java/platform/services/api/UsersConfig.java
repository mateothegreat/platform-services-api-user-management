package platform.services.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import platform.services.api.users.User;
import platform.services.api.users.UserService;

//@ComponentScan(basePackages = {
//
//    UsersConfig.PLATFORM_SERVICES_API_USERS,
//    UsersConfig.PLATFORM_SERVICES_API_AUTHENTICATION,
//    UsersConfig.PLATFORM_SERVICES_API_COMMONS
//
//}, basePackageClasses = { DataSourceConfig.class })
//@EnableJpaRepositories(basePackages = { UsersConfig.PLATFORM_SERVICES_API_USERS })
//@Configuration

//@Configuration
//@EnableJpaRepositories(basePackages = { ApplicationConfig.PLATFORM_SERVICES_API_USERS_JPA })
//@ComponentScan({ ApplicationConfig.PLATFORM_SERVICES_API_COMMON, ApplicationConfig.PLATFORM_SERVICES_API_USERS, })

@Configuration
@ComponentScan(basePackages = {

    UsersConfig.PLATFORM_SERVICES_API_USERS,
    UsersConfig.PLATFORM_SERVICES_API_COMMONS,


})
//@EnableJpaRepositories(basePackages = {
//
//    UsersConfig.PLATFORM_SERVICES_API_USERS
//
//})
public class UsersConfig {

    public static final String PLATFORM_SERVICES_API_COMMONS        = "platform.services.api.commons.*";
    public static final String PLATFORM_SERVICES_API_AUTHENTICATION = "platform.services.api.authentication";
    public static final String PLATFORM_SERVICES_API_USERS          = "platform.services.api.users";
    public static final String PLATFORM_SERVICES_API_STREAMS        = "platform.services.api.streams";
    public static final String DATA_SOURCE_PLATFORM_BASE_BEAN_NAME  = "platformBaseDataSource";
    public static final String DATA_SOURCE_PLATFORM_BASE_DRIVER     = "com.mysql.jdbc.Driver";
    public static final String DATA_SOURCE_PLATFORM_BASE_USER       = "root";
    public static final String DATA_SOURCE_PLATFORM_BASE_PASS       = "asdfasdf";

    public static final String DATA_SOURCE_PLATFORM_BASE_URL

        = "jdbc:mysql://localhost:3306/platform_base?useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false";

    public static final String AUTHENTICATION_REALM_NAME = "PlatformAPI";

    public static final Long   USER_VALID_ID               = null;
    public static final Long   USER_VALID_PARENT_ID        = 1L;
    public static final Long   USER_VALID_STATUS           = 1L;
    public static final String USER_VALID_EMAIL            = "test-user1@testing-user1.com";
    public static final String USER_VALID_USERNAME         = "test-user1";
    public static final String USER_VALID_PASSWORD         = "test-password";
    public static final String USER_VALID_PASSWORD_ENCODED = "$2a$10$atc5W7EVviaucgev1/LgWu3fIcOH0S9dYPzX0cUgYQE6fHIshL4.q";
    public static final Long   USER_INVALID_ID             = 0L;
    public static final Long   USER_INVALID_PARENT_ID      = -1L;
    public static final int    USER_INVALID_STATUS         = -1;
    public static final String USER_INVALID_EMAIL          = "invalid@invalid.com";
    public static final String USER_INVALID_USERNAME       = "invalid";
    public static final String USER_INVALID_PASSWORD       = "invalid";

    public static User buildUser() {

        final User user = new User();

        user.setParentId(USER_VALID_PARENT_ID);
        user.setStatus(USER_VALID_STATUS);
        user.setEmail(USER_VALID_EMAIL);
        user.setUsername(USER_VALID_USERNAME);
        user.setPassword(USER_VALID_PASSWORD);

        return user;

    }

}
