package platform.services.api.streams;

import org.junit.jupiter.api.*;

import platform.services.api.commons.testing.BaseEntityTest;
import platform.services.api.commons.testing.TestingSpringEntity;

@TestingSpringEntity
public class StreamTest extends BaseEntityTest<Stream> {

    @BeforeEach public void beforeEach() {

        baseEntity = Stream.create();

        super.beforeEach();

    }

}
