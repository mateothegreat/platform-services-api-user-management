package platform.services.api.streams;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import platform.services.api.commons.jpa.repositories.BaseRepository;

@RepositoryRestResource(path = "streams", collectionResourceRel = "streams", itemResourceRel = "stream")
public interface StreamRepository extends BaseRepository<Stream> {

    @RestResource(path = "names", rel = "names")
    Page<Stream> findAllByNameContains(String term, Pageable pageable);

}
