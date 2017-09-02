//package com.streamingplatform.api.users;
//
//import com.streamingplatform.api.*;
//import com.streamingplatform.api.common.*;
//import com.streamingplatform.api.users.entities.*;
//import com.streamingplatform.api.users.services.*;
//import org.junit.*;
//import org.junit.runner.*;
//import org.springframework.beans.factory.annotation.*;
//import org.springframework.boot.test.context.*;
//import org.springframework.boot.test.context.SpringBootTest.*;
//import org.springframework.dao.*;
//import org.springframework.test.context.junit4.*;
//
//import static org.assertj.core.api.Assertions.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = UsersApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
//public class UserServiceTests extends BaseTests {
//
//    @Autowired
//    private UserService service;
//
//    private User user1;
//
//    public UserServiceTests(final GenericService genericService) {
//
//        super(genericService);
//    }
//
////    public UserServiceTests(final GenericService genericService) {
////
////        super(genericService);
////    }
//
//    @Before
//    public void setUp() throws InterruptedException {
//
//        user1 = UserTestUtils.buildUser();
//
//    }
//
//    @Test
//    public void createAndDelete() throws Exception {
//
//        User created = service.save(user1);
//
//        assertThat(created.getId()).isNotNull();
//        assertThat(created.getId()).isGreaterThan(0);
//        assertThat(created).isEqualToIgnoringGivenFields(user1, "id", "password");
//
//        assertThat(service.delete(created)).isTrue();
//
//    }
//
//    @Test
//    public void saveTest() throws Exception {
//
//
//
//    }
//
//    @Test
//    public void createDuplicateAndDelete() throws Exception {
//
//        User created = service.save(UserTestUtils.buildUser());
//
//        assertThat(created.getId()).isNotNull();
//        assertThat(created.getId()).isGreaterThan(0);
//        assertThat(created).isEqualToIgnoringGivenFields(user1, "id", "password");
//
//        try {
//
//            User dupe = service.save(UserTestUtils.buildUser());
//
//            assertThat(dupe.getId()).isNull();
//
//
//
//        } catch(DuplicateKeyException e) {
//
//            assertThat(service.delete(created)).isTrue();
//
//        }
//
//    }
//
//}
