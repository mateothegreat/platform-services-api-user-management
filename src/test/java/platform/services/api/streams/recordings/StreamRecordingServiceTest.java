package platform.services.api.streams.recordings;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;

import platform.services.api.commons.testing.BaseServiceTest;
import platform.services.api.commons.testing.TestingSpringService;
import platform.services.api.commons.validation.ValidationError;
import platform.services.api.streams.Stream;
import platform.services.api.streams.StreamService;
import platform.services.api.streams.recordings.sequences.StreamRecordingSequence;
import platform.services.api.streams.recordings.sequences.StreamRecordingSequenceService;

import static org.assertj.core.api.Assertions.assertThat;

@TestingSpringService
public class StreamRecordingServiceTest extends BaseServiceTest<StreamRecordingService, StreamRecordingRepository, StreamRecording> {

    private final StreamRecordingRepository      recordingRepository;
    private final StreamRecordingService         service;
    private final StreamRecordingSequenceService sequenceService;
    @Autowired
    private       StreamService                  streamService;

    @Autowired
    public StreamRecordingServiceTest(final StreamRecordingService service, final StreamRecordingSequenceService sequenceService, final StreamRecordingRepository recordingRepository) {

        super(service, StreamRecording::create, StreamRecording.class);

        this.service = service;
        this.sequenceService = sequenceService;
        this.recordingRepository = recordingRepository;

    }

    @BeforeMethod public void beforeEach() {

        final Stream                  streamFixture           = Stream.create();
        final StreamRecording         streamRecording         = StreamRecording.create();
        final StreamRecordingSequence streamRecordingSequence = StreamRecordingSequence.create();

        try {

            final Stream savedStream = streamService.save(streamFixture);

            assertThat(savedStream.getId()).isNotZero();

            streamRecording.setStream(savedStream);

            final StreamRecording savedRecording = service.getById(service.save(streamRecording).getId());

            assertThat(savedRecording.getId()).isNotZero();

            setFixture(savedRecording);

        } catch(final ValidationError error) {

            error.printStackTrace();

        }

    }

}
