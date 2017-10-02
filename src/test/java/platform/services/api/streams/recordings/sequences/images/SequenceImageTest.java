package platform.services.api.streams.recordings.sequences.images;

import org.junit.jupiter.api.*;

import platform.services.api.commons.testing.BaseEntityTest;
import platform.services.api.commons.testing.TestingSpringEntity;

@TestingSpringEntity
public class SequenceImageTest extends BaseEntityTest<SequenceImage> {

    @BeforeEach public void beforeEach() {

        baseEntity = SequenceImage.create();

        super.beforeEach();

    }

}
