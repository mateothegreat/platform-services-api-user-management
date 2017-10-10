package platform.services.api.streams.recordings;

import org.testng.annotations.BeforeMethod;

import platform.services.api.commons.testing.BaseEntityTest;
import platform.services.api.commons.testing.TestingSpringEntity;

@TestingSpringEntity
public class StreamRecordingTest extends BaseEntityTest<StreamRecording> {

    @BeforeMethod public void beforeEach() {

        baseEntity = StreamRecording.create();

        super.beforeEach();

    }

}
