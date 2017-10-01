package platform.services.api.streams.recordings;

import org.junit.jupiter.api.*;

import platform.services.api.commons.testing.BaseEntityTest;
import platform.services.api.commons.testing.TestingSpringEntity;

@TestingSpringEntity
public class StreamRecordingTest extends BaseEntityTest<StreamRecording> {

    @BeforeEach public void beforeEach() {

        baseEntity = StreamRecording.create();

        super.beforeEach();

    }

}
