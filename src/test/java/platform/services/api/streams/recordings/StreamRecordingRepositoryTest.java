package platform.services.api.streams.recordings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.transaction.Transactional;

import platform.services.api.commons.jpa.datasources.DataSourceConfig;
import platform.services.api.commons.testing.BaseRepositoryTest;
import platform.services.api.streams.Stream;
import platform.services.api.streams.StreamService;

@Transactional

@SpringBootTest(classes = { DataSourceConfig.class, StreamService.class, StreamRecordingRepository.class })
public class StreamRecordingRepositoryTest extends BaseRepositoryTest<StreamRecordingRepository, StreamRecording> {

    @Autowired private StreamRecordingRepository repository;
    @Autowired private StreamService             streamService;

    @BeforeClass public void beforeClass() {

        setFn(StreamRecording::create);
        setBaseRepository(repository);

    }
    @BeforeMethod @Test public void beforeMethod() {

        persistFixture(StreamRecording.create()
                                      .setStream(streamService.saveAndGetById(Stream.create())));

    }

}


