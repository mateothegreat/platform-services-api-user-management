package platform.services.api.users.profiles;

import org.springframework.stereotype.Repository;

import platform.services.api.commons.jpa.repositories.BaseRestRepository;

@Repository
public interface UserProfileRestRepository extends BaseRestRepository<UserProfile, Long> {

//    Optional<UserProfile> getByUserId(final Long userId);

}
