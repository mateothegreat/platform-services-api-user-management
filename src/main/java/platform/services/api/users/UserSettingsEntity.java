package platform.services.api.users;

import lombok.Data;

import platform.services.api.commons.jpa.entities.BaseEntity;
import platform.services.api.commons.jpa.entities.EntityComposed;

@EntityComposed @Data
public class UserSettingsEntity extends BaseEntity<UserSettingsEntity> {

    protected boolean ENABLE_NOTIFICATIONS;

}
