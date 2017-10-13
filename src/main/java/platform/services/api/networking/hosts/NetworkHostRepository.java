package platform.services.api.networking.hosts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.hateoas.MediaTypes;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import platform.services.api.commons.jpa.repositories.BaseRepository;
import platform.services.api.commons.networking.NetworkProtocol;

@Repository(value = "/network/hosts")
//@RepositoryRestResource(collectionResourceRel = "networkHosts", path = "/network/hosts")

public interface NetworkHostRepository extends BaseRepository<NetworkHost> {

    @RequestMapping(method = RequestMethod.GET, name= "address", path = "/search/address", produces = MediaTypes.HAL_JSON_VALUE)
    Page<NetworkHost> findAllByAddressContains(@Param("term") final String address, final Pageable pageable);

    @RequestMapping(method = RequestMethod.GET, name= "all", path = "/search/all", produces = MediaTypes.HAL_JSON_VALUE)
    Page<NetworkHost> findAllByAddressContainsOrHostnameContainsOrPortContainsOrProtocolContains(@Param("term") final String address, @Param("term") final String hostname, @Param("term") final String port, @Param("term") final String protocol, @Param("term") final Pageable pageable);

    @RequestMapping(method = RequestMethod.GET, name= "hostname", path = "/search/hostname", produces = MediaTypes.HAL_JSON_VALUE)
    Page<NetworkHost> findAllByHostnameContains(@Param("term") final String hostname,  final Pageable pageable);

    @RequestMapping(method = RequestMethod.GET, name= "protocol", path = "/search/protocol", produces = MediaTypes.HAL_JSON_VALUE)
    Page<NetworkHost> findAllByProtocolContains(@Param("term") final NetworkProtocol protocol, final Pageable pageable);

}
