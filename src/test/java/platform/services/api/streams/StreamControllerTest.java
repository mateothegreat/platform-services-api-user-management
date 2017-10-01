package platform.services.api.streams;

import org.springframework.beans.factory.annotation.Autowired;

import org.junit.jupiter.api.*;

import platform.services.api.commons.testing.BaseControllerTestCase;
import platform.services.api.users.UserAuthenticationFixtures;
import platform.services.api.users.UserCompositeGenerator;

import static org.assertj.core.api.Assertions.assertThat;

@BaseControllerTestCase
public class StreamControllerTest extends UserAuthenticationFixtures<Stream> {

    private static final String PATH_BASE = "/streams";

    @Autowired
    public StreamControllerTest(@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") final UserCompositeGenerator userCompositeGenerator) {

        super(Stream::create, Stream.class, PATH_BASE, userCompositeGenerator);

    }


    @BeforeEach
    public void beforeEach() {

        super.beforeUserAuthenticationFixturesEach();

        super.beforeEach();

    }

}
