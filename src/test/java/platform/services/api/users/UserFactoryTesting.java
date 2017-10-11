package platform.services.api.users;

import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import platform.services.api.commons.jpa.datasources.DataSourceConfig;
import platform.services.api.organizations.OrganizationService;
import platform.services.api.users.profiles.UserProfileService;
import platform.services.api.users.roles.UserRoleService;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented

@Test
@SpringBootTest(classes = {

        DataSourceConfig.class,

        OrganizationService.class,

        UserAuthIntercept.class,
        UserFactory.class,

        UserService.class,
        UserRoleService.class,
        UserProfileService.class,
        UserAuthIntercept.class

})
public @interface UserFactoryTesting {

}
