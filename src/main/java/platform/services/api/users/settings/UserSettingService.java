package platform.services.api.users.settings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import platform.services.api.commons.services.GenericService;

@Service
public class UserSettingService extends GenericService<UserSettingRepository, UserSetting> {

    private final UserSettingRepository repository;

    @Autowired
    public UserSettingService(final UserSettingRepository repository) {

        super(repository);

        this.repository = repository;

    }

}
