package platform.services.api.users.profiles;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import platform.services.api.commons.jpa.entities.BaseEntity;
import platform.services.api.commons.utilities.Randomizers;
import platform.services.api.users.User;

@Entity
@Getter @Setter
@Table(name = "user_profiles")
public class UserProfile extends BaseEntity<UserProfile> {

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    private String displayName;
    private String avatar;

    public UserProfile() {

    }

    public UserProfile(final String avatar) {

        this.avatar = avatar;

    }

    public static UserProfile create() {

        final UserProfile fixture = new UserProfile();

        fixture.setAvatar(Randomizers.avatar());
        fixture.setDisplayName(new Faker().hacker().verb());

        return fixture;

    }

    public UserProfile setAvatar(final String avatar) {

        this.avatar = avatar;

        return this;

    }

    public UserProfile setUser(final User user) {

        this.user = user;

        return this;

    }

}
