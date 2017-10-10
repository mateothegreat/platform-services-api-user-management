package platform.services.api.streams.recordings;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;

import platform.services.api.commons.testing.BaseControllerTestCase;
import platform.services.api.streams.Stream;
import platform.services.api.users.UserAuthenticationTestSetup;
import platform.services.api.users.UserCompositeGenerator;

@BaseControllerTestCase
public class StreamRecordingControllerTest extends UserAuthenticationTestSetup<StreamRecording> {

    private static final String PATH_BASE = "/";

    @Autowired
    public StreamRecordingControllerTest(@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") final UserCompositeGenerator userCompositeGenerator) {

        super(StreamRecording::create, StreamRecording.class, PATH_BASE, userCompositeGenerator);

    }

    @BeforeMethod
    public void beforeEach() {

        final Stream streamFixture = Stream.create();
        final Stream streamEntity  = create_custom_expecting_201_CREATED("/streams", streamFixture, Stream.class);

        setPathBase(String.format("/streams/%s/recordings", streamEntity.getUuid()));

        generateFixture();

        setEntity(create_expecting_201_CREATED(getFixture()));

    }

}
