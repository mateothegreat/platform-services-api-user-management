package platform.services.api.users.profiles;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import platform.services.api.commons.jpa.repositories.BaseRepository;

@RepositoryRestResource(path = "profiles", collectionResourceRel = "profiles", itemResourceRel = "profile")
public interface UserProfileRepository extends BaseRepository<UserProfile> {

//    Optional<UserProfile> getByUserId(final Long userId);
//          UserProfile queryUserProfilesBy
}
