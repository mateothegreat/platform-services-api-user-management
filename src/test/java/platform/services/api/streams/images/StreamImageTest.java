package platform.services.api.streams.images;

import org.testng.annotations.BeforeMethod;

import platform.services.api.commons.testing.BaseEntityTest;
import platform.services.api.commons.testing.TestingSpringEntity;

@TestingSpringEntity
public class StreamImageTest extends BaseEntityTest<StreamImage> {

    @BeforeMethod public void beforeEach() {

        baseEntity = StreamImage.create();

        super.beforeEach();

    }

}
