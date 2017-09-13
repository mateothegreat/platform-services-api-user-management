package platform.services.api.users;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.junit.platform.runner.*;
import org.junit.runner.*;

import platform.services.api.UsersConfig;
import platform.services.api.authentication.AuthenticatedRunAsManager;
import platform.services.api.authentication.Authorities;
import platform.services.api.authentication.SecurityConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
@Profile("testing")
@Transactional
@RunWith(JUnitPlatform.class)
@SpringBootTest
//@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { SecurityConfiguration.class, UsersConfig.class }, loader = AnnotationConfigContextLoader.class)
public class UserControllerTest extends BaseControllerTest {

    @Autowired
    UserController userController;

    @BeforeEach
    public void beforeEach() {

        super.beforeEach();

        assertThat(userController).isNotNull();

    }

    @Test
    public void create() throws Exception {

        AuthenticatedRunAsManager.runAs("test-user1", "test-password1", Authorities.ROLE_ADMIN, Authorities.ROLE_USER);

        final User              user           = this.r.get(User.class);
        final ResponseEntity<?> responseEntity = this.userController.save(user);
        final User              result         = (User) responseEntity.getBody();


        final User got = this.userController.getByUsername(result.getUsername()).getBody();

        baseEntity_isValidAndCompare(user, got, "id");
    }

//    @Test
//    public void getAll() throws Exception {
//
//        final PagedResourcesAssembler assembler = new PagedResourcesAssembler(null, null);
//
//        final HttpEntity<PagedResources<User>> results = this.userController.getAll(PageRequest.of(0, 5), assembler);
//
//        final PagedResources<User> page = results.getBody();
//
//        assertThat(page.getContent().size()).isGreaterThan(0);
//
//        baseEntity_isValid(page.getContent().iterator().next());
////        baseEntity_isValid(results.getContent().get(results.getNumberOfElements() - 1));
//
//    }

}
