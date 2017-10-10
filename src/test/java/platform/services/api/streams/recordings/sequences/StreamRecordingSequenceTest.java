package platform.services.api.streams.recordings.sequences;

import org.testng.annotations.BeforeMethod;

import platform.services.api.commons.testing.BaseEntityTest;
import platform.services.api.commons.testing.TestingSpringEntity;

@TestingSpringEntity
public class StreamRecordingSequenceTest extends BaseEntityTest<StreamRecordingSequence> {

    @BeforeMethod public void beforeEach() {

        baseEntity = new StreamRecordingSequence().create();

        super.beforeEach();

    }

}
