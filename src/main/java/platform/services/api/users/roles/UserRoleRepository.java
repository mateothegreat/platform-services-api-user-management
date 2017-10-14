package platform.services.api.users.roles;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import platform.services.api.commons.jpa.repositories.BaseRepository;

@RepositoryRestResource(path = "roles", collectionResourceRel = "roles", itemResourceRel = "role")
public interface UserRoleRepository extends BaseRepository<UserRole> {


}
