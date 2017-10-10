package platform.services.api.streams.recordings.sequences.images;

import org.testng.annotations.BeforeMethod;

import platform.services.api.commons.testing.BaseEntityTest;
import platform.services.api.commons.testing.TestingSpringEntity;

@TestingSpringEntity
public class SequenceImageTest extends BaseEntityTest<SequenceImage> {

    @BeforeMethod public void beforeEach() {

        baseEntity = SequenceImage.create();

        super.beforeEach();

    }

}
