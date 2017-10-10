package platform.services.api.streams;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;

import javax.transaction.Transactional;

import platform.services.api.commons.testing.BaseServiceTest;
import platform.services.api.commons.testing.TestingSpringService;
import platform.services.api.commons.validation.ValidationError;
import platform.services.api.streams.recordings.StreamRecording;
import platform.services.api.streams.recordings.StreamRecordingService;
import platform.services.api.streams.recordings.sequences.StreamRecordingSequence;
import platform.services.api.streams.recordings.sequences.StreamRecordingSequenceService;

import static org.assertj.core.api.Assertions.assertThat;

@TestingSpringService
@Transactional
public class StreamServiceTest extends BaseServiceTest<StreamService, StreamRepository, Stream> {

    private final StreamService service;

    @Autowired
    private StreamRecordingService streamRecordingService;

    @Autowired
    StreamRecordingSequenceService streamRecordingSequenceService;

    @Autowired
    public StreamServiceTest(final StreamService service) {

        super(service, Stream::create, Stream.class);

        this.service = service;

    }

    @BeforeMethod
    public void beforeEach() {

        final Stream                  streamFixture           = Stream.create();
        final StreamRecording         streamRecording         = StreamRecording.create();
        final StreamRecordingSequence streamRecordingSequence = StreamRecordingSequence.create();

        try {

            Stream saved = service.save(streamFixture);

            setFixture(saved);

//            streamRecording.getSequences().add(streamRecordingSequence);
            streamRecording.setStream(service.getById(saved.getId()));

            StreamRecording streamRecordingSaved = streamRecordingService.save(streamRecording);

//            streamRecordingSequence.setRecording(streamRecordingSaved);
//
//            streamRecordingSequenceService.save(streamRecordingSequence);

            saved = service.getById(streamFixture.getId());

            assertThat(saved.getRecordings().size()).isNotZero();
//            assertThat(saved.getRecordings().iterator().next().getSequences().size()).isNotZero();

        } catch(final ValidationError error) {

            error.printStackTrace();

        }

    }

}
