package platform.services.api.networking.hosts;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

import platform.services.api.commons.networking.NetworkProtocol;

@Getter @Setter
public class NetworkHostResource extends ResourceSupport {

    private Long entityId = 1L;

    private String address = "1.1.1.1";

    private String hostname = "asdf";

    private int port = 123;

    private NetworkProtocol protocol = NetworkProtocol.TCP;
    ;

}
