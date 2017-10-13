package platform.services.api.networking.hosts;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.assertj.core.api.Assertions.assertThat;

@Service @Getter @Setter
public class NetworkHostFactory {

    @Autowired private NetworkHostService networkHostService;

    private NetworkHost networkHost;

    public NetworkHost persist() {

        networkHost = networkHostService.saveAndGetById(NetworkHost.create());

        assertThat(networkHost).isNotNull();

        return networkHost;

    }

}
