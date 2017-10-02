package platform.services.api.streams;

import org.springframework.beans.factory.annotation.Autowired;

import org.junit.jupiter.api.*;

import platform.services.api.commons.testing.BaseControllerTestCase;
import platform.services.api.users.UserAuthenticationTestSetup;
import platform.services.api.users.UserCompositeGenerator;

@BaseControllerTestCase
public class StreamControllerTest extends UserAuthenticationTestSetup<Stream> {

    private static final String PATH_BASE = "/streams";

    @Autowired
    public StreamControllerTest(@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") final UserCompositeGenerator userCompositeGenerator) {

        super(Stream::create, Stream.class, PATH_BASE, userCompositeGenerator);

    }


    @BeforeEach
    public void beforeEach() {

        beforeUserAuthenticationFixturesEach();

        super.beforeEach();

    }

}
