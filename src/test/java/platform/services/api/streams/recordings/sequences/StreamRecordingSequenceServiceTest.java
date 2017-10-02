package platform.services.api.streams.recordings.sequences;

import org.springframework.beans.factory.annotation.Autowired;

import org.junit.jupiter.api.*;

import platform.services.api.commons.testing.BaseServiceTest;
import platform.services.api.commons.testing.TestingSpringService;
import platform.services.api.commons.validation.ValidationError;
import platform.services.api.streams.Stream;
import platform.services.api.streams.StreamService;
import platform.services.api.streams.recordings.StreamRecording;
import platform.services.api.streams.recordings.StreamRecordingService;

import static org.assertj.core.api.Assertions.assertThat;

@TestingSpringService
public class StreamRecordingSequenceServiceTest extends BaseServiceTest<StreamRecordingSequenceService, StreamRecordingSequenceRepository, StreamRecordingSequence> {

    @Autowired
    private StreamService streamService;

    @Autowired
    private StreamRecordingService streamRecordingService;

    private final StreamRecordingSequenceService service;

    @Autowired
    public StreamRecordingSequenceServiceTest(final StreamRecordingSequenceService service) {

        super(service, StreamRecordingSequence::create, StreamRecordingSequence.class);

        this.service = service;

    }

    @BeforeEach public void beforeEach() {

        final Stream                  streamFixture           = Stream.create();
        final StreamRecording         streamRecording         = StreamRecording.create();
        final StreamRecordingSequence streamRecordingSequence = StreamRecordingSequence.create();

        try {

            final Stream savedStream = streamService.save(streamFixture);

            assertThat(savedStream.getId()).isNotZero();

            streamRecording.setStream(savedStream);

            final StreamRecording savedRecording = streamRecordingService.getById(streamRecordingService.save(streamRecording).getId());

            assertThat(savedRecording.getId()).isNotZero();

            streamRecordingSequence.setRecording(savedRecording);

            final StreamRecordingSequence savedSequence = service.getById(service.save(streamRecordingSequence).getId());

            assertThat(savedSequence.getId()).isNotZero();

            setFixture(savedSequence);

            assertThat(streamRecordingService.getById(streamRecordingService.save(streamRecording).getId()).getSequences().size()).isNotZero();

        } catch(final ValidationError error) {

            error.printStackTrace();

        }

    }

}
