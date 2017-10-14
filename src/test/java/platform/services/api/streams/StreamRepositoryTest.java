package platform.services.api.streams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import platform.services.api.commons.jpa.datasources.DataSourceConfig;
import platform.services.api.commons.testing.BaseRepositoryTest;

@SpringBootTest(classes = { DataSourceConfig.class, StreamRepository.class })
public class StreamRepositoryTest extends BaseRepositoryTest<StreamRepository, Stream> {

    @Autowired
    private StreamRepository repository;

//
//    @Autowired
//    private StreamFixtureFactory factory;

    @BeforeClass
    public void beforeClass() {

        setFn(Stream::create);
        setBaseRepository(repository);

    }

    @BeforeMethod @Test

    public void beforeMethod() {

//        setFixture(factory.persist());
//
//        try {
//
//            setFixture(repository.getById(getFixture().getId()));
//
//            assertThat(getFixture().getFunctions().size()).isEqualTo(2);
//
//        } catch(ValidationError error) {
//
//            error.printStackTrace();
//
//        }

//        functionsRepository.save(StreamFunction.create()
//                                               .setFunction(StreamFunctions.RECORD_ON_TRIGGER).setStream(getFixture()));

    }

}
