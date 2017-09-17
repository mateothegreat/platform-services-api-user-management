package platform.services.api.users;

import lombok.Data;

import platform.services.api.commons.jpa.BaseEntity;
import platform.services.api.commons.jpa.EntityComposed;

@EntityComposed @Data
public class UserSettingsEntity extends BaseEntity<UserSettingsEntity> {

    protected boolean ENABLE_NOTIFICATIONS;

}
