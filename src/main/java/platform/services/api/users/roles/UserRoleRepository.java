package platform.services.api.users.roles;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import platform.services.api.commons.jpa.repositories.BaseRepository;

@Repository
@RepositoryRestResource(path = "people")
public interface UserRoleRepository extends BaseRepository<UserRole, Long> {

}
