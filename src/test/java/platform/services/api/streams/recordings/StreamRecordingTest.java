package platform.services.api.streams.recordings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;

import platform.services.api.commons.testing.BaseEntityTest;
import platform.services.api.streams.Stream;
import platform.services.api.streams.recordings.sequences.StreamRecordingSequence;

import static org.assertj.core.api.Assertions.assertThat;

public class StreamRecordingTest extends BaseEntityTest<StreamRecording> {

    @BeforeMethod public void beforeEach() {

        baseEntity = StreamRecording.create();

    }

    @Test public void testCreate() {

        assertThat(StreamRecording.create()).isNotNull();

    }
    @Test public void testGetBitrate() {

        assertThat(baseEntity.getBitrate()).isNotNull();

    }
    @Test public void testGetBitrateAverage() {

        assertThat(baseEntity.getBitrateAverage()).isNotNull();

    }
    @Test public void testGetBitrateMax() {

        assertThat(baseEntity.getBitrateMax()).isNotNull();

    }
    @Test public void testGetCodec() {

        assertThat(baseEntity.getCodec()).isNotNull();

    }
    @Test public void testGetCrf() {

        assertThat(baseEntity.getCrf()).isNotNull();

    }
    @Test public void testGetDateEnd() {

        assertThat(baseEntity.getDateEnd()).isNotNull();

    }
    @Test public void testGetDateStart() {

        assertThat(baseEntity.getDateStart()).isNotNull();

    }
    @Test public void testGetDuration() {

        assertThat(baseEntity.getDuration()).isNotNull();

    }
    @Test public void testGetFps() {

        assertThat(baseEntity.getFps()).isNotNull();

    }
    @Test public void testGetResolutionHeight() {

        assertThat(baseEntity.getResolutionHeight()).isNotNull();

    }
    @Test public void testGetResolutionWidth() {

        assertThat(baseEntity.getResolutionWidth()).isNotNull();

    }
    @Test public void testGetSegmentLength() {

        assertThat(baseEntity.getSegmentLength()).isNotNull();

    }
    @Test public void testGetSequences() {

        assertThat(baseEntity.getSequences()).isNotNull();

    }
    @Test public void testGetStream() {

        assertThat(baseEntity.setStream(Stream.create()).getStream()).isNotNull();

    }
    @Test public void testSetDateEnd() {

        assertThat(baseEntity.setDateEnd(LocalDateTime.now()).getDateStart()).isNotNull();

    }
    @Test public void testSetDateStart() {

        assertThat(baseEntity.setDateStart(LocalDateTime.now()).getDateStart()).isNotNull();

    }
    @Test public void testSetDuration() {

        assertThat(baseEntity.getDateStart()).isNotNull();

    }
    @Test public void testSetSequences() {

        assertThat(baseEntity.setSequences(new HashSet<>(Collections.singletonList(StreamRecordingSequence.create()))).getSequences()).isNotNull();

    }
    @Test public void testSetStream() {

        assertThat(baseEntity.setStream(Stream.create()).getStream()).isNotNull();

    }

}
