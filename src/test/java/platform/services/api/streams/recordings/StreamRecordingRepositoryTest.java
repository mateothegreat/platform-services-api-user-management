package platform.services.api.streams.recordings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.*;

import platform.services.api.commons.jpa.datasources.DataSourceConfig;
import platform.services.api.commons.testing.BaseRepositoryTest;
import platform.services.api.commons.testing.TestingSpringRepository;
import platform.services.api.streams.recordings.sequences.StreamRecordingSequence;

import static org.assertj.core.api.Assertions.assertThat;

@TestingSpringRepository
@SpringBootTest(classes = { DataSourceConfig.class, StreamRecordingRepository.class })
public class StreamRecordingRepositoryTest extends BaseRepositoryTest<StreamRecordingRepository, StreamRecording> {

    @Autowired StreamRecordingRepositoryTest(final StreamRecordingRepository repository) {

        super(repository, StreamRecording::create, StreamRecording.class);

    }

    @Test
    public void createStreamRecordingSequences() {

        getFixture().getSequences().add(new StreamRecordingSequence().create());

        getBaseRepository().save(getFixture());

        setFixture(getBaseRepository().getById(getFixture().getId()));

        assertThat(getFixture().getSequences().size()).isNotZero();

    }


}
