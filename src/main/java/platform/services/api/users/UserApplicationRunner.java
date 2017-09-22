//package platform.services.api.users;
//
//import lombok.extern.log4j.Log4j2;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.Optional;
//
//import platform.services.api.UsersConfig;
//import platform.services.api.commons.jpa.enums.Role;
//import platform.services.api.commons.jpa.enums.Status;
//
//@Log4j2
//@Component
//public class UserApplicationRunner implements ApplicationRunner {
//
//    protected final UserService            userService;
//    protected final UserRoleRestRepository userRoleRestRepository;
//
//    @Autowired public UserApplicationRunner(final UserService userService, final UserRoleRestRepository userRoleRestRepository) {
//
//        this.userService = userService;
//        this.userRoleRestRepository = userRoleRestRepository;
//
//    }
//
//    @Override
//    public void run(final ApplicationArguments arguments) throws Exception {
//
//        log.trace("run(final ApplicationArguments arguments): {}", arguments.toString());
//
//        try {
//
//            final Optional<User> result = userService.findByUsername("integration-admin1");
//
//            log.trace("getByUsername: {}", result);
//
//            if(result.isPresent()) {
//
//                log.trace("exists");
//
//            } else {
//
//                final User user = new User();
//
//                user.setUsername(UsersConfig.USER_VALID_USERNAME);
//                user.setPassword(UsersConfig.USER_VALID_PASSWORD);
//                user.setEmail(UsersConfig.USER_VALID_EMAIL);
//                user.setStatus(Status.ACTIVE);
//                user.setParentId(0L);
//
//                final User created = userService.saveEntity(user);
//
//                log.trace("run: {}", created);
//
//                final UserRole role = new UserRole();
//
////                role.setUsername(UsersConfig.USER_VALID_USERNAME);
//                role.setRole(Role.ROLE_ADMIN);
//
//                userRoleRestRepository.save(role);
//
//            }
//
//        } catch(final RuntimeException e) {
//
//            log.warn(e.toString());
//
//        }
//
//    }
//
//}
