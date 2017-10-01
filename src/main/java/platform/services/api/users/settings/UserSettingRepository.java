package platform.services.api.users.settings;

import org.springframework.stereotype.Repository;

import platform.services.api.commons.jpa.repositories.BaseRepository;

@Repository
public interface UserSettingRepository extends BaseRepository<UserSetting> {

}
