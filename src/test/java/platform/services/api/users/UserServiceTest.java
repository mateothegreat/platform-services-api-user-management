package platform.services.api.users;

import lombok.extern.log4j.Log4j2;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import org.junit.jupiter.api.Test;

import javax.sql.DataSource;

import java.util.ArrayList;
import java.util.Optional;

import platform.services.api.DataSourceConfig;
import platform.services.api.UsersConfig;
import platform.services.api.commons.jpa.enums.Role;
import platform.services.api.commons.testing.ComposedJUnit5BootTest;
import platform.services.api.commons.testing.EntityRandomizer;

@Log4j2
@ComposedJUnit5BootTest
@SpringBootConfiguration
@ContextConfiguration(classes = { UsersConfig.class, DataSourceConfig.class }, loader = AnnotationConfigContextLoader.class)
//public class UserServiceTest extends BaseRestRepositoryTest<User> {
public class UserServiceTest {

    //
    @Autowired
    public UserService userService;

    @Autowired public UserRestRepository userRestRepository;

    @Autowired public UserRoleRestRepository userRoleRestRepository;

    @Autowired public DataSource platformDataSource;

    @Autowired public UserProfileRestRepository userProfileRestRepository;

    //
//    @BeforeEach
//    public void beforeEach() {
//
////        super.beforeEach();
////
////        entityClass = User.class;
////        genericService = userService;
//
//    }
//
//    @Test
//    public void getUserByUsername() throws Exception {
//
//        final User user   = this.userService.saveEntity(this.r.get(User.class));
//        final User result = this.userService.getUserByUsername(user.getUsername());
//
//        baseEntity_isValidAndCompare(user, result);
//
//    }
//
//    @Test
//    public void getUserByEmail() throws Exception {
//
//        final User user   = this.userService.saveEntity(this.r.get(User.class));
//        final User result = this.userService.getUserByEmail(user.getEmail());
//
//        baseEntity_isValidAndCompare(user, result);
//
//    }
    @Test
    public void create() {

//        new StandardServiceRegistryBuilder().applySettings(DataSourceConfig.buildHibernateConfiguration()).build().;
//        SessionFactory sessionFactory = DataSourceConfig.buildHibernateConfiguration().setProperties(DataSourceConfig.buildHibernateConfiguration()).buildSessionFactory();
//
//        Session session = sessionFactory.getCurrentSession();


        final User r    = (User) EntityRandomizer.get(User.class);
        final User user = new User();

        user.setUsername(EntityRandomizer.username.getRandomValue());
        user.setPassword(r.getPassword());
        user.setParentId(r.getParentId());
        user.setStatus(r.getStatus());
        user.setEmail(r.getEmail());

        final UserProfile profile = new UserProfile("testavatar1");

        profile.setUser(user);

        user.setProfile(profile);


//        HibernateSessionFactory hibernateSessionFactory = HibernateSessionFactory.doInTransaction(user);

        HibernateUtility.getSession().saveOrUpdate(user);

        final User saved = userRestRepository.save(user);

        final Optional<User> result = this.userService.findById(saved.getId());

        assertThat(result.get().getId()).isGreaterThan(0L);
        assertThat(result.get().getUsername()).isEqualTo(user.getUsername());
        assertThat(result.get().getEmail()).isEqualTo(user.getEmail());
        assertThat(result.get().getStatus()).isEqualTo(user.getStatus());

        assignProfile(result.get());

    }


    public Optional<User> assignRoles(final User user) {

        user.roles = new ArrayList<>(2);
        user.roles.add(new UserRole(Role.ROLE_ADMIN));
        user.roles.add(new UserRole(Role.ROLE_USER));

        final User saved = userRestRepository.save(user);

        final Optional<User> result = this.userService.findById(saved.getId());

        assertThat(result.get().getRoles().size()).isEqualTo(2);

        return result;

    }

    Optional<User> assignProfile(final User user) {

        final UserProfile profile = new UserProfile("testavatar1");

        profile.setUser(user);

//        log.fatal(userProfileRestRepository.save(profile));


        user.setProfile(profile);
        final User saved = userRestRepository.save(user);


        Optional<User> result = this.userService.findById(user.getId());

        assertThat(result.get().getProfile().getAvatar()).isEqualTo(profile.getAvatar());

        result.get().getProfile().setAvatar("asdfasdf");

        log.fatal(userRestRepository.save(result.get()));

        result = this.userService.findById(user.getId());

        return result;

    }

    @Test void getById() {

        final User user = this.userService.findById(9L).get();

    }
}
