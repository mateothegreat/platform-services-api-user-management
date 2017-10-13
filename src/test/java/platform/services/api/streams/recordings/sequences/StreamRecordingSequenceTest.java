package platform.services.api.streams.recordings.sequences;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import platform.services.api.commons.testing.BaseEntityTest;
import platform.services.api.commons.utilities.Randomizers;
import platform.services.api.streams.recordings.StreamRecording;

import static org.assertj.core.api.Assertions.assertThat;

public class StreamRecordingSequenceTest extends BaseEntityTest<StreamRecordingSequence> {

    @BeforeClass public void beforeEach() {

        baseEntity = StreamRecordingSequence.create();

    }

    @Test public void testCreate() {

        assertThat(StreamRecordingSequence.create()).isNotNull();

    }
    @Test public void testSetLocation() {

        assertThat(baseEntity.setLocation("test").getLocation()).isNotNull();

    }
    @Test public void testSetDateEnd() {

        assertThat(baseEntity.setDateEnd(LocalDateTime.now()).getDateEnd()).isNotNull();

    }
    @Test public void testSetDateOffset() {

        assertThat(baseEntity.setDateOffset(ZoneOffset.UTC).getDateOffset()).isNotNull();

    }
    @Test public void testSetDateStart() {

        assertThat(baseEntity.setDateStart(LocalDateTime.now()).getDateStart()).isNotNull();

    }
    @Test public void testSetDuration() {

        assertThat(baseEntity.setDuration(1L).getDuration()).isNotZero();

    }
    @Test public void testSetFilename() {

        baseEntity.setFilename(Randomizers.username());

        assertThat(baseEntity.setFilename(Randomizers.username()).getFilename()).isNotNull();

    }
    @Test public void testSetRecording() {

        assertThat(baseEntity.setRecording(StreamRecording.create()).getRecording()).isNotNull();

    }

}
