package platform.services.api.users.roles;

import org.springframework.stereotype.Repository;

import platform.services.api.commons.jpa.repositories.BaseRepository;
import platform.services.api.users.profiles.UserProfile;

@Repository
public interface UserRoleRepository extends BaseRepository<UserRole> {


}
