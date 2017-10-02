package platform.services.api.streams.images;

import org.junit.jupiter.api.*;

import platform.services.api.commons.testing.BaseEntityTest;
import platform.services.api.commons.testing.TestingSpringEntity;

@TestingSpringEntity
public class StreamImageTest extends BaseEntityTest<StreamImage> {

    @BeforeEach public void beforeEach() {

        baseEntity = StreamImage.create();

        super.beforeEach();

    }

}
