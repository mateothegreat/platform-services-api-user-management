package platform.services.api.users;

import org.springframework.stereotype.Repository;

import platform.services.api.commons.jpa.repositories.BaseRestRepository;

@Repository
public interface UserProfileRestRepository extends BaseRestRepository<UserProfile, Long> {

}
