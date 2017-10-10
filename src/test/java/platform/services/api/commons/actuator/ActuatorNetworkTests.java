package platform.services.api.commons.actuator;

import org.springframework.boot.actuate.autoconfigure.LocalManagementPort;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.Map;

import platform.services.api.UsersConfig;

import static org.assertj.core.api.Assertions.assertThat;

@DirtiesContext
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, properties = { "endpoints.enabled:true" })
public class ActuatorNetworkTests extends AbstractTestNGSpringContextTests {

    @LocalServerPort
    private int port;

    @LocalManagementPort
    private int managementPort;

    @Test
    public void testHome() {

        ResponseEntity<String> entity = new TestRestTemplate().getForEntity("http://localhost:" + this.port, String.class);

        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);

    }

    @Test
    public void testMetrics() {

        @SuppressWarnings("rawtypes")
        ResponseEntity<Map> entity = new TestRestTemplate().getForEntity("http://localhost:" + this.managementPort + "/application/metrics", Map.class);

        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);

    }

    @Test
    public void testHealth() {

        ResponseEntity<String> entity = new TestRestTemplate().withBasicAuth(UsersConfig.TESTING_USERNAME, UsersConfig.TESTING_PASSWORD)
                                                              .getForEntity("http://localhost:" + this.managementPort + "/application/health", String.class);

        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody()).contains("\"status\":\"UP\"");

    }

}
