package platform.services.api.users.profiles;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import platform.services.api.commons.services.GenericServiceImpl;

@Log4j2
@Service
public class UserProfileService extends GenericServiceImpl<UserProfileRestRepository, UserProfile> {

    private final UserProfileRestRepository repository;

    @Autowired
    public UserProfileService(final UserProfileRestRepository repository) {

        super(repository);

        this.repository = repository;

    }

//    public Optional<UserProfile> getByUserId(final Long userId) {
//
////        return repository.getByUserId(userId);
//return null
//    }

}
