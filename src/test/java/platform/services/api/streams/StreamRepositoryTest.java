package platform.services.api.streams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeClass;

import platform.services.api.commons.jpa.datasources.DataSourceConfig;
import platform.services.api.commons.testing.BaseRepositoryTest;

@SpringBootTest(classes = { DataSourceConfig.class, StreamRepository.class })
public class StreamRepositoryTest extends BaseRepositoryTest<StreamRepository, Stream> {

    @Autowired
    private StreamRepository repository;

    @BeforeClass
    public void beforeClass() {

        setFn(Stream::create);
        setBaseRepository(repository);

    }

}
