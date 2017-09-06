package platform.services.api.users;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import platform.services.api.users.jpa.User;
import platform.services.api.users.services.UserService;

//@Log4j2
//@Configuration
@EnableAutoConfiguration
@ComponentScan
@Component
public class UserRepositoryInitializer implements ApplicationRunner {

//    @Autowired
//    protected UserRepository userRepository;

    @Autowired
    protected UserService    userService;

    private static final Logger log = LoggerFactory.getLogger(UserRepositoryInitializer.class);

//    @Autowired public UserRepositoryInitializer(final UserRepository userRepository, final UserService userService) {
//
//        this.userRepository = userRepository;
//        this.userService = userService;
//
//    }

    @Override
    public void run(final ApplicationArguments arguments) throws Exception {

        log.trace("run(final ApplicationArguments arguments): {}", arguments.toString());

        User result = userService.getUserByUsername("integration-admin1");

        log.trace("getUserByUsername: {}", result);

        if(result == null) {

            User admin   = new User("integration-admin1@integration-admin1.com", "integration-admin1", "password", 1L);

            admin.setParentId(1L);

            User created = userService.saveEntity(admin);

            log.trace("created: {}", created);

        }

    }

}
