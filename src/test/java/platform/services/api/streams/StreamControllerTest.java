package platform.services.api.streams;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.mvc.TypeReferences.PagedResourcesType;
import org.springframework.http.ResponseEntity;
import org.testng.annotations.BeforeClass;

import platform.services.api.commons.testing.BaseControllerTest;
import platform.services.api.networking.hosts.NetworkHost;

@SpringBootTest
public class StreamControllerTest extends BaseControllerTest<Stream> {

    @BeforeClass
    public void beforeClass() {

        getRest().setTypeReference(new PagedResourcesType<Stream>() {

        });

        final ResponseEntity<NetworkHost> result = getRest().getTemplate()
                                                            .postForEntity(getRest().getNewUri("hosts")
                                                                                    .build()
                                                                                    .toUri(), NetworkHost.create(), NetworkHost.class);

        super.beforeClass(StreamController.PATH_BASE, Stream.class, () -> Stream.create().setHost(result.getBody()));

    }

//    @BeforeMethod
//    public void beforeMethod() {
//
//        final ResponseEntity<NetworkHost> result = getRest().getTemplate()
//                                                            .postForEntity(getRest().getNewUri("hosts")
//                                                                                    .build()
//                                                                                    .toUri(), NetworkHost.create(), NetworkHost.class);
//
//    }

}
