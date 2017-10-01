package platform.services.api.streams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import platform.services.api.commons.jpa.datasources.DataSourceConfig;
import platform.services.api.commons.testing.BaseRepositoryTest;
import platform.services.api.commons.testing.TestingSpringRepository;

@TestingSpringRepository
@SpringBootTest(classes = { DataSourceConfig.class, StreamRepository.class })
public class StreamRepositoryTest extends BaseRepositoryTest<StreamRepository, Stream> {

    @Autowired StreamRepositoryTest(final StreamRepository repository) {

        super(repository, Stream::create, Stream.class);

    }

}
