package platform.services.api.streams.recordings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.*;

import platform.services.api.commons.jpa.datasources.DataSourceConfig;
import platform.services.api.commons.testing.BaseRepositoryTest;
import platform.services.api.commons.testing.TestingSpringRepository;
import platform.services.api.commons.validation.ValidationError;
import platform.services.api.streams.Stream;
import platform.services.api.streams.StreamService;

import static org.assertj.core.api.Assertions.assertThat;

@TestingSpringRepository
@SpringBootTest(classes = {

        DataSourceConfig.class,
        StreamService.class,
        StreamRecordingRepository.class

})
public class StreamRecordingRepositoryTest extends BaseRepositoryTest<StreamRecordingRepository, StreamRecording> {

    private final StreamRecordingRepository streamRecordingRepository;

    @Autowired
    private StreamService streamService;

    @Autowired StreamRecordingRepositoryTest(final StreamRecordingRepository streamRecordingRepository) {

        super(streamRecordingRepository, StreamRecording::create, StreamRecording.class);

        this.streamRecordingRepository = streamRecordingRepository;

    }

    @BeforeEach
    public void beforeEach() {

        try {

            final Stream          stream          = streamService.save(Stream.create());
            final StreamRecording streamRecording = streamRecordingRepository.getById(streamRecordingRepository.save(StreamRecording.create().setStream(stream)).getId());

            assertThat(streamRecording.getId()).isNotZero();

            setFixture(streamRecording);

        } catch(final ValidationError error) {

            error.printStackTrace();

        }

    }

}
