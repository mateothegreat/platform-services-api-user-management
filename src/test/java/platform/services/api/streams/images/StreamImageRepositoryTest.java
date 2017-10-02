package platform.services.api.streams.images;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import platform.services.api.commons.jpa.datasources.DataSourceConfig;
import platform.services.api.commons.testing.BaseRepositoryTest;
import platform.services.api.commons.testing.TestingSpringRepository;

@TestingSpringRepository
@SpringBootTest(classes = { DataSourceConfig.class, StreamImageRepository.class })
public class StreamImageRepositoryTest extends BaseRepositoryTest<StreamImageRepository, StreamImage> {

    @Autowired StreamImageRepositoryTest(final StreamImageRepository repository) {

        super(repository, StreamImage::create, StreamImage.class);

    }

}
