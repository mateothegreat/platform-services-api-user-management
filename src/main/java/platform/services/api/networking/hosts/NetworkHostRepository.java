package platform.services.api.networking.hosts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import platform.services.api.commons.jpa.repositories.BaseRepository;

//@Repository
//@RepositoryRestResource(collectionResourceRel = "hosts", collectionResourceDescription = @Description("asdf"), itemResourceDescription = @Description("xx"), path = "network/hosts")
//@RepositoryRestResource(path = "/network/hosts", collectionResourceRel = "hosts")
@RepositoryRestResource(path = "/hosts", collectionResourceRel = "hosts", itemResourceRel = "host")
public interface NetworkHostRepository extends BaseRepository<NetworkHost> {

//    @CacheEvict("byHostname")
//    NetworkHost save(NetworkHost entity);
//
//    @Cacheable("byHostname")
//    NetworkHost findByHostname(String hostname);
//
    @RestResource(path = "addresses", rel = "addresses")
//    @RequestMapping(method = RequestMethod.GET, name= "a", value = "/search/address", produces = MediaTypes.HAL_JSON_VALUE)
    Page<NetworkHost> findAllByAddressContains(@Param("term") final String address, final Pageable pageable);
//
//    @RequestMapping(method = RequestMethod.GET, name= "all", value = "/search/all", produces = MediaTypes.HAL_JSON_VALUE)
//    Page<NetworkHost> findAllByAddressContainsOrHostnameContainsOrPortContainsOrProtocolContains(@Param("term") final String address, @Param("term") final String hostname, @Param("term") final String port, @Param("term") final String protocol, @Param("term") final Pageable pageable);
//
//    @RequestMapping(method = RequestMethod.GET, name= "hostname", value = "/search/hostname", produces = MediaTypes.HAL_JSON_VALUE)
//    Page<NetworkHost> findAllByHostnameContains(@Param("term") final String hostname,  final Pageable pageable);
//
//    @RequestMapping(method = RequestMethod.GET, name= "protocol", value = "/search/protocol", produces = MediaTypes.HAL_JSON_VALUE)
//    Page<NetworkHost> findAllByProtocolContains(@Param("term") final NetworkProtocol protocol, final Pageable pageable);
}
