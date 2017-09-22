package platform.services.api.users;

import static org.hamcrest.Matchers.is;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import platform.services.api.commons.testing.TestingSpringController;

//@RunWith(SpringRunner.class)
//@ExtendWith(SpringExtension.class)
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestingSpringController
public class SpringBootApplicationContextTest {

    @Test
    public void test() {

        Assert.assertThat(true, is(true));

    }

}
