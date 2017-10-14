package platform.services.api.organizations;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import platform.services.api.commons.jpa.repositories.BaseRepository;

@RepositoryRestResource(path = "organizations", collectionResourceRel = "organizations", itemResourceRel = "organization")
public interface OrganizationRepository extends BaseRepository<Organization> {

    @RestResource(path = "names", rel = "names")
    Page<Organization> findAllByNameContains(String term, Pageable pageable);

}
