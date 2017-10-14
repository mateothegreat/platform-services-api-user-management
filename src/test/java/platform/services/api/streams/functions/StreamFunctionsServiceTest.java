package platform.services.api.streams.functions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeClass;

import platform.services.api.commons.jpa.datasources.DataSourceConfig;
import platform.services.api.commons.testing.BaseServiceTest;

@SpringBootTest(classes = { DataSourceConfig.class, StreamFunctionsService.class, StreamFunctionsRepository.class })
public class StreamFunctionsServiceTest extends BaseServiceTest<StreamFunctionsService, StreamFunctionsRepository, StreamFunction> {

    @Autowired
    private StreamFunctionsService service;

    @BeforeClass
    public void beforeClass() {

        setFn(StreamFunction::create);
        setGenericService(service);

    }

}
