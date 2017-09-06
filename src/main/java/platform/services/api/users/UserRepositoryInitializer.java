package platform.services.api.users;

import lombok.extern.log4j.Log4j2;
import org.apache.catalina.startup.UserConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import platform.services.api.users.jpa.User;
import platform.services.api.users.services.UserService;

@Log4j2
//@EnableAutoConfiguration
//@ComponentScan
@Component
public class UserRepositoryInitializer implements ApplicationRunner {

    protected final UserService userService;

    @Autowired public UserRepositoryInitializer(final UserService userService) {

        this.userService = userService;

    }

    @Override
    public void run(final ApplicationArguments arguments) throws Exception {

        log.trace("run(final ApplicationArguments arguments): {}", arguments.toString());

        try {
            User result = userService.getUserByUsername("integration-admin1");

            log.trace("getUserByUsername: {}", result);

//        if(result == null) {

//            User admin = new User("integration-admin1@integration-admin1.com", "integration-admin1", "password", 1L);
            User admin = platform.services.api.users.UserConfig.buildUser();

            admin.setParentId(1L);

            User created = userService.saveEntity(admin);

            log.trace("run: {}", created);

//        }

        } catch(Exception e) {

            log.warn(e.toString());

        }

    }

}
