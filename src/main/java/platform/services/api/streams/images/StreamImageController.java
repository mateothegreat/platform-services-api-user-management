package platform.services.api.streams.images;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import platform.services.api.commons.controller.BaseController;

@RestController
@RequestMapping("/streamimage")
public class StreamImageController extends BaseController<StreamImageService, StreamImageRepository, StreamImage> {

    private final StreamImageService service;

    @Autowired public StreamImageController(final StreamImageService service) {

        super(service);

        this.service = service;

    }

}
