package platform.services.api.users.profiles;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import platform.services.api.commons.jpa.entities.BaseEntity;
import platform.services.api.users.User;

@Entity
@Getter @Setter
@Table(name = "user_profiles")
public class UserProfile extends BaseEntity<UserProfile> {

    @JsonBackReference
    @ManyToOne
//    @JoinColumn(name = "parentId")
    @JoinColumn(name = "parentId")
    private User user;
    private String avatar;

    public UserProfile() {

    }

    public UserProfile(final String avatar) {

        this.avatar = avatar;

    }

    public UserProfile setUser(final User user) {

        this.user = user;

        return this;

    }

    public UserProfile setAvatar(final String avatar) {

        this.avatar = avatar;

        return this;

    }

    @Override public String toString() {

        return String.format("platform.services.api.users.profiles.UserProfile{user=%s, avatar='%s'} %s", user, avatar, super.toString());
    }
}
