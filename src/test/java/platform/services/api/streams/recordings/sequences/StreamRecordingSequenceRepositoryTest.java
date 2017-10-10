package platform.services.api.streams.recordings.sequences;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeMethod;

import platform.services.api.commons.jpa.datasources.DataSourceConfig;
import platform.services.api.commons.testing.BaseRepositoryTest;
import platform.services.api.commons.testing.TestingSpringRepository;
import platform.services.api.commons.validation.ValidationError;
import platform.services.api.streams.Stream;
import platform.services.api.streams.StreamService;
import platform.services.api.streams.recordings.StreamRecording;
import platform.services.api.streams.recordings.StreamRecordingRepository;
import platform.services.api.streams.recordings.StreamRecordingService;

import static org.assertj.core.api.Assertions.assertThat;

@TestingSpringRepository
@SpringBootTest(classes = {

        DataSourceConfig.class,
        StreamService.class,
        StreamRecordingRepository.class,
        StreamRecordingService.class,
        StreamRecordingSequenceRepository.class

})
public class StreamRecordingSequenceRepositoryTest extends BaseRepositoryTest<StreamRecordingSequenceRepository, StreamRecordingSequence> {

    private final StreamRecordingSequenceRepository streamRecordingSequenceRepository;

    @Autowired
    private StreamRecordingRepository streamRecordingRepository;

    @Autowired
    private StreamService streamService;

    @Autowired
    private StreamRecordingService streamRecordingService;

    @Autowired StreamRecordingSequenceRepositoryTest(final StreamRecordingSequenceRepository streamRecordingSequenceRepository) {

        super(streamRecordingSequenceRepository, StreamRecordingSequence::create, StreamRecordingSequence.class);

        this.streamRecordingSequenceRepository = streamRecordingSequenceRepository;

    }

    @BeforeMethod
    public void beforeEach() {

        try {

            final Stream                  stream                  = streamService.save(Stream.create());
            final StreamRecording         streamRecording         = streamRecordingService.save(StreamRecording.create().setStream(stream));
            final StreamRecordingSequence streamRecordingSequence = streamRecordingSequenceRepository.getById(streamRecordingSequenceRepository.save(StreamRecordingSequence.create().setRecording(streamRecording)).getId());

            assertThat(streamRecordingSequence.getId()).isNotZero();

            setFixture(streamRecordingSequence);

        } catch(final ValidationError error) {

            error.printStackTrace();

        }

    }

}
