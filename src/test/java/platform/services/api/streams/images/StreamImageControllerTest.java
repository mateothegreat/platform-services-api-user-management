package platform.services.api.streams.images;

import org.springframework.beans.factory.annotation.Autowired;

import platform.services.api.commons.testing.BaseControllerTestCase;
import platform.services.api.users.UserAuthenticationTestSetup;
import platform.services.api.users.UserCompositeGenerator;

@BaseControllerTestCase
public class StreamImageControllerTest extends UserAuthenticationTestSetup<StreamImage> {

    private static final String PATH_BASE = "/streamimage";

    @Autowired
    public StreamImageControllerTest(final UserCompositeGenerator userCompositeGenerator) {

        super(StreamImage::create, StreamImage.class, PATH_BASE, userCompositeGenerator);

    }

}
