package platform.services.api.streams.recordings.sequences.images;

import org.springframework.beans.factory.annotation.Autowired;

import platform.services.api.commons.testing.BaseControllerTestCase;
import platform.services.api.streams.images.StreamImage;
import platform.services.api.users.UserAuthenticationTestSetup;
import platform.services.api.users.UserCompositeGenerator;

@BaseControllerTestCase
public class SequenceImageControllerTest extends UserAuthenticationTestSetup<StreamImage> {

    private static final String PATH_BASE = "/streamimage";

    @Autowired
    public SequenceImageControllerTest(final UserCompositeGenerator userCompositeGenerator) {

        super(StreamImage::create, StreamImage.class, PATH_BASE, userCompositeGenerator);

    }

}
