package platform.services.api.streams.images;

import org.springframework.beans.factory.annotation.Autowired;

import platform.services.api.commons.testing.BaseServiceTest;
import platform.services.api.commons.testing.TestingSpringService;

@TestingSpringService
public class StreamImageServiceTest extends BaseServiceTest<StreamImageService, StreamImageRepository, StreamImage> {

    private final StreamImageService service;

    @Autowired
    public StreamImageServiceTest(final StreamImageService service) {

        super(service, StreamImage::create, StreamImage.class);

        this.service = service;

    }

}
