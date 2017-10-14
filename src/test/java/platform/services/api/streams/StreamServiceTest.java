package platform.services.api.streams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import platform.services.api.commons.jpa.datasources.DataSourceConfig;
import platform.services.api.commons.testing.BaseServiceTest;
import platform.services.api.networking.hosts.NetworkHostFactory;
import platform.services.api.networking.hosts.NetworkHostFactorySetup;

@NetworkHostFactorySetup
@SpringBootTest(classes = { DataSourceConfig.class, StreamService.class, StreamRepository.class })
public class StreamServiceTest extends BaseServiceTest<StreamService, StreamRepository, Stream> {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private StreamService service;

    @Autowired
    private NetworkHostFactory networkHostFactory;

    @BeforeClass
    public void beforeClass() {

        setFn(Stream::create);
        setGenericService(service);

    }

    @BeforeMethod
    public void beforeMethod() {

        setFixture(service.saveAndGetById(Stream.create().setHost(networkHostFactory.persist())));

    }

}
