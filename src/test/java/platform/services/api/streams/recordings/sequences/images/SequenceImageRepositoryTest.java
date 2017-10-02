package platform.services.api.streams.recordings.sequences.images;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import platform.services.api.commons.jpa.datasources.DataSourceConfig;
import platform.services.api.commons.testing.BaseRepositoryTest;
import platform.services.api.commons.testing.TestingSpringRepository;

@TestingSpringRepository
@SpringBootTest(classes = { DataSourceConfig.class, SequenceImageRepository.class })
public class SequenceImageRepositoryTest extends BaseRepositoryTest<SequenceImageRepository, SequenceImage> {

    @Autowired SequenceImageRepositoryTest(final SequenceImageRepository repository) {

        super(repository, SequenceImage::create, SequenceImage.class);

    }

}
