package platform.services.api.streams.recordings.sequences.images;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import platform.services.api.commons.controller.BaseController;

@RestController
@RequestMapping("/streamimage")
public class SequenceImageController extends BaseController<SequenceImageService, SequenceImageRepository, SequenceImage> {

    private final SequenceImageService service;

    @Autowired public SequenceImageController(final SequenceImageService service) {

        super(service);

        this.service = service;

    }

}
