package platform.services.api.users;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

import java.io.Serializable;
import java.util.Objects;

@Getter @Setter
public class UserProfileFK implements Serializable {

    @Column
    public Long user;

    @Column
    public Long profile;

    private static final long serialVersionUID = -4685554841903497926L;

    public UserProfileFK() {}

    private UserProfileFK(final Long userId, final Long profileId) {

        this.user = userId;
        this.profile = profileId;
    }

    @Override public boolean equals(final Object o) {

        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        final UserProfileFK fk = (UserProfileFK) o;
        return Objects.equals(user, fk.user) &&
            Objects.equals(profile, fk.profile);
    }

    @Override public int hashCode() {

        return Objects.hash(user, profile);
    }
}
