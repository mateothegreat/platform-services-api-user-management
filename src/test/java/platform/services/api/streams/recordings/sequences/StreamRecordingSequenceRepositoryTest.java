package platform.services.api.streams.recordings.sequences;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.*;

import platform.services.api.commons.jpa.datasources.DataSourceConfig;
import platform.services.api.commons.testing.BaseRepositoryTest;
import platform.services.api.commons.testing.TestingSpringRepository;
import platform.services.api.streams.recordings.StreamRecording;
import platform.services.api.streams.recordings.StreamRecordingRepository;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
@TestingSpringRepository
@SpringBootTest(classes = { DataSourceConfig.class, StreamRecordingSequenceRepository.class })
@Tag("StreamRecordingSequence")
public class StreamRecordingSequenceRepositoryTest extends BaseRepositoryTest<StreamRecordingSequenceRepository, StreamRecordingSequence> {

    private final StreamRecordingSequenceRepository streamRecordingSequenceRepository;
    private final StreamRecordingRepository         streamRecordingRepository;

    @Autowired StreamRecordingSequenceRepositoryTest(final StreamRecordingSequenceRepository streamRecordingSequenceRepository, final StreamRecordingRepository streamRecordingRepository) {

        super(streamRecordingSequenceRepository, StreamRecordingSequence::create, StreamRecordingSequence.class);

        this.streamRecordingRepository = streamRecordingRepository;
        this.streamRecordingSequenceRepository = streamRecordingSequenceRepository;

    }

    @BeforeEach public void beforeEach() {

        persistFixture(getFn().create());

        final StreamRecording streamRecording = StreamRecording.create();

        streamRecording.getSequences().add(getFn().create());

        final StreamRecording persistedRecording = streamRecordingRepository.getById(streamRecordingRepository.save(streamRecording).getId());



    }

    @Test
    public void getSequencesByRecordingId() {

//        final Page<StreamRecordingSequence> page = getBaseRepository().getByParentId(getFixture().getId(), new PageRequest(0, 10));
//
//        assertThat(page.getTotalElements()).isNotZero();

    }

}
