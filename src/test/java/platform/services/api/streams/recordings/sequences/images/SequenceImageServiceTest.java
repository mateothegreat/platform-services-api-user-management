package platform.services.api.streams.recordings.sequences.images;

import org.springframework.beans.factory.annotation.Autowired;

import platform.services.api.commons.testing.BaseServiceTest;
import platform.services.api.commons.testing.TestingSpringService;

@TestingSpringService
public class SequenceImageServiceTest extends BaseServiceTest<SequenceImageService, SequenceImageRepository, SequenceImage> {

    private final SequenceImageService service;

    @Autowired
    public SequenceImageServiceTest(final SequenceImageService service) {

        super(service, SequenceImage::create, SequenceImage.class);

        this.service = service;

    }

}
