package platform.services.api.streams.recordings;

import org.springframework.beans.factory.annotation.Autowired;

import org.junit.jupiter.api.*;

import platform.services.api.commons.testing.BaseServiceTest;
import platform.services.api.commons.testing.TestingSpringService;
import platform.services.api.commons.validation.ValidationError;
import platform.services.api.streams.recordings.sequences.StreamRecordingSequence;
import platform.services.api.streams.recordings.sequences.StreamRecordingSequenceService;

import static org.assertj.core.api.Assertions.assertThat;

@TestingSpringService
public class StreamRecordingServiceTest extends BaseServiceTest<StreamRecordingService, StreamRecordingRepository, StreamRecording> {

    private final StreamRecordingRepository      recordingRepository;
    private final StreamRecordingService         service;
    private final StreamRecordingSequenceService sequenceService;

    @Autowired
    public StreamRecordingServiceTest(final StreamRecordingService service, final StreamRecordingSequenceService sequenceService, final StreamRecordingRepository recordingRepository) {

        super(service,StreamRecording::create, StreamRecording.class);

        this.service = service;
        this.sequenceService = sequenceService;
        this.recordingRepository = recordingRepository;

    }

//    @BeforeEach
//    public void beforeEach() {
//
////        super.beforeEach();
//
//        final StreamRecording saved = service.save(new StreamRecording().create());
//
//        setFixture(service.getById(saved.getId()));
//
//        assertThat(getFixture().getSequences().size()).isNotZero();
//        assertThat(getFixture().getSequences().iterator().next().getRecordingId()).isNotZero();
//
//    }

//    @Test
//    public void getAllByRecordingId() {
//
//        final Page<StreamRecordingSequence> page = sequenceService.getAllByRecordingId(getFixture().getId());
//
////        assertThat(page.getTotalElements()).isNotZero();
////        assertThat(page.getContent().get(0).getRecordingId()).isNotZero();
//
//    }

    @Test
    public void createStreamRecordingSequences() {


        getFixture().getSequences().add(new StreamRecordingSequence().create());

        try {
            getGenericService().save(getFixture());

        } catch(final ValidationError error) {

            error.printStackTrace();

        }

        setFixture(getGenericService().getById(getFixture().getId()));

        assertThat(getFixture().getSequences().size()).isNotZero();

    }

}
