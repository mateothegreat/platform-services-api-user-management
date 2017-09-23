package platform.services.api.users;

import javax.persistence.Entity;

import platform.services.api.commons.jpa.entities.BaseEntity;

@Entity
public class UserSettingsEntity extends BaseEntity<UserSettingsEntity> {

    protected boolean ENABLE_NOTIFICATIONS;

}
