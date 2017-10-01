package platform.services.api.streams.recordings.sequences;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.*;

import platform.services.api.commons.jpa.datasources.DataSourceConfig;
import platform.services.api.commons.testing.BaseServiceTest;
import platform.services.api.commons.testing.TestingSpringService;

@TestingSpringService
@Tag("StreamRecordingSequence")
@SpringBootTest(classes = { DataSourceConfig.class, StreamRecordingSequenceService.class, StreamRecordingSequenceRepository.class })

public class StreamRecordingSequenceServiceTest extends BaseServiceTest<StreamRecordingSequenceService, StreamRecordingSequenceRepository, StreamRecordingSequence> {

    private final StreamRecordingSequenceService service;

    @Autowired
    public StreamRecordingSequenceServiceTest(final StreamRecordingSequenceService service) {

        super(service, StreamRecordingSequence::create, StreamRecordingSequence.class);

        this.service = service;

    }

}
