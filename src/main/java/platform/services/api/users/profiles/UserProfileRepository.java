package platform.services.api.users.profiles;

import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import platform.services.api.commons.jpa.repositories.BaseRepository;

@Repository
public interface UserProfileRepository extends BaseRepository<UserProfile, Long> {

//    Optional<UserProfile> getByUserId(final Long userId);

}
