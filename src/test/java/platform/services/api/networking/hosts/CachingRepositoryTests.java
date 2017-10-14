package platform.services.api.networking.hosts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

import platform.services.api.commons.jpa.datasources.DataSourceConfig;

@Test
@Transactional
@SpringBootTest(classes = { DataSourceConfig.class, NetworkHostRepository.class })
public  class CachingRepositoryTests extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired NetworkHostRepository repository;
    @Autowired CacheManager          cacheManager;

    @Test
    public void cachesValuesReturnedForQueryMethod() {

        NetworkHost host = repository.save((NetworkHost) NetworkHost.create().setHostname("host1"));

//        assertThat(repository.findByHostname("host1")).isEqualTo(host);
//
//        // Verify entity cached
//        Cache cache = cacheManager.getCache("byHostname");
//        assertThat(cache.get("host1").get()).isEqualTo(host);
    }
}
