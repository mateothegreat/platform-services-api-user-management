package platform.services.api.users.settings;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import platform.services.api.commons.jpa.entities.BaseEntity;
import platform.services.api.users.User;

@Table(name = "user_settings")
@Entity @Getter @Setter
public class UserSetting extends BaseEntity {

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "parentId")
    private User user;

    private String name;

    private boolean enabled;

    public UserSetting(final String name, final boolean enabled) {

        this.name = name;
        this.enabled = enabled;

    }

    public UserSetting() {

    }

}
