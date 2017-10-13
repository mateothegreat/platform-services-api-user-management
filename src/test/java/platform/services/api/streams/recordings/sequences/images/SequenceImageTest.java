package platform.services.api.streams.recordings.sequences.images;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import platform.services.api.commons.testing.BaseEntityTest;
import platform.services.api.streams.recordings.sequences.StreamRecordingSequence;

import static org.assertj.core.api.Assertions.assertThat;

public class SequenceImageTest extends BaseEntityTest<SequenceImage> {

    @Test @BeforeMethod public void beforeEach() {

        baseEntity = SequenceImage.create();

        assertThat(SequenceImage.create()).isNotNull();

    }

    @Test public void testCreate() {

        assertThat(SequenceImage.create()).isNotNull();

    }
    @Test public void testSetSequence() {

        assertThat(baseEntity.setSequence(StreamRecordingSequence.create()).getSequence()).isNotNull();

    }

}
