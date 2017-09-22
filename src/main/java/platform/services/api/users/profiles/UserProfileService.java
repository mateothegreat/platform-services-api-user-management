package platform.services.api.users.profiles;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import platform.services.api.commons.services.GenericService;

@Log4j2
@Service
public class UserProfileService extends GenericService<UserProfileRepository, UserProfile> {

    private final UserProfileRepository repository;

    @Autowired
    public UserProfileService(final UserProfileRepository repository) {

        super(repository);

        this.repository = repository;

    }

//    public Optional<UserProfile> getByUserId(final Long userId) {
//
////        return repository.getByUserId(userId);
//return null
//    }

}
