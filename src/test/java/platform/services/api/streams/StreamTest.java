package platform.services.api.streams;

import org.testng.annotations.BeforeMethod;

import platform.services.api.commons.testing.BaseEntityTest;
import platform.services.api.commons.testing.TestingSpringEntity;

@TestingSpringEntity
public class StreamTest extends BaseEntityTest<Stream> {

    @BeforeMethod public void beforeEach() {

        baseEntity = Stream.create();

        super.beforeEach();

    }

}
