package platform.services.api.streams.functions;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import platform.services.api.commons.jpa.repositories.BaseRepository;

@RepositoryRestResource
public interface StreamFunctionsRepository extends BaseRepository<StreamFunction> {

}
