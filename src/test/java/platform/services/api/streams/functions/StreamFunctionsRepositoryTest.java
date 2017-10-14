package platform.services.api.streams.functions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import platform.services.api.commons.jpa.datasources.DataSourceConfig;
import platform.services.api.commons.testing.BaseRepositoryTest;
import platform.services.api.commons.validation.ValidationError;
import platform.services.api.streams.Stream;
import platform.services.api.streams.StreamFixtureFactory;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {

        DataSourceConfig.class,

        StreamFixtureFactory.class,

        StreamFunctions.class,
        StreamFunctionsRepository.class,
        StreamFunctionsService.class

})
public class StreamFunctionsRepositoryTest extends BaseRepositoryTest<StreamFunctionsRepository, StreamFunction> {

    @Autowired private StreamFunctionsRepository repository;
    @Autowired private StreamFunctionsService    service;
    @Autowired private StreamFixtureFactory      factory;

    @BeforeClass @Test public void beforeClass() {

        setBaseRepository(repository);

    }

    @BeforeMethod @Test
    public void beforeMethod() {

        try {

            final Stream stream = factory.persist();

            service.save(StreamFunction.create()
                                       .setFunction(StreamFunctions.MONITOR)
                                       .setStream(stream));

            setFixture(repository.getById(getFixture().getId()));

            assertThat(getFixture().getUuid()).isNotNull();

        } catch(ValidationError error) {

            error.printStackTrace();

        }

//        functionsRepository.save(StreamFunction.create()
//                                               .setFunction(StreamFunctions.RECORD_ON_TRIGGER).setStream(getFixture()));

    }
}
