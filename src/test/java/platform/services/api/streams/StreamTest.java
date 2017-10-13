package platform.services.api.streams;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

import platform.services.api.commons.testing.BaseEntityTest;
import platform.services.api.commons.utilities.Randomizers;
import platform.services.api.networking.hosts.NetworkHost;
import platform.services.api.streams.recordings.StreamRecording;

import static org.assertj.core.api.Assertions.assertThat;

public class StreamTest extends BaseEntityTest<Stream> {

    @BeforeMethod @Test public void beforeEach() {

        baseEntity = Stream.create();

        assertThat(baseEntity).isNotNull();

    }

    @Test public void testAddRecording() {

        assertThat(baseEntity.addRecording(StreamRecording.create()).getRecordings()).isNotNull();

    }
    @Test public void testGetDescription() {

        assertThat(baseEntity.getDescription()).isNotNull();

    }
    @Test public void testGetHost() {

        assertThat(baseEntity.getHost()).isNotNull();

    }
    @Test public void testGetName() {

        assertThat(baseEntity.getName()).isNotNull();

    }
    @Test public void testGetPassword() {

        assertThat(baseEntity.getPassword()).isNotBlank();

    }
    @Test public void testGetPath() {

        assertThat(baseEntity.getPath()).isNotNull();

    }
    @Test public void testGetProtcol() {

        assertThat(baseEntity.getProtcol()).isNotNull();

    }
    @Test public void testGetRecordings() {

        assertThat(baseEntity.getRecordings()).isNotNull();

    }
    @Test public void testGetUsername() {

        assertThat(baseEntity.setUsername(Randomizers.username()).getUsername()).isNotNull();

    }
    @Test public void testSetDescription() {

        assertThat(baseEntity.setDescription("test").getDescription()).isNotNull();

    }
    @Test public void testSetHost() {

        assertThat(baseEntity.setHost(NetworkHost.create()).getHost()).isNotNull();

    }
    @Test public void testSetName() {

        assertThat(baseEntity.getName()).isNotNull();

    }
    @Test public void testSetPassword() {

        assertThat(baseEntity.setPassword(Randomizers.password()).getPassword()).isNotBlank();

    }
    @Test public void testSetPath() {

        assertThat(baseEntity.setPath("test").getPath()).isEqualTo("test");

    }
    @Test public void testSetProtcol() {

        assertThat(baseEntity.setProtcol(StreamProtocol.RTMP)).isNotNull();

    }
    @Test public void testSetRecordings() {

        Set<StreamRecording> streamRecordings = new HashSet<>(1);

        streamRecordings.add(StreamRecording.create());

        assertThat(baseEntity.setRecordings(streamRecordings).getRecordings()).isNotNull();

    }
    @Test public void testSetUsername() {

        assertThat(baseEntity.setUsername(Randomizers.username()).getUsername()).isNotNull();

    }

}
