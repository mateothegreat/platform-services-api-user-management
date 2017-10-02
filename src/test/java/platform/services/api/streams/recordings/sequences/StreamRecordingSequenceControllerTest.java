package platform.services.api.streams.recordings.sequences;

import org.springframework.beans.factory.annotation.Autowired;

import org.junit.jupiter.api.*;

import platform.services.api.commons.testing.BaseControllerTestCase;
import platform.services.api.streams.Stream;
import platform.services.api.streams.recordings.StreamRecording;
import platform.services.api.users.UserAuthenticationTestSetup;
import platform.services.api.users.UserCompositeGenerator;

@BaseControllerTestCase
public class StreamRecordingSequenceControllerTest extends UserAuthenticationTestSetup<StreamRecordingSequence> {


    private static final String PATH_BASE = "/";

    @Autowired
    public StreamRecordingSequenceControllerTest(final UserCompositeGenerator userCompositeGenerator) {

        super(StreamRecordingSequence::create, StreamRecordingSequence.class, PATH_BASE, userCompositeGenerator);

    }

    @BeforeEach
    public void beforeEach() {

        final Stream          streamFixture          = Stream.create();
        final Stream          streamEntity           = create_custom_expecting_201_CREATED("/streams", streamFixture, Stream.class);
        final StreamRecording streamRecordingFixture = StreamRecording.create();
        final StreamRecording streamRecordingEntity  = create_custom_expecting_201_CREATED(String.format("/streams/%s/recordings", streamEntity.getUuid()), streamRecordingFixture, StreamRecording.class);

        setPathBase(String.format("/streams/%s/recordings/%s/sequences", streamEntity.getUuid(), streamRecordingEntity.getUuid()));

        generateFixture();

        fixture.setRecording(streamRecordingEntity);

        setEntity(create_expecting_201_CREATED(getFixture()));

    }

}
