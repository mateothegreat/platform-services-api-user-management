package platform.services.api.users.settings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

import platform.services.api.commons.services.GenericService;
import platform.services.api.commons.validation.ValidationError;
import platform.services.api.users.User;
import platform.services.api.users.UserService;

@Service
public class UserSettingService extends GenericService<UserSettingRepository, UserSetting> {

    private final UserSettingRepository repository;

    @Autowired
    private UserService userService;

    @Autowired
    public UserSettingService(final UserSettingRepository repository) {

        super(repository);

        this.repository = repository;

    }

    public UserSetting save(final UUID uuid, final UserSetting entity) throws ValidationError {

        final User parent = userService.getByUuid(uuid);

        if(parent == null) {

            throw new ValidationError("Invalid user");

        }

        entity.setUser(parent);

        return repository.save(entity);

    }

}
