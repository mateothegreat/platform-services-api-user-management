package platform.services.api.users;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
