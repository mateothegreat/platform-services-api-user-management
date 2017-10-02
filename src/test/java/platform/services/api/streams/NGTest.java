//package platform.services.api.streams;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
//import org.testng.annotations.Test;
//
//import platform.services.api.organizations.Organization;
//
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//@DirtiesContext
//public class NGTest extends AbstractTransactionalTestNGSpringContextTests {
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    @Test
//    public void test() {
//
//        final ResponseEntity<Organization> organization = restTemplate.getForEntity("/organizations", Organization.class);
//
//
//    }
//}
